package org.woojin.ds;

import java.util.*;

public class Parenthesis_JWJ {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        Stack<Character> st = new Stack<>();

        int weight = 1;
        int result = 0;
        for(int i=0; i<str.length(); i++){

            if(str.charAt(i)=='('){
                st.push(str.charAt(i));
                weight *= 2;
            }
            else if(str.charAt(i)=='['){
                st.push(str.charAt(i));
                weight *= 3;
            }
            else if(str.charAt(i)==')'){

                if(st.isEmpty() || st.peek() != '('){
                    result = 0;
                    break;
                }

                if(str.charAt(i-1)=='('){
                    result += weight;
                }

                st.pop();
                weight /= 2;
            }
            else if(str.charAt(i)==']'){
                if(st.isEmpty() || st.peek() != '['){
                    result = 0;
                    break;
                }

                if(str.charAt(i-1)=='['){
                    result += weight;
                }

                st.pop();
                weight /= 3;
            }
        }

        if(!st.isEmpty()){
            result = 0;
        }

        System.out.println(result);

    }

}
