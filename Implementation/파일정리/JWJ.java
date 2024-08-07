package org.woojin.impl;

import java.util.*;

public class 파일정리 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());

        HashMap<String, Integer> h = new HashMap<>();

        for(int i=0; i<n; i++){
            String[] strs = sc.nextLine().split("\\.");
            h.put(strs[1], h.getOrDefault(strs[1], 0) + 1);
        }

        ArrayList<String> keys = new ArrayList<>(h.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for(String k : keys){
            sb.append(k).append(" ").append(h.get(k)).append("\n");
        }
        System.out.println(sb);

    }
}
