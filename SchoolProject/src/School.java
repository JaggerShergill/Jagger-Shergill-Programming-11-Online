import java.util.ArrayList;

public class School{//The class for the "School" object.

    ArrayList<Teacher> teachers = new ArrayList<>();//ArrayLists for the different objects
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<School> courses = new ArrayList<>();

    private String name;//Fields
    private int schoolNum;
    private String location;

    School() {//School object with no parameters
        name = "";
        schoolNum = 1;
        location = "";
    }

    School(String name, int schoolNum, String location){//school object with parameters
        this.name = name;
        this.schoolNum = schoolNum;
        this.location = location;
    }


    public String getName() {//getters and setters
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSchoolnum() {
        return schoolNum;
    }
    public void setSchoolnum(int schoolnum) {
        this.schoolNum = schoolnum;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public void addTeacher(Teacher x){//adds Teacher
        teachers.add(x);
    }
    public void addStudent(Student x){//adds Student
        students.add(x);
    }
    public void deleteTeacher(Teacher x){//deletes Teacher
        teachers.remove(x);
    }
    public void deleteStudent(Student x){//deletes Student
        students.remove(x);
    }
    public void showTeachers(){//shows array of Teachers
        teachers.toArray();
        System.out.println(teachers);
    }
    public void showStudents(){//shows array of Students
        students.toArray();
        System.out.println(students);
    }
}

