package org.mano;

import org.mano.models.Movie;

import java.sql.*;
import java.time.LocalDate;

public class JDBCUtil {

    private static JDBCUtil single_instance = null;
    String className, URL, user, password;
    String query = "select * from movie;";
    Connection connection;
    private JDBCUtil(String className, String URL, String user, String password) {
        this.className = className;
        this.URL = URL;
        this.user = user;
        this.password = password;
        this.connection = null;
    }

    public static JDBCUtil getInstance(String className, String URL, String user, String password)
    {
        if (single_instance == null)
            single_instance = new JDBCUtil(className,URL, user, password);

        return single_instance;
    }

    public void getConnection() {
        //Load the driver class
        try {
            Class.forName(className);
            System.out.println("ok");
        } catch (ClassNotFoundException ex) {
            System.out.println("Unable to load the class. Terminating the program");
            System.exit(-1);
        }
        //get the connection
        try {
            connection = DriverManager.getConnection(URL, user, password);
            System.out.println("ok");

        } catch (SQLException ex) {
            System.out.println("Error getting connection: " + ex.getMessage());
            System.exit(-1);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            System.exit(-1);
        }
    }
    public void queryTest()
    {
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next())
            {
                String Movies = "";
                for(int i = 1; i<5 ; i++)
                    Movies += result.getString(i) + " | ";
                System.out.println(Movies);
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void add (Movie movie)
    {
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("INSERT INTO movie VALUES ('" + movie.getId() +"','"+ movie.getRating() + "','2011-01-23','" + movie.getTitle()+"');");


        }
        catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void findByID(long id)
    {

        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from movie m where m.id =" + id );
            while(result.next())
            {
                String Movies = "";
                for(int i = 1; i<5 ; i++)
                    Movies += result.getString(i) + " | ";
                System.out.println(Movies);
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();

        }


    }
        public void findByName(String title)
        {
            try{
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("select * from movie m where m.title =" + title );
                while(result.next())
                {
                    String Movies = "";
                    for(int i = 1; i<5 ; i++)
                        Movies += result.getString(i) + " | ";
                    System.out.println(Movies);
                }

            }
            catch (Exception ex) {
                ex.printStackTrace();

            }
        }

}
