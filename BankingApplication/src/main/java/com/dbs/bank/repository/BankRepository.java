package com.dbs.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.bank.model.Banker;

@Repository
public interface BankRepository extends JpaRepository<Banker, Long>{

}
