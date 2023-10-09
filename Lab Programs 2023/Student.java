import java.util.*;
class FirstYear{
    String classname;
    String classteacher;
    int stdcount;
    int stdmarks[] = new int[50];
    String stdnames[] = new String[50];
    Scanner sc = new Scanner(System.in);

    public FirstYear(){
        getInfo();
    }

    public void getInfo(){
        System.out.println("Enter class name: ");
        classname = sc.next();
        System.out.println("Enter class teacher name: ");
        classteacher = sc.next();
        System.out.println("Enter number of students: ");
        stdcount = Integer.parseInt(sc.next());
        System.out.println("Enter names of all students ");
        for(int i=0;i<stdcount;i++){
            stdnames[i] = sc.next();
        }
        System.out.println("Enter marks of all students ");
        for(int i=0;i<stdcount;i++){
            stdmarks[i] = sc.nextInt();
        }
    }
    public void bestStudent(){
            int best = 0, k = -1;
            for(int i = 0; i< stdcount ; i++){
                if(stdmarks[i] > best){
                    best = stdmarks[i];
                    k = i;
                }
            }
            System.out.println("The best student is " + stdnames[k] + " with marks " + best);
        }
}
public class Student {
    public static void main(String[] args){
        FirstYear fy = new FirstYear();
        fy.bestStudent();
    }
}
