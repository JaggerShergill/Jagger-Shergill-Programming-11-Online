package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class House {//The class for the "House" object
    String address;//fields
    String colour;
    String city;

    House (String address, String colour, String city){//House object with parameters
        this.address = address;
        this.colour = colour;
        this.city = city;
    }

    public String toString(){//toString method
        return address + ", " + city;
    }

    public void writeToHouseFile() throws IOException{//creates a text file and saves the information of House objects in it
        FileWriter fw = new FileWriter("house.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(address + ",\r");
        bw.write(colour + ":\r");
        bw.write(city + "\r");
        bw.write(";\r");
        bw.close();
    }

    public static void changeColour(House h, String colour){//Method used to change the "colour" of a House object
        h.colour = colour;
    }
}
