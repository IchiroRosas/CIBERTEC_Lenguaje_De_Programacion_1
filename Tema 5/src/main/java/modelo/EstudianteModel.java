package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Estudiante;
import entidades.TipoDocumento;
import interfaces.EstudianteInterface;
import util.MySqlConexion;

public class EstudianteModel implements EstudianteInterface {

	@Override
	public List<TipoDocumento> listTipoDocumentos() {
		// TODO Auto-generated method stub
		List<TipoDocumento> listDocumentos = new ArrayList<TipoDocumento>();
		Connection cn = null;
		PreparedStatement pstm= null;
		ResultSet rs = null;
		
		try {
			cn = MySqlConexion.getConexion();
			String sql = "SELECT * FROM TipoDocumento";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TipoDocumento documento = new TipoDocumento();
				documento.setId(rs.getString("idTipo"));
				documento.setDocumento(rs.getString("documento"));
				
				listDocumentos.add(documento);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstm != null) pstm.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return listDocumentos;
	}

	@Override
	public List<Estudiante> listEstudiantes() {
		// TODO Auto-generated method stub
		
		List<Estudiante> listEstudiantes = new ArrayList<Estudiante>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlConexion.getConexion();
			String sql= "SELECT est.idEstudiante,est.tipoDocumento, est.nombresApellidos, tipo.documento, est.documento as 'numeroDocumento', est.telefono, est.carrera "
					+ "FROM estudiante as est INNER JOIN tipoDocumento as tipo "
					+ "on est.tipoDocumento = tipo.idTipo";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Estudiante estudiante = new Estudiante();
				estudiante.setId(rs.getString("idEstudiante"));
				estudiante.setNombresApellidos(rs.getString("nombresApellidos"));
				estudiante.setTipoDocumento(rs.getString("tipoDocumento"));
				estudiante.setDocumento(rs.getString("documento"));
				estudiante.setNumeroDocumento(rs.getString("numeroDocumento"));
				estudiante.setTelefono(rs.getString("telefono"));
				estudiante.setCarrera(rs.getString("carrera"));
				listEstudiantes.add(estudiante);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstm != null) pstm.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return listEstudiantes;
	}
	
}
