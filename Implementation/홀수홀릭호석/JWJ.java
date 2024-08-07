package org.woojin.impl;

import java.util.*;

public class 홀수홀릭호석{
    //처음에는 DP를 생각했지만, 이전에 구한 해를 적용할 수 없는 문제
    //그냥 쪼개지는 모든 경우를 계산하는 방법으로 진행

    static Queue<Node> strs = new LinkedList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String start_str = sc.nextLine();
        //입력끝

        //첫번째수 초기화
        int result = countOdd(start_str);
        strs.offer(new Node(start_str, result));

        //모든 결과를 저장하는 배열
        ArrayList<Integer> results = new ArrayList<>();

        int count;
        String str;
        while(!strs.isEmpty()){
            Node now = strs.poll();
            str = now.str;
            count = now.count;
            //System.out.println(str + " " + count);

            if(str.length() == 1){
                results.add(count);
            }
            else if(str.length() == 2){
                doubleStr(str, count);
            } else {
                tripleStr(str, count);
            }
        }

        //정렬을 통해 최소 계산수, 최대 계산 수 출력
        Collections.sort(results);

        System.out.println(results.get(0) + " " + results.get(results.size()-1));
    }

    public static int countOdd(String str){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(Integer.valueOf(str.charAt(i) - '0') % 2 == 1){
                count++;
            }
        }
        return count;
    }

    //2개로 쪼개지는 경우를 strs에 삽입
    public static void doubleStr(String str, int count){
        int a = Integer.valueOf(str.charAt(0) - '0');
        int b = Integer.valueOf(str.charAt(1) - '0');
        //System.out.println("2--------" +a + " " + b);

        str = String.valueOf(a+b);
        count += countOdd(str);

        strs.offer(new Node(str, count));

    }

    //3개로 쪼개지는 모든 경우를 strs에 삽입
    public static void tripleStr(String str, int count){
        int i=1, j;

        // 0~i, i~j, j~length
        int a,b,c;
        String temp;
        int temp_count;
        for(; i<str.length()-1; i++){
            for(j=i+1; j<str.length(); j++){
                a = Integer.valueOf(str.substring(0,i));
                b = Integer.valueOf(str.substring(i,j));
                c = Integer.valueOf(str.substring(j,str.length()));

                temp = String.valueOf(a+b+c);
                temp_count = count + countOdd(temp);

                //System.out.println("3--------" +a + " " + b + " " + c + "->" + temp + " " + temp_count);

                strs.offer(new Node(temp, temp_count));
            }
        }
    }

    static class Node{
        String str;
        int count;

        Node(String _str, int _c){
            str = _str;
            count = _c;
        }

    }


}