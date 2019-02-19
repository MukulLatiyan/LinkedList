//code 

//count the nodes of the linked list
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

//linked list length(odd or even)
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

//print linked list elements
private void printList(Node head){
    if(head == null) return;
    Node temp = head;
    while(temp!=null){
        System.out.print(temp.data+" ");
        temp = temp.next;
    }
    System.out.println();
}

//sum of nodes of linked list
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

//insert at the begining of linked list
private void push(int new_data){
    Node new_node = new Node(new_data);
    new_node.next = head;
    head = new_node;
}

//after a given node
private void insertAfter(Node prev_node,int new_data){
    if(prev_node == null){
        return;
    }
    Node new_node = new Node(new_data);
    new_node.next = prev_node.next;
    prev_node.next = new_node;
}

//at a given position 
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

//at the end of linked list
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

//print a node at a given index of linked list
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

//search if given node exists
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

//delete a node at a given index
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

//delete a node of given value
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

//delete alternate nodes
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

//delete a node without head
private void delteWithoutHead(Node head){
    Node temp = node.next;
    node.data = temp.data;
    node.next = temp.next;
}

//sum of last n nodes of a linked list
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

//check if a linked list is circular in nature (what if a loop is present)
boolean isCircular(Node head){
    if(head == null) return true;
    Node temp = head;
    while(temp.next!=null && temp.next!=head){
        temp = temp.next;
    }
    if(temp.next == null) return false;
    return true;
}

//find the middle element of linked list
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

//detect loop in a linked list
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

//find the length of the loop present in linked list
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

//find the start node of the loop in linked list
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

//inserting in the middle of linked list
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

//check if two linked list are identical
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

//merge two sorted linked lists(recursive)
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

//merge two sorted linked lists(iterative)
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

//Intersection of two linked list(Y-shape)
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

//remove duplicates from sorted linked list
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

//remove duplicates from unsorted linked list
private Node removeDuplicateUnsorted(Node head){
	if(head == null) return null;
	Node temp = head;
	HashSet<Integer> hset = new HashSet<>();
	while(temp!=null){
		if(temp.data == temp.next.data){
			prev.next = temp.next;
		}else{
			prev = temp;
			hset.add(temp.data);
		}
		temp = temp.next;
	}
	return head;
}

//remove all occurrences of duplicate nodes from linked list
