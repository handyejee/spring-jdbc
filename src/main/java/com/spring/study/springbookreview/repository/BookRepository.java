package com.spring.study.springbookreview.repository;

import com.spring.study.springbookreview.entity.Book;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepository {

  private final JdbcTemplate jdbcTemplate;

  // 책 저장
  public void save(Book book) {
    String sql = "INSERT INTO book (bookName, author) VALUES (?, ?)";
    jdbcTemplate.update(sql, book.getBookName(), book.getAuthor());
  }

  // 책 정보 수정
  public void update(Book book) {
    String sql = "UPDATE book SET bookName = ?, author = ? WHERE id = ?";
    jdbcTemplate.update(sql, book.getBookName(), book.getAuthor(), book.getId());
  }

  // 책 정보 삭제
  public void deleteById(Long id) {
    String sql = "DELETE from book where id = ?";
    jdbcTemplate.update(sql, id);
  }

  // 책 단건조회
  public Book findById(Long id) {
    String sql = "SELECT * FROM book WHERE id = ?";
    System.out.println("== 실행 SQL: " + sql + " / 파라미터: " + id);
    try {
      return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  // 전체 책 목록 조회
  public List<Book> findAll() {
    String sql = "SELECT * FROM book ORDER BY id DESC";
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
  }
}
