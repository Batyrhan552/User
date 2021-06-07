package sample.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.db.Dbwork;
import sample.models.Category;

public class AddGoodController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNameG;

    @FXML
    private TextField txtPrice;

    @FXML
    private ComboBox<Category> cmbCategories;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancelG;

    @FXML
    void initialize() {
        Dbwork dbwork = new Dbwork();
        ArrayList<Category>categoryActiveArrayList = dbwork.selectAllActiveCategories();
        ObservableList<Category>categoryActiveObservableList = FXCollections.observableArrayList();
        categoryActiveObservableList.addAll(categoryActiveArrayList);
        cmbCategories.setItems(categoryActiveObservableList);

  btnSave.setOnAction(actionEvent -> {
      String name = txtNameG.getText().trim();
     String price = txtPrice.getText().trim();
             Double priceGood = Double.valueOf(price);

    Category categoryCmB = cmbCategories.getValue();
  });
    }
}
