package com.apple.models.cms;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String confirmationToken;

    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime localDateTime;

    @OneToOne (targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name="user_tid")
    private User user;


    public ConfirmationToken() {
    }


    public ConfirmationToken(User user) {
        this.confirmationToken = UUID.randomUUID().toString();
        this.localDateTime = LocalDateTime.now();
        this.user = user;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
