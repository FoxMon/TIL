package everyday.subject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    private String name;
    private int korea;
    private int english;
    private int math;

    public Student(String name, int korea, int english, int math) {
        this.name = name;
        this.korea = korea;
        this.english = english;
        this.math = math;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getKorea() {
        return korea;
    }
    public void setKorea(int korea) {
        this.korea = korea;
    }
    public int getEnglish() {
        return english;
    }
    public void setEnglish(int english) {
        this.english = english;
    }
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        this.math = math;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        Student[] students = new Student[total];

        for(int i = 0; i < students.length; i++) {
            String name = scanner.next();
            int korea = scanner.nextInt();
            int english = scanner.nextInt();
            int math = scanner.nextInt();
            students[i] = new Student(name, korea, english, math);
        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student stu1, Student stu2) {
                if(stu1.getKorea() < stu2.getKorea()) {
                    return 1;
                } else if(stu1.getKorea() == stu2.getKorea()) {
                    if(stu1.getEnglish() > stu2.getEnglish()) {
                        return 1;
                    } else if(stu1.getEnglish() == stu2.getEnglish()) {
                        if(stu1.getMath() < stu2.getMath()) {
                            return 1;
                        }else if (stu1.getMath() == stu2.getMath()) {
                            return stu1.getName().compareTo(stu2.getName());
                        }
                    }
                }

                return -1;
            }
        });
        for(Student student : students) {
            System.out.println(student.getName());
        }
    }
}
