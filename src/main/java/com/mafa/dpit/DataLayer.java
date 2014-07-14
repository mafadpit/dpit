package com.mafa.dpit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mafa.dpit.excepciones.AccessException;
import com.mafa.dpit.util.*;


public class DataLayer {
	String url;
	String usuario;
	String contraseña;
	String driver;
	
	/**
	 * Constructor: Inicializa los valores de la capa de datos
	 */
	public DataLayer(){
		 url = "jdbc:postgresql://localhost:5432/postgres";
         usuario="postgres";
         contraseña="672001";
         driver="org.postgresql.Driver";
	}
	/**
	 * Comprueba si existe el usuario en la bbdd y lo devuelve en caso afirmativo
	 * @param sql
	 * @param user
	 * @param pass
	 * @return
	 * @throws Exception
	 */
	public User findUser(String sql,String user, String pass) throws Exception{
		User result=null;
		try{
			Class.forName(driver);
			Connection con= DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1, user);
			smt.setString(2, pass);
			ResultSet rs=smt.executeQuery();
			rs.next();
			result = new User(rs.getString(1), rs.getString(2)+" "+rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
			rs.close();
			smt.close();
			con.close();
			
		}catch(ClassNotFoundException e){
			throw new AccessException("No ha detectado el Driver");
		}catch(SQLException ee){
			throw new AccessException("Fallo al conectar con la BBDD");
			
		}
		return result;
	}
	/**
	 * Solicita a la una tabla la información deseada
	 * @param tabla Nombre de la tabla
	 * @param columnas Columnas que se mostrarán en la consulta
	 * @param indices Valor numérico de las columnas anteriores
	 * @param eliminar Vista que se accede para eliminar 
	 * @param actualizar Vista que se accede para actualizar
	 * @return
	 */
	public String showList(String tabla, String columnas, int indices,String eliminar,String actualizar,String user) throws AccessException{
		String result="";
		String sql="select "+columnas+ " from "+ tabla+ " where codigo_user=?";
		try{
			Class.forName(driver);
			Connection con= DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1, user);
			ResultSet rs=smt.executeQuery();
			while(rs.next()){

				result+="<tr><td><a href=\""+eliminar+"?id="+rs.getString(1)+"\">X</a> <a href=\""+actualizar+"?id="+rs.getString(1)+"\">E</a></td>";
				for(int i =1;i<indices;i++){
					result += "<td>"+rs.getString(i+1)+"</td>";
				}
				result+="</tr>";
			}
			rs.close();
			smt.close();
			con.close();
			
		}catch(ClassNotFoundException e){
				throw new AccessException("No ha detectado el Driver");
		}catch(SQLException ee){
			throw new AccessException("Fallo al conectar con la BBDD");
			
		}
		return result;
	}
	/**
	 * Elimina las filas de una tabla que confirma una condición
	 * @param tabla Nombre de la tabla 
	 * @param atributo Nombre del atributo que debe cumplir la condición
	 * @param valor Valor de la condición
	 * @throws AccessException Produce una excepción si se produce un erros durante la transacción con la BBDD
	 */
	public void delete(String tabla,String atributo,String valor)throws AccessException{
		String sql="delete from "+tabla+" where "+atributo+"='"+valor+"'";
		System.out.println(sql);
		try{
			Class.forName(driver);
			Connection con= DriverManager.getConnection(url, usuario, contraseña);
			Statement smt=con.createStatement();
			smt.execute(sql);
			smt.close();
			con.close();
			
		}catch(ClassNotFoundException e){
				throw new AccessException("No ha detectado el Driver");
		}catch(SQLException ee){
			throw new AccessException("Fallo al conectar con la BBDD");
			
		}
	}
	/**
	 * Actualiza los valores de una fila determinada
	 * @param tabla
	 * @param atributos
	 * @param valores
	 * @throws AccessException
	 */
	public void update(String tabla,String[] atributos,String[] valores,String indice) throws AccessException{
		String sql="update "+tabla+" set";
		for(int i=0;i< atributos.length-1;i++){
			sql+=" "+atributos[i]+"='"+valores[i]+"', ";
		}
		sql+=" "+atributos[atributos.length-1]+"='"+valores[atributos.length-1]+"'";
		sql+="where codigo='"+indice+"';";
		try{
			
			Class.forName(driver);
			Connection con= DriverManager.getConnection(url, usuario, contraseña);
			Statement smt=con.createStatement();
			smt.execute(sql);
			smt.close();
			con.close();
			
		}catch(ClassNotFoundException e){
				throw new AccessException("No ha detectado el Driver");
		}catch(SQLException ee){
			throw new AccessException("Fallo al conectar con la BBDD");
			
		}
	}
	/**
	 * Inserta un registro con  los valores indicados por parametros en la tabla indicada 
	 * @param tabla Nombre de la tabla donde se insertará el registro
	 * @param valores Nuevos valores del registro
	 * @throws AccessException Se produce esta excepción si falla la conexion con la BBDD
	 */
	public void create(String tabla,String[] valores)throws AccessException{
		String sql="insert into \""+tabla+"\" values(";
		for(int i=0;i< valores.length-1;i++){
			sql+=" '"+valores[i]+"', ";
		}
		sql+=" '"+valores[valores.length-1]+"');";
		
		try{
			Class.forName(driver);
			Connection con= DriverManager.getConnection(url, usuario, contraseña);
			Statement smt=con.createStatement();
			System.out.println(sql);
			smt.execute(sql);
			smt.close();
			con.close();
			
		}catch(ClassNotFoundException e){
				throw new AccessException("No ha detectado el Driver");
		}catch(SQLException ee){
			throw new AccessException("Fallo al conectar con la BBDD");
			
		}
	}
	/**
	 * Calcula el nuevo valor del codigo
	 * @param tabla
	 * @return
	 * @throws AccessException
	 */
	public String autoCode(String tabla) throws AccessException{
		String sql="select * from \""+tabla+"\" order by codigo desc";
		String resultado;
		long result;
		try{
			Class.forName(driver);
			Connection con= DriverManager.getConnection(url, usuario, contraseña);
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery(sql);
			if(rs.next()){
			resultado=rs.getString(1);
			result=Long.parseLong(resultado);
			result+=1;
			resultado=""+result;
			}else{
				resultado="1";
			}
			rs.close();
			smt.close();
			con.close();
			return resultado;
		}catch(ClassNotFoundException e){
				throw new AccessException("No ha detectado el Driver");
		}catch(SQLException ee){
			throw new AccessException("Fallo al conectar con la BBDD");
			
		} 
	}
	/**
	 * Busca un trabajador concreto
	 * @param sql
	 * @param worker
	 * @return
	 * @throws Exception
	 */
	public Worker findWorker(String sql,String worker) throws Exception{
		Worker result=null;
		try{
			Class.forName(driver);
			Connection con= DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1, worker);
			ResultSet rs=smt.executeQuery();
			rs.next();
			result = new Worker(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11), rs.getString(12),rs.getString(13), rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19));
			rs.close();
			smt.close();
			con.close();
			
		}catch(ClassNotFoundException e){
			throw new AccessException("No ha detectado el Driver");
		}catch(SQLException ee){
			throw new AccessException("Fallo al conectar con la BBDD");
			
		}
		return result;
	}
	public Support findSupport(String sql,String support) throws Exception{
		Support result;
		try{
			Class.forName(driver);
			Connection con= DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1, support);
			ResultSet rs=smt.executeQuery();
			rs.next();
			result = new Support(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
			rs.close();
			smt.close();
			con.close();
			
		}catch(ClassNotFoundException e){
			throw new AccessException("No ha detectado el Driver");
		}catch(SQLException ee){
			throw new AccessException("Fallo al conectar con la BBDD");
		}
		return result;
	}
	public Material findMaterial(String sql, String material) throws AccessException{
		Material result=null;
		try{
			Class.forName(driver);
			Connection con= DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1, material);
			ResultSet rs=smt.executeQuery();
			rs.next();
			result = new Material(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4));
			rs.close();
			smt.close();
			con.close();
			
		}catch(ClassNotFoundException e){
			throw new AccessException("No ha detectado el Driver");
		}catch(SQLException ee){
			throw new AccessException("Fallo al conectar con la BBDD");
			
		}
		return result;
	}
	public Installation findInstallation(String sql, String instalacion,String user) throws AccessException{
		Installation result=null;
		try{
			Class.forName(driver);
			Connection con= DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1, instalacion);
			smt.setString(1, user);
			ResultSet rs=smt.executeQuery();
			rs.next();
			result = new Installation(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8),rs.getString(9),user);
			ñ
			rs.close();
			smt.close();
			con.close();
			
		}catch(ClassNotFoundException e){
			throw new AccessException("No ha detectado el Driver");
		}catch(SQLException ee){
			throw new AccessException("Fallo al conectar con la BBDD");
			
		}
		return result;
	}
	public String showList(String tabla, String columnas, String instalacion) throws AccessException{
		String result="";
		String sql="select "+columnas+"  from "+tabla+" where codigo_instalacion=?";
		try{
			Class.forName(driver);
			Connection con= DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement smt= con.prepareStatement(sql);
			smt.setString(1, instalacion);
			ResultSet rs=smt.executeQuery();
			while(rs.next()){
				result+="<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td></tr>";
			}
			
		}catch(SQLException e){
			throw new AccessException("Fallo en la conexión de BBDD");
		}catch(ClassNotFoundException e){
			throw new AccessException("Fallo en la BBDD");
		}
		return result;
	}
}
