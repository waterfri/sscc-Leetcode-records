package shopee笔试;

// #shopee笔试 链表求和（高位在前）
// 链表
// 栈
// 头插法
/* 给定两个非空链表 l1 和 l2 来代表两个非负整数，数字最高位置位于链表开始位置，他们的每个节点只存储一位数字，将这个两个数字相加会返回一个新的链表。可以假设除了数字 0 外，两个数字都不会以 0 开头。 */

import java.util.Stack;

class ListNode{
    int val;
    ListNode next;

    ListNode(){}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}

}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        int carry = 0; // 进位

        ListNode head = null;

        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0){
            int sum = carry;

            if(!s1.isEmpty()){
                sum += s1.pop();
            }

            if(!s2.isEmpty()){
                sum += s2.pop();
            }

            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;

        }

        return head;
    }
}
