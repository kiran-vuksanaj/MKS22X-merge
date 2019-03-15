import java.util.Arrays;
public class Merge{
  public static void mergesort(int[] data){
    int[] copy = Arrays.copyOfRange(data,0,data.length);
    msort(data,copy,0,data.length);
  }
  private static void msort(int[] data,int[] temp,int lo,int hi){
    if(lo < hi){
      //recursive case: base case is empty, but implied is do nothing when lo>=hi
      //find approximate middle index
      int mid = (lo+hi) / 2;
      //mergesort first half(before middle index)
      msort(temp,data,lo,mid);
      //mergesort second half(including and after middle index)
      msort(temp,data,mid,hi);
      //merge the two together(the real work)
      merge(data,temp,lo,mid,hi);
    }
  }
  private static void merge(int[] into,int[] withSorted,int lo,int mid,int hi){
    
  }
}
