package com.company;

public class Main {

    public static void main(String[] args) {
	System.out.println("hot loca is not happy");
    }
}


class Solution {
    public int reverse(int x) {
         int reversed = 0;
         // 123
         while(x != 0) {
           int  temp = reversed * 10 + x % 10; // 3 * 10 + 2
             if (temp / 10 != reversed ) {
                 return 0;
             }
             reversed = temp;  // 3
             x = x / 10; // 12
         }

         return reversed;
    }
}

class Solutions {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        double result = 0;

        // remove whitespaces

        str = str.trim();
        // handle positive and negative sign
        boolean isNegative = false;
        int startIndex = 0;

        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            startIndex++;
        }
        if (str.charAt(0) == '-') {
            isNegative = true;
        }

        for(int i = startIndex; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9'){
                break;
            }
            int digitValue = str.charAt(i) - '0';
            result = result * 10 + digitValue;
        }

        if(isNegative) {
            result = -result;
        }

        // handle out of integer range
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int)result;

    }
}

class Solution_Palindrome {
    public boolean isPalindrome(int x) {
// A number that remains the same when its digits are reversed.
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false ;
        }

        // reverse process
        int reversed = 0;
        int original = x;
        while( x != 0){
            reversed = reversed * 10 + x % 10;
            x = x/10;
        }




        return reversed == original;
    }
}

class Solution_Regular {
    public boolean isMatch(String s, String p) {

        boolean [][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        char[] string = new char[s.length() + 1];
        char[] pattern = new char[p.length() + 1];

        string[0] = (char)0;
        pattern[0] = (char)0;

        for(int i = 0; i < s.length(); i++) {
            string[i + 1] = s.charAt(i);
        }

        for(int i = 0; i < p.length(); i++) {
            pattern[i + 1] = s.charAt(i);
        }

        for(int i = 0; i < p.length(); i++) {
            if (pattern[i] == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }

        for(int i = 1 ; i < s.length(); i++) {
            for(int j = 1; j < pattern.length; j++) {
                if(pattern[j] == string[i] || pattern[j] == '.') {
                    dp[i][j] = dp[i -1][j -1];
                } else if(pattern[i] == '*') {
                    if(pattern[j-1] == string[i] || pattern[j - 1] == '.'){
                        dp[i][j] = dp[i][j-2] || dp[i-1][j];
                    }else {
                        dp[i][j] =  dp[i ][j - 2];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}

class Solution_water {
    public int maxArea(int[] height) {

      int max_area = 0;
      int a_pointer = 0;
      int b_pointer = height.length - 1;

      while(a_pointer < b_pointer) {
          if (height[a_pointer] < height[b_pointer]) {
              max_area = Math.max(max_area, height[a_pointer] * (b_pointer - a_pointer));
              a_pointer += 1;
          }else {
              max_area = Math.max(max_area, height[b_pointer] * (b_pointer - a_pointer));
              b_pointer -= 1;
          }
      }
      return max_area;

    }
}