package com.example.codetribe.firebaselogindemo;

/**
 * Created by codetribe on 9/15/2017.
 */

public class UserProfile {

    private String header;
    private String profileContent;

    public UserProfile(String header, String profileContent) {
        this.header = header;
        this.profileContent = profileContent;
    }

    public String getHeader() {
        return header;
    }

    public String getProfileContent() {
        return profileContent;
    }
}
