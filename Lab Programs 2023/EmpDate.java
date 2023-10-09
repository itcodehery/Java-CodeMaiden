import java.util.Date;
class Employee{
    String name;
    Date appDate;

    public Employee (String nm, Date apdt){
        name = nm;
        appDate = apdt;
    }

    public void display(){
        System.out.println("Name: " + name);
        System.out.println("Appointment Date: " + appDate);
    }
}
public class EmpDate {
    public static void main(String[] args){
        Employee emp[] = new Employee[10];
        emp[0] = new Employee("Neeraja K", new Date(1999, 04,22));
        emp[1] = new Employee("Sneha", new Date(1999, 04,22));
        emp[2] = new Employee("Sneha", new Date(1999, 04,22));
        emp[3] = new Employee("Sneha", new Date(1999, 04,22));
        emp[4] = new Employee("Sneha", new Date(1999, 04,22));
        emp[5] = new Employee("Sneha", new Date(1999, 04,22));
        emp[6] = new Employee("Sneha", new Date(1999, 04,22));
        emp[7] = new Employee("Sneha", new Date(1999, 04,22));
        emp[8] = new Employee("Sneha", new Date(1999, 04,22));
        emp[9] = new Employee("Sneha", new Date(1999, 04,22));
        for(int i=0;i<10;i++){
            emp[i].display();
        }
        for(int i=0; i< emp.length ; i++){
            for(int j = i+1; j < emp.length; j++){
                if(emp[i].appDate.after(emp[j].appDate)){
                    Employee temp = emp[i];
                    emp[i] = emp[j];
                    emp[j] = temp;
                }
            }
        }
        System.out.println("\nList of Employees Seniority Wise:");
        for(int i=0;i<10;i++){
            emp[i].display();
        }
    }
}
