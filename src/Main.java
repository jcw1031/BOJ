import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), "...");
        String input = br.readLine();

        int count = 0;
        int index = 0;
        int start = 0;
        String result = "";

        while(index < input.length()){
            if(input.charAt(index) == 'X'){
                count++;
            }
            else{
                if(count%2!=0) {
                    System.out.println(-1);
                    System.exit(0);
                }
                else{
                    int a = count/4;
                    count = count%4;
                    int b = count/2;
                    for(int i=0;i<a*4;i++){
                        result+='A';
                    }
                    for(int i=0;i<b*2;i++){
                        result+='B';
                    }
                    result+='.';
                }
                count = 0;
            }
            index++;
        }

        if(count%2!=0){
            System.out.println(-1);
            System.exit(0);
        }

        int a = count/4;
        count = count%4;
        int b = count/2;
        for(int i=0;i<a*4;i++){
            result+='A';
        }
        for(int i=0;i<b*2;i++){
            result+='B';
        }

        System.out.println(result);
    }
}