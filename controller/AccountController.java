package io.bankapp.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.bankapp.model.Accounts;
import io.bankapp.model.Logger;
import io.bankapp.service.AccountService;

   /*Comment Section */
//Creation of the Account Controller class
//Using the Post, Get and Delete functions of a Rest Api, same as the other controllers.
//For the Account creation we need to have a Customer created already.
//Get balance is simple function that checks the balance
//The deposit and withdraw function use similar logic but different calculus, at the end we will add the time of the movement
//The transfer function use the same logic as deposit or withdraw but takes into consideration both accounts,
//and which is the one doing the transfer so the order in the call is important.
//The removal of the account comes with the removal of the log of the corresponding account.

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private LoggerController loggerController;

	public void createAccount(int acctID, int balance, String acctStatus) {

		Accounts acct = new Accounts(acctID, balance, acctStatus);
		accountService.createAccount(acct);

	}

	@GetMapping("/account/{acctID}/balance")
	public int getBalance(@PathVariable int acctID) {

		return accountService.getBalance(acctID);

	}

	@PutMapping("/account/{acctID}/deposit/{amount}")
	public void depositAmount(@PathVariable int acctID, @PathVariable int amount) {

		int initBal = getBalance(acctID);
		Instant dateTime = Instant.now();
		accountService.depositAmount(acctID, amount);
		Logger logger = new Logger(acctID, "Deposited", "Success", initBal, initBal + amount, dateTime);
		loggerController.addLog(logger);

	}

	@PutMapping("/account/{acctID}/withdraw/{amount}")
	public void withdrawAmount(@PathVariable int acctID, @PathVariable int amount) {

		int initBal = getBalance(acctID);
		accountService.withdrawAmount(acctID, amount);
		Instant dateTime = Instant.now();

		Logger logger = new Logger(acctID, "Withdrawn", "Success", initBal, initBal - amount, dateTime);
		loggerController.addLog(logger);

	}

	@PutMapping("/account/{acctID}/transfer/{destAcctID}/{amount}")
	public void transferAmount(@PathVariable int acctID, @PathVariable int destAcctID, @PathVariable int amount) {

		int initBalSender = getBalance(acctID);
		int initBalReceiver = getBalance(destAcctID);
		accountService.transferAmount(acctID, destAcctID, amount);
		Instant dateTime = Instant.now();

		Logger loggerSender = new Logger(acctID, "Transferred", "Success", initBalSender, initBalSender - amount, dateTime);
		loggerController.addLog(loggerSender);

		Logger loggerReceiver = new Logger(destAcctID, "Received", "Success", initBalReceiver,
				initBalReceiver + amount, dateTime);
		loggerController.addLog(loggerReceiver);

	}

	@DeleteMapping("/account/{acctID}")
	public void deleteAccount(@PathVariable int acctID) {

		accountService.deleteAccount(acctID);
		loggerController.deleteLog(acctID);

	}

	@GetMapping("/account/{acctID}")
	public Accounts getAccountInfo(@PathVariable int acctID) {

		return accountService.getAccountInfo(acctID);
		
	}

}
