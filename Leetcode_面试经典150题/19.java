// #19 删除链表的倒数第 N 个结点
// 链表
// 双指针
// 快慢指针

class ListNode{
    int value;
    ListNode next;

    ListNode() {}
    ListNode(int value) { this.value = value; }
    ListNode(int value, ListNode next) { this.value = value; this.next = next; }
}

class Solution{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i = 0; i < n; i++){
            fast = fast.next;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;

    }
}
