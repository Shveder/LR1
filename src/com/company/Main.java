package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    interface Function<T1, T2, R> {
        R apply(T1 arg1, T2 arg2);
    }

    interface

    public static void main(String[] args) {

        carShowroom CarShowroom = new carShowroom();
        List<Car> currentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choise = 0;
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
                    buyCar(CarShowroom, scanner);
                    break;
                case 4:
                    changeEquipment(CarShowroom, scanner);
                    break;
                case 5:
                    return;
                case 6:
                    currentList = CarShowroom.getCarList();
                    while (true) {
                        int choise2 = 0;
                        System.out.println("1- +addF 2 - -addF 3 - <10k cost 4 - >10k cost 5 - <30m guar 6 - >30m guar  0-back");
                        try {
                            choise2 = Integer.parseInt(scanner.next());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input");
                        }
                        switch (choise2) {
                            case 1:
                                CarShowroom.setList(filterByAdditionalFeatures(CarShowroom.getCarList(), "yes"));
                                break;
                            case 2:
                                CarShowroom.setList(filterByAdditionalFeatures(CarShowroom.getCarList(), "no"));
                                break;
                            case 3:
                                CarShowroom.setList(filterByMinCost(CarShowroom.getCarList(), 10000));
                                break;
                            case 4:
                                CarShowroom.setList(filterByMaxCost(CarShowroom.getCarList(), 10000));
                                break;
                            case 5:
                                CarShowroom.setList(filterByMinGuarantee(CarShowroom.getCarList(), 30));
                                break;
                            case 6:
                                CarShowroom.setList(filterByMaxGuarantee(CarShowroom.getCarList(), 30));
                                break;
                        }
                        if(choise2==0)
                            break;
                    }
                    break;
                case 7:
                    CarShowroom.setList(currentList);
                    break;
            }
        }
    }

    public static List<Car> filterByMinGuarantee(List<Car>carList,int guaranteeMonth)
    {
        return carList.stream()
                .filter(car -> car.getGuaranteeMonth() < guaranteeMonth)
                .collect(Collectors.toList());
    }

    public static List<Car> filterByMaxGuarantee(List<Car>carList,int guaranteeMonth)
    {
        return carList.stream()
                .filter(car -> car.getGuaranteeMonth() > guaranteeMonth)
                .collect(Collectors.toList());
    }

    public static List<Car> filterByAdditionalFeatures(List<Car>carList,String string)
    {
        return carList.stream()
                .filter(car -> car.getAdditionalFeatures().equals(string))
                .collect(Collectors.toList());
    }

    public static List<Car> filterByMinCost(List<Car>carList, int cost)
    {
        return carList.stream()
                .filter(car -> car.getCost() < cost)
                .collect(Collectors.toList());
    }

    public static List<Car> filterByMaxCost(List<Car>carList, int cost)
    {
        return carList.stream()
                .filter(car -> car.getCost() > cost)
                .collect(Collectors.toList());
    }

    public static void printMenu() {
        System.out.println("-----------Menu------------");
        System.out.println("\t 1 - View offers\n\t 2 - New Offer\n\t 3 - Buy car\n\t 4 - Change equipment\n\t 5 - Exit\n\t 6 -Filter \n\t 7- return to default");
    }

    public static void viewOffers(carShowroom CarShowroom) {
        Function<Integer ,Integer, Integer> function = (arg1, arg2) -> arg1 + arg2;
        try {
            int i = 0;
            for (Car car : CarShowroom.getCarList()) {
                System.out.println(i + 1 + "." + car.toString());
                i = function.apply(i,1);
            }
            if (i == 0)
                throw new noCarException();
        } catch (noCarException e) {
            System.out.println("!!");
        }
    }

    public static void addOffer(Scanner scanner) {
        System.out.println("Enter car model:");
        String carModel = scanner.next();
        System.out.println("Enter quarantee:");
        int guaranteeMonth = 0;
        while (true) {
            try {
                guaranteeMonth = Integer.parseInt(scanner.next());
                if (guaranteeMonth < 0) {
                    throw new ValueErrorException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Try Again");
            } catch (ValueErrorException e) {
                System.out.println("Guarantee month value must be positive");
            }
        }
        System.out.println("Enter additional features:");
        String additionalFeatures = scanner.next();
        System.out.println("Enter cost:");
        int cost = 0;
        while (true) {
            try {
                cost = Integer.parseInt(scanner.next());
                if (cost <= 0) {
                    throw new ValueErrorException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Try Again");
            } catch (ValueErrorException e) {
                System.out.println("Cost value must be positive");
            }
        }
        Car car = new Car(carModel, guaranteeMonth, additionalFeatures, cost);
        carShowroom.addCar(car);
    }

    public static void buyCar(carShowroom CarShowroom, Scanner scanner) {
        int choise = 0;
        while (true) {
            viewOffers(CarShowroom);
            System.out.println("Enter number of car you want to buy: 0 - back");
            try {
                choise = Integer.parseInt(scanner.next());
                if (choise > CarShowroom.getCarList().size() || choise < 0) {
                    throw new ValueErrorException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            } catch (ValueErrorException e) {
                System.out.println("Choise must be positive and < number of cars");
            }
        }
        if (choise == 0) {
            return;
        }
        int number = 0;
        System.out.println("Are you sure 1 - Y 0 - N " + CarShowroom.getCarList().get(choise - 1));
        while (true) {
            try {
                number = Integer.parseInt(scanner.next());
                if (number < 0 || number > 1) {
                    throw new ValueErrorException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            } catch (ValueErrorException e) {
                System.out.println("Choose 1 or 0");
            }
        }
        if (number == 0) {
            return;
        }
        System.out.println("Order is accepted you need to pay:" + CarShowroom.getCarList().get(choise - 1).getCost());
    }

    public static void changeEquipment(carShowroom CarShowroom, Scanner scanner) {
        int choise = 0;
        while (true) {
            viewOffers(CarShowroom);
            System.out.println("Enter number of car you want to change: 0 - back");
            try {
                choise = Integer.parseInt(scanner.next());
                if (choise > CarShowroom.getCarList().size() || choise < 0) {
                    throw new ValueErrorException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            } catch (ValueErrorException e) {
                System.out.println("Choise must be positive and < number of cars");
            }
        }
        if (choise == 0) {
            return;
        }
        int number = 0;
        System.out.println("What do you want to change ? 1-guarantee 2 - equipment " + CarShowroom.getCarList().get(choise - 1));
        while (true) {
            try {
                number = Integer.parseInt(scanner.next());
                if (number < 1 || number > 2) {
                    throw new ValueErrorException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            } catch (ValueErrorException e) {
                System.out.println("Choose 1 or 2");
            }
        }
        if (number == 1) {
            int number1;
            while (true) {
                try {
                    System.out.println("1 - +6 month +200$ 2 - -6 month -200$ 0-back");
                    number1 = Integer.parseInt(scanner.next());
                    if (number1 < 0 || number1 > 2) {
                        throw new ValueErrorException();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                } catch (ValueErrorException e) {
                    System.out.println("Choose 0-2");
                }
            }
            Function<Integer ,Integer, Integer> function = (arg1, arg2) -> arg1 + arg2;
            switch (number1) {
                case 1:
                    CarShowroom.getCarList().get(choise - 1).setGuaranteeMonth(function.apply(CarShowroom.getCarList().get(choise-1).getGuaranteeMonth(),6));
                    CarShowroom.getCarList().get(choise - 1).setCost(CarShowroom.getCarList().get(choise - 1).getCost() + 200);
                    System.out.println("Succesfull!");
                    break;
                case 2:
                    try {
                        if (CarShowroom.getCarList().get(choise - 1).getGuaranteeMonth() - 6 < 12) {
                            throw new ValueErrorException();
                        }
                        CarShowroom.getCarList().get(choise - 1).setGuaranteeMonth(CarShowroom.getCarList().get(choise - 1).getGuaranteeMonth() - 6);
                        CarShowroom.getCarList().get(choise - 1).setCost(CarShowroom.getCarList().get(choise - 1).getCost() - 200);
                    } catch (ValueErrorException e) {
                        System.out.println("Guarantee must be > 12");
                    }
                    break;
                case 0:
                    break;
            }
        }
        if (number == 2) {
            int number1;
            while (true) {
                try {
                    System.out.println("1 - yes +1000$   2 - -no -1000$ 0-back");
                    number1 = Integer.parseInt(scanner.next());
                    if (number1 < 0 || number1 > 2) {
                        throw new ValueErrorException();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                } catch (ValueErrorException e) {
                    System.out.println("Choose 0-2");
                }
            }
            switch (number1) {
                case 1:
                    try {
                        if (Objects.equals(CarShowroom.getCarList().get(choise - 1).getAdditionalFeatures(), "yes")) {
                            throw new ValueErrorException();
                        }
                        CarShowroom.getCarList().get(choise - 1).setAdditionalFeatures("yes");
                        CarShowroom.getCarList().get(choise - 1).setCost(CarShowroom.getCarList().get(choise - 1).getCost() + 1000);
                    } catch (ValueErrorException e) {
                        System.out.println("Car already has additional features");
                    }
                    break;
                case 2:
                    try {
                        if (Objects.equals(CarShowroom.getCarList().get(choise - 1).getAdditionalFeatures(), "no")) {
                            throw new ValueErrorException();
                        }
                        CarShowroom.getCarList().get(choise - 1).setAdditionalFeatures("no");
                        CarShowroom.getCarList().get(choise - 1).setCost(CarShowroom.getCarList().get(choise - 1).getCost() - 1000);
                    } catch (ValueErrorException e) {
                        System.out.println("Car already hasn't additional features");
                    }
                    break;
                case 0:
                    break;
            }
        }
    }

    public static int input_number(Scanner scanner)
    {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Try again");
            }
        }
        return number;
    }
}