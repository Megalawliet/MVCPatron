package Backend.PatronMVC.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import Backend.PatronMVC.model.conexion.Conexion;
import Backend.PatronMVC.model.dto.Persona;

/**
 * Clase que permite el acceso a la base de datos
 * CRUD
 *
 */
public class PersonaDao
{

	public void registrarPersona(Persona miPersona)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO persona VALUES ('"+miPersona.getIdPersona()+"', '"
					+miPersona.getNombrePersona()+"', '"+miPersona.getEdadPersona()+"', '"
					+miPersona.getProfesionPersona()+"', '"+miPersona.getTelefonoPersona()+"');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}

	public Persona buscarPersona(int codigo) 
	{
		Conexion conex= new Conexion();
		Persona persona= new Persona();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM persona where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				persona.setIdPersona(Integer.parseInt(res.getString("id")));
				persona.setNombrePersona(res.getString("nombre"));
				persona.setEdadPersona(Integer.parseInt(res.getString("edad")));
				persona.setProfesionPersona(res.getString("profesion"));
				persona.setTelefonoPersona(Integer.parseInt(res.getString("telefono")));
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return persona;
			}
			else return null;				
	}

	public void modificarPersona(Persona miPersona) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE persona SET id= ? ,nombre = ? , edad=? , profesion=? , telefono= ? WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, miPersona.getIdPersona());
            estatuto.setString(2, miPersona.getNombrePersona());
            estatuto.setInt(3, miPersona.getEdadPersona());
            estatuto.setString(4, miPersona.getProfesionPersona());
            estatuto.setInt(5,miPersona.getTelefonoPersona());
            estatuto.setInt(6, miPersona.getIdPersona());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarPersona(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM persona WHERE id='"+codigo+"'";
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

}
