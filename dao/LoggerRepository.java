package io.bankapp.dao;

import org.springframework.data.repository.CrudRepository;
import io.bankapp.model.Logger;

   /*Comment Section */
//Making use of the inheritance concept with a Spring data interface for
//generic CRUD operations on a repository of a specific type

public interface LoggerRepository extends CrudRepository<Logger, Integer> {

}
