import java.util.*;
import java.io.*;

public class InterleavingStrings {
    //returns 1 if C can be formed by interleaving A and B, otherwise 0
    public static int isInterleave(String A, String B, String C) {
        if(C.length() != A.length() + B.length()) {
            return 0;
        }
          
        boolean[][] match = new boolean[A.length() + 1][B.length() + 1];
          
         for(int i = 1; i <= A.length(); i++){
            if(A.charAt(i - 1) == C.charAt(i - 1)) {
                match[i][0] = true;
            }
            else {
                break;
            }
        }
        for(int i = 1; i <= B.length(); i++){
            if(B.charAt(i-1) == C.charAt(i-1)) {
                match[0][i] = true;
            }
            else {
                break;
            }
        }
          
        for(int i = 1; i <= A.length(); i++){
            char ai = A.charAt(i - 1);
            for(int j = 1; j <= B.length(); j++){
                char bi = B.charAt(j - 1);
                char ci = C.charAt(i + j - 1);
                if(ai == ci) {
                    match[i][j] = (match[i - 1][j] || match[i][j]);
                }
                if(bi == ci) {
                    match[i][j] = (match[i][j - 1] || match[i][j]);
                }
            }
        }

        if(match[A.length()][B.length()]) {
            return 1;
        }
        return 0;
    }

    public static void main(String args[]) {
        String A = "aabcc";
        String B = "dbbca";
        System.out.println(isInterleave(A, B, "aadbbcbcac"));
        System.out.println(isInterleave(A, B, "aadbbbaccc"));
	  }
}    
