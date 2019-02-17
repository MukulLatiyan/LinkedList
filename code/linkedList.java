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
