import java.util.NoSuchElementException;

public class DoubleLinkedList {
    private ListNode front;
    private Integer size;

    public DoubleLinkedList() {
        front = null;
        size = 0;
    }

    public DoubleLinkedList(DoubleLinkedList another) {
        this.front = another.front;
        this.size = another.size;// you can access
    }



    public void addFront(Integer x) {
        if (isEmpty())
            front = new ListNode(x);
        else {
            ListNode temp = front;
            front = new ListNode(null, x, temp);
            front.next.prev = front;
        }
        size++;
    }

    public void addEnd(Integer x) {
        if (isEmpty())
            front = new ListNode(x);
        else {
            ListNode temp = front;
            // Traverse till end of list
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(temp, x, null);
        }
        size++;
    }

    public void addBefore(Integer x, Integer y) {
        // List is empty, can't add
        if (isEmpty())
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        ListNode current = front;

        // Looping through until found
        while (current != null && current.data.equals(x))
            current = current.next;

        // If null, not found
        if (current == null)
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        ListNode newNode = new ListNode(current.prev, y, current);
        if (current.prev != null)
            current.prev.next = newNode;
        else
            front = newNode;
        current.prev = newNode;

        size++;
    }

    public void addAfter(Integer x, Integer y) {
        if (isEmpty())
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        ListNode current = front;

        // Looping through until found
        while (current != null && !current.data.equals(x))
            current = current.next;

        // If null, not found
        if (current == null)
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        // Not null, value found
        ListNode newNode = new ListNode(current, y, current.next);
        if (current.next != null)
            current.next.prev = newNode;
        current.next = newNode;

        size++;
    }

    public void remove(Integer x) {
        if (isEmpty())
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        // Removing front element
        if (front.data.equals(x)) {
            front = front.next;
            return;
        }

        ListNode current = front;

        // Looping through until found
        while (current != null && !current.data.equals(x))
            current = current.next;

        // If null, not found
        if (current == null)
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        // It has a next pointer, so not the last node.
        if (current.next != null)
            current.next.prev = current.prev;

        current.prev.next = current.next;

        size--;
    }

    public void print(){
        ListNode current = front;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public ListNode getFront(){
        return front;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
