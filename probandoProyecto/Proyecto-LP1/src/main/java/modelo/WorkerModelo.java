package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Workers;
import interfaz.WorkerInterface;
import util.SQLConexion;

public class WorkerModelo implements WorkerInterface {

	@Override
	public List<Workers> listadoObjeto() {
		List<Workers> listar = new ArrayList<Workers>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = SQLConexion.getConexion();
			String sql = "Select * from workers";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Workers work = new Workers();
				work.setIdWorkers(rs.getString("idWorkers"));
				work.setNombres(rs.getString("nombres"));
				work.setApellidoP(rs.getString("apellidoP"));
				work.setApellidoM(rs.getString("apellidoM"));
				work.setDni(rs.getString("dni"));
				work.setSalario(rs.getString("salario"));
				work.setDireccion(rs.getString("direccion"));
				work.setTelefono(rs.getString("telefono"));
				work.setFechaNacimiento(rs.getString("fechaNacimiento"));
				work.setCorreo(rs.getString("correo"));
				work.setJornadaDiaria(rs.getString("jornadaDiaria"));
				work.setInicioContrato(rs.getString("inicioContrato"));
				work.setFinContrato(rs.getString("finContrato"));
				work.setCargo(rs.getString("cargo"));
				work.setTipoContrato(rs.getString("tipoContrato"));
				listar.add(work);
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

		return listar;
	}

	@Override
	public int crearObjeto(Workers worker) {
		int value = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = SQLConexion.getConexion();
			String sql = "INSERT INTO workers values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, worker.getNombres());
			pstm.setString(2, worker.getApellidoP());
			pstm.setString(3, worker.getApellidoM());
			pstm.setString(4, worker.getDni());
			pstm.setString(5, worker.getSalario());
			pstm.setString(6, worker.getDireccion());
			pstm.setString(7, worker.getTelefono());
			pstm.setString(8, worker.getFechaNacimiento());
			pstm.setString(9, worker.getCorreo());
			pstm.setString(10, worker.getJornadaDiaria());
			pstm.setString(11, worker.getInicioContrato());
			pstm.setString(12, worker.getFinContrato());
			pstm.setString(13, worker.getCargo());
			pstm.setString(14, worker.getTipoContrato());

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
			String sql = "Delete from workers where idWorkers = ?";
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
	public int editarObejto(Workers worker) {
		int value = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = SQLConexion.getConexion();
			String sql = "Update workers set nombres = ?, apellidoP = ?, apellidoM = ?, dni = ?, salario = ?, direccion = ?, telefono = ?, fechaNacimiento = ?, correo = ?, jornadaDiaria = ?, inicioContrato = ?, finContrato = ?, cargo = ?, tipoContrato = ? where idWorkers = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, worker.getNombres());
			pstm.setString(2, worker.getApellidoP());
			pstm.setString(3, worker.getApellidoM());
			pstm.setString(4, worker.getDni());
			pstm.setString(5, worker.getSalario());
			pstm.setString(6, worker.getDireccion());
			pstm.setString(7, worker.getTelefono());
			pstm.setString(8, worker.getFechaNacimiento());
			pstm.setString(9, worker.getCorreo());
			pstm.setString(10, worker.getJornadaDiaria());
			pstm.setString(11, worker.getInicioContrato());
			pstm.setString(12, worker.getFinContrato());
			pstm.setString(13, worker.getCargo());
			pstm.setString(14, worker.getTipoContrato());
			pstm.setString(15, worker.getIdWorkers());
			
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
	public Workers infoObjeto(String id) {
		Workers work = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = SQLConexion.getConexion();
			String sql = "Select * from workers where idWorkers = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			if(rs.next()) {
				work = new Workers();
				work.setIdWorkers(rs.getString("idWorkers"));
				work.setNombres(rs.getString("nombres"));
				work.setApellidoP(rs.getString("apellidoP"));
				work.setApellidoM(rs.getString("apellidoM"));
				work.setDni(rs.getString("dni"));
				work.setSalario(rs.getString("salario"));
				work.setDireccion(rs.getString("direccion"));
				work.setTelefono(rs.getString("telefono"));
				work.setFechaNacimiento(rs.getString("fechaNacimiento"));
				work.setCorreo(rs.getString("correo"));
				work.setJornadaDiaria(rs.getString("jornadaDiaria"));
				work.setInicioContrato(rs.getString("inicioContrato"));
				work.setFinContrato(rs.getString("finContrato"));
				work.setCargo(rs.getString("cargo"));
				work.setTipoContrato(rs.getString("tipoContrato"));
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
		return work;
	}

	@Override
	public List<Workers> listadoObjetoFiltrado(String tipoCargo) {
		List<Workers> listar = new ArrayList<Workers>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = SQLConexion.getConexion();
			String sql = "Select * from workers where tipoContrato = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, tipoCargo);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Workers work = new Workers();
				work.setIdWorkers(rs.getString("idWorkers"));
				work.setNombres(rs.getString("nombres"));
				work.setApellidoP(rs.getString("apellidoP"));
				work.setApellidoM(rs.getString("apellidoM"));
				work.setDni(rs.getString("dni"));
				work.setSalario(rs.getString("salario"));
				work.setDireccion(rs.getString("direccion"));
				work.setTelefono(rs.getString("telefono"));
				work.setFechaNacimiento(rs.getString("fechaNacimiento"));
				work.setCorreo(rs.getString("correo"));
				work.setJornadaDiaria(rs.getString("jornadaDiaria"));
				work.setInicioContrato(rs.getString("inicioContrato"));
				work.setFinContrato(rs.getString("finContrato"));
				work.setCargo(rs.getString("cargo"));
				work.setTipoContrato(rs.getString("tipoContrato"));
				listar.add(work);
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

		return listar;
	}

}
