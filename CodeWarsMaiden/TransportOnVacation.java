public class TransportOnVacation {
    public static int rentalCarCost(int d) {
    // Your solution here
    int price = 0;
    
    if(d >= 3 && d < 7){
        price = (d * 40) - 20;
    }
    else if(d >= 7){
        price = (d * 40) - 50;
    }
    else{
        price = d * 40;
    }
    return price;
  }
}
