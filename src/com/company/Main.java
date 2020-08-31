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