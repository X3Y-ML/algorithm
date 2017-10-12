import java.util.Arrays;
import java.util.ArrayList;

class LeetCode3Sum{
  public static void main(String args[]){
    int[] arr = new int[]{-1,0,1,2,-1,-4};
    ArrayList<ArrayList<Integer>> result = Sum3(arr);
    for(int i = 0;i<result.size();i++){
      ArrayList<Integer> unit = result.get(i);
      for(int j = 0;j<unit.size();j++){
        System.out.print(unit.get(j)+",");
      }
      System.out.println("");
    }
    System.out.println(result.size());
  }

  public static ArrayList<ArrayList<Integer>> Sum3(int[] arr){

    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if(arr.length<3||arr==null){
      return res;
    }

    Arrays.sort(arr);

    for(int i=0;i<arr.length;i++){
      if(i==0||arr[i]!=arr[i-1]){//remove dupicate
          int low = i+1;
          int high = arr.length-1;

          while(low<high){
            int sum = arr[low]+arr[high]+arr[i];

            if(sum == 0){
              ArrayList<Integer> unit = new ArrayList<Integer>();
              unit.add(arr[i]);
              unit.add(arr[low]);
              unit.add(arr[high]);
              res.add(unit);
              high--;
              low++;

              while(low<high&&arr[low]==arr[low-1]){
                low++;
              }
              while(low<high&&arr[high]==arr[high+1]){
                high--;
              }

            }else if(sum>0){
              high--;
            }else{
              low++;
            }
          }
        }

    }

    return res;
  }

}
