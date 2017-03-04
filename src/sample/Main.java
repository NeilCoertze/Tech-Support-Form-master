package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ArrayList<Admin> admins = new ArrayList<>();
        ArrayList<Problem> problems = new ArrayList<>();
        for(int i = 0; i < SaveFile.retrieveAdmins().size(); i++)
        {
            admins.add(SaveFile.retrieveAdmins().get(i));
        }
        for(int i = 0; i < SaveFile.retrieveProblems().size(); i++)
        {
            problems.add(SaveFile.retrieveProblems().get(i));
        }

        Problem p = new Problem("test","test","test","test","test");
        Admin a = new Admin("test","test","test");

        /*FileOutputStream fos = new FileOutputStream("problemList");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p);
        oos.close();*.

       /*FileOutputStream fos1 = new FileOutputStream("adminList");
        ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
        oos1.writeObject(a);
        oos.close();*/


        Controller.updateLists();
        System.out.println("Problems:");
        SaveFile.printProblemNames(problems);
        System.out.println("Admins:");
        SaveFile.printAdminsUsernames(admins);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Tech Support Inquiries");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
