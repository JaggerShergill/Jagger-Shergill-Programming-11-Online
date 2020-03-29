public class Teacher {//The class for the "Teacher" object.

    private String firstName;//Fields
    private String lastName;
    private String subject;

    Teacher(){//Teacher object with no parameters
        firstName = "";
        lastName = "";
        subject = "";
    }

    Teacher(String firstName, String lastName, String subject){//Teacher object with parameters
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
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
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String toString(){//When printed printed Teacher will return:
        return "Name: " + this.firstName + " " + this.lastName + "\tSubject: " + this.subject;
    }
}
