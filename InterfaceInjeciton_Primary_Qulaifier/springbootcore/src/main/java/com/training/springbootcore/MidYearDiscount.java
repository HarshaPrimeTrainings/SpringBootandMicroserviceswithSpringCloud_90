package com.training.springbootcore;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Qualifier("midyeardisc")
@Component
public class MidYearDiscount implements Discount{

	@Override
	public int applyDiscount(int price) {
		System.out.println("MidYear Discount Applied :: 30%");
		return price-(price/30);
	}

}
