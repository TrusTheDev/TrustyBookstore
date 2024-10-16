package com.trusty.TrustyBookstore.repository;

import com.trusty.TrustyBookstore.models.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookJPARepository extends JpaRepository<book, Integer> {
}
