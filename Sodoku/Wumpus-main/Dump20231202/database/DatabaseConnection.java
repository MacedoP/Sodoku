package nye.hu.progTech.database;

import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {

    public Connection databaseLink;
//Aqui fizemo s conexao com base de dados
    public Connection getConnection(){
        String databaseName = "wumpus_db";
        String databaseUser = "root";
        String databasePassword = "Ae6_I*c#vdwV";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);

        }catch (Exception e){
            System.out.println(e);
        }

        return databaseLink;

    }
}
