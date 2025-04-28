package com.spring.study.springbookreview.service;

import com.spring.study.springbookreview.dto.ReviewRequestDto;
import com.spring.study.springbookreview.dto.ReviewResponseDto;
import com.spring.study.springbookreview.entity.Review;
import com.spring.study.springbookreview.repository.ReviewRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

  private final ReviewRepository reviewRepository;

  @Transactional
  public void save(ReviewRequestDto reviewRequestDto) {
    Review review = Review.create(reviewRequestDto.getBookId(), reviewRequestDto.getTitle(), reviewRequestDto.getContent());
    reviewRepository.save(review);
  }

  @Transactional
  public void update(Long id, ReviewRequestDto reviewRequestDto) {
    Review review = reviewRepository.findById(id); // 기존 review 조회

    // 기존 bookId를 유지하고 제목, 내용만 수정
    Review newReview = Review.of(id, review.getBookId(), reviewRequestDto.getTitle(), reviewRequestDto.getContent());
    reviewRepository.update(newReview);
  }

  public void deleteById(Long id) {
    reviewRepository.deleteById(id);
  }

  public ReviewResponseDto findById(Long id) {
    Review review = reviewRepository.findById(id);
    return ReviewResponseDto.of(review);
  }

  // 책을 기준으로 리뷰 목록을 조회하는 메서드
  public List<ReviewResponseDto> findAllByBookId(Long bookId) {
    List<Review> reviews = reviewRepository.findAllByBookId(bookId);
    List<ReviewResponseDto> result = new ArrayList<>();

    for(Review review: reviews) {
      ReviewResponseDto dto = ReviewResponseDto.of(review);
      result.add(dto);
    }

    return result;
  }
}
