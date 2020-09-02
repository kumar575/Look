package com.company;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	//System.out.println("hot loca is not happy");

	ArrayList l = new ArrayList();
	for(int  i = 0; i <= 10; i++) {
	    l.add(i);
    }
	//System.out.println(l);

        LinkedList ll = new LinkedList();
	ll.add("Yes");
	ll.add("No");
	ll.add("Maybe");
	System.out.println(ll);

	ListIterator ltr = ll.listIterator();
	while(ltr.hasNext()) {
	    String s = (String) ltr.next();
	    if(s.equals("Yes")) {
	        ltr.remove();
        }
	    else if(s.equals("No")) {
	        ltr.add("Nope");
        }
	    else if(s.equals("Maybe")) {
	        ltr.set("Perhaps");
        }
        System.out.println(ll);
    }


//	ListIterator itr = (ListIterator) l.iterator();
//	while(itr.hasNext()) {
//	    Integer i = (Integer) itr.next();
//	    if(i % 2 == 0) {
//            System.out.println(l);
//        }else {
//	        itr.remove();
//        }
//    }

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

class Solution_Roman {
    public String intToRoman(int num) {

        int[] arabics = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL","X","IX", "V", "IV", "I" };

//        StringBuilder sb = new StringBuilder();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arabics.length ; i++) {
            while(num - arabics[i] >= 0){
                sb.append(romans[i]);
                num = num - arabics[i];
            }
        }
        return sb.toString();



    }
}

class Solution_RomanToInt {
    public int romanToInt(String s) {

        Map<Character,Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            }else {
                result += map.get(s.charAt(i));
            }


        }
        return result;

    }
}

class Solution_Prefix {
    public String longestCommonPrefix(String[] strs) {

         if(strs.length == 0) return "";
         String prefix = strs[0];

         for(int i = 0; i <strs.length; i++) {
             while(strs[i].indexOf(prefix) != 0 ) {
                 prefix = prefix.substring(prefix.length() - 1);
             }
         }
         return prefix;

    }
}

class Solution_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {

        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 2; i++) {
            int a_pointer = i + 1;
            int b_pointer = nums.length - 1;

            while (a_pointer < b_pointer) {
                int current_sum = nums[i] + nums[a_pointer] + nums[b_pointer];
                if (current_sum > target) {
                    b_pointer -= 1;
                } else {
                    a_pointer += 1;
                }
                if (Math.abs(current_sum - target) < Math.abs(result - target)) {
                    result = current_sum;
                }
            }
        }
        return result;

     }


}

class Solution_List {
    public List<String> letterCombinations(String digits) {

        LinkedList<String> output_arr = new LinkedList();
        if(digits.length() == 0) {
            return output_arr;
        }

        output_arr.add("");
        String[] char_map = new String[] { "0", "1", "abc", "def", "ghi","jkl", "mno", "pqrs", "tuv", "wxyz"};

        for(int i = 0 ; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while(output_arr.peek().length() == i) {
                String permutation = output_arr.remove();
                for(char c: char_map[index].toCharArray()) {
                    output_arr.add(permutation + c);
                }
            }
        }

        return output_arr;
    }
}

class Solution_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;

                    } else {
                        List<Integer> quadruplets = new ArrayList<>();
                        quadruplets.add(nums[i]);
                        quadruplets.add(nums[j]);
                        quadruplets.add(nums[left]);
                        quadruplets.add(nums[right]);

                        result.add(quadruplets);
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }


        }
        return result;
    }
}




 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution_NthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy_head = new ListNode(0);
        dummy_head.next = head;

        ListNode slow = dummy_head;
        ListNode fast = dummy_head;

        for(int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;


        return dummy_head.next;


    }
}

class Solution_Brackets {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false ;
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[' ) {
                stack.push(c);
            }else if (c == '}' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }else if (c == ']' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}

class Solution_Merging {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {



        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while(l1 != null || l2 != null ) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            }else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if(l1 != null) {
            dummy.next = l1;
        }else {
            dummy.next = l2;
        }

        return head.next;


    }
}

class Solution_Parenthesis {
    public List<String> generateParenthesis(int n) {

         List<String> output_arr = new ArrayList();
         backtrack(output_arr, "", 0,0,n);
         return output_arr;


    }

    public void backtrack(List<String> output_arr, String current_string,int open, int close, int max) {
        if (current_string.length() ==  max * 2) {
            output_arr.add(current_string);
            return;
        }
        if(open < max) backtrack(output_arr,current_string + "(", open + 1, close, max);
        if (close < open) backtrack(output_arr,current_string + ")", open, close + 1, max);
    }
}

class Solution_mergeList {
    public ListNode mergeKLists(ListNode[] lists) {

        // min Heap

        if (lists.length == 0) return null;

        int interval = 1;
        int length = lists.length;
        while(interval < length) {
            for(int i = 0; i < length - interval; i+= (interval * 2)) {
                merge(lists, i, i + interval);

            }
            interval *= 2;
        }

        return lists[0];


    }

    public void merge(ListNode[] list, int index1, int index2) {
        ListNode ans = new ListNode(-1);
        ListNode ptr = ans;
        ListNode l1 = list[index1];
        ListNode l2 = list[index2];

        while(l1 != null || l2 != null) {
            if(l1 == null ) {
                ptr.next = l2;
                break;
            }
            if (l2 == null ){
                ptr.next = l1;
                break;
            }
            if(l1.val < l2.val){
                ptr.next = l1;
                l1 = l1.next;
            }else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        list[index1] = ans.next;
    }
}

class Solution_SwapNodes {
    public ListNode swapPairs(ListNode head) {

        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode current = temp;

        while(current.next != null && current.next.next != null) {
            ListNode first_node = current.next;
            ListNode second_node = current.next.next;
            first_node.next  = second_node.next;
            current.next.next = first_node;
            current = current.next.next;

        }

        return temp.next;

    }
}

class Solution_ReverseNodeK {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode root = new ListNode(0, head);
        ListNode cur = head;
        ListNode prev = root;

        while(cur != null) {
            ListNode tail = cur;
            int listIndex = 0;

             while(cur != null && listIndex < k) {
                 cur = cur.next;
                 listIndex++;
             }
             if(listIndex != k) {
                 prev.next = tail;

             }else {
                 prev.next = reverse(tail, k);
                 prev = tail;
             }
        }
        return root.next;


    }

    private ListNode reverse (ListNode head, int k ){
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while(current != null && k-- > 0){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        head = prev;
        return head;

    }

}

//
//class Solution_duplicatesList {
//    public int removeDuplicates(ListNode nums) {
//
//         ListNode current_node = head;
//         while(current_node != null && current_node.next != null) {
//             if(current_node.next.val == current_node.val){
//                 current_node.next = current_node.next.next;
//             }else{
//                 current_node = current_node.next;
//             }
//         }
//         return head;
//    }
//}

class Solution_duplicatesArray {
    public int removeDuplicates(int[] nums) {

        int index = 1;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] != nums[i + 1]) {
                nums[index++] = nums[i + 1];
            }
        }
        return index;

    }
}

class Solution_removeElement {
    public int removeElement(int[] nums, int val) {

        if(nums.length == 0) {
            return 0;
        }

        int valid_size = 0;
        int j = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != val) {
                nums[j] = nums[i];
                valid_size++;
            }
        }
        return valid_size;
    }
}

class Solution_str {
    public int strStr(String haystack, String needle) {

        if(haystack == null || needle == null) {
            return -1;
        }

        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j;
            for( j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i + j) == needle.charAt(j)) {
                    break;
                }
            }
            if(j == needle.length()) {
                return i;
            }
        }
        return -1;

    }
}

class Solution_divide {
    public int divide(int dividend, int divisor) {

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1 ;

        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long)divisor);

        long res = 0;

        while(ldivisor <= ldividend){
            long temp = ldivisor;
            long mul = 1;
            while(ldividend >= (temp << 1)) {
                temp <<= 1 ;
                mul <<= 1;
            }

            res += mul;
            ldividend -= temp;
        }
        res *= sign;

        if(res >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        } else {
            return (int)res;
        }

    }
}


class Solution_substring {
    public List<Integer> findSubstring(String s, String[] words) {

          List<Integer> result = new ArrayList();

          if(s.length()==0 || words.length==0)return result;
          HashMap<String, Integer> map1 = new HashMap();

          for(int i=0; i<words.length; i++) {
              map1.put(words[i], map1.getOrDefault(words[i], 0) + 1);

          }
          int t = words.length * words[0].length();
          int sl = words[0].length();

          int i = 0;
          while(i<=s.length()-t){
              String sub = s.substring(i, i+t);
              // 0 6 , 1 7 2 8
              HashMap<String, Integer> map2 = new HashMap();
              int k = 0;
              int n = 0;
              while(k < words.length) {

                  String temp = sub.substring(n, n+sl);
                  map2.put(words[i], map2.getOrDefault(temp, 0) + 1);

                  n = n + sl;
                  k++;
              }
              if(map1.equals(map2))result.add(i);
              i++;
          }


          return result;

    }
}

//class Solution_mergeKsorted {
//    public ListNode mergeKLists(ListNode[] lists) {
//        PriorityQueue<ListNode> heap;
//        heap = new PriorityQueue(<Comparator <ListNode>> (o1, o2) -> o1.val -  o2.val;);
//
//        for(ListNode head: lists){
//            if(head != null){
//                heap.offer(head);
//
//            }
//        }
//        ListNode pre = new ListNode(-1);
//        ListNode tmp = pre;
//        while(!heap.isEmpty()){
//          ListNode curr = heap.poll();
//          tmp.next = new ListNode(curr.val);
//        }
//        tmp = tmp.next;
//    }
//    return pre.next;
//
//
//    }