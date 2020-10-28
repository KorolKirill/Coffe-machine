package machine;

public class Stock {
    private int water;
    private int milk;
    private int coffee;
    private int money;
    private int disposableCups;

    public  String checker(int option) {
        String answer = "";
        switch (option) {
            case 1:
                if (water < 250) {answer="water";}
                if (coffee < 16) {answer= "coffee";}
                break;
            case 2:
                if (water < 350) {answer="water";}
                if (coffee < 20) {answer= "coffee";}
                if (milk < 75 ) {answer="milk";}
                break;
            case 3:
                if (water < 200) {answer="water";}
                if (coffee < 12) {answer= "coffee";}
                if (milk < 100 ) {answer="milk";}
                break;
        }
        return answer;
    }

    public void addWater(int water) {
        this.water+=water;
    }
    public void addCoffee(int coffee) {
        this.coffee += coffee;
    }
    public void addMilk(int milk) {
        this.milk+=milk;
    }
    public void addCups(int cups) {
        this.disposableCups+=cups;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getMilk() {
        return milk;
    }

    public int getWater() {
        return water;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public void espresso() {
        this.water -= 250;
        this.coffee -= 16;
        this.money += 4;
        this.disposableCups--;
    }
    public void latte() {
        this.water -= 350;
        this.milk -= 75;
        this.coffee -= 20;
        this.money += 7;
        this.disposableCups--;
    }

    public void cappuccino() {
        this.water -= 200;
        this.milk -= 100;
        this.coffee -= 12;
        this.money += 6;
        this.disposableCups--;
    }

    public void setDisposableCups(int disposableCups) {
        this.disposableCups = disposableCups;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

}
