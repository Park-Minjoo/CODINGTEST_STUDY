import java.util.*;

class Solution {
    //1. 2~9진법을 전부 탐방
    //2. x가 아닌 수식을 만족하는 진법 추출
    //3. 거기서 x가 모두 동일한 결과가 아니면 ? 출력
    public String[] solution(String[] expressions) {

        boolean[] bs = new boolean[10];

        //1.
        for(int i=2; i<=9; i++){
            bs[i] = checkFn(i, expressions);

        }
        //System.out.println(Arrays.toString(bs));

        //3.
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        for(int i=2; i<=9; i++){
            if(bs[i]){
                results.add(getResult(i, expressions));
            }
        }

        //+ 다른 값이면 ?로 대체
        String[] answer = new String[results.get(0).size()];
        for(int j=0; j<results.get(0).size(); j++){
            answer[j] = results.get(0).get(j);
        }

        for(int j=0; j<results.get(0).size(); j++){
            for(int i=0; i<results.size()-1; i++){
                String now = results.get(i).get(j);
                String next = results.get(i+1).get(j);
                if(!now.equals(next)){
                    answer[j] = now.split(" = ")[0] + " = ?";
                    break;
                } else {
                    answer[j] = now;
                }

            }
        }


        return answer;
    }

    //2.
    public static boolean checkFn(int i, String[] exs){
        for(String ex : exs){
            // System.out.println("원래: " + ex);
            String[] tmp = ex.split(" = ");
            String[] nums = {};
            int a,b,c;
            //X가 아닌 수식만

            //덧셈 뺄셈 구분
            if(tmp[0].contains("+")){
                nums = tmp[0].split(" \\+ ");
                a = changeV(nums[0], i);
                b = changeV(nums[1], i);

                if(a == -1 || b == -1){
                    return false;
                }

                if(!tmp[1].equals("X")){
                    c = changeV(tmp[1], i);

                    if(a+b != c){
                        return false;
                    }
                }

                //System.out.printf("%d진법: %d + %d = %d\n", i,a,b,c);

            } else {
                nums = tmp[0].split(" - ");

                a = changeV(nums[0], i);
                b = changeV(nums[1], i);

                if(a == -1 || b == -1){
                    return false;
                }

                if(!tmp[1].equals("X")){
                    c = changeV(tmp[1], i);

                    if(a-b != c){
                        return false;
                    }
                }
            }

        }

        return true;
    }

    //3.
    public static ArrayList<String> getResult(int i, String[] exs){

        ArrayList<String> str_arr = new ArrayList<>();

        for(String ex : exs){
            // System.out.println("원래: " + ex);
            String[] tmp = ex.split(" = ");
            String[] nums = {};
            int a,b,c;

            //X가 아닌 수식만
            if(tmp[1].equals("X")){
                //덧셈 뺄셈 구분
                if(tmp[0].contains("+")){
                    nums = tmp[0].split(" \\+ ");
                    a = changeV(nums[0], i);
                    b = changeV(nums[1], i);
                    //System.out.printf("%d진법: %d + %d = %d\n", i,a,b,c);

                    str_arr.add(nums[0] + " + " + nums[1] + " = " + reverseV(String.valueOf(a+b), i));

                } else {
                    nums = tmp[0].split(" - ");

                    a = changeV(nums[0], i);
                    b = changeV(nums[1], i);

                    str_arr.add(nums[0] + " - " + nums[1] + " = " + reverseV(String.valueOf(a-b), i));
                }
            }

        }

        return str_arr;
    }

    //모든 진법 -> 10진법 변환
    public static int changeV(String s, int k){
        int result = 0;
        for(int i =s.length()-1; i>=0; i--){
            int a = s.charAt(i) - '0';

            //예외: 숫자 값이 진법보다 크면 안됨
            if(a >= k){
                return -1;
            }

            result += (a * Math.pow(k, s.length() - i - 1));
        }

        return result;
    }


    //10진법 -> k진법
    public static String reverseV(String s, int k){
        int a = Integer.valueOf(s);

        if(a==0){
            return "0";
        }

        String tmp = "";
        while(a != 0){
            tmp += (a % k);
            a = a/k;
        }

        String result = "";

        for(int i =tmp.length()-1; i>=0; i--){
            result += tmp.charAt(i);
        }

        return result;
    }
}