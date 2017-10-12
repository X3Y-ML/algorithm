/**
 *Given four lists A, B, C, D of integer values,
 *compute how many tuples (i, j, k, l)
 *there are such that A[i] + B[j] + C[k] + D[l] is zero.
 *
 * To make problem a bit easier,
 * all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -228 to 228 - 1 and
 * the result is guaranteed to be at most 231 - 1.
 */

 /**
 *Input:
 *A = [ 1, 2]
 *B = [-2,-1]
 *C = [-1, 2]
 *D = [ 0, 2]
 *Output:
 *2
 *Explanation:
 *The two tuples are:
 *1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 *2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */

 import java.util.Arrays;
 import java.util.Map;
 import java.util.HashMap;

class LeetCode4Sum2{
  public static void main(String args[]){
    // int[] A = new int[]{1,2};
    // int[] B = new int[]{-2,-1};
    // int[] C = new int[]{-1,2};
    // int[] D = new int[]{0,2};
    int[] A = new int[]{-1,-1};
    int[] B = new int[]{-1,1};
    int[] C = new int[]{-1,1};
    int[] D = new int[]{1,-1};
    System.out.println(FourSumCount(A,B,C,D));

  }

  public static int FourSumCount(int[] A, int[] B, int[] C, int[] D){

    if (A == null || A.length <= 0 || B == null || B.length <= 0|| C == null || C.length <= 0 || C == null || C.length <= 0) {
		      return 0;
	 }

    int result = 0;

    int l = A.length;

    Map<Integer, Integer> abSum = new HashMap<>();

    for(int i = 0;i<l;i++){
      for(int j = 0;j<l;j++){
        int tmp = A[i] + B[j];
        abSum.put(tmp, abSum.getOrDefault(tmp, 0) + 1);
      }
    }

    for(int i = 0;i<l;i++){
      for(int j = 0;j<l;j++){
        int sum = C[i]+D[j];
        result += abSum.getOrDefault(-(C[i] + D[j]), 0);
        //  if(AB.contains(0-sum)){
        //    result++;
        //  }
      }
    }

    return result;

  }

}
