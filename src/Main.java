import java.util.Random;

public class Main {
    public static void main(String[] args) {

        DoubleLinkedList dll = initList();
        dll.print();

        findMin(dll);
        dll.print();


    }

    public static DoubleLinkedList initList(){
        DoubleLinkedList dll = new DoubleLinkedList();
        for (int i = 0; i < 11; i++){
            int random = (int)(Math.random() * 100 - 50);
            dll.addEnd(random);
        }
        return dll;
    }

    public static ListNode findMin(DoubleLinkedList dll1){
        DoubleLinkedList dll = new DoubleLinkedList(dll1);
        ListNode current = dll.getFront();
        ListNode min = current;
        while (current.next != null){
            int temp = current.data;
            if(temp > current.data){
                temp = current.data;
                min = current;
            }
            current = current.next;
        }
        System.out.println();
        System.out.println("Minimus is " + min.data);
        return min;
    }

    public static DoubleLinkedList changeNodes(DoubleLinkedList dll,ListNode a, ListNode b){

        return null;
    }
}


