/**
 *题目:
 *Given an array of integers, find two numbers such that they add up to a specific target number.
 *The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *You may assume that each input would have exactly one solution.
 *Input: numbers={2, 7, 11, 15}, target=9
 *Output: index1=1, index2=2
 */
import java.util.HashMap;

class LeetCodeTwoSum {

    public static void main(String args[]){
      int arr[] = {3,2,4};
      int target = 6;
      int result[] = twoSumByHashMap(arr,target);
      System.out.println("twoSumByHashMap:["+result[0]+","+result[1]+"]");
    }

  //1. 暴力破解
  public static int[] twoSum(int[] nums, int target) {
    int result[] = {0,0};
    for(int i =0; i<nums.length ;i++){
      for(int j = i+1; j<nums.length ;j++){
        if((nums[i]+nums[j])==target){
          result[0] = i;
          result[1] = j;
          return result;
        }
      }
    }
    return result;
  }


  //使用HashMap的思考:
  //2. HashMap的map.containsKey 替代了 一个for循环
  public static int[] twoSumByHashMap(int[] nums, int target) {
    int result[] = new int[2];
    if(nums==null||nums.length<2){
      return result;
    }

    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    for(int i= 0;i<nums.length;i++){
      if(map.containsKey(target-nums[i])){
        result[0] = map.get(target-nums[i]);
        result[1] = i;
        return result;
      }else{
        map.put(nums[i],i);
      }
    }
    return result;
  }

  //3. 先sort;然后从中间两个一正一负开始向两边遍历,判断和是否为target
  //这种方法比较适合已排序好的数组中


}
