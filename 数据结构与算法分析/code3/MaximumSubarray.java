import java.util.ArrayList;
import java.lang.Math;

class MaximumSubarray{

  public static void main(String args[]){
    int[] arr = {-2,11,-4,13,-5,-2};
    int[] arr1 = {-2,11,-4,-13,-5,-2};
    MaximumSubarray m = new MaximumSubarray();
    System.out.println(m.maxSubArraySum(arr1));
    System.out.println(MaximumSubarray.maxByDivide(arr1,0,arr1.length-1));
    System.out.println(m.maxSubArraySum(arr));
    System.out.println(MaximumSubarray.maxByDivide(arr,0,arr.length-1));
  }

  //任何负的子序列不可能是最优子序列的前缀
  //时间复杂度为N
  public int maxSubArraySum(int arr[]){
    int thisSum = 0;
    int maxSum = 0;
    for(int i=0; i<arr.length;i++){
      thisSum+=arr[i];
      if(thisSum<0){
        thisSum = 0;
      }
      //记录最大值
      if(maxSum<thisSum){
        maxSum = thisSum;
      }
    }
    return maxSum;
  }


  //分治法
  //思考:二分法
  //T(N):求最大子序列和的时间(N为数组的长度)
  //T(N)= 2(T(N/2))+N;
  //时间复杂度为N*Log(N)
  public static int maxByDivide(int arr[],int left,int right){
    if(left==right){
      if(arr[left]>0){
        return arr[left];
      }else{
        return 0;
      }
    }

    int center = (left+right)/2;
    int maxLeft = maxByDivide(arr,left,center);
    int maxright= maxByDivide(arr,center+1,right);

    int maxLeftBorder = 0;
    int LeftBorder = 0;
    int maxRightBorder = 0;
    int RightBorder = 0;

    for(int i = center;i>=left;i--){
      LeftBorder+=arr[i];
      if(maxLeftBorder<LeftBorder){
        maxLeftBorder = LeftBorder;
      }
    }

    for(int i = center+1;i<=right;i++){
      RightBorder+=arr[i];
      if(maxRightBorder<RightBorder){
        maxRightBorder = RightBorder;
      }
    }

    return Math.max(Math.max(maxLeft,maxright),maxLeftBorder+maxRightBorder);
  }
}
