/**
 *LeetCode – 4Sum (Java)
 */
import java.util.ArrayList;
import java.util.Arrays;

class LeetCode4Sum{
  public static void main(String args[]){
    // int[] arr = new int[]{1,0,-1,0,-2,2};
    int[] arr = new int[]{-3,-2,-1,0,0,1,2,3};
    ArrayList<ArrayList<Integer>> result = Sum4(arr);

    for(int i = 0;i<result.size();i++){
      ArrayList<Integer> unit = result.get(i);
      for(int j = 0;j<unit.size();j++){
        System.out.print(unit.get(j)+",");
      }
      System.out.println("");
    }
    System.out.println(result.size());

  }

  public static ArrayList<ArrayList<Integer>> Sum4(int[] arr){
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    if(arr.length<4||arr==null){
      return result;
    }
    Arrays.sort(arr);

    for(int i = 0;i<arr.length-3;i++){
      if(i!=0&&arr[i]==arr[i-1]){
        System.out.println("输出i："+i);
        continue;
      }

      for(int j = i+1;j<arr.length-2;j++){

        if(j!=i+1&&arr[j]==arr[j-1]){
          continue;
        }

        int low = j+1;
        int high = arr.length-1;
        while(low<high){
          int sum = arr[i]+arr[j]+arr[low]+arr[high];
          if(sum==0){
            ArrayList<Integer> unit = new ArrayList<Integer>();
            unit.add(arr[i]);
            unit.add(arr[j]);
            unit.add(arr[low]);
            unit.add(arr[high]);
            result.add(unit);

            low++;
            high--;

            while(low<high&&arr[low]==arr[low-1]){
              low++;
            }

            while(low<high&&arr[high] == arr[high+1]){
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

    return result;

  }

}
