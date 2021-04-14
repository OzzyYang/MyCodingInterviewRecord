package linkedlist.solution6;

import java.util.Stack;

/**
 * @author Ozzy Yang
 * Finshed time:2021-04-14
 */
public class Solution6 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        Solution6 solu = new Solution6();
        int[] arr = solu.reversePrint(n1);
        for (int num : arr) {
            System.out.print(num + ", ");
        }
    }

    public int[] reversePrint(ListNode head) {
        return changeSolution(head);
    }

    /**
     * 使用栈的后进先出特性完成遍历
     *
     * @param head 链表的头结点
     * @return 遍历后的数组
     */
    private int[] stackSolution(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Stack<Integer> arrStack = new Stack<>();
        while (head != null) {
            arrStack.push(head.val);
            head = head.next;
        }
        int[] result = new int[arrStack.size()];
        int i = 0;
        while (!arrStack.isEmpty()) {
            result[i++] = arrStack.pop();
        }
        return result;
    }

    /**
     * 改变链表结构，使其的链接从尾指向前。然后再遍历链表
     *
     * @param head 链表的头
     * @return 遍历后的数组
     * @deprecated 逻辑未实现
     */
    private int[] changeSolution(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int size = 0;
        ListNode nextNode = head, preNode = null;
        while (head != null && head.next != null && nextNode != null) {
            nextNode = head.next;
            preNode = head;
            nextNode.next = preNode;
            head = nextNode;
            if (size == 0) {
                preNode.next = null;
            }
            size++;
        }
        int[] result = new int[size];
        size = 0;
        while (head != null) {
            result[size++] = head.val;
            head = head.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int x) {
        val = x;
    }
}