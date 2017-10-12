// Fibonacci
// 1   1   2   3    5    7   12

public class Fibonacci{
  public static void main(String args[]){
    System.out.println(""+getFibonacci(3));
  }

  public static int getFibonacci(int nums){
    int[] arr = new int[nums];

    if(nums<=0){
      return 0;
    }

    if(nums==1||nums==2){
      return 1;
    }

    arr[0]=arr[1]=1;

    for(int i=2;i<nums;i++){
        arr[i] = arr[i-2]+arr[i-1];
    }
    return arr[nums-1];
  }

}
