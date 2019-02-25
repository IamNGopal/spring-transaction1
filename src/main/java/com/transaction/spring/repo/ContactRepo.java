package com.transaction.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.spring.model.CustomerContact;


@Repository
public interface ContactRepo extends JpaRepository<CustomerContact, Integer>{

}
