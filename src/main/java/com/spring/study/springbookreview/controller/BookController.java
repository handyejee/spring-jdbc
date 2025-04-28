package com.spring.study.springbookreview.controller;

import com.spring.study.springbookreview.dto.BookRequestDto;
import com.spring.study.springbookreview.dto.BookResponseDto;
import com.spring.study.springbookreview.service.BookService;
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
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  // 책 정보 등록
  @PostMapping
  public void createBook(@RequestBody BookRequestDto requestDto) {
    bookService.save(requestDto);
  }

  // 책 정보 수정
  @PutMapping("/{id}")
  public void updateBook(@PathVariable Long id, @RequestBody BookRequestDto requestDto) {
    bookService.update(id, requestDto);
  }

  // 책 단건 조회
  @GetMapping("/{id}")
  public BookResponseDto getBookById(@PathVariable Long id) {
    return bookService.findById(id);
  }

  // 책 목록 조회
  @GetMapping
  public List<BookResponseDto> getBookList() {
    return bookService.findAll();
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable Long id) {
    bookService.deleteById(id);
  }
}
