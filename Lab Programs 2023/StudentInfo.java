import java.util.*;

class Student{
    Scanner sc = new Scanner(System.in);
    String Enrollment_id;
    String name;
    int sub1,sub2,sub3, total;

    Student(){
        readStudentInfo();
    }

    public void readStudentInfo(){
        System.out.println("Enter student details:");
        System.out.println("Enrollment Number: ");
        Enrollment_id = sc.next();
        System.out.println("Name: ");
        name = sc.next();
        System.out.println("Marks in three subjects: ");
        sub1 = sc.nextInt();
        sub2 = sc.nextInt();
        sub3 = sc.nextInt();
        if(sub1>=50 && sub2>=50 && sub3>=50){
            total = sub1+sub2+sub3;
        }
        else{
            total = 0;
        }
    }

    public void displayInfo(){
        System.out.println(Enrollment_id+" " + name + " " + total);

    }
}
public class StudentInfo {
    public static void main(String[] args){
        Student s[] = new Student[3];
        for(int i=0;i<3;i++){
            s[i] = new Student();
        }
        System.out.println("Student details are:");
        System.out.println("Enrollment_id Name Total");
        for(int i=0;i<3;i++){
            s[i].displayInfo();
        }
    }
}
