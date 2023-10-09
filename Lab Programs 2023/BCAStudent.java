import java.util.Scanner;
public class BCAStudent {
    String name,sex;
    int age;
    Scanner sc = new Scanner(System.in);

    public void getData(){
        System.out.println("Student name: ");
        name = sc.nextLine();
        System.out.println("Student Sex:");
        sex = sc.nextLine();
        System.out.println("Student Age:");
        age = Integer.parseInt(sc.nextLine());
    }

    public void display(){
        System.out.println("Student Details are ");
        System.out.println("Student Name: " + name);
        System.out.println("Student age: "+ age);
        System.out.println("Student sex: " + sex);
    }
}

