// #206 反转链表
// 指针
// 递归
// 遍历

public class ListNode{
    int value;
    ListNode next;

    ListNode() {};
    ListNode(int value) { this.value = value; }
    ListNode(int value, ListNode next) { this.value = value; this.next = next; }
}

class Solution{
    public ListNode reverseList(ListNode head){

        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            ListNode next = cur.next; // 防止断链

            cur.next = pre;
            
            pre = cur;
            cur = next;
        }

        return pre;
    }
}