package org.woojin.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Tree_JWJ {
    public static void main(String[] args) throws IOException {
        /*
            문제 review

         */

        mySolution();
    }


    static HashMap<String, Tree> trees = new HashMap<>();
    static StringBuilder prefixResult = new StringBuilder();
    static StringBuilder inorderResult = new StringBuilder();
    static StringBuilder postfixResult = new StringBuilder();

    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        for(int i=0; i<n; i++){
            trees.put(String.valueOf((char) ('A' + i)), new Tree((char)('A' + i)));
        }


        StringTokenizer st;
        String a,b,c;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            b = st.nextToken();
            c = st.nextToken();

            Tree now = trees.get(a);
            Tree left = null;
            Tree right = null;

            if(!b.equals(".")){ left = trees.get(b); }
            if(!c.equals(".")){ right = trees.get(c); }

            now.setLeft(left);
            now.setRight(right);
        }

        traversal(trees.get("A"));

        System.out.println(prefixResult);
        System.out.println(inorderResult);
        System.out.println(postfixResult);

    }

    public static void traversal(Tree t){
        prefixResult.append(t.getV());
        if(t.getLeft() != null) {
            traversal(t.getLeft());
        }
        inorderResult.append(t.getV());
        if(t.getRight() != null){
            traversal(t.getRight());
        }
        postfixResult.append(t.getV());
    }


}

class Tree{
    private String v;
    private Tree left;
    private Tree right;

    public Tree(String v, Tree l, Tree r){
        this.v = v;
        left = l;
        right = r;
    }

    public Tree(char v){
        this.v = String.valueOf(v);
    }

    public String getV(){ return v; }
    public Tree getLeft(){ return left; }
    public Tree getRight(){ return right; }

    public void setLeft(Tree l){ left = l; }
    public void setRight(Tree r){ right = r; }
}
