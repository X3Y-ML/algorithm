/**
 *题目:
 *Given an array of integers, find two numbers such that they add up to a specific target number.
 *The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *You may assume that each input would have exactly one solution.
 *Input: numbers={2, 7, 11, 15}, target=9
 *Output: index1=1, index2=2
 */

 /**
  *`又碰到敏感的关键字array和target`，自然而然想到二分查找法。但是这道题不能像传统二分查找法那样舍弃一半在另外一半查找，需要一点点挪low和high指针，所以时间复杂度为O(n)。
  *首先先将整个list拷贝并排序，使用Arrays.Sort()函数，时间复杂度O(nlogn)
  *然后利用二分查找法，判断target和numbers[low]+numbers[high]。
  *target == numbers[low]+numbers[high]， 记录copy[low]和copy[high]；
  *target > numbers[low]+numbers[high]，说明最大的和最小的加一起还小于target，所以小值要取大一点，即low++；
  *target > numbers[low]+numbers[high], 说明最大的和最小的加一起大于target，那么大值需要往下取一点，即high--。
  *再把找到的两个合格值在原list中找到对应的index，返回即可。
  *总共的时间复杂度为O(n+nlogn+n+n) = O(nlogn)。
  */
import java.util.HashMap;
import java.util.Arrays;

class LeetCodeTwoSum {

    public static void main(String args[]){
      int arr[] = {3,2,4};
      int target = 6;
      int result[] = twoSumByHashMap(arr,target);
      System.out.println("twoSumByHashMap:["+result[0]+","+result[1]+"]");
    }

  //1. 暴力破解o(N^2)
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
  // O(N)
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
  // sort()o(NlogN)+o(N)
  //这种方法比较适合已排序好的数组中

  //4 分治法
  public static int[] twoSumBy(int[] nums, int target){

    int [] res = new int[2];
    if(numbers==null||numbers.length<2){
      return res;
    }

    int[] copyArr = new int[nums.length];
    System.arraycopy(nums, 0, copyArr, 0, nums.length);
    Arrays.sort(copyArr);

    int low = 0;
    int high = copyArr.length;

    while(low<hight){
      if(copyArr[low]+copyArr[high]==target){
        res[0] = copyArr[low];
        res[1] = copyArr[high]
      }
    }

  }

}
