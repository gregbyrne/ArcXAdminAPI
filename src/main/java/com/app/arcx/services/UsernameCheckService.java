package com.app.arcx.services;

import javax.servlet.http.HttpServletRequest;

public class UsernameCheckService {

    public boolean userCheck(HttpServletRequest request){
        boolean verifiedUser = true;

        System.out.println("usernames: " + System.getenv("ARCX_USERNAMES"));
        /*String allowedUsers = System.getenv("ARCX_USERNAMES");
        Boolean verifiedUser = false;
        try{
            String username = request.getHeader("userid");
            if (allowedUsers.contains(username)){
                verifiedUser = true;
            }else{
                verifiedUser = false;
            }

        }catch (Exception e){
            System.out.println(e);

        }*/


        return verifiedUser;
    }
}
