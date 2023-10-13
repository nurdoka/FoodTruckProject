package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	private FoodTruck [] fleet = new FoodTruck[5];
	
	public static void main(String[] args) {
		FoodTruckApp fta = new FoodTruckApp();
		fta.run();
	}
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			System.out.print("Enter foodtruck's name: ");
			String name = sc.next();
			if(name.equals("quit")) {
				break;
			}
			System.out.print("Enter food type: ");
			String foodType = sc.next();
			
			System.out.print("Enter rating: ");
			double rating = sc.nextDouble();
			
			fleet[i] = new FoodTruck(name,foodType,rating);						
		}
		
		int choice = 0;
		
		while(choice!=4) {
			printMenu();
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: 
				displayListOfTrucks(fleet);
				break;
			case 2:
				System.out.println(calculateAverageRating(fleet));
				break;
			case 3:
				System.out.println(highestRating(fleet));
				break;
			case 4:
				System.out.println("Bye Bye Bye!!!");
				break;
			default:
				System.out.println("Invalid entry, try again!");
			}
				
		}
		
		sc.close();
	}
	public FoodTruck highestRating(FoodTruck [] arrayList) {
		double maxRating = arrayList[0].getRating();
		FoodTruck maxRatTruck = arrayList[0];
		for (int i = 0; i < arrayList.length; i++) {
			if(arrayList[i]!=null) {
				if(arrayList[i].getRating() > maxRating) {
					maxRating = arrayList[i].getRating();
					maxRatTruck = arrayList[0];
				}
			}
			else
				break;
		}
		return maxRatTruck;
	}
	
	public double calculateAverageRating(FoodTruck [] arrayList) {
		double sumRating = 0.0;
		int i = 0;
		for (; i < arrayList.length; i++) {
			if(arrayList[i]!=null)
				sumRating += arrayList[i].getRating();
			else
				break;
		}
		return sumRating/i;
	}
	public void printMenu() {
		System.out.println("Choose your option...");
		System.out.println("1: List all existing food trucks.");
		System.out.println("2: See the average rating of food trucks.");
		System.out.println("3: Display the highest-rated food truck.");
		System.out.println("4: Quit the program.");
	}
	
	public void displayListOfTrucks(FoodTruck [] foodTruckList) {
		for (int i = 0; i < foodTruckList.length; i++) {
			if(foodTruckList[i]!=null)
				System.out.println(foodTruckList[i].toString());
			else
				break;
		}
	}
	

}
