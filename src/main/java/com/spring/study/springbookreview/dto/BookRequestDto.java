package com.spring.study.springbookreview.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookRequestDto {
  private String bookName;
  private String author;
}
