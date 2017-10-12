class PrintListFromTailToHead{
  public static void main(String args[]){

  }

  public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){

    if(listNode == null){
      return new ArrayList<Integer>();
    }

    if(listNode.next == null){
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(listNode.val);
      return list;
    }else{
      ArrayList<Integer> relist = printListFromTailToHead(listNode.next);
      relist.add(listNode.val);
      return relist;
    }
  }


  public class ListNode {
      int val;
     ListNode next = null;

      ListNode(int val) {
         this.val = val;
     }
   }

}
