package io.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.bankapp.dao.LoggerRepository;
import io.bankapp.model.Logger;

    /*Comment Section */
//Using the repository, we create a few functions to make the creation of the log, making it visible in the case it exists
//And the corresponding removal if necessary

@Service
public class LoggerService {
	@Autowired
	LoggerRepository loggerRepository;

	public void addLog(Logger logger) {

		loggerRepository.save(logger);

	}

	public Logger showLog(int acctID) {

		return loggerRepository.findById(acctID).orElse(null);

	}

	public void deleteLog(int acctID) {

		loggerRepository.deleteById(acctID);

	}
}
