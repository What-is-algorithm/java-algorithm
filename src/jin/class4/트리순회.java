package jin.class4;

import java.io.*;
import java.util.*;

// [S1] 1991. 트리 순회
public class 트리순회 {

    static class Node {
        char data;
        Node left, right;

        public Node (char c) {
            data = c;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        public BinaryTree () {
            root = null;
        }

        // (루트) (왼쪽 자식) (오른쪽 자식)
        void printPreOrder(Node node) {
            if (node == null) return;

            System.out.print(node.data);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }

        // (왼쪽 자식) (루트) (오른쪽 자식)
        void printInOrder(Node node) {
            if (node == null) return;

            printInOrder(node.left);
            System.out.print(node.data);
            printInOrder(node.right);
        }

        // (왼쪽 자식) (오른쪽 자식) (루트)
        void printPostOrder(Node node) {
            if (node == null) return;

            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.data);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Map<Character, Node> data = new HashMap<>();
        BinaryTree tree = new BinaryTree();

        for (int i = 0; i < N; i++) {
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

            if (i == 0) tree.root = pNode;
        }


        tree.printPreOrder(tree.root);
        System.out.println();
        tree.printInOrder(tree.root);
        System.out.println();
        tree.printPostOrder(tree.root);
        br.close();
    }
}
