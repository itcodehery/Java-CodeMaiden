public class DivisionByZeroDemo {
public static void main(String[] args){
    int a = 5;
    int b = 0;
    try{
        System.out.println(a/b);
    }
    catch(ArithmeticException e){
        System.out.println("Division by zero is not possible");
    }
}    
}
