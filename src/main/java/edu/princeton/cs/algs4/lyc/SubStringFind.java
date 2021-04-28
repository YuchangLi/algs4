package edu.princeton.cs.algs4.lyc;

/**
 * @author liyuchang
 * @Date 2019-09-23 10:15
 */
public class SubStringFind {

    public static int indexOf(String txt, String pat) {
        char[] txts = txt.toCharArray();
        char[] pats = pat.toCharArray();
        int tlength = txts.length;
        int plength = pats.length;
        int i = 0;
        int j = 0;
        while (i <= tlength-1 && j <= plength-1) {
            if (txts[i] == pats[j]){
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return j == pats.length ? i - j : -1;
    }

    public static void main(String[] args) {
        System.out.println("asdfasdf".charAt(2));
        System.out.println(indexOf("11133", "133"));
    }
}
