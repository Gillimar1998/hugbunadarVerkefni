package com.example.hugbunadarVerkefni.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Comment {

    @Id
    private int commentID;
    private String content;
    private int userID; // Sá sem gerði commentið

    // Getterar
    public String getContent() {
        return content;
    }

    public int getUserID() {
        return userID;
    }

    // Setterar
    public void setContent(String content) {
        this.content = content;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
