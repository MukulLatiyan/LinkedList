// code 

// count the nodes of the linked list
private int getCount(Node head){
    if(head == null) return;
    Node temp = head;
    int count = 0;
    while(temp!=null){
        count++;
        temp = temp.next;
    }
    return count;
}

// linked list length(odd or even)
private boolean isEven(Node head){
    if(head == null) return;
    Node temp = head;
    int count = 0;
    while(temp!=null){
        count++;
        temp = temp.next;
    }
    if(count%2 == 0){
        return true;
    }
    return false;
}

// print linked list elements
private void printList(Node head){
    if(head == null) return;
    Node temp = head;
    while(temp!=null){
        System.out.print(temp.data+" ");
        temp = temp.next;
    }
    System.out.println();
}

// sum of nodes of linked list
private int linkedListSum(Node head){
    if(head == null) return;
    Node temp = head;
    int sum = 0;
    while(temp!=null){
        sum +=temp.data;
        temp = temp.next;
    }
    return sum;
}

/*----Insertion----*/

// insert at the begining of linked list
private void push(int new_data){
    Node new_node = new Node(new_data);
    new_node.next = head;
    head = new_node;
}

// after a given node
private void insertAfter(Node prev_node,int new_data){
    if(prev_node == null){
        return;
    }
    Node new_node = new Node(new_data);
    new_node.next = prev_node.next;
    prev_node.next = new_node;
}

// at a given position 
private void insertAtPosition(Node head,int new_data,int pos){
    Node new_node = new Node(new_data);
    Node temp = head;
    if(pos == 0){
       head.next = new_node;
       return;
    }
    for(int i=0;temp!=null && i<pos-1;i++){
        temp = temp.next;
    }
    new_node.next = temp.next;
    temp.next = new_node;
}

// at the end of linked list
private void insertAtEnd(Node head,int new_data){
    Node new_node = new Node(new_data);
    if(head == null){
        head = new Node(new_data);
        return;
    }
    new_node.next = null;
    Node last = head;
    while(last.next!=null){
        last = last.next;
    }
    last.next = new_node;
    return;
}

/*---- Searching ----*/

// print a node at a given index of linked list
private int getNthNode(Node head,int pos){
    if(head == null) return;
    Node temp = head;
    int count = 0;
    while(temp!=null){
        if(count == pos) return temp.data;
        count++;
        temp = temp.next;
    }
    return 0;
}

// search if given node exists
private boolean search(Node head,int val){
    if(head == null) return;
    Node temp = head;
    int count = 0;
    while(temp!=null){
        if(temp.data == val) return true;
        count++;
        temp = temp.next; 
    }
    return false;
}

/*---- Deletion ----*/

// delete a node at a given index
private void deleteNodePosition(Node head){
    if(head == null) return;
    Node temp = head;
    if(pos == 0){
        head = temp.next;
        return;
    }
    for(int i=0;temp!=null && i<pos-1;i++){
        temp = temp.next;
    }
    if(temp==null || temp.next==null) return;
    Node next = temp.next.next;
    temp.next = next;
}

// delete a node of given value
private void deleteNodeValue(Node head,int val){
    if(head == null) return;
    Node temp = head;
    Node prev = temp;
    while(temp!=null && temp.data!=val){
        prev = temp;
        temp = temp.next;
    }
    prev.next = temp.next;
}

// delete alternate nodes
private void deleteAlterante(Node head){
    if(head == null) return;
    Node slow = head;
    Node fast = head.next;
    while(slow!=null && fast!=null){
        slow.next = fast.next;
        fast = null;
        slow = slow.next;
        if(slow!=null){
            fast = slow.next;
        }
    }
}

// delete a node without head
private void delteWithoutHead(Node head){
    Node temp = node.next;
    node.data = temp.data;
    node.next = temp.next;
}

// sum of last n nodes of a linked list
private int lastNSum(Node head,int k){
    ArrayList<Integer> list = new ArrayList<>();
    Node temp = head;
    while(temp!=null){
        list.add(temp.data);
        temp = temp.next;
    }
    int start = list.size()-k;
    int sum = 0;
    for(int i=start;i<list.size();i++){
        sum+=list.get(i);
    }
    return sum;
}

// check if a linked list is circular in nature (what if a loop is present)
boolean isCircular(Node head){
    if(head == null) return true;
    Node temp = head;
    while(temp.next!=null && temp.next!=head){
        temp = temp.next;
    }
    if(temp.next == null) return false;
    return true;
}

// find the middle element of linked list
private int getMiddle(Node head){
    if(head == null) return -1;
    Node slow = head;
    Node fast = head;
    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow.data;
}

// detect loop in a linked list
private boolean isLoopPresent(Node head){
    if(head==null) return false;
    Node slow = head;
    Node fast = head;
    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            return true;
        }
    }
    return false;
}

// find the length of the loop present in linked list
private int getLoopLength(Node head){
    if(head == null) return -1;
    Node slow = head;
    Node fast = head;
    int hasCycle = 0;
    int count = 0;
    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            hasCycle = 1;
            break;
        }
    }
    if(hasCycle == 0){
        return -1;
    }else{
        slow = slow.next;
        while(slow!=fast){
            slow = slow.next;
            count++;
        }
    }
    return count;
}

// find the start node of the loop in linked list
private int getStartNodeLoop(Node head){
    if(head == null) return -1;
    Node slow = head;
    Node fast = head;
    int hasCycle = 0;
    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            hasCycle = 1;
            break;
        }
    }
    if(hasCycle == 0){
        return -1;
    }else{
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
    }
    return slow.data;
}

// inserting in the middle of linked list
private Node InsertInMid(Node head,int data){
    if(head == null) return head;
    Node prev = head;
    Node slow = head;
    Node fast = head;
    int flag = 0;
    Node new_node = new Node(data);
    if(getLength(head)%2 == 0){
        flag = 1;
    }
    while(slow!=null && fast!=null && fast.next!=null){
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    if(flag == 1){
        new_node.next = prev.next;
        prev.next = new_node;
    }else{
        new_node.next = slow.next;
        slow.next = new_node;
    }
    return head;
   }
}

// check if two linked list are identical
private boolean compareLists(Node head1,Node head2){
    Node a = head1;
    Node b = head2;
    while(a!=null && b!=null){
        if(a.data == b.data){
            a = a.next;
            b = b.next;
        }else{
            return false;
        }
       if(a == null && b==null) return true;
    }
    return false;
}

// merge two sorted linked lists(recursive)
private Node mergeTwoLists(Node l1, Node l2) {
        if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
 }

// merge two sorted linked lists(iterative)
private Node mergeTwoLists(Node a,Node b){
    Node start = new Node(-1);
    Node headNode = start;
    
    while(a!=null && b!=null){
        if(a.data<=b.data){
            start.next = a;
            a = a.next;
        }else{
            start.next = b;
            b = b.next;
        }
        start = start.next;
    }
    if(a == null){
        start.next = b;
    }else if(b == null){
        start.next = a;
    }
    return headNode.next;
}

// delete middle of a linked list
public static int getLength(ListNode<Integer> head){
        ListNode<Integer> temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
 public static ListNode<Integer> deleteMid(ListNode<Integer> head) {
		ListNode<Integer> temp = head;
        if(head == null || head.next == null) return null;
        ListNode<Integer> prev = new ListNode<>(-1);
        prev.next = head;
        ListNode<Integer> prev_slow = new ListNode<>(-1);
        prev_slow.next = prev;
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
        while(fast!=null && fast.next!=null){
            prev_slow = prev_slow.next;
            prev = prev.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(getLength(head)%2==0){
            prev_slow.next = prev.next;
            prev = null;
        }else if(getLength(head)%2!=0){
            prev.next = slow.next;
            slow = null;
        }
        return head;
    }

// Intersection of two linked list(Y-shape)
    private int getLength(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    private ListNode _getIntersectionNode(ListNode a,ListNode b,int d){
        for(int i=0;i<d;i++){
            a = a.next;
        }
        while(a!=null && b!=null){
            if(a == b){
                return a; //can also return a.data;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
    
    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        ListNode ans = null;
        int a_size = getLength(a);
        int b_size = getLength(b);
        int d = 0;
        if(a_size>b_size){
               d = a_size-b_size;
               ans = _getIntersectionNode(a,b,d);
        }else{
               d = b_size-a_size;
               ans = _getIntersectionNode(b,a,d);
        }
        return ans;
    }

// remove duplicates from sorted linked list
private Node removeDuplicates(Node head){
	if(head == null) return null;
	Node temp = head;
	while(temp!=null && temp.next!=null){
		if(temp.data == temp.next.data){
			temp.next = temp.next.next;
		}else{
			temp = temp.next;
		}
	}
	return head;
}

// remove duplicates from unsorted linked list
public static ListNode<Integer> deleteDuplicates(ListNode<Integer> head) {
      Set<Integer> set = new HashSet<>();
      ListNode<Integer> pre = null;
      ListNode<Integer> fakeHead = head;
    	while(fakeHead != null){
          if(!set.add(fakeHead.data)){
            pre.next = fakeHead.next;
          } else{
            pre = fakeHead;
          }
        fakeHead = fakeHead.next;
     }
    return head;
   }

// remove all occurrences of duplicate nodes from linked list
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode FakeHead = new ListNode(0);
        FakeHead.next = head;
        ListNode prev = FakeHead;
        ListNode curr = head;
        while(curr!=null){
            while(curr.next!=null && curr.val == curr.next.val){
                curr = curr.next;
            }
            if(prev.next == curr){
                prev = prev.next;
            }else{
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return FakeHead.next;
    }

// reverse a linked list
private Node reverseLinkedList(Node head){
	Node prev = null;
	Node current = head;
	Node next = null;
	while(current!=null){
		next = current.next;
		current.next = prev;
		prev = current;
		current = next;
	}
	head = prev;
	return head;
}

// swap list nodes in pairs
public ListNode swapPairs(ListNode head) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
          ListNode first = current.next;
          ListNode second = current.next.next;
          first.next = second.next;
          current.next = second;
          current.next.next = first;
          current = current.next.next;
        }
        return dummy.next;
    }

// oddEven Linked list
private Node OddEvenLinkedList(Node head){
	if(head == null) return null;
	Node odd = head;
	Node even = head.next;
	Node evenFirst = even;
	while(even!=null && even.next!=null){
		odd.next = even.next;
		odd = odd.next;
		even.next = odd.next;
		even = even.next;
	}
	odd.next= evenFirst;
	return head;
}

// add 1 to a number represented as linked list
 public static ListNode<Integer> reverse(ListNode<Integer> head){
        if(head == null) return null;
        ListNode<Integer> prev = null;
        ListNode<Integer> curr = head;
        ListNode<Integer> next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
  public static ListNode<Integer>  changelist(ListNode<Integer> head) {
		ListNode<Integer> FakeHead = reverse(head);
        ListNode<Integer> temp = FakeHead;
        while(temp!=null){
            if(temp.data + 1 <= 9){
                temp.data = temp.data + 1;
                break;
            }else{
                temp.data = 0 ;
                if(temp.next == null){
                    temp.next = new ListNode<Integer>(1);
                    break;
                }
                temp = temp.next;
            }
        }
        return reverse(FakeHead);
   }


// nth node from the end of linked list
private Node printNthFromEnd(Node head,int n){
	if(head == null) return null;
	Node ref_ptr = head;
	Node main_ptr = head;
	int count = 0;
	if(head!=null){
		while(count<n){
			if(ref_ptr==null){
				return null;
			}
			ref_ptr = ref_ptr.next;
			count++;
		}
		while(ref_ptr!=null){
			main_ptr = main_ptr.next;
			ref_ptr = ref_ptr.next;
		}
	}
	return main_ptr.data;
}

// remove nth node from the end of linked list
public ListNode removeNthFromEnd(ListNode head, int n) {
      if (head == null || head.next == null) return null;
         
        ListNode slow = head;
        ListNode fast = head;
         
        // move fast pointer n steps ahead of slow
        for (int i = 0; fast!=null && i < n; i++) {
            fast = fast.next;
        }
         
        // move slow and fast pointer one step a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
         
        // delete the node
        if (fast == null) {
            head = head.next;
        } else {
            slow.next = slow.next.next;
        }
        return head;
}

// palindrome linked list 
private boolean isPalindrome(Node head){
	Node fast = head,slow = head;
	while(fast!= null && fast.next!=null){
		slow = slow.next;
		fast = fast.next.next;
	}
	if(fast!=null){
		slow = slow.next;
	}
	slow = reverse(slow); // reverse a linked list call
	fast = head;
	
	while(slow!=null){
           if(fast.data!=slow.data){
		   return false;
	  }
	   fast = fast.next;
           slow = slow.next;
	}
	return true;
}

// rearrange a linked list(imp. question)
private void reorderList(Node head){
	if(head == null || head.next == null) return;
	
	Node p1 = head;
	Node p2 = head;
	while(p2.next!=null && p2.next.next!=null){
		p1 = p1.next;
		p2 = p2.next.next;
	}
	
	// reverse the half after the middle of linked list
	Node preMiddle = p1;
	Node preCurrent = p1.next;
	while(preCurrent.next!=null){
		Node current = preCurrent.next;
		preCurrent.next = current.next;
		current.next = preMiddle.next;
		preMiddle.next = current;
	}
	
	//start reorder one by one
	p1 = head;
	p2 = preMiddle.next;
	while(p1!=preMiddle){
		preMiddle.next = p2.next;
		p2.next = p1.next;
		p1.next = p2;
		p1 = p2.next;
		p2 = preMiddle.next;
	}
}

// delete N nodes after M nodes in a linked list 
private void deleteNafterM(Node head,int M,int N){
	Node current = head,t;
	int count;
	while(current!=null){
	 for(count = 1;count<M && current!=null;count++){
	     curr = curr.next;
	    }
	    if(curr == null){
		 return;
	      }
		t = current.next;
		for(count = 1;count<= N &&  t!=null;count++){
		    Node temp = t;
		    t = t.next;
		}
		curr.next = t;
		curr = t;
	}
}

// remove every kth node form a linked list

// Rotate a linked list by K places.
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode curr = head;
        int len = 1;
        while(curr.next!=null){
            curr = curr.next;
            len++;
        }
        curr.next = head;
        int preLen = len-k % len-1;
        ListNode pre = head;
        while(preLen-->0){
            pre = pre.next;
        }
        head = pre.next;
        pre.next = null;
        return head;
    }

// Reverse a linked list from m to n place
public ListNode reverseBetween(ListNode head, int m, int n) {
         ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
         dummy.next = head;
         ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
         for(int i = 0; i<m-1; i++) pre = pre.next;
    
        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed
    
    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
    // dummy-> 1 -> 2 -> 3 -> 4 -> 5
    
      for(int i=0; i<n-m; i++)
       {
        start.next = then.next;
        then.next = pre.next;
        pre.next = then;
        then = start.next;
       }
    
    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
    
      return dummy.next;
    }

// Reorder linked list
// hashmap method 
// another method exists where we find the middle of the linked list and then reverse the half after the middle
// then simply merge the two halfs to reorder the list.
public ListNode reorder(ListNode head){
     HashMap<Integer,ListNode> map = new HashMap<>();
        for(int i = 1;head != null;head = head.next,i++){
            map.put(i,head);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int i = 1,j = map.size();i <= j;i++,j--){   //1,2,3,4
            curr.next = map.get(i);                     //curr->1
            if(i!= j) map.get(i).next = map.get(j);     //1->4
            map.get(j).next = null;                     //4->null
            curr = map.get(j);                          ///curr = 4,then 1->4
        }
        return dummy.next;
}

// add two numbers represented as linked list
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        ListNode code = new ListNode(0);
        ListNode d = code;
        int sum = 0;
        while(a!=null || b!=null){
            sum/=10;
            if(a!=null){
                sum+=a.val;
                a = a.next;
            }
            if(b!=null){
                sum+=b.val;
                b = b.next;
            }
            d.next = new ListNode(sum%10);
            d = d.next;
        }
        if(sum/10 == 1){
            d.next = new ListNode(1);
        }
        return code.next;
    }

// partition list
public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
        ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
        while (head!=null){
            if (head.val<x) {
              curr1.next = head;
              curr1 = head;
            }else {
              curr2.next = head;
              curr2 = head;
            }
              head = head.next;
            }
        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
    }

// union and intersection of linked list
public ListNode unionAndIntersection(ListNode head1,ListNode head2){
        ListNode a = head1;  
  	ListNode b = head2;
	HashSet<Integer> hset = new HashSet<>();
	List<Integer> list1 = new ArryaList<>(); // will contain the union elements
	List<Integer> list2 = new ArrayList<>(); //  will contain the intersection elements
	while(a!=null){
	   hset.add(a.data);
	   list1.add(a.data);
	   a = a.next;
	}
	while(b!=null){
	   if(hset.contains(b.data)){
	      list2.add(b.data);
	   }else{
	      list1.data(b.data);
	   }
	     b = b.next;
	}
}
