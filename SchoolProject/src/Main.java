public class Main {
    public static void main(String[] args) {

        Student Tommy = new Student("Tommy", "Smith",3);//creating students
        Student Jared = new Student("Jared", "Johnson",6);
        Student Ashley = new Student("Ashley", "Cheung",2);
        Student Andrew = new Student("Andrew", "Guan",11);
        Student Harold = new Student("Harold", "Renneckar",9);
        Student Timmy = new Student("Timmy", "Timson",7);
        Student Austin = new Student("Austin", "Powers",12);
        Student Joseph = new Student("Joseph", "Joestar",4);
        Student Hiroki = new Student("Hiroki", "Haji",5);
        Student Hikari = new Student("Hikari", "Asaoka",1);

        Teacher Schmitt = new Teacher("Stefan", "Schmitt", "Science");//creating teachers
        Teacher Lai = new Teacher("Daniel", "Lai", "Math");
        Teacher Dobie = new Teacher("Polly", "Dobie", "English");

        School PointGrey = new School("Point Grey", 39, "Kerrisdale");//creating a school

       PointGrey.addStudent(Tommy);//adding students
       PointGrey.addStudent(Jared);
       PointGrey.addStudent(Ashley);
       PointGrey.addStudent(Andrew);
       PointGrey.addStudent(Harold);
       PointGrey.addStudent(Timmy);
       PointGrey.addStudent(Austin);
       PointGrey.addStudent(Joseph);
       PointGrey.addStudent(Hiroki);
       PointGrey.addStudent(Hikari);

       PointGrey.addTeacher(Schmitt);//adding teachers
       PointGrey.addTeacher(Lai);
       PointGrey.addTeacher(Dobie);

       PointGrey.showStudents();//showing arrays of students and teachers
       PointGrey.showTeachers();

       PointGrey.deleteStudent(Tommy);//deleting students
       PointGrey.deleteStudent(Timmy);

       PointGrey.deleteTeacher(Dobie);//deleting a teacher

       PointGrey.showStudents();//showing arrays of students and teachers
       PointGrey.showTeachers();
    }
}
