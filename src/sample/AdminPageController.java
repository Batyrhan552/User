package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.models.User;

public class AdminPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtLog;

    @FXML
    private TextField txtPasword;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    void initialize() {
        btnSave.setOnAction(actionEvent -> {
            boolean isValid = isValid();
            if(isValid){
             //   System.out.println(txtLog);
              //  System.out.println(txtPasword);
                User user = new User(txtLog.getText(), txtPasword.getText());
                Dbwork dbwork = new Dbwork();
                dbwork.saveUser(user);
            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Не введен логин");
                alert.show();
            }



        });

    }

    private boolean isValid() {
        if (txtLog.getText().equals("") || txtPasword.getText().equals("")) {
//            Alert alert = new Alert(Alert.AlertType.WARNING, "Не введен логин");
//            alert.show();
            return false;
        } else if (txtPasword.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Не введен пароль");
            alert.show();
            return false;
        } else if (txtLog.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Не введен логин");
            alert.show();
            return false;
        }
        return true;

    }
}