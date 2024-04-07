public class Node {
    int val;
    Node next;

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {
    Node head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        Node curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node temp = new Node(val, head);
        head = temp;
        size++;
    }
    
    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = new Node(val, null);
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size)
            return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node curr = head;
        for (int i = 0; i < index - 1; i++)
            curr = curr.next;
        curr.next = new Node(val, curr.next);
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node curr = head;
        for (int i = 0; i < index - 1; i++)
            curr = curr.next;
        curr.next = curr.next.next;
        size--;
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
