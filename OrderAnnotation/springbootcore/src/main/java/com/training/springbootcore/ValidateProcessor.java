package com.training.springbootcore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateProcessor {

	@Autowired
	List<Validator> validator;
	
	
	public void processValidate(int amount) {
		for (Validator validatortemp : validator) {
			validatortemp.validate(amount);
		}
	}
	
}
