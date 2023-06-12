package StringSort;
import java.util.*;
public class StringSort {
	public static String[] stringSort(String[] allMain) {
		String[] sortedStrArr = allMain;
		Arrays.sort(sortedStrArr);	// uses Java Language package
		return sortedStrArr;
	}
	
	public StringSort() {
		Scanner sc = new Scanner(System.in);
		String main = "";
		String[] allMain = new String[10];
		System.out.println("Enter the group of Strings: ");
		main = sc.nextLine();
		allMain = main.split(" ");
		allMain = stringSort(allMain);		//method call
		for(String thisMain: allMain) {
			System.out.println(thisMain + " ");
		}
		sc.close();
	}

	public static void main(String[] args){
		StringSort newRequest = new StringSort();
	}
}
