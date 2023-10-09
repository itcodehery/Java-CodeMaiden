import java.util.Calendar;
public class dateDemo {
    public static void main(String[] args){
        Calendar calendar = Calendar.getInstance();
        String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        System.out.println("Current month = " + month[calendar.get(Calendar.MONTH)]);
    }
}
