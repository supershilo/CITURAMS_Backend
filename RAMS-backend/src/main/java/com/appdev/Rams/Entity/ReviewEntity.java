package com.appdev.Rams.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tblreview")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewID;

    private int isDeleted = 0;
    private String content;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id") // assuming your column name is user_id
    private UserEntity user;


    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int isDeleted() {
        return isDeleted;
    }

    public void setDeleted(int deleted) {
        isDeleted = deleted;
    }

    public ReviewEntity(){}
    public ReviewEntity(int rating, String content) {
        super();
        this.rating = rating;
        this.content = content;
 }
    @Override
    public String toString() {
        return "Review: [reviewID=" + reviewID + ", content=" + content + ", rating="+rating+"]";
    }   
}
