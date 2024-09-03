package com.example.hotelReserv.service;

import com.example.hotelReserv.DTO.CustomUserDetail;
import com.example.hotelReserv.entity.User;
import com.example.hotelReserv.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("로그인 시도: " + username);  // 로그 추가

        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            log.warn("사용자를 찾을 수 없음: " + username);  // 로그 추가
            throw new UsernameNotFoundException(username + "사용자를 찾을 수 없습니다.");
        }
        log.info("사용자 찾음: " + username);  // 로그 추가
        return new CustomUserDetail(user);
    }
}
