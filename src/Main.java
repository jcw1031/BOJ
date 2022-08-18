import java.io.*;
import java.util.*;

class Node{
    public Node left;
    public Node right;
    public void setLeftNode(Node node){
        left = node;
    }
    public void setRightNode(Node node){
        right = node;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) {
                String tmp = st.nextToken();


            }
        }
    }
}