package yelim.solvedac.class4;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinarySearchTree {
    static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }

        Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
            if(n < this.num) { // 현재 노드의 값보다 작으면 왼쪽 노드로 넘어가기
                if(this.left == null) { // 왼쪽 노드로 넘어갔을 때 null일 경우
                    this.left = new Node(n);
                }else {
                    this.left.insert(n);
                }
            }else { // 현재 노드의 값보다 크면 오른쪽 노드로 넘어가기
                if(this.right == null) { // 오른쪽 노드로 넘아갔을 때 null일 경우
                    this.right = new Node(n);
                }else {
                    this.right.insert(n);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 노드의 왼쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 작다.
        // 노드의 오른쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 크다.
        // 왼쪽, 오른쪽 서브트리도 이진 검색 트리
        // 전위 순회(루트-왼쪽-오른쪽)한 결과 -> 후위 순회(왼쪽-오른쪽-루트)한 결과
        // 노드의 수 <= 10000, 0 < 키의 값 < 10^6
        // 같은 키를 가지는 노드는 없다.(중복 X)
        // 전위 순회를 한 결과 -> 트리 구성 알기 -> 후위 순회하기

        Node root = new Node(Integer.parseInt(br.readLine()));

        String input;
        while(true) {
            input = br.readLine();
            if(input == null || input.equals("")) break;

            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    static void postOrder(Node node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}
