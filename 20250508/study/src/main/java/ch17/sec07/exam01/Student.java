package ch17.sec07.exam01;

public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.score, other.score); // 오름차순 정렬 기준
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
