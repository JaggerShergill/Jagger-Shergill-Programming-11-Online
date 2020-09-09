package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {
    String firstName;
    String lastName;
    int age;

    Friend (String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String toString(){
        return firstName + " " + lastName;
    }

    public void writeToFile(String filename) throws IOException{
        FileWriter fw = new FileWriter(filename, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(firstName + ",\r");
        bw.write(lastName + ":\r");
        bw.write(Integer.toString(age) + "\r");
        bw.write(";\r");
        bw.close();
        FileWriter fwTwo = new FileWriter("allFriends.txt", true);
        BufferedWriter bwTwo = new BufferedWriter(fwTwo);
        bwTwo.write(firstName + ",\r");
        bwTwo.write(lastName + ":\r");
        bwTwo.write(Integer.toString(age) + "\r");
        bwTwo.write(";\r");
        bwTwo.close();
    }
}
