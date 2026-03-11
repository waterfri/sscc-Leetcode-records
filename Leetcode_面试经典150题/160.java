// #160 相交链表
// 双指针

import java.util.List;

class ListNode{
    int value;
    ListNode next;

    ListNode(){}
    ListNode(int value) { this.value = value; }

    ListNode(int value, ListNode next) { this.value = value; this.next = next; }
}
class Solution{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2){
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }

        return p1;
    }
}