import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

    //Node definition
    class Node{

//     (object) User information stored in each Node
        UserInfo uI;

        // reference to next node

        Node next;

//        constructor
        public Node(UserInfo uI) {
            this.uI = uI;
            this.next = null;

        }
    }

    // Class linked list
    class linkedList{

        static Node head;
        public int size;

//        constructor where initial head is null and size = 0
        public linkedList() {
            head = null;
            this.size = 0;

        }

        //Method for adding information to the node
        public void add(UserInfo uI) {

            Node newNode = new Node(uI);

            //if head is not existing than create newNode
            if (head == null) {
                head = newNode;
            }
//            else adding node till it reaches null1
            else {
                // Store the head reference in a temporary variable
                Node current = head;
                // Traverse till the last node
                while (current.next != null) {
                    current = current.next;
                }
                // Change the next pointer of the node to point to the new node
                current.next = newNode;
            }
            size++;
        }

//      Algorithm to insert new user to the end of the list
        public void insertAtEnd(UserInfo uI) {

            // Create a new node
            Node newNode = new Node(uI);

            // If the Linked List is empty, make the new node
            if (head == null) {
                head = newNode;
            }

            // Store the head reference in a temporary variable
            Node last = head;

            // Traverse till the last node
            while (last.next != null) {
                last = last.next;
            }
            // Change the next pointer of the last node to point to the new node
            last.next = newNode;
        }



//        Searching algorithm
        public UserInfo search(String target){

            Node temp = head;

//            if head is empty, then nothing will be returned
        if (head == null) {
            return null;
        }

        String exception1 = "Searching Id is not found";

//        loop through linked list and if first index equals to target number return node with data
        while (temp != null){
            if(temp.uI.getId().equals(target)){
                return temp.uI;
            }
            temp = temp.next;
        }

            System.out.println(exception1);

        return null;
    }

        //deletion(identifying name and last name in linked list) function
        public UserInfo deletion(String name, String lastName){
            Node temp = head;

//            if head is empty, then nothing will be returned
            if (head == null) {
                return null;
            }

//           loop through linked list if name and last name equals target &  return founded node
            while (temp != null){
                if(temp.uI.getName().equals(name) || temp.uI.getLastName().equals(lastName)){
                    return temp.uI;
                }
                temp = temp.next;

            }
            return null;
        }

        //      function that delete the founded node
        public void deleteNode(UserInfo del){
            Node temp = head;
            Node prev = null;

//          if node not equal null and node equals target del than move head and delete node
            if (temp != null && temp.uI.equals(del)) {
                head = temp.next;
                return;
            }
//          loop linked list till the end or find temp(node) equals del
            while (temp != null && !temp.uI.equals(del)){
//           move the node
                prev = temp;
                temp = temp.next;
            }
//           Node not found
            if (temp == null) {
                System.out.println("Data not present");
                return;
            }
// deleting the node
            prev.next = temp.next;
        }



// Merge algorithm
       public Node merger(Node left, Node right){
//if list empty return other list
            if(left== null) return right;

            if(right == null) return left;

            Node result;

//            id comparison
            int leftId = Integer.parseInt(left.uI.getId());

            int rightId = Integer.parseInt(right.uI.getId());

//            merging logic (if left node id is greater choose left as result recursively merge next node , else do same thing with right list)
            if(leftId > rightId){

                result = left;

                result.next = merger(left.next, right);
            }
            else{

                result = right;
                result.next = merger(left, right.next);
            }

            return  result;

       }

       public Node mergeSort(Node head){
//            if lis is empty and if head have just one node return node
            if(head == null || head.next == null) return  head;

               Node slow = head;
               Node fast = head;
               Node prev = null;

//               Identifying the middle of the list
               while(fast != null && fast.next != null){
                   prev = slow;
                   slow = slow.next;
                   fast = fast.next.next;
               }
//               Splitting the list(breaking list in to two halves)
               if(prev != null ) {
                   prev.next = null;
               }


                Node left = mergeSort(head);
                Node right = mergeSort(slow);


//                Merging combining two sorted halves
                return  merger(left, right);

       }

//       method which call mergeSort(method to be able call it in main)
       public void descendingSortId(){
            head = mergeSort(head);
       }





//        function to get index of linked list
        public UserInfo get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.uI;
        }

        // getting size of the list
        public int size() {
            return size;
        }


//        Function to read id in the list and increase by 1 when its called
        public static  String increaseUserId(){
            if(head == null){
                return "1";
            }

            Node current = head;

            while(current.next != null){
                current = current.next;

            }

            String lastIdstr = current.uI.getId();
            int lastId = Integer.parseInt(lastIdstr);
            int newId = lastId + 1;

            return Integer.toString(newId);
        }

        // displaying linked list in command line
        public void display() {

            Node current = head;
            while(current != null){
                System.out.println(current.uI);
                current = current.next;
            }
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

        }


//        Getting Node Head of the list
        public Node getHead() {
            return head;
        }



    }




