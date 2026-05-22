package com.training.billingapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.billingapp.model.Item;
import com.training.billingapp.model.Menu;

@Component
public class Order {
	
	@Autowired
	private Menu menu;
	
	@Autowired
	private BillingProcessor billing;
	
	public void placeOrder() {
		while (true) {
			System.out.println("*".repeat(7)+"MENU ITEM"+"*".repeat(7));
			billing.showMenu();
			System.out.println("*".repeat(7)+"CHOOSE OPTION"+"*".repeat(7));
			Scanner sc = new Scanner(System.in);
			switch (sc.nextInt()) {
			case 1: {
				System.out.println("*".repeat(7)+"SELECT BREAKFAST"+"*".repeat(7));
				List<Item> breakfeast = menu.getBreakfast();
				 int breakfastOption = sc.nextInt();
				 Item brekfastItem = breakfeast.get(breakfastOption-1);
				 billing.selectItem(brekfastItem);
				 System.out.println("*".repeat(7)+"SELECTED ITEMS"+"*".repeat(7));
				 billing.displaySelected();
				 billing.checkout();
				 if(sc.nextInt()==2) {
					 System.out.println("*".repeat(7)+"TOTAL BILL: " +billing.calculateTotalBill()+"*".repeat(7));
					 return;
				 }
				break;
			}
			case 2: {
				System.out.println("*".repeat(7)+"SELECT LUNCH"+"*".repeat(7));
				List<Item> lunch = menu.getLunch();
				 int lunchOption = sc.nextInt();
				 Item lunchItem = lunch.get(lunchOption-1);
				 billing.selectItem(lunchItem);
				 System.out.println("*".repeat(7)+"SELECTED ITEMS"+"*".repeat(7));
				 billing.displaySelected();
				 billing.checkout();
				 if(sc.nextInt()==2) {
					 System.out.println("*".repeat(7)+"TOTAL BILL: " +billing.calculateTotalBill()+"*".repeat(7));
					 return;
				 }
				break;
			}
			case 3: {
				System.out.println("*".repeat(7)+"SELECT BEVERAGES"+"*".repeat(7));
				List<Item> beverages = menu.getBeverages();
				 int beveragesOption = sc.nextInt();
				 Item beveragesItem = beverages.get(beveragesOption-1);
				 billing.selectItem(beveragesItem);
				 System.out.println("*".repeat(7)+"SELECTED ITEMS"+"*".repeat(7));
				 billing.displaySelected();
				 billing.checkout();
				 if(sc.nextInt()==2) {
					 System.out.println("*".repeat(7)+"TOTAL BILL: " +billing.calculateTotalBill()+"*".repeat(7));
					 return;
				 }
				break;
			}
			default:
				throw new IllegalArgumentException("Wrong Option: " + sc.nextInt());
			}
		}
		
	}

}
