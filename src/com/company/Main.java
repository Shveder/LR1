package com.company;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {


    @FunctionalInterface
    interface Function<T1, T2, R> {
        R apply(T1 arg1, T2 arg2);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Thr thr = new Thr();
        thr.run(1,19);
        Thread t  = new Thread(new Run());
        t.start();









        UserList userList = new UserList();
        String fileName = "Users.txt";
        carShowroom CarShowroom = new carShowroom();
        List<Car> currentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        userList.readDataFromFile(fileName);
        CarShowroom.addCar(new Car("Porche", 12, "yes", 20000));
        CarShowroom.addCar(new Car("Lamborgini", 18, "no", 25000));
        CarShowroom.addCar(new Car("Mercedes", 30, "yes", 15000));


        int role;
        while(true) {
            String[] options =
                    {
                            "Choose option: ",
                            "1 - Log in",
                            "2 - Create new account",
                            "0 - Exit"
                    };
            for (String option : options) {
                System.out.println(option);
            }
            int number = input_number(scanner);
            switch (number) {
                case 1:
                    role = authorization(userList, scanner);
                    switch (role)
                    {
                        case 0:
                            System.out.println("You are banned");
                            break;
                        case 1:
                            useAsAdmin(CarShowroom, scanner, userList, currentList);
                            break;
                        case 2:
                            useAsUser(CarShowroom, scanner, currentList);
                            break;
                    }
                    userList.writeDataToFile(fileName);
                    break;
                case 2:
                    createNewUser(userList, scanner);
                    break;
                case 0:
                    userList.writeDataToFile(fileName);
                    return;
            }
        }
    }

    public static void useAsUser(carShowroom CarShowroom, Scanner scanner, List<Car>currentList) {
        while (true) {
            int choice = 0;
            printUserMenu();
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
            switch (choice) {
                case 1:
                    viewOffers(CarShowroom);
                    break;
                case 2:
                    addOffer(scanner);
                    currentList = carShowroom.getCarList();
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
                    currentList = carShowroom.getCarList();
                    filter(CarShowroom, scanner, currentList);
                    carShowroom.setList(currentList);
                    break;
                case 8:
                    MyThread myThread = new MyThread();
                    myThread.start();
                    break;
                case 9:
                    Thread thread = new Thread(new Runner());
                    thread.start();
                    break;
            }
        }//admin
    }

    public static void useAsAdmin(carShowroom CarShowroom, Scanner scanner, UserList userList, List<Car>currentList) {
        while (true) {
            int choice = 0;
            printAdminMenu();
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
            switch (choice) {
                case 1:
                    viewOffers(CarShowroom);
                    break;
                case 2:
                    addOffer(scanner);
                    currentList = carShowroom.getCarList();
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
                    currentList = carShowroom.getCarList();
                    filter(CarShowroom, scanner, currentList);
                    CarShowroom.setList(currentList);
                    break;
                case 7:
                    userMenu(userList, scanner);
                    break;
                case 8:
                    MyThread myThread = new MyThread();
                    myThread.start();
                    break;
                case 9:
                    Thread thread = new Thread(new Runner());
                    thread.start();
                    break;
            }
        }//admin
    }

    private static void userMenu(UserList userlist, Scanner scanner){
        String[] options =
                {
                        "Choose option: ",
                        "1 - Print all users.",
                        "2 - Find user by login.",
                        "3 - Edit.",
                        "4 - Delete.",
                        "5 - Ban.",
                        "6 - Create new.",
                        "0 - Exit."
                };

        int choice = 0;
        do {
            for (String option : options) {
                System.out.println(option);
            }
            choice = input_number(scanner);
            if(userlist != null){
                switch (choice){
                    case 1:
                        userlist.getUserList().stream().forEach(n->System.out.println(n));
                        break;
                    case 2:
                        User.findByLogin(userlist, scanner);
                        break;
                    case 3:
                        User.editUser(userlist, scanner);
                        break;
                    case 4:
                        User.deleteUser(userlist, scanner);
                        break;
                    case 5:
                        User.BanUser(userlist, scanner);
                        break;
                    case 6:
                        createNewUser(userlist, scanner);
                        break;
                }
            }else{
                System.out.println("UserList is empty");
            }
        } while (choice != 0);
    }

    public static void filter(carShowroom CarShowroom,Scanner scanner, List<Car>currentList) {
        String filteredByAddF = "0";
        String filteredByNoAddF = "0";
        int filteredByMaxGuar = 0;
        int filteredByMinCost = 0;
        int filteredByMaxCost = 0;
        int filteredByMinGuar = 0;
        while(true) {
            System.out.println("----Filter menu----");
            System.out.println(" 1 - Filter \n 2 - Remove filter \n 3 - Buy car \n 4 - View offers \n 5 -sort\n 0 - Exit");
            int choice4 = 0;
            int choice2 = 0;
            choice4 = input_number(scanner);
            if(choice4==5)
            {
                MyThread myThread = new MyThread();
                myThread.start();
            }
            if(choice4==6)
            {
                Thread thread = new Thread(new Runner());
                thread.start();
            }
            if (choice4 == 1)
                while (true) {
                    System.out.print(" 1- Filter by addF \n 3 - Filter by minCost \n 4 - filter By maxCost \n 5 - filter by minGuar \n 6 - filter by maxGuar \n 0 - Exit ");
                    choice2 = input_number(scanner);
                    switch (choice2) {
                        case 1:
                            System.out.println(" 1 - yes 2 - no 0 - back");
                            int choice3 = input_number(scanner);
                            if (choice3 == 1)
                            {
                                filteredByAddF = "yes";
                                CarShowroom.setList(filterByAdditionalFeatures(CarShowroom.getCarList(), filteredByAddF));}
                            if (choice3 == 2) {
                                filteredByNoAddF = "no";
                                CarShowroom.setList(filterByAdditionalFeatures(CarShowroom.getCarList(), filteredByNoAddF));
                            }
                            break;
                        case 3:
                            System.out.println("Enter lower limit: ");
                            filteredByMinCost = input_number(scanner);
                            CarShowroom.setList(filterByMinCost(CarShowroom.getCarList(), filteredByMinCost));
                            break;
                        case 4:
                            System.out.println("Enter upper limit: ");
                            filteredByMaxCost = input_number(scanner);
                            CarShowroom.setList(filterByMaxCost(CarShowroom.getCarList(), filteredByMaxCost));
                            break;
                        case 5:
                            System.out.println("Enter lower guar: ");
                            filteredByMinGuar = input_number(scanner);
                            CarShowroom.setList(filterByMinGuarantee(CarShowroom.getCarList(), filteredByMinGuar));
                            break;
                        case 6:
                            System.out.println("Enter upper guar: ");
                            filteredByMaxGuar = input_number(scanner);
                            CarShowroom.setList(filterByMaxGuarantee(CarShowroom.getCarList(), filteredByMaxGuar));
                            break;
                    }
                    if (choice2 == 0)
                        break;
                }
            if (choice4 == 2) {
                int choice5 = 0;
                while (true) {
                    System.out.println(" 1 - remove addF filter \n 2- remove guar filter \n 3 - remove cost filter \n 0-back");
                    choice5 = input_number(scanner);
                    switch (choice5) {
                        case 1:
                            filteredByAddF = "0";
                            filteredByNoAddF = "0";
                            CarShowroom.setList(currentList);
                            if (filteredByMinGuar != 0)
                                CarShowroom.setList(filterByMinGuarantee(carShowroom.getCarList(), filteredByMinGuar));
                            if (filteredByMaxGuar != 0)
                                CarShowroom.setList(filterByMaxGuarantee(carShowroom.getCarList(), filteredByMaxGuar));
                            if (filteredByMinCost != 0){
                                CarShowroom.setList(filterByMinCost(carShowroom.getCarList(), filteredByMinCost));}
                            if (filteredByMaxCost != 0){
                                CarShowroom.setList(filterByMaxCost(carShowroom.getCarList(), filteredByMaxCost));}
                            break;
                        case 2:
                            filteredByMinGuar = 0;
                            filteredByMaxGuar = 0;
                            CarShowroom.setList(currentList);
                            if (!filteredByAddF.equals("0"))
                                CarShowroom.setList(filterByAdditionalFeatures(carShowroom.getCarList(), filteredByAddF));
                            if (!filteredByNoAddF.equals("0"))
                                CarShowroom.setList(filterByAdditionalFeatures(carShowroom.getCarList(), filteredByNoAddF));
                            if (filteredByMinCost != 0)
                                CarShowroom.setList(filterByMinCost(carShowroom.getCarList(), filteredByMinCost));
                            if (filteredByMaxCost != 0){
                                CarShowroom.setList(filterByMaxCost(carShowroom.getCarList(), filteredByMaxCost));}
                            break;
                        case 3:
                            filteredByMinCost = 0;
                            filteredByMaxCost = 0;
                            CarShowroom.setList(currentList);
                            if (!filteredByAddF.equals("0"))
                                CarShowroom.setList(filterByAdditionalFeatures(carShowroom.getCarList(), filteredByAddF));
                            if (!filteredByNoAddF.equals("0"))
                                CarShowroom.setList(filterByAdditionalFeatures(carShowroom.getCarList(), filteredByNoAddF));
                            if (filteredByMinGuar != 0)
                                CarShowroom.setList(filterByMinGuarantee(carShowroom.getCarList(), filteredByMinGuar));
                            if (filteredByMaxGuar != 0){
                                CarShowroom.setList(filterByMaxGuarantee(carShowroom.getCarList(), filteredByMaxGuar));}
                            break;
                    }
                    if (choice5 == 0)
                        break;
                }
            }
            if (choice4 == 3) {
                buyCar(CarShowroom, scanner);
            }
            if(choice4 == 4)
                viewOffers(CarShowroom);
            if (choice4 == 0)

                break;
        }

    }

    private static void createNewUser(UserList userlist, Scanner scanner){
        System.out.println("Enter Login: ");
        String login = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        System.out.println("Confirm password: ");
        String confirmPassword = scanner.next();
        if(login.length() < 4){
            System.out.println("Login must be longer than 4 symbols");
            return;
        }
        if(password.length() < 4){
            System.out.println("Password must be longer than 4 symbols");
            return;
        }
        if(!isLoginUnique(userlist, login)){
            System.out.println("Login isn't unique");
            return;
        }
        if(!confirmPassword.equals(password)){
            System.out.println("Passwords do not match");
            return;
        }
        if(login.length() > 16){
            System.out.println("Login must be less than 16 symbols");
            return;
        }
        if(password.length() > 16){
            System.out.println("Password must be less than 16 symbols");
            return;
        }

        UserCreator uc = new UserCreator();
        userlist.addUser(uc.createUser(login, password, 2));
    }

    private static int authorization(UserList userList, Scanner scanner){
        System.out.println("Enter Login: ");
        String login = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        for(var i: userList.getUserList()){
            if(i.getLogin().equals(login) && i.getPassword().equals(password)){
                return i.getRole();
            }
        }
        System.out.println("Incorrect Login or Password");
        return -1;
    }

    private static boolean isLoginUnique(UserList userList, String login){
        for(var i:userList.getUserList()){
            if(i.getLogin().equals(login)){
                return false;
            }
        }
        return true;
    }

    public static List<Car> filterByMaxGuarantee(List<Car>carList,int guaranteeMonth) {
        return carList.stream()
                .filter(car -> car.getGuaranteeMonth() < guaranteeMonth)
                .collect(Collectors.toList());
    }

    public static List<Car> filterByMinGuarantee(List<Car>carList,int guaranteeMonth) {
        return carList.stream()
                .filter(car -> car.getGuaranteeMonth() > guaranteeMonth)
                .collect(Collectors.toList());
    }

    public static List<Car> filterByAdditionalFeatures(List<Car>carList,String string) {

        return carList.stream()

                .filter(car -> car.getAdditionalFeatures().equals(string))
                .collect(Collectors.toList());
    }

    public static List<Car> filterByMaxCost(List<Car>carList, int cost) {
        return carList.stream()
                .filter(car -> car.getCost() < cost)
                .collect(Collectors.toList());
    }

    public static List<Car> filterByMinCost(List<Car>carList, int cost) {
        return carList.stream()
                .filter(car -> car.getCost() > cost)
                .collect(Collectors.toList());
    }

    public static void printAdminMenu() {
        System.out.println("-----------Menu------------");
        System.out.println("\t 1 - View offers\n\t 2 - New Offer\n\t 3 - Buy car\n\t 4 - Change equipment\n\t 5 - Exit\n\t 6 -Filter \n\t 7 - Users \n\t 8 - sort by cost \n\t 9 -sort by cost reverse");
    }

    public static void printUserMenu() {
        System.out.println("-----------Menu------------");
        System.out.println("\t 1 - View offers\n\t 2 - New Offer\n\t 3 - Buy car\n\t 4 - Change equipment\n\t 5 - Exit\n\t 6 -Filter \n\t 8 - sort by cost \n\t 9 -sort by cost reverse");
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
            System.out.println("No cars!");
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
                System.out.println(" Choise must be positive and < number of cars");
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
                    System.out.println("Successful!");
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

    public static int input_number(Scanner scanner) {
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