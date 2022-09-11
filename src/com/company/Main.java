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
                    break;
                case 2:
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
}
