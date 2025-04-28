package com.spring.study.springbookreview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Book {
  private Long id;
  private String bookName; // 책이름
  private String author; // 저자

  // 외부에서 직접 객체를 못만들게 막도록 private 생성자 생성
  private Book(Long id, String bookName, String author){
    this.id = id;
    this.bookName = bookName;
    this.author = author;
  }

  // 새로운 객체를 생성 (여기서는 id값을 db에서 자동으로 생성해주기 때문에 create 사용)
  public static Book create(String bookName, String author) {
    return new Book(null, bookName, author);
  }

  // 필드를 받아서 객체로 만듬 (조회용)
  public static Book of(Long id, String bookName, String author) {
    return new Book(id, bookName, author);
  }
}
