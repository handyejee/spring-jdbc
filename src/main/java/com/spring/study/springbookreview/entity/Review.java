package com.spring.study.springbookreview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Review {
 private Long id;
 private Long bookId;
 private String title;
 private String content;

 private Review (Long id, Long bookId, String title, String content) {
  this.id = id;
  this.bookId = bookId;
  this.title = title;
  this.content = content;
 }

 public static Review create(Long bookId, String title, String content) {
  return new Review(null, bookId, title, content);
 }

 public static Review of(Long id, Long bookId, String title, String content) {
  return new Review(id, bookId, title, content);
 }
}
