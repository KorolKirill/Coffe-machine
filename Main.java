
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stock stock = start();

        boolean working = true;
        while (working) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    if (!scanner.hasNextInt()) {
                        String garbage = scanner.next();
                        break;
                    }
                    int option = scanner.nextInt();
                    String answer = stock.checker(option);
                    switch (option) {
                        case 1:
                            if (stock.checker(option).equals("")) {
                                stock.espresso();
                                System.out.println("I have enough resources, making you a coffee!");
                            } else {
                                System.out.println("Sorry, not enough "+answer+"!");
                            }
                            break;
                        case 2:
                            if (stock.checker(option).equals("")) {
                                stock.latte();
                                System.out.println("I have enough resources, making you a coffee!");
                            }else {
                                System.out.println("Sorry, not enough "+answer+"!");
                            }
                            break;
                        case 3:
                            if (stock.checker(option).equals("")) {
                                stock.cappuccino();
                                System.out.println("I have enough resources, making you a coffee!");
                            }else {
                                System.out.println("Sorry, not enough "+answer+"!");
                            }
                            break;
                    }
                    break;
                case "fill":
                    addIngredients(stock);
                    break;
                case "take":
                    System.out.println("I gave you $" + stock.getMoney());
                    stock.setMoney(0);
                    break;
                case "remaining":
                    status(stock);
                    break;
                case "exit":
                    working =false;
                    break;
            }
            System.out.println();
        }
    }
    public static void amountOfIngredients (int amount) {
        System.out.println("For " +amount + " cups of coffee you will need:\n" +
                amount*200 + "ml of water\n" +
                amount*50 + "ml of milk\n" +
                amount*15 + "g of coffee beans");

    }

    public static Stock start() {
        Stock stock = new Stock();
        stock.setCoffee(120);
        stock.setMilk(540);
        stock.setWater(400);
        stock.setMoney(550);
        stock.setDisposableCups(9);
        return stock;
    }

    public static void status(Stock stock) {
        System.out.println("" +
                "The coffee machine has:\n" +
                stock.getWater()+" of water\n" +
                stock.getMilk()+" of milk\n" +
                stock.getCoffee() +" of coffee beans\n" +
                stock.getDisposableCups() + " of disposable cups\n" +
                stock.getMoney()+" of money");
    }

    public static Stock askForStock() {
        Scanner scanner = new Scanner(System.in);
        Stock stock = new Stock();
        System.out.println("Write how many ml of water the coffee machine has: ");
        stock.setWater(scanner.nextInt());
        System.out.println("Write how many ml of milk the coffee machine has: ");
        stock.setMilk(scanner.nextInt());
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        stock.setCoffee(scanner.nextInt());
        return stock;
    }

    public static void howManyCups(Stock stock) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int wantedCups = scanner.nextInt();
        boolean checker = true;
        int tracker = 0;
        while (checker) {
            int water = stock.getWater();
            int milk = stock.getMilk();
            int coffee = stock.getCoffee();



            if (water < 200 || milk < 50 || coffee < 15 ) {
                checker =false;
            } else {
                tracker++;
            }
        }
        if ( wantedCups == tracker) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if ( tracker > wantedCups ) {
            System.out.println("Yes, I can make that amount of coffee " +
                    "(and even " + (tracker-wantedCups) +" more than that)");
        } else  {
            System.out.println("No, I can make only " + tracker + " cup(s) of coffee");
        }




    }

    public static Stock addIngredients(Stock stock) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add: ");
        stock.addWater(scanner.nextInt());
        System.out.println("Write how many ml of milk do you want to add: ");
        stock.addMilk(scanner.nextInt());
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        stock.addCoffee(scanner.nextInt());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        stock.addCups(scanner.nextInt());
        return stock;
    }
}
