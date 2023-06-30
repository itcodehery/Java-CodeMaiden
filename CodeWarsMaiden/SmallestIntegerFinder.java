import java.util.stream.IntStream;

public class SmallestIntegerFinder {
    // public static int findSmallestInt(int[] args) {
    //   int smallest = args[0];
    //   for(int i = 1 ; i < args.length ; i++){
    //     if(smallest > args[i]){
    //       smallest = args[i];
    //     }
    //   }
    //   return smallest;
    // }
    public static int findSmallestInt(int[] args){
      return IntStream.of(args).min().getAsInt();       //efficient, fast and definitely not my code
    }
}