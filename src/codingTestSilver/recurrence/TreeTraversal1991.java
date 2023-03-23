package codingTestSilver.recurrence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int num;
    public Node left;
    public Node right;

    public Node(int num) {
        this.num = num;
    }

    public void print() {
        char tmp = (char) ('A' + num);
        System.out.print(tmp);
    }
}

public class TreeTraversal1991 {
    public static Node[] nodes;

    public static void preorder(int i) {
        nodes[i].print();
        if (nodes[i].left != null) {
            preorder(nodes[i].left.num);
        }
        if (nodes[i].right != null) {
            preorder(nodes[i].right.num);
        }
    }

    public static void inorder(int i) {
        if (nodes[i].left != null) {
            inorder(nodes[i].left.num);
        }
        nodes[i].print();
        if (nodes[i].right != null) {
            inorder(nodes[i].right.num);
        }
    }

    public static void postorder(int i) {
        if (nodes[i].left != null) {
            postorder(nodes[i].left.num);
        }
        if (nodes[i].right != null) {
            postorder(nodes[i].right.num);
        }
        nodes[i].print();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] tmp = new String[3];
            char[] temp = new char[3];
            for (int j = 0; j < 3; j++) {
                tmp[j] = st.nextToken();
                temp[j] = tmp[j].charAt(0);
            }
            if (temp[1] != '.') {
                nodes[temp[0] - 'A'].left = nodes[temp[1] - 'A'];
            }
            if (temp[2] != '.') {
                nodes[temp[0] - 'A'].right = nodes[temp[2] - 'A'];
            }
        }
        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }
}