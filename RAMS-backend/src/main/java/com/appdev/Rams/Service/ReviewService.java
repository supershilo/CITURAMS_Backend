package com.appdev.Rams.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.Rams.Entity.ReviewEntity;
import com.appdev.Rams.Entity.UserEntity;
import com.appdev.Rams.Repository.ReviewRepository;
import com.appdev.Rams.Repository.UserRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepo;

    public List<ReviewEntity> getAllReviews() {
        List<ReviewEntity> reviews = reviewRepository.findAllReviews();
        populateUserInformation(reviews);
        return reviews;
    }

    private void populateUserInformation(List<ReviewEntity> reviews) {
        for (ReviewEntity review : reviews) {
            UserEntity user = getUser(review.getUser().getUserID()); // Assuming UserEntity has a getUserId() method
            review.setUser(user);
        }
    }
    

    private UserEntity getUser(int userId) {
        return userRepo.findById(userId).get();
    }
    public ReviewEntity getReviewById(int id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public ReviewEntity createReview(ReviewEntity review) {
        return reviewRepository.save(review);
    }

    public ReviewEntity updateReview(int id, ReviewEntity updatedReview) {
        Optional<ReviewEntity> optionalReview = reviewRepository.findById(id);

        if (optionalReview.isPresent()) {
            ReviewEntity existingReview = optionalReview.get();
            existingReview.setContent(updatedReview.getContent());

            return reviewRepository.save(existingReview);
        } else {
            return null; 
        }
    }

    public String deleteReview(int id){
        String msg = "";
        Optional<ReviewEntity> optionalReview = reviewRepository.findById(id);

        if(optionalReview.isPresent()){
            ReviewEntity review = optionalReview.get();
            review.setDeleted(1);
            reviewRepository.save(review);

            msg = "Review ID " + review.getReviewID() + " is deleted";
        } else {
            msg = "Review not found";
        }

        return msg;
    }
}

