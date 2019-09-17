package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.factory.ConnectionFactory;

public class ProdutoDAO {
	
	private Connection connection;

	public ProdutoDAO() {
		connection= ConnectionFactory.getConnection();
	}
	
	public void save(Produto p) {
		String sql="insert into produto (descricao, quantidade, preco, cod_fabricante) values (?,?,?,?)";
		try {
			PreparedStatement statement= connection.prepareStatement(sql);
			statement.setString(1, p.getDescricao());
			statement.setLong(2, p.getQuantidade());
			statement.setDouble(3, p.getPreco());
			statement.setLong(4, p.getFabricante().getCodigo());
			int i = statement.executeUpdate();
			System.out.println("Affected row: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Produto select(Produto p) {
		String sql="select * from produto p join fabricante f on p.cod_fabricante= f.codigo where p.codigo= (?)";
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setLong(1, p.getCodigo());
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				Fabricante fabricante= new Fabricante();
				fabricante.setCodigo(rs.getLong("f.codigo"));
				fabricante.setDescricao(rs.getString("f.descricao"));
				
				Produto produto=  new Produto();
				produto.setCodigo(rs.getLong("p.codigo"));
				produto.setDescricao(rs.getString("p.descricao"));
				produto.setPreco(rs.getDouble("p.preco"));
				produto.setQuantidade(rs.getLong("p.quantidade"));
				produto.setFabricante(fabricante);
				return produto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Produto> selectAll() {
		String sql="select * from produto p join fabricante f on f.codigo= p.cod_fabricante";
		List<Produto> list= new ArrayList<>();
		try { 
			PreparedStatement statement= connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				//Consumindo o que veio da consulta
				Fabricante fabricante= new Fabricante();
				fabricante.setCodigo(rs.getLong("f.codigo"));
				fabricante.setDescricao(rs.getString("f.descricao"));
				
				
				Produto produto= new Produto();
				produto.setCodigo(rs.getLong("p.codigo"));
				produto.setDescricao(rs.getString("p.descricao"));
				produto.setPreco(rs.getDouble("p.preco"));
				produto.setQuantidade(rs.getLong("p.quantidade"));
				produto.setFabricante(fabricante);
				
				list.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void delete(Produto p) {
		String sql= "delete from produto where codigo= (?)";
		try {
			PreparedStatement statement= connection.prepareStatement(sql);
			statement.setLong(1, p.getCodigo());
			int i = statement.executeUpdate();
			System.out.println("Affected row: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Produto p) {
		String sql="update produto set descricao= (?), quantidade= (?), preco= (?), cod_fabricante= (?) where codigo= (?)";
		try {
			PreparedStatement statement= connection.prepareStatement(sql);
			statement.setString(1, p.getDescricao());
			statement.setLong(2, p.getQuantidade());
			statement.setDouble(3, p.getPreco());
			statement.setLong(4, p.getFabricante().getCodigo());
			statement.setLong(5, p.getCodigo());
			int i = statement.executeUpdate();
			System.out.println("Affected row: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
