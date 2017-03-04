package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    @FXML private Text actiontarget;
    @FXML private Text actiontarget1;
    @FXML private TextField solutionBox;
    @FXML private TextField problemBox;
    @FXML private TextField nameBox;
    @FXML private ChoiceBox OS;
    @FXML private ChoiceBox type;

    @FXML private TextField newUsername;
    @FXML private TextField newPass;
    @FXML private TextField newEmail;

    @FXML private TextField userLogin;
    @FXML private PasswordField passLogin;
    @FXML private Text loginFail;

    private static ArrayList<Admin> listOfAdmins = new ArrayList<>();
    private static ArrayList<Problem> listOfProblems = new ArrayList<>();

    public void handleSubmitButtonAction(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        actiontarget.setText("Submitted.");
        listOfProblems.add(new Problem(nameBox.getText(), problemBox.getText(),
                solutionBox.getText(), OS.getValue().toString(), type.getValue().toString()));
        SaveFile.saveProblems(listOfProblems);
    }

    public void adminScreenEnter(ActionEvent event) throws IOException {
        Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Pane adminPane = FXMLLoader.load(getClass().getResource("adminLogin.fxml"));
        Scene welcome = new Scene(adminPane, 800, 600);
        adminStage.setScene(welcome);
        adminStage.show();
    }

    public void createUser(ActionEvent event) throws IOException, ClassNotFoundException {
        actiontarget1.setText("Submitted.");
        Admin a = new Admin(newUsername.getText(), newPass.getText(), newEmail.getText());
        listOfAdmins.add(a);
        a.saveAdmin(listOfAdmins);
        SaveFile.saveAdmins(listOfAdmins);
    }

    public void backToForm(ActionEvent event) throws IOException {
        Stage formStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Pane formPane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene welcome = new Scene(formPane, 800, 600);
        formStage.setScene(welcome);
        formStage.show();
    }

    public void adminLogin(ActionEvent event) throws IOException {

        String u = userLogin.getText();
        String p = passLogin.getText();
        boolean canLogIn = true;

            for (Admin a : listOfAdmins) {
                if (a.getUsername().equals(u) && a.getPassword().equals(p)) {
                    canLogIn = false;
                }
            }
            if (canLogIn) {
                Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Pane adminPane = (FXMLLoader.load(getClass().getResource("adminScreen.fxml")));
                Scene welcome = new Scene(adminPane, 800, 600);
                adminStage.setScene(welcome);
                adminStage.show();
            } else {
                loginFail.setText("Incorrect Login");
                loginFail.setFill(Color.rgb(200, 0, 0));
            }
    }

    public static void updateLists() throws IOException, ClassNotFoundException {
        for(int i = 0; i < SaveFile.retrieveProblems().size(); i++)
        {
            listOfProblems.add(SaveFile.retrieveProblems().get(i));
        }
        for(int i = 0; i < SaveFile.retrieveAdmins().size(); i++)
        {
            listOfAdmins.add(SaveFile.retrieveAdmins().get(i));
        }
    }

}
