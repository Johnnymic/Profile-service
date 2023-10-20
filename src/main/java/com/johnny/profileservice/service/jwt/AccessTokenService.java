package com.johnny.profileservice.service.jwt;

import com.johnny.profileservice.exception.UserNotAuthenticated;
import com.johnny.profileservice.service.AccessTokenRequest;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private  final TokenProvider tokenProvider;

    private final AuthenticationManagerBuilder authenticationManager;


    public String getBearerToken(JwtAppUserTokenDto jwtAppUser , AccessTokenRequest accessTokenRequest){
        UsernamePasswordAuthenticationToken authenticationToken =  new UsernamePasswordAuthenticationToken(
                accessTokenRequest.getUserName(), accessTokenRequest.getPassword());
        Authentication authentication = authenticationManager.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        if (authentication.isAuthenticated()){
            String jwtToken = tokenProvider.generateToken(jwtAppUser, authentication.getAuthorities(), Boolean.FALSE);
            if (jwtToken !=null){
                return jwtToken;
            }else {
                return  null;
            }
        }
        throw new UserNotAuthenticated("authentication failed");
    }

}
