package com.jinvicky.binaryTree.dfs.leetCode;


/**
 * LeetCode 104. Maximum Depth of Binary Tree
 *
 * [풀이]
 * left, right을 기준으로 재귀를 돌려야 함.
 *
 * [주의점]
 * 재귀를 양쪽으로 돌릴 때 dp++해서 넘기는 것이 아니라 메서드 내에서 1번만 +=1 해야 한다.
 * maxDp를 선언해서 left, right 중 최대값을 비교해가면서 순회가 다 끝나면 maxDp를 반환한다.
 * 메서드 lv가 아니라 클래스 iv로 처리한다.
 *
 * [했던 고민들]
 * dp count를 map에 담아서 저장해야 하나 생각해봤다.
 */
public class MaxDepthOfBinaryTree {
    private int maxDp = 0;

    // 전위 순회,
    public void calculate(TreeNode node, int dp) {
        if (node == null) {
            return;
        }
        dp += 1;
        this.maxDp = Math.max(dp, maxDp);

        calculate(node.left, dp);
        calculate(node.right, dp);
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        calculate(root, 0);
        return maxDp;
    }

    public static void main(String[] args) {
        MaxDepthOfBinaryTree maxDepthOfBinaryTree = new MaxDepthOfBinaryTree();
        TreeNode root = maxDepthOfBinaryTree.new TreeNode(3);
        TreeNode left = maxDepthOfBinaryTree.new TreeNode(9);
        TreeNode right = maxDepthOfBinaryTree.new TreeNode(20);
        TreeNode rightLeft = maxDepthOfBinaryTree.new TreeNode(15);
        TreeNode rightRight = maxDepthOfBinaryTree.new TreeNode(7);

        root.left = left;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;

        System.out.println(maxDepthOfBinaryTree.maxDepth(root));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
