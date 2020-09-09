package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    public TextField textGetFirstName;
    public TextField textGetLastName;
    public TextField textGetAge;
    public ListView<Friend> friendsList = new ListView<>();
    public Label lblFirstName;
    public Label lblLastName;
    public Label lblAge;
    public TextField textGetFileSave;
    public TextField textGetFileLoad;

    public void addFriend(ActionEvent actionEvent) {
        Friend Bob = new Friend(textGetFirstName.getText(), textGetLastName.getText(), Integer.parseInt(textGetAge.getText()));
        friendsList.getItems().add(Bob);
        textGetFirstName.clear();
        textGetLastName.clear();
        textGetAge.clear();
    }

    public void displayFriend(MouseEvent mouseEvent) {
        Friend Bob;
        Bob = friendsList.getSelectionModel().getSelectedItem();
        lblFirstName.setText(Bob.firstName);
        lblLastName.setText(Bob.lastName);
        lblAge.setText(Bob.age + " years old");
    }

    public void deleteFriend(ActionEvent actionEvent) {
        Friend Bob;
        Bob = friendsList.getSelectionModel().getSelectedItem();
        friendsList.getItems().remove(Bob);
        lblFirstName.setText("");
        lblLastName.setText("");
        lblAge.setText("");
    }

    public void saveList(ActionEvent actionEvent) throws IOException {
        ObservableList<Friend> myList = friendsList.getItems();
        for(Friend f : myList) {
            f.writeToFile(textGetFileSave.getText());
        }
        friendsList.getItems().clear();
        textGetFileSave.clear();
    }

    public void loadList(ActionEvent actionEvent) throws IOException{
        friendsList.getItems().clear();
        ArrayList<Friend> friends = CreateFriend.createAllFriends(textGetFileLoad.getText());
        for (Friend f : friends){
            friendsList.getItems().add(f);
        }
        textGetFileLoad.clear();
    }

    public void loadAllFriends(ActionEvent actionEvent) throws IOException{
        friendsList.getItems().clear();
        ArrayList<Friend> friends = CreateFriend.createAllFriends("allFriends.txt");
        for (Friend f : friends){
            friendsList.getItems().add(f);
        }
        textGetFileLoad.clear();
    }
    }

