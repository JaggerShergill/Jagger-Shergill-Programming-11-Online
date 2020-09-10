package sample;

import java.io.BufferedReader;
import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;

public class CreateHouse {//class for loading house objects
    private static String address;//fields
    private static String colour;
    private static int city;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<House> houses = new ArrayList<>();

    public static ArrayList createAllHouses(String filename) throws IOException{//Uses the "parseHouse" method to read off of a file and create house objects from it, then putting them in to an array list
        fr = new FileReader(filename);
        br = new BufferedReader(fr);
        String line;
        String houseString = "";
        while ((line = br.readLine()) != null){
            if(!line.equals(";")){
                houseString += line;
            }else{
                parseHouse (houseString);
                houseString = "";
            }
        }
        return houses;
    }
    private static void parseHouse (String string){//Reads a text file and creates house objects from it
        int posOne = 0;
        int posTwo = 0;
        String address = "";
        String colour = "";
        String city = "";
        for (int i = 0; i<string.length(); i++){
            if(string.substring(i, i+1).equals(",")) {
                posOne = i;
                address = string.substring(0, posOne);
            }
            if (string.substring(i, i+1).equals(":")){
                posTwo = i;
                colour = string.substring(posOne+1, posTwo);
                city = string.substring(posTwo+1);
            }
        }
        houses.add(new House(address, colour, city));
    }
}


