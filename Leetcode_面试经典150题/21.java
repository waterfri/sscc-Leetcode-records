// #21 合并两个有序链表
// 链表
// 指针

class ListNode{
    int value;
    ListNode next;

    ListNode(){}
    ListNode(int value) { this.value = value; }
    ListNode(int value, ListNode next) { this.value = value; this.next = next; }

}

class Solution{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){

        ListNode dummy = new ListNode(0); // 永远指向头节点
        ListNode cur = dummy;

        while(list1 != null && list2 != null){
            if(list1.value <= list2.value){
                cur.next = list1;
                list1 = list1.next;
            }
            else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if(list1 != null){
            cur.next = list1; // 直接拼接剩余的
        }
        else{
            cur.next = list2;
        }

        return dummy.next;
    }
}