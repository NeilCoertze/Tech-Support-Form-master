package sample;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Neil Coertze on 11/17/2016.
 */
public class SaveFile {

    public static void saveAdmins(ArrayList<Admin> admins) throws IOException, ClassNotFoundException {
        ArrayList<Admin> a = new ArrayList<>();
        for(int i = 0; i < retrieveAdmins().size(); i++)
        {
            a.add(retrieveAdmins().get(i));
        }
        for (Admin admin : admins) {
            a.add(admin);
        }
        FileOutputStream fos = new FileOutputStream("adminList1");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a);
        oos.close();
    }

    public static ArrayList<Admin> retrieveAdmins() throws IOException, ClassNotFoundException {
        ArrayList<Admin> allAdmins = new ArrayList<>();
        FileInputStream fis = new FileInputStream("adminList1");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Admin> admins = (ArrayList<Admin>) ois.readObject();
        ois.close();
        for (Admin admin : admins) {
            allAdmins.add(admin);
        }
        return allAdmins;
    }

    public static void saveProblems(ArrayList<Problem> probs) throws IOException, ClassNotFoundException {
        ArrayList<Problem> p = new ArrayList<>();
        for(int i = 0; i < retrieveProblems().size(); i++)
        {
            p.add(retrieveProblems().get(i));
        }
        for (Problem prob : probs) {
            p.add(prob);
        }
        FileOutputStream fos = new FileOutputStream("problemList");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p);
        oos.close();
    }

    public static ArrayList<Problem> retrieveProblems() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("problemList");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Problem> probs = (ArrayList<Problem>) ois.readObject();
        ois.close();
        return probs;
    }

    public static void printAdminsUsernames(ArrayList<Admin> admins)
    {
        for (Admin admin : admins) {
            System.out.println(admin.getUsername());
        }
    }

    public static void printProblemNames(ArrayList<Problem> problems) {
        for (Problem problem : problems) {
            System.out.println(problem.getProblemName());
        }
    }

    public static void deleteAdmin(ArrayList<Admin> admins, String username)
    {
        for(int i = 0; i < admins.size(); i++)
        {
            if(admins.get(i).getUsername().equals(username))
            {
                admins.remove(i);
            }
        }
    }

    public static void deleteProblem(ArrayList<Problem> problems, String problemName)
    {
        for(int i = 0; i < problems.size(); i++)
        {
            if(problems.get(i).getProblemName().equals(problemName))
            {
                problems.remove(i);
            }
        }
    }

}
