package LeetCode;

public class SwapPairs24 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode current = head;
        while(current!=null){
            System.out.print(current.val + " > ");
            current = current.next;
        }
        current = swapPairs(head);
        System.out.println();
        while(current!=null){
            System.out.print(current.val + " > ");
            current = current.next;
        }

    }

    /**
     * ตÝน้
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {

        if (head==null || head.next==null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
