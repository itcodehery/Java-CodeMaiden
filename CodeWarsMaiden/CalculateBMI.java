public class CalculateBMI {
  public static String bmi(double weight, double height) {
    double bmi = weight / (height * height);
    if(bmi <= 18.5){
      return "Underweight";
    }
    else if(bmi > 18.5 && bmi <= 25.0){
      return "Normal";
    }
    else if(bmi > 25.0 && bmi <= 30.0){
      return "Overweight";
    }
    else if(bmi > 30){
     return "Obese"; 
    }
    else
      return "";
  }
}