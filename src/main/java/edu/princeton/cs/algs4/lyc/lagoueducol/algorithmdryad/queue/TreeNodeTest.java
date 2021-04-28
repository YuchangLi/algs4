package edu.princeton.cs.algs4.lyc.lagoueducol.algorithmdryad.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

import lombok.Data;

/**
 * @author liyuchang
 * @Date 2021-04-07 16:22
 */
public class TreeNodeTest {
    public static void main(String[] args) {
        TreeNode tree7 = new TreeNode();
        tree7.setVal(7);
        TreeNode tree6 = new TreeNode();
        tree6.setVal(6);

        TreeNode tree8 = new TreeNode();
        tree8.setVal(8);
        tree8.setLeft(tree6);
        tree8.setRight(tree7);

        TreeNode tree9 = new TreeNode();
        tree9.setVal(9);
        TreeNode tree91 = new TreeNode();
        tree91.setVal(91);
        TreeNode tree92 = new TreeNode();
        tree92.setVal(92);
        tree9.setLeft(tree91);
        tree9.setRight(tree92);
        TreeNode tree911 = new TreeNode();
        tree911.setVal(911);
        TreeNode tree912 = new TreeNode();
        tree912.setVal(912);
        tree91.setLeft(tree911);
        tree91.setRight(tree912);

        TreeNode tree3 = new TreeNode();
        tree3.setVal(3);
        tree3.setLeft(tree9);
        tree3.setRight(tree8);
         int[] a = new int[]{1};
        System.out.println(a[0]);
        list4(tree3);

    }

    private static void list2(TreeNode tree3) {
        ArrayDeque<List<TreeNode>> queue = new ArrayDeque<>();
        queue.addLast(Arrays.asList(tree3));
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<TreeNode> treeNode = queue.pop();
            list.add(treeNode.stream().map(TreeNode::getVal).collect(Collectors.toList()));
            treeNode.forEach(node -> {
                List<TreeNode> tlist = new ArrayList<>();
                if (node.getLeft() != null) {
                    tlist.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    tlist.add(node.getRight());
                }
                if (!tlist.isEmpty()) {
                    queue.addLast(tlist);
                }

            });
        }
        System.out.println(JSON.toJSONString(list));
    }

    private static void list3(TreeNode tree3) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(tree3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(tree3.getVal()));
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.pop();
            List<Integer> ilist = new ArrayList<>();
            if (treeNode.getLeft() != null) {
                queue.addLast(treeNode.getLeft());
                ilist.add(treeNode.getLeft().getVal());
            }
            if (treeNode.getRight() != null) {
                queue.addLast(treeNode.getRight());
                ilist.add(treeNode.getRight().getVal());
            }
            if (!ilist.isEmpty()) {
                list.add(ilist);
            }
        }
        System.out.println(JSON.toJSONString(list));
    }


    private static void list4(TreeNode tree3) {
        List<Integer> list = new ArrayList<>();
        list44(tree3, list);
        System.out.println(JSON.toJSONString(list));
    }

    private static void list44(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        list.add(treeNode.getVal());
        System.out.print(treeNode.getVal()+" ");
        list44(treeNode.getLeft(), list);
        list44(treeNode.getRight(), list);
    }

    private static void levelTraversal(TreeNode left, TreeNode right, List<List<Integer>> list) {
//        list.add(Arrays.asList(tree.getVal()));

        List<Integer> as = new ArrayList<>();
        if (left != null) {
            as.add(left.getVal());
        }
        if (right != null) {
            as.add(right.getVal());
        }
        if (as.size() > 0) {
            list.add(as);
        }
        if (left != null) {
            levelTraversal(left.getLeft(), left.getRight(), list);
        }
        if (right != null) {
            levelTraversal(right.getLeft(), right.getRight(), list);
        }
    }

}

@Data
class TreeNode {
    private int val = 0;

    private TreeNode left;
    private TreeNode right;
}