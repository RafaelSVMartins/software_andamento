package com.caelum.tarefas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

	private Connection con;
	public UsuarioDao() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void adiciona(Usuario user) {
		String sql="insert into usuarios (login,senha) values (?,?)";

		try(PreparedStatement stm = this.con.prepareStatement(sql)) {
			stm.setString(1, user.getLogin());
			stm.setString(2, user.getPassword());
			stm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}

	}

	public void exclui(Usuario user) {
		String sql="delete * from usuarios where id=?";

		try(PreparedStatement stm = this.con.prepareStatement(sql)) {
			stm.setInt(1,user.getId());
			stm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
	}

	public void alterar(Usuario user) {
		String sql="update usuarios set login=?, senha=? where id=?";

		try(PreparedStatement stm = this.con.prepareStatement(sql)) {
			stm.setString(1, user.getLogin());
			stm.setString(2,user.getPassword());
			stm.setInt(3, user.getId());
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<Usuario> ListaUsuario() {
		List<Usuario> usuarios = new ArrayList<>();
		Usuario u=null;
		String sql= "select * from usuarios";
		try(PreparedStatement stm = this.con.prepareStatement(sql)) {
			try(ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					u = new Usuario();
					u.setId(rs.getInt("id"));
					u.setLogin(rs.getString("login"));
					u.setPassword(rs.getString("senha"));
					usuarios.add(u);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}

		return usuarios;
	}

	public Usuario buscaporid(int id) {
		String sql= "select * from usuarios where id=?";
		Usuario u = null;
		try(PreparedStatement stm = this.con.prepareStatement(sql)) {
			stm.setInt(1, id);
			try(ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					u = new Usuario();
					u.setId(rs.getInt(id));
					u.setLogin(rs.getString("login"));
					u.setPassword(rs.getString("senha"));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage());
		}

		return u;
	}
	
	public Usuario buscausuario(Usuario u) {
		String sql= "select * from usuarios where senha=?";
		try(PreparedStatement stm = this.con.prepareStatement(sql)) {
			stm.setString(1, u.getPassword());
			try(ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					u = new Usuario();
					u.setId(rs.getInt("id"));
					u.setLogin(rs.getString("login"));
					u.setPassword(rs.getString("senha"));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage());
		}

		return u;
	}
}
