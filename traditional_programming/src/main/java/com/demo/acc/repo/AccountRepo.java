package com.demo.acc.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.acc.doc.Account;

@Repository
public interface AccountRepo extends MongoRepository<Account, Integer> {

	List<Account> findAllByStatus(String status);

	Account findOneByAccountNoAndStatus(String accNumber, String status);

	Account findOneByAccountNoAndMobileNoAndStatus(String accNumber, String mobileNo, String status);

}
