package sample;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Neil Coertze on 11/7/2016.
 */
public class Admin implements Serializable {

    private String username;
    private String password;
    private String email;

    public Admin (String u, String p, String e) throws IOException {
        this.username = u;
        this.password = p;
        this.email = e;
    }

    public void saveAdmin(ArrayList<Admin> a) throws IOException {
        String data = ("Username: " + username + "\nPassword: " + password + "\nE-mail: " + email);
        FileWriter fw = new FileWriter(new File("Admin" + removeSpace(username) + ".txt"));
        fw.write(data);
        fw.close();
        FileOutputStream fos = new FileOutputStream("adminList1");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a);
        oos.close();
    }

    public String removeSpace(String s)
    {
        String toReturn = "";
        for(int i = 0; i < s.length(); i++)
        {
            if(!(s.substring(i,i+1).equals(" ")))
            {
                toReturn += s.substring(i,i+1);
            }
        }
        return toReturn;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail()
    {
        return this.email;
    }

    public static Admin getDesignatedAdmin(ArrayList<Admin> a, String username)
    {
        for (Admin anA : a) {
            if (anA.getUsername().equals(username)) {
                return anA;
            }
        }
        return null;
    }

}
