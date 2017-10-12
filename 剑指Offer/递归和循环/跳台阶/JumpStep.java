public class JumpStep{
  public static void main(String args[]){
    System.out.println(""+count(10));
  }

  public static int count(int a){
    if(a<=0){
      return 0;
    }else if(a==1){
      return 1;
    }else if(a==2){
      return 2;
    }else{
      int[] arr =  new int[a];
      arr[0] = 1;
      arr[1] = 2;
      for(int i=2;i<a;i++){
        arr[i] = arr[i-1]+arr[i-2];
      }
      return arr[a-1];
    }
  }
}
