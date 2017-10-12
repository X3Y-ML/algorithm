class Find{
  public static void main(String args[]){

  }

  public static boolean find(int target, int [][] array){

    int a = array.length;
    int b = array[0].length;

    for(int i = 0;i<a;i++){
      int low = 0;
      int high = b-1;
      while(low<=high){
        int mid = (low+high)/2;
        if(array[i][mid]==target){
          return true;
        }else if(target>array[i][mid]){
          low=mid+1;
        }else{
          high=mid-1;
        }
      }
    }
    return false;
  }
}
