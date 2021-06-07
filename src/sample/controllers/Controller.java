package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.db.Dbwork;
import sample.models.User;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginfx;

    @FXML
    private TextField passwordfx;

    @FXML
    private Button btninput;

    @FXML
    private Button btnR;
//    @FXML
//    private AnchorPane idAnc;

    @FXML
    void initialize() {

        btninput.setOnAction(actionEvent -> {
            btninput.getScene().getWindow().hide();
            String loginUser = loginfx.getText().trim();
            String passwordUser = passwordfx.getText().trim();

            User user = new User(loginUser, passwordUser);
            Dbwork dbWork = new Dbwork();
          boolean isChecked = dbWork.checkUser(user);
          if(isChecked){
              FXMLLoader loader = new FXMLLoader();
              loader.setLocation(getClass().getResource("/sample/view/mainPage.fxml"));
              try {
                  Scene scene = new Scene(loader.load(), 600, 400);
                  Stage stage = new Stage();
                  stage.setTitle("Склад");
                  stage.setScene(scene);
                  stage.show();

              } catch (IOException e) {
                  e.printStackTrace();
              }

          }else {
              Alert alert = new Alert(Alert.AlertType.WARNING,"Вход не выполнен");
              alert.show();
          }
        });
//        btninput.setOnAction(event -> {
//            btninput.getScene().getWindow().hide();

//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/sample/view/sample.fxml"));

//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            Parent root = loader.getRoot();
//            Stage stage1 = new Stage();
//            stage1.setScene(new Scene(root));
//            stage1.show();
//

        btnR.setOnAction(actionEvent -> {
            btnR.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/adminPage.fxml"));
            try {
                Scene scene = new Scene(loader.load(), 600, 400);
                Stage stage = new Stage();
                stage.setTitle("Регистрация");
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }
    }





