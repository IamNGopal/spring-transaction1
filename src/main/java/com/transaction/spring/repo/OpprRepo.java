package com.transaction.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.spring.model.SalesOppr;


@Repository
public interface OpprRepo extends JpaRepository<SalesOppr, Integer>{

}
