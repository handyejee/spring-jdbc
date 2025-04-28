package com.spring.study.springbookreview.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewRequestDto {
  private Long bookId;
  private String title;
  private String content;
}
