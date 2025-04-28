-- 테이블 먼저 삭제
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS book;

-- 책 테이블 생성
CREATE TABLE book (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      bookName VARCHAR(255) NOT NULL,
                      author VARCHAR(255) NOT NULL
);

-- 감상문(리뷰) 테이블 생성
CREATE TABLE review (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        bookId BIGINT NOT NULL,
                        title VARCHAR(255) NOT NULL,
                        content TEXT NOT NULL,
                        CONSTRAINT fk_review_book
                            FOREIGN KEY (bookId) REFERENCES book(id)
                                ON DELETE CASCADE
);

-- 샘플 데이터 - 책 정보
INSERT INTO book (bookName, author) VALUES
                                         ('스프링6 입문', '토기 코헤이'),
                                         ('개발자 기술 면접 노트', '이남희');

-- 샘플 데이터 - 감상문(리뷰) 정보
INSERT INTO review (bookId, title, content) VALUES
                                                 (1, '스프링6 입문 2장', '스프링에서 DI가 어떻게 일어나는지 이해할 수 있었다.'),
                                                 (1, '스프링6 입문 8장', '스프링 시큐리티가 어떻게 동작되는지 이해할 수 있었다.'),
                                                 (2, '개발자 이력서 작성법', '읽는 사람을 생각하는 글을 작성해야겠다.');
