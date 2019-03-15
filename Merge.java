import java.util.Arrays;
public class Merge{
  public static void main(String[] args){
    //testing MERGE
    int[] sortedSections = {2,3,7,1,2,4,5};
    int[] out = new int[sortedSections.length];
    merge(out,sortedSections,0,3,sortedSections.length);
    System.out.println(Arrays.toString(out));
    //for the hell of it
    int[] data = {6,3,45,5,6,78,8,8,8,9,2,8,-5,4,2};
    int[] data2 = Arrays.copyOfRange(data,0,data.length);
    mergesort(data);
    System.out.println(Arrays.toString(data));
    Arrays.sort(data2);
    System.out.println(Arrays.toString(data2));
  }
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
    int loCounter = lo;
    int hiCounter = mid;
    for(int i=lo;i<hi;i++){
      if(hiCounter < hi && loCounter < mid &&
         withSorted[hiCounter] < withSorted[loCounter]){
        //note the less than and not less than or equal to, preserves stability
        into[i] = withSorted[hiCounter++];
      }else{
        into[i] = withSorted[loCounter++];
      }
    }
  }
}
