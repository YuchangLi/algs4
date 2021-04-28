package edu.princeton.cs.algs4.lyc.lagoueducol.algorithmdryad;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
//         while (in.hasNextInt()) { // 注意 while 处理多个 case
//             int a = in.nextInt();
//             int b = in.nextInt();
//             System.out.println(a + b);
//         }
        String a = in.nextLine();
        String b = in.nextLine();

        if(a==null || a.equals("") || b==null || b.equals("") ){
            System.out.println(0);
        }

        a = a.toLowerCase();
        b = b.toLowerCase();
        System.out.println(a);
        System.out.println(b);
        char[] cs = a.toCharArray();
        int count = 0;
        for(int i=0; i<cs.length; i++){
            if(b.equals(String.valueOf(cs[i]))){
                count++;
            }
        }
        System.out.println(count);
    }
}