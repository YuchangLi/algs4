package edu.princeton.cs.algs4.lyc;

/**
 * @author liyuchang
 * @Date 2019-09-23 10:15
 */
public class SubStringKMPFind {
    static int[] next = null;
    public static int indexOf(String txt, String pat) {
        char[] txts = txt.toCharArray();
        char[] pats = pat.toCharArray();
        int tlength = txts.length;
        int plength = pats.length;
        int i = 0;
        int j = 0;
        while (i <= tlength-1 && j <= plength-1) {
            if (j==-1 || txts[i] == pats[j]){
                i++;
                j++;
            } else {
//                i = i - j + 1;
                j = next[j];
            }
        }
        return j == pats.length ? i - j : -1;
    }

    static void initNext(String pat) {
        char[] pats = pat.toCharArray();
        next = new int[pats.length];
        next[0] = -1;
        int j = 1;
        int k = -1;
        while (j<pats.length) {
            if (k == -1 || pats[k] == pats[j-1]) {
                next[j++] = ++k;
            } else {
                k = next[k];
            }
        }
    }

    public static void main(String[] args) {
        int[][] as = new int[2][1];
        System.out.println(as[0][0]);
        System.out.println(as[1][0]);
        String txt = "abbabc";
        String pat = "ba";
        System.out.println(txt.indexOf(pat));
        initNext(pat);
        System.out.println(indexOf(txt, pat));
//        System.out.println(indexOf("11133", "133"));
        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i]+" ");
        }
    }
}
