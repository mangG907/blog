package com.manggee.blog.user.service;

import com.manggee.blog.user.dto.UserRequestDto;
import com.manggee.blog.user.dto.UserResponseDto;
import com.manggee.blog.user.entity.UserEntity;
import com.manggee.blog.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /* 사용자 생성 */
    @Transactional
    public UserResponseDto.SaveUser createUser(UserRequestDto userRequestDto) {

        /* 사용자 중복 확인 */
        Optional<UserEntity> findUser = userRepository.findByEmail(userRequestDto.getEmail());

        if (findUser.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일 입니다.");
        }

        /* 비밀번호와 비밀번호 확인이 일치하는지 확인 */
        if (!userRequestDto.getPassword().equals(userRequestDto.getConfirmPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        /* 비밀번호 암호화 */
        String encodedPassword = passwordEncoder.encode(userRequestDto.getPassword());

        /* DB에 저장할 사용자 생성 */
        UserEntity user = new UserEntity(
                userRequestDto.getEmail(),
                encodedPassword,
                userRequestDto.getName(),
                userRequestDto.getBirthDate(),
                userRequestDto.getShop(),
                userRequestDto.getPhone()
        );

        /* DB에 저장 */
        UserEntity newUser = userRepository.save(user);

        /* 반환할 사용자 리턴 */
        return new UserResponseDto.SaveUser(newUser);
    }

    /* 모든 사용자 조회 */
    public List<UserResponseDto.SaveUser> findAllUsers() {

        /* 모든 user 엔티티를 DB에서 조회 */
        List<UserEntity> users = userRepository.findAll();

        /* user 엔티티 목록을 UserResponseDto.SaveUser로 변환하여 반환 */
        return users.stream()
                .map(UserResponseDto.SaveUser::new)
                .collect(Collectors.toList());
    }

    /* 사용자 업데이트 */
    @Transactional
    public UserResponseDto.SaveUser updateUser(UserRequestDto userRequestDto) {

        /* 사용자 조회 */
        UserEntity findUser = userRepository.findByEmail(userRequestDto.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("해당 이메일의 사용자를 찾을 수 없습니다." + userRequestDto.getEmail()));

        /* 사용자 업데이트 */
        findUser.updateUser(userRequestDto);
        return new UserResponseDto.SaveUser(findUser);
    }

    /* 사용자 삭제 */
    @Transactional
    public String deleteUser(String email) {
        /* 삭제할 사용자가 있는 지 조회 */
        UserEntity finduser = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("해당 이메일의 사용자를 찾을 수 없습니다." + email));

        userRepository.deleteById(Long.valueOf(email));
        return "정상적으로 사용자를 삭제 하였습니다.";
    }

}
