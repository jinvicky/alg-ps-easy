package com.jinvicky.linkedList.leetCode;

/**
 * LeetCode 876. Middle of the Linked List
 * <p>
 * [회고]
 * 미디엄 난이도의 중간 요소 제거하기 문제()를 풀다가 어려워서 한 단계 낮춰서 이 문제부터 풀었다.
 * 미디엄 문제에서 나온 힌트을 사용해서 풀었다.
 * <p>
 * [핵심]
 * Q. 단방향 링크드 리스트에서 중간 요소를 찾고 싶다면? 2개의 포인터를 사용한다.
 * A. 매번 1칸씩 이동하는 fast와 두번에 1칸씩 이동하는 slow 포인터를 사용하면 된다.
 * <p>
 * [어려웠던점]
 * - 짝수여서 중간 노드의 개수가 2개라면 오른쪽을 택해야 한다는 부분이 계산이 머리에 잘 안 그려졌다.

 * - 0부터 시작하기 때문에 flag가 짝수일 경우 홀수이며, 이때 slow를 slow.next로 갱신한다.
 * - fast는 항상 fast.next로 갱신한다.
 */
public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        int flag = 0;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            if (flag % 2 == 0) {
                slow = slow.next;
            }
            flag++;
            fast = fast.next;
        }
        return slow;
    }

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
    }
}
