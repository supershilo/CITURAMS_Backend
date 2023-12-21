package com.appdev.Rams.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdev.Rams.Entity.ReviewEntity;
import com.appdev.Rams.Entity.UserEntity;
import com.appdev.Rams.Service.ReviewService;
import com.appdev.Rams.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @GetMapping("/getAllReviews")
    public List<ReviewEntity> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/getReview/{id}")
    public ReviewEntity getReviewById(@PathVariable int id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping("/createReview")
    public ResponseEntity<ReviewEntity> createReview(@RequestBody ReviewEntity review, @RequestParam int userId) {
        UserEntity user = userService.getUserById(userId);

        // If the user exists, associate it with the review
        if (user != null) {
            review.setUser(user);
            ReviewEntity createdReview = reviewService.createReview(review);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateReview/{id}")
    public ReviewEntity updateReview(@PathVariable int id, @RequestBody ReviewEntity updatedReview) {
        return reviewService.updateReview(id, updatedReview);
    }

    @DeleteMapping("/deleteReview/{id}")
    public String deleteReview(@PathVariable int id) {
        return reviewService.deleteReview(id);
    }
    
}
