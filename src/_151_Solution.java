/**
 * Created by chenjunxing ON 2020-07-14 23:18.
 */
public class _151_Solution {
    // stupid method
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        String[] sarray = s.trim().split(" ");
        String ss = "";

        for (int i = 0; i < sarray.length; i++) {
            if (sarray[i].equals("")) {
                continue;
            }

            if (i != sarray.length - 1) {
                ss += sarray[i] + " ";
            } else {
                ss += sarray[i];
            }
        }

        String[] split = ss.split(" ");
        int start = 0, end = split.length - 1;

        while (start < end) {
            String tem = split[start];
            split[start] = split[end];
            split[end] = tem;
            start++;
            end--;
        }

        StringBuilder result = new StringBuilder();
        for (String s1 : split) {
            result.append(s1 + " ");
        }

        return result.toString().trim();
    }

    // ----------------------------------the elegant code by jeantimex
    public String reverseWordsElegant(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }
}
