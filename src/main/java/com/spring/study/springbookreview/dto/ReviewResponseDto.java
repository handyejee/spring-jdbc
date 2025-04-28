package com.spring.study.springbookreview.dto;

import com.spring.study.springbookreview.entity.Review;
import lombok.Getter;

@Getter
public class ReviewResponseDto {
  private final Long id;
  private final String title;
  private final String content;

  /* final 필드인 경우 생성자에서 초기화 필요
     생성자 통해 객체로 만들어주는 순간 필수 값을 넣어줘야 하기 때문에 안전하다.
  */
  public ReviewResponseDto(Long id, String title, String content) {
    this.id = id;
    this.title = title;
    this.content = content;
  }

  /*
    entity의 of 메서드와의 차이
    - DTO에서 of는 Entity를 받아서 DTO로 변환할 때 사용
    - Entity에서는 데이터베이스에서 읽어온 데이터를 기반으로 Entity 객체 만들 때 사용
   */
  public static ReviewResponseDto of(Review review) {
    return new ReviewResponseDto(
        review.getId(),
        review.getTitle(),
        review.getContent()
    );
  }
}
