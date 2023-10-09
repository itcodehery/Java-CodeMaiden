class Student{
    static String collegeName = "PES College";
    int rollNo;
    String name;

    Student(int rollNo, String name){
        this.rollNo = rollNo;
        this.name = name;
    }

    void display(){
        System.out.prinlnt(collegeName + " " + rollNo + " " + name);
    }
}
public class StaticDemo {
    public static void main(String args[]){
        System.out.println("Objects Sharing the static Variable - College Name \n");
        Student s1 = new Student(1001, "Srikanth");
        Student s2 = new Student(1002, "Srinivas");
        s1.display();
        s2.display();
        System.out.println("Static value changed by one of the objects");
        s1.collegeName = "Jain College";
        s1.display();
        s2.display();
    }
}
