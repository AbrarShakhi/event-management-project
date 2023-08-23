package control;

import people.User;

public class Price {
    private final int oneFoodPrice;
    private final int colorPrice;
    
    // private  int premiumDiscount;
    private int totalPrice;

    public Price() {
        oneFoodPrice = 10;
        colorPrice = 5;
    }

    public void calculate(User user) {
        var numberOfFoodItem = user.getEvent().getFood().length;
        totalPrice = (numberOfFoodItem * oneFoodPrice) + colorPrice;
    }

    public String getTotalPrice(){
        return Integer.toString(totalPrice);
    }
}
