package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreatePerson {//class for loading person objects
    private static String firstName;//fields
    private static String lastName;
    private static int age;
    private static String houseAddress;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Person> people = new ArrayList<>();

    public static ArrayList createAllPeople(String filename) throws IOException{//Uses the "parsePeople" method to read off of a file and create person objects from it, then putting them in to an array list
        fr = new FileReader(filename);
        br = new BufferedReader(fr);
        String line;
        String peopleString = "";
        while ((line = br.readLine()) != null){
            if(!line.equals(";")){
                peopleString += line;
            }else{
                parsePeople (peopleString);
                peopleString = "";
            }
        }
        return people;
    }
    private static void parsePeople (String string){//Reads a text file and creates person objects from it
        int posOne = 0;
        int posTwo = 0;
        int posThree = 0;
        String firstName = "";
        String lastName = "";
        int age = 0;
        String houseAddress = "";
        for (int i = 0; i<string.length(); i++){
            if(string.substring(i, i+1).equals(",")) {
                posOne = i;
                firstName = string.substring(0, posOne);
            }
            if (string.substring(i, i+1).equals(":")){
                posTwo = i;
                lastName = string.substring(posOne+1, posTwo);
            }
            if (string.substring(i, i+1).equals("[")){
                posThree = i;
                age = Integer.parseInt(string.substring(posTwo+1, posThree));
                houseAddress = string.substring(posThree+1);
            }
        }
        people.add(new Person(firstName, lastName, age, houseAddress));
    }
}


