package com.app.arcx.services;

import javax.servlet.http.HttpServletRequest;

public class UsernameCheckService {

    public boolean userCheck(String username){
        boolean verifiedUser = false;

        String allowedUsers = System.getenv("ARCX_USERNAMES");
        try{
            if (allowedUsers.contains(username)){
                verifiedUser = true;
            }else{
                verifiedUser = false;
            }

        }catch (Exception e){
            System.out.println(e);

        }


        return verifiedUser;
    }
}
