package jin.class4_2;

import java.io.*;
import java.util.*;

public class 트리순회_1991 {

    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BinaryTree bt = new BinaryTree();
        Map<Character, Node> data = new HashMap<>();

        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            Node pNode = data.getOrDefault(p, new Node(p));
            Node lNode = (l == '.') ? null : data.getOrDefault(l, new Node(l));
            Node rNode = (r == '.') ? null : data.getOrDefault(r, new Node(r));

            pNode.left = lNode;
            pNode.right = rNode;

            if (!data.containsKey(p)) data.put(p, pNode);
            if (l != '.') data.put(l, lNode);
            if (r != '.') data.put(r, rNode);
            if (p == 'A') bt.root = pNode;
        }

        bt.preorder(bt.root);
        result.append("\n");
        bt.inorder(bt.root);
        result.append("\n");
        bt.postorder(bt.root);
        System.out.println(result);
    }

    static class BinaryTree {
        Node root;

        public BinaryTree() {
            root = null;
        }


        // 전위: 루트-왼-오
        private void preorder(Node node) {
            if (node == null) return;

            result.append(node.c);
            preorder(node.left);
            preorder(node.right);
        }

        // 중위: 왼-루트-오
        private void inorder(Node node) {
            if (node == null) return;

            inorder(node.left);
            result.append(node.c);
            inorder(node.right);
        }

        // 후위: 왼-오-루트

        private void postorder(Node node) {
            if (node == null) return;

            postorder(node.left);
            postorder(node.right);
            result.append(node.c);
        }
    }

    static class Node {
        char c;
        Node left, right;

        public Node(char c) {
            this.c = c;
            left = right = null;
        }

    }
}
