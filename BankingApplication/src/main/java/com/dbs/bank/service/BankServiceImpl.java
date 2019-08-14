package com.dbs.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.bank.repository.BankRepository;


@Service
public class BankServiceImpl implements BankService{
	@Autowired
    private BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository){
        this.bankRepository = bankRepository;
    }
}
