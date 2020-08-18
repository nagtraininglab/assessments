package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Txn;

public interface TransactionOneRepository extends JpaRepository<Txn, Integer> {

}