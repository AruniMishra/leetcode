class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode [val=" + val + ", next=" + next + "]";
    }

}

public class p0002_AddTwoNumbers {
    public static void main(String[] args) {

        ListNode l1;
        ListNode l2;
        ListNode a, b, c;

        a = new ListNode(3);
        b = new ListNode(4, a);
        c = new ListNode(8, b);
        l1 = c;

        a = new ListNode(4);
        b = new ListNode(6, a);
        c = new ListNode(5, b);
        l2 = c;

        System.out.println(l1);
        System.out.println(l2);

        p0002_AddTwoNumbers s1 = new p0002_AddTwoNumbers();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(s1.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;

            /*
             * Create a new node with the digit value of (sum mod 10)
             * set it to current node's next, then advance current node to next.
             */
            carry = sum / 10;

            ListNode tempListNode = new ListNode(sum % 10);
            curr.next = tempListNode;
            System.out.println("-----\n" + curr);
            System.out.println("dummyHead: " + dummyHead);
            curr = tempListNode;
            System.out.println(curr);
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

        }
        return dummyHead.next;
    }
}