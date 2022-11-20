/**
Given the head of a singly linked list, reverse the list, and return the 
reversed list. 

 
 Example 1: 
 
 
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
 

 Example 2: 
 
 
Input: head = [1,2]
Output: [2,1]
 

 Example 3: 

 
Input: head = []
Output: []
 

 
 Constraints: 

 
 The number of nodes in the list is the range [0, 5000]. 
 -5000 <= Node.val <= 5000 
 

 
 Follow up: A linked list can be reversed either iteratively or recursively. 
Could you implement both? 

 Related Topics Linked List Recursion 👍 14570 👎 248

*/

//leetcode submit region begin(Prohibit modification and deletion)

import java.io.Serializable;
import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //画图解释了
    //https://leetcode.cn/problems/reverse-linked-list/solution/shi-pin-tu-jie-206-fan-zhuan-lian-biao-d-zvli/
    public ListNode reverseList(ListNode head) {
        return solution1_TWO_POINTER_V2(head);
    }

    /**
     * 递归
     * 递归上来就先写终止条件：如果head为空或者head.next为空，返回head
     *
     * 在用递归思想解题时，明确递推公式的含义后，不要试图想明白每一步是如何递归的，这很容易把自己绕晕哈。
     * @param head
     * @return
     */
    public ListNode solution2_RECURSION(ListNode head){
        //递归终止条件是当前为空，或者下一个节点为空
        if(head == null || head.next == null){
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

    /**
     * 双指针
     * 容易理解
     * @param head
     * @return
     */
    public ListNode solution1_TWO_POINTER(ListNode head){
        //申请节点，pre和 cur，pre指向null
        ListNode pre = null;
        ListNode cuur = head;
        ListNode temp = null;
        while (cuur != null){
            //记录当前节点的下一个节点
            temp = cuur.next;
            //然后将当前节点指向pre
            cuur.next = pre;
            //pre和cur节点都前进一位
            pre = cuur;
            cuur = temp;
        }
        return pre;
    }

    /**
     * 难以理解
     * 双指针
     * https://leetcode.cn/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-shuang-zhi-zhen-di-gui-yao-mo-/
     * @param head
     * @return
     */
    public ListNode solution1_TWO_POINTER_V2(ListNode head){
        //申请节点，pre和 cur，pre指向null
        if (head == null) { return head; }
        ListNode cuur = head;
        while (head.next != null) {
            ListNode t = head.next.next;
            head.next.next = cuur;
            cuur = head.next;
            head.next = t;
        }
        return cuur;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
