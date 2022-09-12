package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        carShowroom CarShowroom = new carShowroom();
        Scanner scanner = new Scanner(System.in);
        int choise = 0;
        while (true) {
            printMenu();
            try {
                choise = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
            switch (choise) {
                case 1:
                    viewOffers(CarShowroom);
                    break;
                case 2:
                    addOffer(scanner);
                    break;
                case 3:

                    break;
                case 4:

                    break;
            }
        }
    }
    public static void printMenu()
    {
        System.out.println("-----------Menu------------");
        System.out.println("\t 1 - View offers\n\t 2 - New Offer\n\t 3 - Buy car\n\t 4 - Change equipment\n"); }
    public static void viewOffers(carShowroom CarShowroom)
    {
        try
        {
            int i = 0;
            for(Car car : CarShowroom.getCarList())
            {
                System.out.println(car.toString());
                i++;
            }
            if (i == 0)
                throw new noCarException();
        }
        catch (noCarException e)
        {
            e.printStackTrace();
        }
    }
    public static void addOffer(Scanner scanner)
    {
        System.out.println("Enter car model:");
        String carModel = scanner.next();
        System.out.println("Enter quarantee:");
        int quaranteeMonth = scanner.nextInt();
        System.out.println("Enter additional features:");
        String additionalFeatures = scanner.next();
        System.out.println("Enter cost:");
        int cost = scanner.nextInt();
        Car car = new Car(carModel,quaranteeMonth,additionalFeatures,cost);
        carShowroom.addCar(car);
    }
}
