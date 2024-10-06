package org.woojin.impl;

import java.util.*;

public class 단어맞추기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(findNext(sc.nextLine().toCharArray())).append("\n");
        }
        System.out.println(sb);
    }

    public static String findNext(char[] str){

        int i = str.length-1;
        int j = i;
        boolean isFind = true;

        for(; i>0; i--){
            if(str[i] > str[i-1]){
                i--;
                isFind = false;
                break;
            }
        }

        if(isFind){
            return String.valueOf(str);
        }

        for(; j>0; j--){
            if(str[j] > str[i]){
                break;
            }
        }

        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;

        Arrays.sort(str, i+1, str.length);

        return  String.valueOf(str);
    }
}
