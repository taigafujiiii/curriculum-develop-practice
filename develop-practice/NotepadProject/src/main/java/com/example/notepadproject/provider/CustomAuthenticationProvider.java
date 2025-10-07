package com.example.notepadproject.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import com.example.notepadproject.entity.Users;
import com.example.notepadproject.service.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		//メールアドレスとパスワードを取得する
		String email = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		Users user = userService.getUserEmail(email);
		
		if(user != null && password.equals(user.getPassword())) {
			//認証成功時は、認証トークンを作成
			return new UsernamePasswordAuthenticationToken(email, password, AuthorityUtils.createAuthorityList());
		}else {
			//失敗時はエラーを返す
			throw new BadCredentialsException("Authentication failed");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
