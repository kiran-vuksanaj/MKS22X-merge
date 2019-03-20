import java.io.*;
import java.util.*;
public class InsertionBalance{
  public static void main(String[] args){
    while(true){
      int k = (int)(Math.random()*249)+1;
      int[] ary = TypeDriver.makeArray(5000000,2);
      int[] ary2 = Arrays.copyOfRange(ary,0,ary.length);
      long builtinStart = System.currentTimeMillis();
      Arrays.sort(ary);
      long builtinEnd = System.currentTimeMillis();
      long timeStart = System.currentTimeMillis();
      Merge.mergesort(ary2,k);
      long timeEnd = System.currentTimeMillis();
      if(!(Arrays.equals(ary,ary2))) throw new RuntimeException("FAIL TO SORT");
      double val = (timeEnd-timeStart)/((double)builtinEnd-builtinStart);
      System.out.println(k+","+val);
    }
  }
  private static double sum(double[] ary){
    double out = 0;
    for(double val : ary){
      out += val;
    }
    return out;
  }
}
