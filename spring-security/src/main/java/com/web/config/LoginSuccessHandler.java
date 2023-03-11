package com.web.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.web.dao.AccountDao;
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    @Autowired
    private AccountDao accountDao;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        String username = authentication.getName();

        System.out.println("==== username: "+username);

    }

   //kiểm tra role
    public boolean checkRole(String role,List<String> list) {
        for(String s : list) {
            if(s.equals(role)) {
                return true;
            }
        }
        return false;
    }
}

