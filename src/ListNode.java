public class ListNode {
    Integer data;
    ListNode next;
    ListNode prev;

    ListNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    ListNode(ListNode prev, int data, ListNode next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
