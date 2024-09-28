package com.example.hugbunadarVerkefni;

import java.util.HashMap;

public class Login {


        private HashMap<String, String> dummyUsers = new HashMap<>();

        public Login(){
            dummyUsers.put("Admin", "Admin123");
            dummyUsers.put("Test", "Test321");
            dummyUsers.put("asdf", "asdf1234");

        }

        public boolean validateLogin(String username, String password){
            System.out.println(dummyUsers.get(username));
            return dummyUsers.containsKey(username) && dummyUsers.get(username).equals(password);
        }


}
