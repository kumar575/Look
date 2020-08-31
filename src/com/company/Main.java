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
            int digitValue = (int)(str.charAt(i) - '0');
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
      return true;
    }
}