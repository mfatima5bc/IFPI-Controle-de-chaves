package Controllers;

import ModelDAO.ChavePegaDAO;
import ModelDAO.OperadorDAO;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Fátima
 */
public class LoginController extends BaseController implements Initializable {

    ChavePegaDAO daoCP = new ChavePegaDAO();
    OperadorDAO odao = new OperadorDAO();

    @FXML
    private TextField labelLogin;

    @FXML
    private TextField labelSenha;

    @FXML
    private JFXButton btnEntrarSuper;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //    verificar();
                assert btnEntrarSuper != null : "fx:id=\"btnEntrarSuper\" was not injected: check your FXML file 'Login.fxml'.";
        assert labelLogin != null : "fx:id=\"labelLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert labelSenha != null : "fx:id=\"labelSenha\" was not injected: check your FXML file 'Login.fxml'.";
    }

//    String loginp = null;
//    String senhap = null;
////    Date d = new Data.
////    
//    SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
//    Date date = new Date();
//
//    private void verificar() {
//        if (dateFormat.format(date).equals("01")) {
//            daoCP.removerDados();
//            Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
//
//            dialogo.setTitle("Dados excluidos");
//            dialogo.setHeaderText("Operaçao bem sucedida!");
//            dialogo.setContentText("Todos os registros de chaves pegas foram excluidos!");
//            dialogo.showAndWait();
//        }
//    }
    @FXML
    private void entrar(ActionEvent event) throws IOException {
        //String v = 
        // if (odao.VerificaLogin(labelLogin.getText(), labelSenha.getText())) {
        switch (odao.checkLogin(labelLogin.getText(), labelSenha.getText())) {
            case "1":
                navigate(event, FXMLLoader.load(getClass().getResource("FXML1.fxml")));
                break;
            case "2":
                navigate(event, FXMLLoader.load(getClass().getResource("UserPadrao.fxml")));
                break;
            case "sn":
                Alert dialogo1 = new Alert(Alert.AlertType.WARNING);
                dialogo1.setTitle("Usuário invalido");
                dialogo1.setContentText("Usuário invalido");
                dialogo1.showAndWait();
                break;
            default:
                Alert dialogo2 = new Alert(Alert.AlertType.WARNING);
                dialogo2.setTitle("Usuário invalido");
                break;
        }

    }

    @FXML
    private void mover(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            System.out.println("aqui");
            labelSenha.requestFocus();

        }
    }

    @FXML
    private void on_senha(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            switch (odao.checkLogin(labelLogin.getText(), labelSenha.getText())) {
            case "1":
                navigate(event, FXMLLoader.load(getClass().getResource("/View/Menu.fxml")));
                break;
            case "2":
                navigate(event, FXMLLoader.load(getClass().getResource("/View/UserPadrao.fxml")));
                break;
            case "sn":
                Alert dialogo1 = new Alert(Alert.AlertType.WARNING);
                dialogo1.setTitle("Usuário invalido");
                dialogo1.setContentText("Usuário invalido");
                dialogo1.showAndWait();
                break;
            default:
                Alert dialogo2 = new Alert(Alert.AlertType.WARNING);
                dialogo2.setTitle("Usuário invalido");
                break;
        }
        }
    }

}