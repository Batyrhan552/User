package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.db.Dbwork;
import sample.models.Category;

public class ShowCategoryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Category> table;

    @FXML
    private TableColumn<Category, String > tblName;

    @FXML
    private TableColumn<Category, Integer> tblActiveC;

    @FXML
    private Menu menuEx;

    @FXML
    void initialize() {

        Dbwork dbwork = new Dbwork();
        ArrayList<Category> categories=dbwork.selectAllCategories();
        ObservableList<Category>categoryObservableList = FXCollections.observableArrayList();
        categoryObservableList.addAll(categories);

        tblName.setCellValueFactory(new PropertyValueFactory<Category,String>("name"));
        tblActiveC.setCellValueFactory(new PropertyValueFactory<Category,Integer>("active"));

        table.setItems(categoryObservableList);


        table.setRowFactory(t -> new TableRow<>(){
            protected void updateItem(Category category, boolean e){
                super.updateItem(category, e);
                if (category!= null && category.isActive() != 1){
                    setStyle("-fx-background-color: #ff9999;");
                }else {
                    setStyle("");
                }

            }


        });
        menuEx.setOnAction(event -> {
            table.getScene().getWindow().hide();
            FXMLLoader loader =new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/mainPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Categories");
            stage.setScene(new Scene(root));
            stage.show();

    });

    }
}


