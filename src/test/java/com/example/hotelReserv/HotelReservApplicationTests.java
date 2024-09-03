package com.example.hotelReserv;

import com.example.hotelReserv.entity.User;
import com.example.hotelReserv.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HotelReservApplicationTests {
	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
		User user = userRepository.findByUsername("admin@example.com").orElse(null);
		assertEquals("admin@example.com", user.getUsername());

	}

}
