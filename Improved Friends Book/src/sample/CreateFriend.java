package sample;

import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;

public class CreateFriend {
    private static String firstName;
    private static String lastName;
    private static int age;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<>();

    public static ArrayList createAllFriends(String filename) throws IOException{
        fr = new FileReader(filename);
        br = new BufferedReader(fr);
        String line;
        String friendString = "";
        while ((line = br.readLine()) != null){
            if(!line.equals(";")){
                friendString += line;
            }else{
                parseFriend (friendString);
                friendString = "";
            }
        }
        return friends;
    }
    private static void parseFriend (String string){
        int posOne = 0;
        int posTwo = 0;
        String firstName = "";
        String lastName = "";
        int age = 0;
        for (int i = 0; i<string.length(); i++){
            if(string.substring(i, i+1).equals(",")) {
                posOne = i;
                firstName = string.substring(0, posOne);
            }
            if (string.substring(i, i+1).equals(":")){
                posTwo = i;
                lastName = string.substring(posOne+1, posTwo);
                age = Integer.parseInt(string.substring(posTwo+1));
            }
        }
        friends.add(new Friend(firstName, lastName, age));
    }
}

