package com.jinvicky.linkedList.leetCode;


/**
 * LeetCode 206. Reverse Linked List
 *
 * [문제]
 * 링크드 리스트를 역순으로 바꾸기.
 *
 * [풀이]
 */
public class ReverseLinkedList {

    /**
     * 재귀함수로 풀이한 코드
     */
    public ListNode reverseList(ListNode head){

        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * while 반복문으로 풀이한 코드
     */
    public ListNode reverseList2(ListNode head) {
        ListNode node = null;

        while(head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
