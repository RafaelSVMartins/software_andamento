package com.rafael.tarefas;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;


@Repository
public class TarefasDao implements DaoTarefa {
	 Connection con = null;

	public TarefasDao() {
		this.con = ConnectionFactory.getConnection() ;
	}

	
	public void adiciona(Tarefa tarefa) {
		// TODO Auto-generated method stub
		String sql="insert into tarefas (descricao,finalizado,dataFinalizacao) values(?,?,?)";
		try (PreparedStatement stm = this.con.prepareStatement(sql)){
			stm.setString(1, tarefa.getDescricao());
			stm.setBoolean(2,tarefa.getFinalizado());
			stm.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		} 
	}

	
	public void exclui(Tarefa tarefa) {
		// TODO Auto-generated method stub
		String sql = "delete  from tarefas where id=?";
		try (PreparedStatement stm = con.prepareStatement(sql)){
			stm.setLong(1, tarefa.getId());
			stm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		} 
	}

	public void alterar(Tarefa tarefa) {
		// TODO Auto-generated method stub
		String sql = "update tarefas set descricao=?, finalizado=?, dataFinalizacao=? where id =?";

		try(PreparedStatement stm = this.con.prepareStatement(sql)) {
			stm.setString(1, tarefa.getDescricao());
			stm.setBoolean(2, tarefa.getFinalizado());
			stm.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stm.setLong(4,tarefa.getId());
			stm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}

	}

	
	public List<Tarefa> listatarefas() {
		// TODO Auto-generated method stub
		List<Tarefa> tarefas = new ArrayList<>();
		String sql = "select * from tarefas";
		try (PreparedStatement stm = this.con.prepareStatement(sql)){
			try(ResultSet rs = stm.executeQuery()) {
				while(rs.next()) {
					Tarefa t = new Tarefa();
					t.setId(rs.getLong("id"));
					t.setDescricao(rs.getString("descricao"));
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("dataFinalizacao"));
					t.setDataFinalizacao(data);
					t.setFinalizado(rs.getBoolean("finalizado"));
					tarefas.add(t);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}

		return tarefas;
	}

	
	public Tarefa buscaporid(Long id) {
		// TODO Auto-generated method stub
		Tarefa tarefa = null;
		String sql = "select * from tarefas where id=?";

		try (PreparedStatement stm = this.con.prepareStatement(sql)) {
			stm.setLong(1,id);
			try(ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					tarefa = new Tarefa();
					tarefa.setId(id);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tarefa;
	}

	public void finaliza(Long id) {
		// TODO Auto-generated method stub
		String sql="update tarefas set finalizado=? where id=?";

		try(PreparedStatement stm = this.con.prepareStatement(sql)) {
			stm.setBoolean(1, true);
			stm.setLong(2, id);
			stm.execute();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage());
		}
	}
}

