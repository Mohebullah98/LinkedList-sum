class Main {
  public static LinkedListNode sum(LinkedListNode a, LinkedListNode b){
    LinkedListNode head =null;
    int value=0;
    boolean carryover =false;
    while(a!=null||b!=null||carryover==true){
      LinkedListNode n = new LinkedListNode(0);
      if(a!=null){//only add value if list is not finished
        value+=a.data;
        a=a.next;
      }
      if(b!=null){
        value+=b.data;
        b=b.next;
      }
      if(carryover){ //make sure to add carryover
        value+=1;
        carryover=false;
      }
      if(value>9){//make sure to carryover
        value=value%10;
        carryover=true;
      }
      n.data=value;//add value to node of sumList, starting at tail
      value=0;
      n.next=head;
      head=n;
    }
    return head;
  }
  public static void printList(LinkedListNode head){
    while(head!=null){
      System.out.print(head.data+" ");
      head=head.next;
    }
  }
  public static LinkedListNode reverseList(LinkedListNode h){//reverse lists just so the addition can be viewed more easily
    LinkedListNode head=null;
    while(h!=null){
      LinkedListNode n= new LinkedListNode(h.data);
      n.next=head;
      head=n;
      h=h.next;
    }
    return head;
  }
  public static void main(String[] args) {
    LinkedListNode T = new LinkedListNode(7);
    LinkedListNode A = new LinkedListNode(1);
    LinkedListNode C = new LinkedListNode(6);
    LinkedListNode O = new LinkedListNode(5);
    LinkedListNode H= new LinkedListNode(9);
    LinkedListNode L= new LinkedListNode(2);
    T.next=A;A.next=C;C.next=null;//716
    O.next=H;H.next=L;L.next=null;//592
    //The numbers are represented backwards so it is actually 617+295
    printList(reverseList(T));//show the reverse list so addition is more readable
    System.out.print("\n");
    printList(reverseList(O));
    System.out.print("\n");
    System.out.print("________+\n");
    LinkedListNode head =sum(T,O);
    printList(head); //should print sum of 617+295
  }
}