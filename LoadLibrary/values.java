import java.io.*;
import java.lang.*;
import java.util.*;

public class values {

    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        FileWriter fw=new FileWriter("values.txt",true);
        PrintWriter pw=new PrintWriter(fw);

        int range=0;
        String value;
        System.out.println("Enter the Range");
        range=Integer.parseInt(br.readLine());

        System.out.println("The Range is "+range);
        for (int i =1;i<=range;i++) {
            value=i+" "+i;
            pw.println(value);
        }

        pw.close();
        fw.close();
        br.close();
        
    }
}
