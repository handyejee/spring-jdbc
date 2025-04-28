package com.spring.study.springbookreview.service;

import com.spring.study.springbookreview.dto.BookRequestDto;
import com.spring.study.springbookreview.dto.BookResponseDto;
import com.spring.study.springbookreview.entity.Book;
import com.spring.study.springbookreview.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository bookRepository;

  // 책 저장
  @Transactional
  public void save(BookRequestDto requestDto) {
    Book book = Book.create(requestDto.getBookName(), requestDto.getAuthor());
    bookRepository.save(book);
  }

  // 책 수정
  @Transactional
  public void update(Long id, BookRequestDto requestDto) {
    Book book = Book.of(id, requestDto.getBookName(), requestDto.getAuthor());
    bookRepository.update(book);
  }

  // 책 삭제
  public void deleteById(Long id) {
    bookRepository.deleteById(id);
  }

  // 책 단건 조회
  public BookResponseDto findById(Long id) {
    Book book = bookRepository.findById(id);
    return BookResponseDto.of(book); // Book -> BookResponseDto 변환
  }

  // 책 전체조회
  public List<BookResponseDto> findAll() {
    List<Book> books = bookRepository.findAll();
    List<BookResponseDto> result = new ArrayList<>();

    for (Book book: books) {
      BookResponseDto dto = BookResponseDto.of(book);
      result.add(dto);
    }

    return result;
  }
}
