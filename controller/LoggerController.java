package io.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.bankapp.model.Logger;
import io.bankapp.service.LoggerService;

   /*Comment Section */
//Creation of the controller Rest, of the log class

@RestController
public class LoggerController {
	@Autowired
	private LoggerService loggerService;

	public void addLog(Logger logger) {

		loggerService.addLog(logger);

	}

	@GetMapping("/account/{acctID}/logs")
	public Logger showLog(@PathVariable int acctID) {

		return loggerService.showLog(acctID);

	}

	public void deleteLog(int acctID) {

		loggerService.deleteLog(acctID);

	}
}
