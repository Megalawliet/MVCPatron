package Backend.PatronMVC.model.conexion;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Clase que permite conectar con la base de datos
 *
 */
public class Conexion {
   static String bd = "MVC_db";
   static String login = "remote";
   static String password = "";
   static String url = "jdbc:mysql://localhost:3306/"+bd+"?useTimezone=true&serverTimezone=UTC";

   Connection conn = null;

   // Constructor de DbConnection 
   public Conexion() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.cj.jdbc.Driver");
         //obtenemos la conexion
         conn = DriverManager.getConnection(url,login,password);

         if (conn!=null){
            System.out.print("Conexión a base de datos "+bd+"_SUCCESS at");
            fecha();
         }
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
   }
   //Permite retornar la conexion
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
   }
   
 //METODO QUE MUESTRA FECHA
 	public static void fecha() {
 		Date date = new Date();
 		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
 		System.out.println(" - " + hourdateFormat.format(date));
 		}

}