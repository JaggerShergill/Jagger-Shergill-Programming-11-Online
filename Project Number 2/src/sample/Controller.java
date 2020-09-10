package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {//Java FX fields
    public TextField textGetAddress;
    public TextField textGetColour;
    public TextField textGetCity;
    public ListView<House> houseList = new ListView<>();
    public Label lblAddress;
    public Label lblColour;
    public Label lblCity;
    public ListView<House> houseListTwo;
    public ListView<Person> peopleList;
    public Label lblFirstName;
    public Label lblLastName;
    public Label lblAge;
    public TextField textGetFirstName;
    public TextField textGetLastName;
    public TextField textGetAge;
    public Button buttonAddPerson;
    public Label lblHouseAddress;
    public TextField textGetColourChange;

    public void addHouse(ActionEvent actionEvent) {//Adds a house object to the "houseList" and "houseListTwo".
        House Home = new House(textGetAddress.getText(), textGetColour.getText(), textGetCity.getText());
        houseList.getItems().add(Home);
        houseListTwo.getItems().add(Home);
        textGetAddress.clear();
        textGetColour.clear();
        textGetCity.clear();
    }

    public void displayHouse(MouseEvent mouseEvent) {//Displays a house object's information when clicked on in "houseList".
        House Home;
        Home = houseList.getSelectionModel().getSelectedItem();
        lblAddress.setText(Home.address);
        lblColour.setText(Home.colour);
        lblCity.setText(Home.city);
        buttonAddPerson.setDisable(false);
    }

    public void deleteHouse(ActionEvent actionEvent) {//Deletes a house object from both "houseList" and "houseListTwo".
        House Home;
        Home = houseList.getSelectionModel().getSelectedItem();
        houseList.getItems().remove(Home);
        houseListTwo.getItems().remove(Home);
        lblAddress.setText("");
        lblColour.setText("");
        lblCity.setText("");
        buttonAddPerson.setDisable(true);
    }

    public void saveHouseList(ActionEvent actionEvent) throws IOException {//Saves all house objects in "houseList 2" to a file called "house.txt"
        ObservableList<House> myList = houseListTwo.getItems();
        for(House h : myList) {
            h.writeToHouseFile();
        }
        houseList.getItems().clear();
        houseListTwo.getItems().clear();
    }

    public void loadHouseList(ActionEvent actionEvent) throws IOException{//Loads all house objects from a file called "house.txt" on to "houseList" and "houseListTwo".
        houseListTwo.getItems().clear();
        houseList.getItems().clear();
        ArrayList<House> houses = CreateHouse.createAllHouses("house.txt");
        for (House h : houses){
            houseList.getItems().add(h);
            houseListTwo.getItems().add(h);
        }
    }

    public void displayPerson(MouseEvent mouseEvent) {//Displays a person object's information when clicked on in "peopleList".
        Person Bob;
        Bob = peopleList.getSelectionModel().getSelectedItem();
        lblFirstName.setText(Bob.firstName);
        lblLastName.setText(Bob.lastName);
        lblAge.setText(Integer.toString(Bob.age));
        lblHouseAddress.setText((Bob.houseAddress));
    }

    public void addPerson(ActionEvent actionEvent) {//Adds a person object to "peopleList', making the "houseAddress" of the person object the selected house object's address from "houseList".
        House Home;
        Home = houseList.getSelectionModel().getSelectedItem();
        Person Bob = new Person(textGetFirstName.getText(), textGetLastName.getText(), Integer.parseInt(textGetAge.getText()), Home.address);
        peopleList.getItems().add(Bob);
        textGetFirstName.clear();
        textGetLastName.clear();
        textGetAge.clear();
    }

    public void deletePerson(ActionEvent actionEvent) {//Deletes a person object from "peopleList"
        Person Bob;
        Bob = peopleList.getSelectionModel().getSelectedItem();
        peopleList.getItems().remove(Bob);
        lblFirstName.setText("");
        lblLastName.setText("");
        lblAge.setText("");
        lblHouseAddress.setText("");
    }

    public void changeAddress(ActionEvent actionEvent) {//Changes a person object's "houseAddress" to the address of the selected house object in "houseListTwo".
        Person Bob;
        House Home;
        Bob = peopleList.getSelectionModel().getSelectedItem();
        Home = houseListTwo.getSelectionModel().getSelectedItem();
        Person.changeAddress(Bob, Home.address);
        lblHouseAddress.setText(Bob.houseAddress);
    }

    public void changeColour(ActionEvent actionEvent){//Changes a house object's "colour" to the colour typed in to the "textGetColourChange" text field.
        House Home;
        Home = houseList.getSelectionModel().getSelectedItem();
        House.changeColour(Home, textGetColourChange.getText());
        lblColour.setText(textGetColourChange.getText());
        textGetColourChange.clear();
    }

    public void savePeopleList(ActionEvent actionEvent) throws IOException {//Saves all person objects in "peopleList" to a file called "people.txt"
        ObservableList<Person> myList = peopleList.getItems();
        for(Person Bob : myList) {
            Bob.writeToPeopleFile();
        }
        peopleList.getItems().clear();
    }

    public void loadPeopleList(ActionEvent actionEvent) throws IOException{//Loads all person objects from a file called "people.txt" on to "peopleList".
        peopleList.getItems().clear();
        ArrayList<Person> people = CreatePerson.createAllPeople("people.txt");
        for (Person Bob : people){
            peopleList.getItems().add(Bob);
        }
    }
}

