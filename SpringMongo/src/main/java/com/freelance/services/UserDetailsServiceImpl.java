package com.freelance.services;

import java.util.Date;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.freelance.model.User;
import com.freelance.repository.UserDAO;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired 
	UserDAO userDao;

	@Autowired
	BCryptPasswordEncoder bcryptIt;
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUsername(userName);
		List<SimpleGrantedAuthority> roleList = null;
		SimpleGrantedAuthority role = new SimpleGrantedAuthority(user.getRoleName());
		roleList.add(role);
		
		UserDetails userDetailsUser = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roleList);
		return userDetailsUser;
	}
	
	
	public User userPropertiesSet(User userVo){
		User userTo = new User();
		BeanUtils.copyProperties(userVo, userTo);
		userTo.setRegistrationDate(new Date());
		userTo.setPassword(bcryptIt.encode(userVo.getPassword()));
		userDao.save(userTo);
		return userTo;
	}

}
