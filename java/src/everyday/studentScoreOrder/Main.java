package everyday.studentScoreOrder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    private int score;
    private String name;

    public Student(String name, int score) {
        this.score = score;
        this.name = name;
    }

    public void setScore(int score) { this.score = score; }
    public void setName(String name) { this.name = name; }
    public int getScore() { return this.score; }
    public String getName() { return this.name; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentNumber = scanner.nextInt();
        Student[] students = new Student[studentNumber];

        for(int i = 0; i < students.length; i++) {
            String name = scanner.next();
            int score = scanner.nextInt();
            students[i] = new Student(name, score);
        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return student1.getScore() - student2.getScore();
            }
        });

        for(Student student : students) {
            System.out.print(student.getName() + " ");
        }
    }
}
