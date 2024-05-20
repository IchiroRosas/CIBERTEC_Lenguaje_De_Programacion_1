package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Candidato;
import interfaz.CandidatosInterface;
import util.SQLConexion;

public class CandidatoModelo implements CandidatosInterface {

	@Override
	public List<Candidato> ListadoObjeto() {
		List<Candidato> listado = new ArrayList<Candidato>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = SQLConexion.getConexion();
			String sql = "Select * from candidatos";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Candidato candi = new Candidato();
				candi.setIdEmpleado(rs.getString("idCandidato"));
				candi.setNombres(rs.getString("nombres"));
				candi.setApellidoP(rs.getString("apellidoP"));
				candi.setApellidoM(rs.getString("apellidoM"));
				candi.setDni(rs.getString("dni"));
				candi.setCarrera(rs.getString("carrera"));
				candi.setTelefono(rs.getString("telefono"));
				candi.setCorreo(rs.getString("correo"));
				candi.setFechaNacimiento(rs.getString("fechaNacimiento"));
				listado.add(candi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return listado;
	}

	@Override
	public int crearObjeto(Candidato candidato) {
		int value = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = SQLConexion.getConexion();
			String sql = "Insert into candidatos values (null, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, candidato.getNombres());
			pstm.setString(2, candidato.getApellidoP());
			pstm.setString(3, candidato.getApellidoM());
			pstm.setString(4, candidato.getDni());
			pstm.setString(5, candidato.getCarrera());
			pstm.setString(6, candidato.getTelefono());
			pstm.setString(7, candidato.getCorreo());
			pstm.setString(8, candidato.getFechaNacimiento());
			
			value = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int eliminarObjeto(String id) {
		int value = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = SQLConexion.getConexion();
			String sql = "Delete from candidatos where idCandidato = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, id);

			value = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int editarObjeto(Candidato candidato) {
		int value = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = SQLConexion.getConexion();
			String sql = "Update candidatos set nombres = ?, apellidoP = ?, apellidoM = ?, dni = ?, carrera = ?, telefono = ?, correo = ?, fechaNacimiento = ? where idCandidato = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, candidato.getNombres());
			pstm.setString(2, candidato.getApellidoP());
			pstm.setString(3, candidato.getApellidoM());
			pstm.setString(4, candidato.getDni());
			pstm.setString(5, candidato.getCarrera());
			pstm.setString(6, candidato.getTelefono());
			pstm.setString(7, candidato.getCorreo());
			pstm.setString(8, candidato.getFechaNacimiento());
			pstm.setString(9, candidato.getIdEmpleado());
			
			value = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public Candidato infoObjeto(String id) {
		Candidato candidato = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = SQLConexion.getConexion();
			String sql = "Select * from candidatos where idCandidato = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
				candidato = new Candidato();
				candidato.setIdEmpleado(rs.getString("idCandidato"));
				candidato.setNombres(rs.getString("nombres"));
				candidato.setApellidoP(rs.getString("apellidoP"));
				candidato.setApellidoM(rs.getString("apellidoM"));
				candidato.setDni(rs.getString("dni"));
				candidato.setCarrera(rs.getString("carrera"));
				candidato.setTelefono(rs.getString("telefono"));
				candidato.setCorreo(rs.getString("correo"));
				candidato.setFechaNacimiento(rs.getString("fechaNacimiento"));			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null) cn.close();
				if (rs != null) rs.close();
				if (pstm != null) pstm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return candidato;
	}

	@Override
	public List<Candidato> listadoObjetoFiltrado(String carrera) {
		List<Candidato> listado = new ArrayList<Candidato>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = SQLConexion.getConexion();
			String sql = "Select * from candidatos where carrera = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, carrera);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Candidato candi = new Candidato();
				candi.setIdEmpleado(rs.getString("idCandidato"));
				candi.setNombres(rs.getString("nombres"));
				candi.setApellidoP(rs.getString("apellidoP"));
				candi.setApellidoM(rs.getString("apellidoM"));
				candi.setDni(rs.getString("dni"));
				candi.setCarrera(rs.getString("carrera"));
				candi.setTelefono(rs.getString("telefono"));
				candi.setCorreo(rs.getString("correo"));
				candi.setFechaNacimiento(rs.getString("fechaNacimiento"));
				listado.add(candi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return listado;
	}

}
