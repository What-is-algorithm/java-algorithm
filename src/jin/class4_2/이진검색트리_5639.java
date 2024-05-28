package jin.class4_2;

import java.io.*;

public class 이진검색트리_5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BST bst = new BST();
        StringBuilder result = new StringBuilder();
        String input;
        while ( (input = br.readLine()) != null && !input.isEmpty()) {
            int value = Integer.parseInt(input);
            bst.insert(value);
        }
        br.close();

        bst.postorder(bst.root, result);
        System.out.println(result);
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

            // l - r - m
            postorder(node.left, sb);
            postorder(node.right, sb);
            sb.append(node.value).append("\n");
        }

        static class Node {
            int value;
            Node left, right;

            public Node(int value) {
                this.value = value;
                left = right = null;
            }

            public void insert(int num) {
                if (this.value > num) {
                    if (this.left == null) {
                        this.left = new Node(num);
                    } else {
                        left.insert(num);
                    }
                } else {
                    if (this.right == null) {
                        this.right = new Node(num);
                    } else {
                        right.insert(num);
                    }
                }
            }
        }

    }

}
