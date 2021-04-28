package edu.princeton.cs.algs4.lyc;

/**
 * @author liyuchang
 * @Date 2019-09-23 10:15
 */
public class SubStringBMFind {
    static int R = 256;
    static int[] right = new int[R];
    public static int indexOf(String txt, String pat) {
        char[] txts = txt.toCharArray();
        char[] pats = pat.toCharArray();
        int tlength = txts.length;
        int plength = pats.length;
        int i = plength - 1;
        int j = plength - 1;
        while (j >= 0 && i < tlength) {
            if (pats[j] == txts[i]) {
                j--;
                i--;
            } else {
                j = plength - 1;
                i = i + plength - right[txts[i]] - 1;
            }
        }
        return j < 0 ? i + 1 : -1;
    }

    static void initRight(String pat) {
        char[] pats = pat.toCharArray();
        for (int i = 0; i < R; i++) {
            right[i] = -1;
        }
        for (int i = 0; i < pat.length(); i++) {
            right[pats[i]] = i;
        }
    }

    public static void main(String[] args) {
        String txt = "ababab";
        String pat = "ababab";
//        char c = '沈';
//        System.out.println(c);
//        System.out.println((int)c);
        initRight(pat);
        System.out.println(indexOf(txt, pat));
        System.out.println(txt.indexOf(pat));
//        System.out.println(indexOf("11133", "133"));
    }
}
