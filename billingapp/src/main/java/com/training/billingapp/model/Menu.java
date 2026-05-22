package com.training.billingapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Menu {
	
	@Value("${discount.number}")
	private Integer discountValue;
	
	@Value("${discount.activate}")
	private boolean discountActivate;
	
	List<Item> discountedList = new ArrayList<>();
	
	Menu(){
		System.out.println("discountValue in Constructor :: "+discountValue);
//		List<Item> breakfeastList = discountActivate?applyiDiscount(getBreakfast(), discountValue):getBreakfast();
//		displayItems(breakfeastList);
	}
	
	@PostConstruct
	void initOperations() {
		//List<Item> breakfeastList = discountActivate?applyiDiscount(getBreakfast(), discountValue):getBreakfast();
		//displayItems(breakfeastList);
	}
	

	public void displayItems(List<Item> items) {
//		int num = 1;
//		for (Item item : items) {
//			System.out.println(num+" ."+item.getName()+ " :: " + item.getPrice());
//			num++;
//		}
		
		IntStream.range(0, items.size()).forEach(i-> System.out.println((i+1)+"."+items.get(i)));
	}
	
	public List<Item> applyiDiscount(List<Item> items,Integer discount){
		if(discount>0) {
			List<Item> discountedList= items.stream()
					.map(item-> new Item(item.getName(), item.getPrice()-(item.getPrice()/discount))).toList();
		return discountedList;
		}
		return items;
	}
	
	
	public List<Item> getBreakfast(){
		List<Item> breakfaset =  List.of(new Item("IDLI", 25),
				new Item("WADA", 30),
				new Item("POOHA", 45),
				new Item("PANCAKES", 50));
		displayItems(breakfaset);
		return breakfaset;
	}
	
	
	public List<Item> getBeverages(){
		List<Item> beverages = List.of(new Item("TEA", 15),
				new Item("COFFE", 25),
				new Item("MOJITO", 45),
				new Item("MILK", 20));
		displayItems(beverages);
		return beverages;
	}
	public List<Item> getLunch(){
		List<Item> lunch =  List.of(new Item("THALI", 25),
				new Item("COMBO", 30),
				new Item("BIRIYANI", 45),
				new Item("NAAN_THALI", 50));
		displayItems(lunch);
		return lunch;
	}
}
