package com.demo.acc.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.acc.common.DataException;
import com.demo.acc.common.Versions;
import com.demo.acc.doc.Account;
import com.demo.acc.service.AccountService;

@RestController
@RequestMapping(value = "/app/", consumes = Versions.V1_0, produces = Versions.V1_0)

public class AccountController {

	@Inject
	private AccountService accService;

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	@RequestMapping(value = "/listallacc", method = RequestMethod.GET)
	public List<Account> listacc() throws DataException {
		LOGGER.info("List all acc with status A");
		return accService.getCbsAccount();
	}

}
