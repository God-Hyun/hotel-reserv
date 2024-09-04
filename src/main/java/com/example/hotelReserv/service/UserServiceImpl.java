package com.example.hotelReserv.service;

import com.example.hotelReserv.DTO.UserDTO;
import com.example.hotelReserv.entity.User;
import com.example.hotelReserv.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/* 서비스 계층에 convertToDTO와 convertToEntity 같은 변환 메서드를 작성하는 이유
   서비스 계층은 리포지토리와의 상호작용을 포함해 엔티티 클래스에 대한 이해를 가지고 있어야 하므로
   서비스 계층에서 변환 작업을 수행하는 것이 자연스러움.
     */

@Slf4j
@Service
public class UserServiceImpl extends CustomUserDetailService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToDTO).collect(Collectors.toList());
        // users를 stream으로 변환. 스트림은 데이터이 연속적인 흐름을 표현. --> 필터링, 변환, 집계 쉽게 수행 가능.
        // map()은 스트림의 각 요소에 대해 특정 함수를 적용하여 변환 작업을 수행하는 매서드.
        // this::convertToDTO는 converToDTO라는 메서드를 참조하는 참조 표현식.
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        log.info(userDTO.toString());
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // User 객체를 UserDTO 객체로 변환하는 메서드
    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirst_name());
        dto.setLastName(user.getLast_name());
        dto.setUsername(user.getUsername());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        return dto;
    }

    // UserDTO 객체를 User 객체로 변환하는 메서드
    private User convertToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFirst_name(dto.getFirstName());
        user.setLast_name(dto.getLastName());
        user.setUsername(dto.getUsername());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());
        return user;
    }
    // 회원가입 메서드
    public void registerUser(UserDTO userDTO) {
        log.info(userDTO.toString()); // 로그 확인

        User user = new User();
        user.setFirst_name(userDTO.getFirstName());
        user.setLast_name(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setPhone(userDTO.getPhone());
        user.setRole("ROLE_USER"); // 기본적으로 일반 사용자로 설정
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // 비밀번호 암호화
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

}
