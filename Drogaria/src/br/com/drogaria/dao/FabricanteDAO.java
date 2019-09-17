package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConnectionFactory;

public class FabricanteDAO {
	private Connection connection;

	public FabricanteDAO() {
		this.connection= ConnectionFactory.getConnection();
	}
	
	public void save(Fabricante f) {
		String sql= "insert into fabricante (descricao) values (?)";
		try {
			PreparedStatement statement= connection.prepareStatement(sql);
			statement.setString(1, f.getDescricao());
			int i = statement.executeUpdate();
			System.out.println("Rows affecteds: "+ i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Fabricante select(Fabricante f) {
		String sql= "select * from fabricante where codigo= (?)";
		Fabricante fabricante= null;
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setLong(1, f.getCodigo());
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				fabricante= new Fabricante(rs.getLong("codigo"),rs.getString("descricao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fabricante;
	}
	
	public List<Fabricante> selectAll() {
		String sql= "select * from fabricante order by descricao";
		List<Fabricante> list= new ArrayList<>();
		try {
			PreparedStatement statement= connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				list.add(new Fabricante(rs.getLong("codigo"), rs.getString("descricao")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Fabricante> selectForDescription(Fabricante f){
		String sql="select * from fabricante where descricao like ?";
		List<Fabricante> list= new LinkedList<>();
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+f.getDescricao()+"%");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				list.add(new Fabricante(rs.getLong("codigo"), rs.getString("descricao")));
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void delete(Fabricante f) {
		String sql="delete from fabricante where codigo= (?)";
		try {
			PreparedStatement statement= connection.prepareStatement(sql);
			statement.setLong(1, f.getCodigo());
			int i = statement.executeUpdate();
			System.out.println("Rows affecteds: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(Fabricante f) {
		String sql="update fabricante set descricao= (?) where codigo= (?)";
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, f.getDescricao());
			preparedStatement.setLong(2, f.getCodigo());
			int i = preparedStatement.executeUpdate();
			System.out.println("Rows affecteds: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
