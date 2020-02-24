package com.example.demo.ZModel;

import javax.persistence.*;

@Embeddable
public class UserProfile {
    @Column
    private int followers = 0;
    @Column
    private boolean active = true;

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
