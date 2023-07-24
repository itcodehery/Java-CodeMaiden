public class Counter {
  public int countSheeps(Boolean[] arrayOfSheeps) {
    int count = 0;
    for(Boolean i : arrayOfSheeps){
      if(i == true) count+=1;
      if(i == null){};
    }
    return count;
  }
}