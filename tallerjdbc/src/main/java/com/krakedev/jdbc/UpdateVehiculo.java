package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateVehiculo {
	
	private static final Logger log = LogManager.getLogger(UpdateVehiculo.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
		con = Conexion.getConnection();
		
		String sql = """
				UPDATE vehiculos SET precio = ?, disponible = ?, kilometraje = ? 
				WHERE placa = ?
				""";
		
		ps = con.prepareStatement(sql);
		
		ps.setDouble(1, 23500.0);
		ps.setBoolean(2, false);
		ps.setInt(3, 18000);
		ps.setString(4, "ABC-1234");
		
		int filas = ps.executeUpdate();
		
		log.info("Filas actualizadas: " + filas);
		
		} catch (Exception e) {
			
			log.error("Error al actualizar: " + e.getMessage());
			
		} finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}