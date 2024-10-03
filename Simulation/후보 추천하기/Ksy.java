import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ksy {

    static class Student implements Comparable<Student> {

        private int count;
        private int number;
        private int order;

        public Student(int number, int order) {
            this.count = 1;
            this.number = number;
            this.order = order;
        }

        public void increase() {
            count++;
        }

        public boolean isSameNumber(int number) {
            return number == this.number;
        }

        @Override
        public int compareTo(Student o) {
            if (this.count > o.count) {
                return 1;
            } else if (this.count == o.count && this.order > o.order) {
                return 1;
            } else if (this.count == o.count && this.order == o.order) {
                return 0;
            }
            return -1;
        }
    }

    private static int[] solution(int n, int total, int[] studentNumbers) {
        List<Student> students = new ArrayList<>();

        first:
        for (int i = 0; i < total; i++) {
            int number = studentNumbers[i];

            for (Student student : students) {
                if (student.isSameNumber(number)) {
                    student.increase();

                    continue first;
                }
            }

            if (students.size() == n) {
                students.sort(Student::compareTo);
                students.remove(0);
            }

            students.add(new Student(number, i));
        }

        return students.stream()
                .mapToInt(student -> student.number)
                .sorted()
                .toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (reader) {
            int n = Integer.parseInt(reader.readLine());
            int total = Integer.parseInt(reader.readLine());

            int[] studentNumber = new int[total];
            String[] numbers = reader.readLine().split(" ");

            for (int i = 0; i < total; i++) {
                studentNumber[i] = Integer.parseInt(numbers[i]);
            }

            int[] finalStudentNumbers = solution(n, total, studentNumber);

            StringBuilder result = new StringBuilder();
            for (int finalStudentNumber : finalStudentNumbers) {
                result.append(finalStudentNumber)
                        .append(" ");
            }

            System.out.println(result);
        }
    }
}
