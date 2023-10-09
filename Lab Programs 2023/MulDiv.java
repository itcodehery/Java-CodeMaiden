class AddSub{
    int n1, n2;

    public AddSub(int x, int y){
        n1 = x;
        n2 = y;
    }

    public int add(){
        return (n1+n2);
    }

    public int sub(){
        return (n1-n2);
    }
}

public class MulDiv extends AddSub{
    public MulDiv(int x, int y){
        super(x, y);
    }

    public int mul(){
        return n1*n2;
    }

    public int div(){
        return n1/n2;
    }
}

public class ArithmeticOperations{
    public static void main(String[] args){
        MulDiv obj = new MulDiv(20, 10);
        System.out.println("Sum of 20 and 10 is: " + obj.add());
        System.out.println("Difference of 20 and 10 is: " + obj.sub());
        System.out.println("Product of 20 and 10 is: " + obj.mul());
        System.out.println("Quotient of 20 and 10 is: " + obj.div());
    }
}