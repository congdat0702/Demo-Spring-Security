package com.web.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.dao.UserInfoDAO;
import com.web.model.UserInfo;


@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserInfoDAO userInfoDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = userInfoDAO.findUserInfo(username);
		System.out.println("UserInfo= " + userInfo);
		
		
		//kiểm tra xem người dùng có tồn tại trong cơ sở dữ liệu hay không. 
		//Nếu người dùng không tồn tại, phương thức sẽ đưa ra một ngoại lệ.
		if (userInfo == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}

		// [USER,ADMIN,..]
		List<String> roles = userInfoDAO.getUserRoles(username);
		//Nếu có thì sử dụng lớp userInfoDAO để lấy danh sách vai trò của người dùng.
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roles != null) {
			for (String role : roles) {
				// ROLE_USER, ROLE_ADMIN,..
				GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
				grantList.add(authority);
			}
		}
		//Trả về đối tượng đã được xác thực. 
		UserDetails userDetails = (UserDetails) new User(userInfo.getUserName(), //
				userInfo.getPassword(), grantList);

		return userDetails;
	}
}
