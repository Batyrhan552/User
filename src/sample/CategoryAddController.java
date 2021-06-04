package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.models.Category;

public class CategoryAddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCategory;

    @FXML
    private Button btnADD;

    @FXML
    private Button btnCancel;

    @FXML
    void initialize() {
        btnADD.setOnAction(actionEvent -> {
            String newNameCategory = txtCategory.getText().trim();
            if(newNameCategory.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING,"Название категории" + "не может быть пустым");
                alert.show();
                    return;
            }
            Category category = new Category(newNameCategory,1);
            Dbwork dbwork = new Dbwork();
           boolean isCheck= dbwork.saveCategory(category);
            if(isCheck){
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Добавлена");
                alert.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING,"Не добавлено");
                alert.show();
            }


        });

    }
}
