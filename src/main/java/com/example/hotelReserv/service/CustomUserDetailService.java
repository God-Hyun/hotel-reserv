package com.example.hotelReserv.service;

import com.example.hotelReserv.DTO.CustomUserDetail;
import com.example.hotelReserv.entity.User;
import com.example.hotelReserv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException(username + "사용자를 찾을 수 없습니다.");
        }
        return new CustomUserDetail(user);
    }
}
