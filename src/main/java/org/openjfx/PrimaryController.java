package org.openjfx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class PrimaryController {
    static int roundNumber = 0;
    String resultat = "Null";
    static ArrayList<String> gamelist = new ArrayList<String>(Arrays.asList("", "", "", "", "", "", "", "", ""));
    @FXML
    GridPane myGridPane = new GridPane();

    @FXML
    public void initialize() {

        Button btn1 = new Button();
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                createButtonHandle(btn1, 1);
            }
        });
        myGridPane.add(btn1, 0, 0);

        Button btn2 = new Button();
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                createButtonHandle(btn2, 2);
            }
        });
        myGridPane.add(btn2, 1, 0);

        Button btn3 = new Button();
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                createButtonHandle(btn3, 3);
            }
        });
        myGridPane.add(btn3, 2, 0);

        Button btn4 = new Button();
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                createButtonHandle(btn4, 4);
            }
        });
        myGridPane.add(btn4, 0, 1);

        Button btn5 = new Button();
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                createButtonHandle(btn5, 5);
            }
        });
        myGridPane.add(btn5, 1, 1);

        Button btn6 = new Button();
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                createButtonHandle(btn6, 6);
            }
        });
        myGridPane.add(btn6, 2, 1);

        Button btn7 = new Button();
        btn7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                createButtonHandle(btn7, 7);
            }
        });
        myGridPane.add(btn7, 0, 2);

        Button btn8 = new Button();
        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                createButtonHandle(btn8, 8);
            }
        });
        myGridPane.add(btn8, 1, 2);

        Button btn9 = new Button();
        btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                createButtonHandle(btn9, 9);
            }
        });
        myGridPane.add(btn9, 2, 2);
    }

    private void createButtonHandle(Button btn, Integer index) {
        if (roundNumber % 2 == 0) {
            btn.setText("X");
            gamelist.set(index - 1, "X");
        }
        if (roundNumber % 2 == 1) {
            btn.setText("O");
            gamelist.set(index - 1, "O");
        }
        roundNumber++;
        resultat = verify(gamelist);
        if (resultat == "Null" && roundNumber == 9){System.out.println("There is a draw"); myGridPane.setDisable(true);}
        if (resultat == "X"){System.out.println("X won"); myGridPane.setDisable(true);}
        if (resultat == "O"){System.out.println("O won"); myGridPane.setDisable(true);}


    };


    public String verify(ArrayList<String> gameList){
        //return the winner if there is one

        //Row
        if (gameList.get(0) == gameList.get(1) && gameList.get(0) == gameList.get(2)){
            return gameList.get(0);
        }
        if (gameList.get(3) == gameList.get(4) && gameList.get(3) == gameList.get(5)){
            return gameList.get(3);
        }
        if (gameList.get(6) == gameList.get(7) && gameList.get(6) == gameList.get(8)){
            return gameList.get(6);
        }

        //Column
        if (gameList.get(0) == gameList.get(3) && gameList.get(0) == gameList.get(6)){
            return gameList.get(0);
        }
        if (gameList.get(1) == gameList.get(4) && gameList.get(1) == gameList.get(7)){
            return gameList.get(1);
        }
        if (gameList.get(2) == gameList.get(5) && gameList.get(2) == gameList.get(8)){
            return gameList.get(2);
        }

        //Diagonal
        if (gameList.get(0) == gameList.get(4) && gameList.get(0) == gameList.get(8)){
            return gameList.get(0);
        }
        if (gameList.get(2) == gameList.get(4) && gameList.get(2) == gameList.get(6)){
            return gameList.get(2);
        }

        return "Null";
    }


    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }


}
