import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File studentsFile = new File("students.txt");
        List<Student> students = new ArrayList<Student>();

        try {
            Scanner scanner = new Scanner(studentsFile);

            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(",");
                Student student = new Student(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3], Integer.parseInt(split[4]));
                students.add(student);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        File coursesFile = new File("courses.txt");
        List<Student.Course> courses = new ArrayList<Student.Course>();

        try {
            Scanner scanner = new Scanner(coursesFile);

            while (scanner.hasNextLine()){
                String[] split = scanner.nextLine().split(",");
                Student.Course course = new Student().new Course(split[0], split[1]);
                courses.add(course);
            }
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }


        File courcesStudentsFile = new File("courses_students.txt");
        List<Student.Course> coursesStudents = new ArrayList<Student.Course>();

        try {
            Scanner scanner = new Scanner(courcesStudentsFile);

            while (scanner.hasNextLine()){
                String[] split = scanner.nextLine().split(",");
                Student.Course course = new Student().new Course(split[0], split[1]);
                coursesStudents.add(course);
            }
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }


        int count = 0;
        for (Student student : students){
            count++;
            boolean check1 = true;
            boolean check2 = true;
            boolean check3 = true;
            System.out.print("[Student(");
            for (Student.Course courseStudent : coursesStudents){
                if (student.name.equals(courseStudent.description)){
                    if (check1){
                        System.out.print(student.toSting());
                        check1 = false;
                    }
                    if (check2){
                        System.out.print(", courses=[");
                        check2 = false;
                    }
                    for (Student.Course course : courses){
                        if (courseStudent.name.equals(course.name)){
                            if (check3){
                                System.out.print("Course(" + course.toString() + ")");
                                check3 = false;
                            }
                            else{
                                System.out.print(", Course(" + course.toString() + ")");
                            }
                        }
                    }
                }
            }
            System.out.print("])");
            if (count == students.size()){
                System.out.print("]");
            }
            else{
                System.out.print(", ");
            }
        }
    }
}
