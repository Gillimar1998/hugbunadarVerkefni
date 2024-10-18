package com.example.hugbunadarVerkefni;

import java.util.HashMap;

public class Users {

    private HashMap<String, String> dummyUsers = new HashMap<>();

    public Users() {
        dummyUsers.put("Admin", "Admin123");
        dummyUsers.put("Test", "Test321");
        dummyUsers.put("asdf", "asdf1234");

    }

    // held við þurfum að bæta við id og fleirra hérna í inntaki enn þetta er bara mjög basic útgáfa
    public String getUser(String username) {
        return dummyUsers.containsKey(username) ? username : null;
    }

}
