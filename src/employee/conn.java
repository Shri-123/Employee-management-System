package employee;
import java.sql.*;
import java.util.*;

import java.sql.*;

public class conn{

    public Connection c;
    public Statement s;

    public conn(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///newdb","root","12010517");
            s = c.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
