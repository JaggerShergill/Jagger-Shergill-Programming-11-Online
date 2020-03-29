public class Student {//The class for the "Student" object."


    private String firstName;//fields
    private String lastName;
    private int grade;
    private int studentNumber;
    private static int idNum = 1;//used to make unique student numbers

    Student(){//Student object with no parameters
        firstName = "";
        lastName = "";
        grade = 1;
        studentNumber = idNum;
        idNum++;//increases student number each time a student is added
    }

    Student(String firstName, String lastName, int grade){//Student object with parameters
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        studentNumber = idNum;
        idNum++;//increases student number each time a student is added
    }


    public String getFirstName() {//getters and setters
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public int getStudentNumber() {
        return studentNumber;
    }
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
    public static int getIdNum() {
        return idNum;
    }
    public static void setIdNum(int idNum) {
        Student.idNum = idNum;
    }

    public String toString(){//When printed Student will return:
        return "Name: " + this.firstName + " " + this.lastName + "\tGrade: " + this.grade;
    }
}

