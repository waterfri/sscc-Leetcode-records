// #141 环形链表
// 链表
// 双指针
// 快慢指针

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){ // fast.next 为 null，快指针到达链表末尾，避免越界
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇
            if(slow == fast){
                return true;
            }
        }
        // 快指针到达末尾，无环
        return false;
    }
}