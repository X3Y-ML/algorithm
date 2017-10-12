public class RectCover {

    public static void main(String args[]){
      System.out.println(""+RectCoverStep(10));
    }

    public static int RectCoverStep(int target) {
        if(target<=0){
            return 0;
        }else if(target == 1){
            return 1;
        }else if(target == 2){
            return 2;
        }else{
            int[] arr = new int[target];
            arr[0] = 1;arr[1] = 2;
            for(int i=2;i<target;i++){
                arr[i] = arr[i-1]+arr[i-2];
            }
            return arr[target-1];
        }

    }
}
