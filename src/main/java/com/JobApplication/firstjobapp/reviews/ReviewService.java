package com.JobApplication.firstjobapp.reviews;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);

    boolean addReview(Long companyId,Review review);

    Review getReview(Long comapanyId,Long reviewId);

    boolean updateReview(Long companyId, Long reviewId, Review review);
    boolean deleteReviewById(Long companyId, Long reviewId);
}
