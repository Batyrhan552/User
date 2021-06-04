package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    }
}
