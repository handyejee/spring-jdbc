package com.spring.study.springbookreview.repository;

import com.spring.study.springbookreview.entity.Review;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {

  private final JdbcTemplate jdbcTemplate;

  public void save(Review review) {
    String sql = "INSERT INTO review (bookId, title, content) VALUES (?, ?, ?)";
    jdbcTemplate.update(sql, review.getBookId(), review.getTitle(), review.getContent());
  }

  public void update(Review review) {
    String sql = "UPDATE review SET title = ?, content = ? WHERE id = ?";
    jdbcTemplate.update(sql, review.getTitle(), review.getContent(), review.getId());
  }

  public void deleteById(Long id) {
    String sql = "DELETE FROM review WHERE id = ?";
    jdbcTemplate.update(sql, id);
  }

  public Review findById(Long id) {
    String sql = "SELECT * FROM review WHERE id = ?";
    return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Review.class), id);
  }

  public List<Review> findAllByBookId(Long bookId) {
    String sql = "SELECT * FROM review WHERE bookId = ? ORDER BY id DESC";
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Review.class), bookId);
  }
}
