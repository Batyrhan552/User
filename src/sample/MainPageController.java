package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MainPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Menu menuCategory;

    @FXML
    private MenuItem mnltmPok;

    @FXML
    private MenuItem mnltDob;

    @FXML
    private MenuItem mnltDelete;

    @FXML
    private MenuItem mnltRedac;

    @FXML
    private Menu menuProduct;

    @FXML
    private MenuItem mnltProdPokaz;

    @FXML
    private MenuItem mnltProdAdd;

    @FXML
    private MenuItem mnltProdRedactor;

    @FXML
    private MenuItem mnltProductDelete;

    @FXML
    private Menu menuAdmin;

    @FXML
    private MenuItem mnltAdminPokaz;

    @FXML
    private MenuItem mnltAdminRedactor;

    @FXML
    void initialize() {
    mnltDob.setOnAction(actionEvent -> {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/categoryAdd.fxml"));
        try {
            Scene scene = new Scene(loader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Склад");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    });
    mnltmPok.setOnAction(actionEvent -> {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/view/showCategories.fxml"));
        try {
            Scene scene = new Scene(loader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Склад");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    });
    }
}
