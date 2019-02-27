package com.javajwt.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import com.javajwt.security.JwtTokenUtil;
import com.javajwt.security.JwtUser;
import com.javajwt.security.repository.UserRepository;

@RestController
public class UserRestController {

	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "user", method = RequestMethod.GET)
	public JwtUser getAuthenticatedUser(HttpServletRequest request) {
		String token = request.getHeader(tokenHeader);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
		return user;
	}

	@RequestMapping(value = "user/date", method = RequestMethod.GET)
	public Date getDateUser(HttpServletRequest request) {
		String token = request.getHeader(tokenHeader);
		Date createdDate = jwtTokenUtil.getCreatedDateFromToken(token);
		return createdDate;
	}

	/*
	 * @RequestMapping(value = "/user", method = { RequestMethod.POST,
	 * RequestMethod.PUT }) public User createUser(@RequestBody User user) {
	 * 
	 * return userRepository.save(user); URI location =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (result.getId()).toUri(); return ResponseEntity.created(location).build(); }
	 * 
	 * @RequestMapping(value = "/user", method = { RequestMethod.POST,
	 * RequestMethod.PUT }) public ResponseEntity<?> createUser(@RequestBody User
	 * user) {
	 * 
	 * User result = userRepository.save(user); URI location =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (result.getId()).toUri(); return ResponseEntity.created(location).build(); }
	 */

}
