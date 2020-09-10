package sample;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Person {//The class for the "Person" object
    String firstName;//fields
    String lastName;
    int age;
    String houseAddress;

    Person (String firstName, String lastName, int age, String houseAddress){//Person object with parameters
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.houseAddress = houseAddress;
    }

    public String toString(){//toString method
        return firstName + " " + lastName;
    }

    public void writeToPeopleFile() throws IOException {//Creates a text file and saves the information of Person objects in it
        FileWriter fw = new FileWriter("people.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(firstName + ",\r");
        bw.write(lastName + ":\r");
        bw.write(age + "[\r");
        bw.write(houseAddress + "\r");
        bw.write(";\r");
        bw.close();
    }

    public static void changeAddress(Person Bob, String address){//method used to change the "houseAddress" of a Person object
        Bob.houseAddress = address;
    }

}
