package com.demo.acc.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.demo.acc.common.DataException;
import com.demo.acc.doc.Account;
import com.demo.acc.repo.AccountRepo;

@Service
public class AccountService {

	@Inject
	private AccountRepo accAccountRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

	public List<Account> getCbsAccount() throws DataException {

		try {
			List<Account> list = accAccountRepo.findAllByStatus("A");
			LOGGER.info("list of accounts from DB ..[{}]", list);
			if (list == null) {
				throw new DataException("01", "NO Account Exists !");
			}

			return list;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			if (e instanceof DataException) {
				throw e;
			}
			throw new DataException("11", "FAILURE");
		}

	}

}
