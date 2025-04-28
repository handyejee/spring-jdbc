package com.spring.study.springbookreview.controller;

import com.spring.study.springbookreview.dto.ReviewRequestDto;
import com.spring.study.springbookreview.dto.ReviewResponseDto;
import com.spring.study.springbookreview.service.ReviewService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

  private final ReviewService reviewService;

  @PostMapping()
  public void createReview(@RequestBody ReviewRequestDto reviewRequestDto) {
    reviewService.save(reviewRequestDto);
  }

  @PutMapping("/{id}")
  public void updateReview(@PathVariable Long id, @RequestBody ReviewRequestDto requestDto) {
    reviewService.update(id, requestDto);
  }

  @GetMapping("/{id}")
  public ReviewResponseDto getReviewById(@PathVariable Long id) {
    return reviewService.findById(id);
  }

  @GetMapping("/book/{bookId}")
  public List<ReviewResponseDto> getReviewsByBookId(@PathVariable Long bookId) {
    return reviewService.findAllByBookId(bookId);
  }

  @DeleteMapping("/{id}")
  public void deleteReview(@PathVariable Long id) {
    reviewService.deleteById(id);
  }
}
