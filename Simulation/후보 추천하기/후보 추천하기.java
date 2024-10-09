import java.util.*;
import java.io.*;

public class Main {

    private static int N, M; // 사진첩 개수, 학생수
    private static List<Student> list = new ArrayList<Student>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 처음 개수만큼 리스트에 넣기
        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(st.nextToken());

            Student student = getStudent(current);
            if (student != null) {
                student.value++;
            } else {
                list.add(new Student(current, i, 1));
            }
        }

        // 나머지
        for (int i = N; i < M; i++) {
            int current = Integer.parseInt(st.nextToken());

            Student student = getStudent(current);
            int a = 0;
            if (student != null) {
                student.value++;
            } else {
                // 사진틀 가득 차있으면 하나 지운다
                int size = list.size();
                if (size >= N) {
                    Collections.sort(list);
                    list.remove(0);
                }
                list.add(new Student(current, i, 1));
            }
        }

        // 학생 번호를 기준을 정렬
        list.sort(Comparator.comparingInt(l -> l.id));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<list.size(); i++) {
            sb.append(list.get(i).id + " ");
        }
        System.out.println(sb.toString());

    }

    public static class Student implements Comparable<Student> {
        int id; // 학생번호
        int orderNum; // 순서번호
        int value;

        @Override
        public int compareTo(Student other) {
            if (value != other.value) {
                return value - other.value;
            }
            return orderNum - other.orderNum;
        }

        public Student(int id, int orderNum, int value) {
            this.id = id;
            this.orderNum = orderNum;
            this.value = value;
        }
    }

    // 리스트 안에 존재여부 확인
    public static Student getStudent(int id) {
        int size = list.size();
        for (int i=0; i<size; i++) {
            Student student = list.get(i);
            if (id == student.id) {
                return student;
            }
        }
        return null;
    }

    public static void print() {
        int size = list.size();
        System.out.println("================================");
        for (int i=0; i<size; i++) {
            Student s = list.get(i);
            System.out.println("student id : " + s.id + "   student value : " + s.value + "   student orderNum : " + s.orderNum);
        }
    }

}