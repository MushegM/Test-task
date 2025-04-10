package com.Web_test.repository;

import com.Web_test.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE (:title IS NULL OR b.title LIKE %:title%) AND (:brand IS NULL OR b.brand LIKE %:brand%) AND (:year = 0 OR b.year = :year)")
    Page<Book> findByFilters(@Param("title") String title, @Param("brand") String brand, @Param("year") int year, Pageable pageable);
}
