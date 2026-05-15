package com.training.springbootcore;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "dicscount.activate",havingValue = "dafault")
@Component
public class DefaultDiscountImpl implements Discount{

	@Override
	public int applyDiscount(int price) {
		System.out.println("Default Discount Applied :: 10%");
		return price-(price/10);
	}

}
