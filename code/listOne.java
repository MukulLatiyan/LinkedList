// "static void main" must be defined in a public class.
public class Main {
    
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int d){
            val = d;
            next = null;
        }
    }
    
    private static void printList(ListNode head){
        if(head == null) return;
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    // middle of linked list
    /*
        1 2 3 4 ( middle is 3 )
        1 2 3 4 5 ( middle is 3 )
    */
    private static int getMiddle(ListNode head){
        if(head == null) return -1;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }
    
    // reverse a linked list
    /*
        1 2 3 4 -> 4 3 2 1
    */
    
    private static ListNode reverseList(ListNode head){
        if(head == null) return null;
        ListNode prev = null, curr = head, next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    // delete node in a linked list
    /*
        1 2 3 4 5 -> 1 2 3 5( given access to only that node of the list i.e 4)
    */
    
    private static void deleteSpecificNode(ListNode node){
        if(node == null) return;
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
        System.gc();
    }
    
    // merge sorted linked lists
    private static ListNode mergeTwoSortedLists(ListNode headA,ListNode headB){
        if(headA == null && headB == null) return null;
        ListNode fakeHead = new ListNode(-1);
        ListNode dummy = fakeHead;
        while(headA!=null && headB !=null){
            if(headA.val < headB.val){
                dummy.next = headA;
                headA = headA.next;
            }else{
                dummy.next = headB;
                headB = headB.next;
            }
            dummy = dummy.next;
        }
        if(headA != null) dummy.next = headA;
        if(headB != null) dummy.next = headB;
        return fakeHead.next;
    }
    
    private static boolean isCycle(ListNode head){
        if(head == null) return false;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
    
    // palindrome linked list
    private static boolean isPalindromeList(ListNode head){
        if(head == null) return false;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null){
            slow = slow.next;
        }
        slow = reverseList(slow);
        fast = head;
        while(slow!=null){
            if(slow.val!=fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    // Intersection of two Y-shaped linked list
    private static ListNode intersectionOfTwoLists(ListNode headA,ListNode headB){
        if(headA == null && headB == null) return null;
        ListNode a = headA, b = headB;
        while(a!=b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
    
    public static void main(String[] args) {
        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // System.out.println("Linked list:");
        // printList(head);
        // System.out.println("Middle of the linked list is: \n"+ getMiddle(head));
        // ListNode newHead = reverseList(head);
        // System.out.println("Reversed list: ");
        // printList(newHead);
        // ListNode headA = new ListNode(1);
        // headA.next = new ListNode(2);
        // headA.next.next = new ListNode(3);
        // headA.next.next.next = new ListNode(4);
        // System.out.println("After deleting 3rd node: ");
        // deleteSpecificNode(headA.next.next);
        // printList(headA);
        
        /* 
            Case 2
            Merged Two Sorted List
        */
        
        // ListNode headA = new ListNode(1);
        // headA.next = new ListNode(3);
        // headA.next.next = new ListNode(5);
        // ListNode headB = new ListNode(2);
        // headB.next = new ListNode(4);
        // headB.next.next = new ListNode(6);
        // ListNode mergedHead = mergeTwoSortedLists(headA,headB);
        // System.out.println("Merged linked list is: ");
        // printList(mergedHead);
        
        /* 
            Cycle cases 
        */
        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        // head.next.next.next.next.next = head.next.next;
        // boolean isCycleThere = isCycle(head);
        // System.out.println(isCycleThere);
        
        /* 
            Palindrome List
        */
        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(2);
        // head.next.next.next = new ListNode(2);
        // boolean isPalindrome = isPalindromeList(head);
        // System.out.println(isPalindrome);
        
        /*
            Intersection of Y-shaped Linked Lists
        */
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        
        ListNode headB = new ListNode(7);
        headB.next = headA.next.next;
        ListNode node = intersectionOfTwoLists(headA,headB);
        System.out.println(node.val);
    }
}
