package jin.class4;

// [G5] 5639. 이진 검색 트리

import java.io.*;

public class 이진검색트리 {
    static class Node {
        int value;
        Node left, right;

        public Node (int value) {
            this.value = value;
            left = right = null;
        }

        void insert (int num) {
            if (this.value > num) {
                if (this.left == null) {
                    this.left = new Node(num);
                } else {
                    this.left.insert(num);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(num);
                } else {
                    this.right.insert(num);
                }
            }
        }
    }

    static class BST {
        Node root;

        void insert(int value) {
            if (root == null) {
                root = new Node(value);
            } else {
                root.insert(value);
            }
        }

        void postorder(Node node, StringBuilder sb) {
            if (node == null) return;

            // 왼쪽 - 오른쪽 - 루트
            postorder(node.left, sb);
            postorder(node.right, sb);
            sb.append(node.value).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BST bst = new BST();
        StringBuilder sb = new StringBuilder();
        String input;
        while ( (input = br.readLine()) != null && !input.isEmpty()) {
            int num = Integer.parseInt(input);
            bst.insert(num);
        }

        bst.postorder(bst.root, sb);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

        br.close();
    }
}
