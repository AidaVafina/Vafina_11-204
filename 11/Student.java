import java.util.List;

public class Student {
    public String name;
    public int age;
    public int weight;
    public String groupNum;
    public int course;
    public List<Course> cources;

    public Student(){}

    public Student(String name, int age, int weight, String groupNum, int course) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.groupNum = groupNum;
        this.course = course;
    }

    public class Course{
        public String name;
        public String description;

        public Course(){}
        public Course(String name, String description){
            this.name = name;
            this.description = description;
        }

        public String toString(){
            return "name=" + this.name + ", description=" + this.description;
        }
    }

    public String toSting() {
        return "name=" + this.name + ", age=" + this.age + ", weight=" + this.weight + ", groupNun=" + this.groupNum;
    }
}

