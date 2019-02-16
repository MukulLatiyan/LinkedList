//code 

//count the nodes of the linked list
private int getCount(Node head){
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
    Node temp = head;
    while(temp!=null){
        System.out.print(temp.data+" ");
        temp = temp.next;
    }
    System.out.println();
}

//sum of nodes of linked list
private int linkedListSum(Node head){
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
    Node temp = head;
    int count = 0;
    while(temp!=null){
        if(temp.data == val) return true;
        count++;
        temp = temp.next; 
    }
    return false;
}



