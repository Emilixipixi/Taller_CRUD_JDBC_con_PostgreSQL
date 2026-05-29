package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertVehiculo {

	private static final Logger log = LogManager.getLogger(InsertVehiculo.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = Conexion.getConnection();

			String sql = """
					INSERT INTO vehiculos (placa, marca, modelo, anio, precio, color, disponible)
					VALUES (?,?,?,?,?,?,?)
					""";
			ps = con.prepareStatement(sql);

			ps.setString(1, "ABC-1234");
			ps.setString(2, "Toyota");
			ps.setString(3, "Corolla");
			ps.setInt(4, 2022);
			ps.setDouble(5, 25000.0);
			ps.setString(6, "Negro");
			ps.setBoolean(7, true);

			int filas = ps.executeUpdate();

			log.info("Filas insertadas: " + filas);

		} catch (Exception e) {

			log.error("Error al insertar: " + e.getMessage());

		} finally {

			try {
				con.close();
			} catch (SQLException e) {

				log.error("Error de Conexion: " + e.getMessage());
			}

		}
	}
}