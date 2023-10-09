public class Square {    
    public static boolean isSquare(int n) {        
        int test = (int)Math.sqrt(n);
        if((test * test) == n){
            return true;
        }
        else{
            return false;
        }
    }
}