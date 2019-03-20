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
    //testing INSERTION
    int[] ary = {4,5,3,1,3,7,9,9,9,9,4,63,4,-7};
    insertionsort(ary,4,14);
    System.out.println(Arrays.toString(ary));
    System.out.println(Arrays.toString(Arrays.copyOfRange(ary,4,14)));
  }
  public static void mergesort(int[] data){
    mergesort(data,1);
  }
  public static void mergesort(int[] data,int k){
    int[] copy = Arrays.copyOfRange(data,0,data.length);
    msort(data,copy,0,data.length,k);
  }
  private static void msort(int[] data,int[] temp,int lo,int hi,int k){
    if(lo+k < hi){
      //recursive case: base case is empty, but implied is do nothing when lo>=hi
      //find approximate middle index
      int mid = (lo+hi) / 2;
      //mergesort first half(before middle index)
      msort(temp,data,lo,mid,k);
      //mergesort second half(including and after middle index)
      msort(temp,data,mid,hi,k);
      //merge the two together(the real work)
      merge(data,temp,lo,mid,hi);
    }else{
      insertionsort(data,lo,hi);
    }
  }
  private static void merge(int[] into,int[] withSorted,int lo,int mid,int hi){
    int loCounter = lo;
    int hiCounter = mid;
    int i = lo;
    while(i < hi && hiCounter < hi && loCounter < mid){
      //compare values: place in lower among hiCounter and loCounter index
      //                and tick up on the counter that is put in
      if(withSorted[loCounter] <= withSorted[hiCounter]){
        into[i++] = withSorted[loCounter++];
      }else{
        into[i++] = withSorted[hiCounter++];
      }
    }
    //add leftover values at the end
    while(i < hi && hiCounter < hi){
      //for if the hi counter didn't reach the end
      into[i++] = withSorted[hiCounter++];
    }
    while(i < hi && loCounter < mid){
      //for if the lo counter didn't reach the end
      into[i++] = withSorted[loCounter++];
    }
  }
  private static void insertionsort(int[] data,int lo,int hi){
    for(int i=lo+1;i<hi;i++){//at any given time, all values to the left of i are sorted
      int j = i;
      while(j > lo && data[j-1] > data[j]){
        swap(data,j-1,j--);
      }
    }
  }
  private static void swap(int[] data,int a,int b){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }
}
