package com.company.leetcode;

import java.util.Stack;

public class LeetCode20 {
     public static void main(String[] args){
        System.out.println(isValid("()")); //true
        System.out.println(isValid("(([{}][))")); //false
     }

    public  static boolean isValid(String s) {
        if (s == null || s.length()==0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for ( int i =0  ; i< s.length() ;  i++) {
            char e = s.charAt(i);
            if (e == '(' || e == '[' || e == '{') {
                stack.push(e);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (e == ')' || e == ']' || e == '}') {

                    char topChar = stack.peek();
                    switch (topChar) {
                        case '(': {
                            if (e != ')') {
                                return false;
                            } else {
                                stack.pop();
                                break;
                            }
                        }
                        case '[': {
                            if (e != ']') {
                                return false;
                            } else {
                                stack.pop();
                                break;
                            }
                        }
                        case '{': {
                            if (e != '}') {
                                return false;
                            } else {
                                stack.pop();
                                break;
                            }
                        }
                    }

                }
            }

        }
        return stack.isEmpty();
    }
}
