package hh.sof003.bookstore.web;

import hh.sof003.bookstore.domain.User;
import hh.sof003.bookstore.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UserDetailService implements UserDetailsService  {
	private final UserRepository repository;

	public UserDetailService(UserRepository userRepository) {
		this.repository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User curruser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username,       	curruser.getPassword(),
		AuthorityUtils.createAuthorityList(curruser.getRole()));
		return user;
	}
}