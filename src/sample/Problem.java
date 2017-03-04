package sample;

import javafx.fxml.FXML;
import java.io.*;

/**
 * Created by Neil Coertze on 11/3/2016.
 */
public class Problem implements Serializable {

    //creates a new problem submission
          private String problemName;
    @FXML private String solutionBox;
    @FXML private String problemBox;
    @FXML private String OS;
    @FXML private String type;

    public Problem(String nB, String pB, String sB, String OS, String problemType) throws IOException {
        this.problemName = nB;
        this.solutionBox = sB;
        this.problemBox = pB;
        this.OS = OS;
        this.type = problemType;

        String data = ("Name: " + problemName + "\n" + "Category: " + type + "\n" + "Operating System: " + OS +
                "\n" + "Problem: " + problemBox  + "\n" + "Suggested Solution: " + solutionBox);
        FileWriter fw = new FileWriter(new File(problemName + ".txt"));
        fw.write(data);
        fw.close();

    }

    public String getProblemName()
    {
        return this.problemName;
    }

}
