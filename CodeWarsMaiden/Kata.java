/* for a given array of integers return an 
 * array in which the first element in 
 */

public class Kata
{
    public static int[] countPositivesSumNegatives(int[] input)
    {
        int[] output = new int[2];
        int posCount = 0;
        int sumNeg = 0;
        if(input != null){
            for(int i = 0; i < input.length ; i++){
            if(input[i] > 0){
                posCount += 1;
            }
            else{
                if(input[i] < 0){
                    sumNeg += input[i];
                }
            }
        }
        output[0] = posCount;
        output[1] = sumNeg;
        return output;
        }
        else{
            return output;
        } //return an array with count of positives and sum of negatives
    }
}