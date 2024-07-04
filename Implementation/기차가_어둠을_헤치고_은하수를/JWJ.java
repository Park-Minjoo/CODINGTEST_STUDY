package org.woojin.impl;
import java.io.*;
import java.util.*;

public class Train_JWJ {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] strs = br.readLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int [][] trains = new int [N+1][21];
        int M = Integer.parseInt(strs[1]);

        for(int i=0;i<M;i++) {
            strs = br.readLine().split(" ");
            int cmd = Integer.parseInt(strs[0]);
            int train = Integer.parseInt(strs[1]);
            if(strs.length >2) {
                int seat = Integer.parseInt(strs[2]);
                if(cmd == 1) {
                    trains[train][seat] = 1;
                }
                else if(cmd == 2) {
                    trains[train][seat] = 0;
                }
            }
            else {
                if(cmd == 3) {
                    if(trains[train][19]==0 && trains[train][20]==1) trains[train][20]=0;
                    for(int j=19;j>0;j--) {
                        if(trains[train][j]==1) {
                            trains[train][j+1] = 1;
                            trains[train][j] = 0;
                        }
                    }
                }
                else {
                    if(trains[train][2]==0 && trains[train][1]==1) trains[train][1] =0;
                    for(int j=2;j<21;j++) {
                        if(trains[train][j]==1) {
                            trains[train][j-1] = 1;
                            trains[train][j] = 0;
                        }
                    }
                }
            }


        }
        String [] trainsInteger = new String [N+1];
        for(int i=1;i<N+1;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=1;j<21;j++) {
                sb.append(trains[i][j]);
            }
            trainsInteger[i] = sb.toString();

        }

        HashSet<String> set = new HashSet<>();
        for(int i=1;i<N+1;i++) {
            set.add(trainsInteger[i]);
        }
        System.out.println(set.size());

    }

}