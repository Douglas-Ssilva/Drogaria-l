package br.com.drogaria.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class Testes {
	
	@Test
	@Ignore
	public void save() {
		ProdutoDAO dao= new ProdutoDAO();
		Produto produto= new Produto("Notbook", 1L, 500.5, new Fabricante(28L,"Ultrafarma2"));
		dao.save(produto);
	}
	
	@Test
	@Ignore
	public void selectAll() {
		ProdutoDAO dao= new ProdutoDAO();
		List<Produto> selectAll = dao.selectAll();
		for (Produto produto : selectAll) {
			System.out.println(produto);
		}
	}
	
	@Test
	@Ignore
	public void select() {
		ProdutoDAO dao= new ProdutoDAO();
		Produto produto= new Produto();
		produto.setCodigo(2L);
		Produto p = dao.select(produto);
		System.out.println(p);
		
	}
	
	@Test
	@Ignore
	public void delete() {
		ProdutoDAO dao= new ProdutoDAO();
		Produto produto= new Produto();
		produto.setCodigo(1L);
		dao.delete(produto);
	}
	
	@Test
	@Ignore
	public void update() {
		ProdutoDAO dao= new ProdutoDAO();
		Produto produto= new Produto();
		produto.setCodigo(3L);
		Produto p = dao.select(produto);
		System.out.println("Product before update: "+ p);
		p.setDescricao("Notbook");
		p.setPreco(500.5);
		p.setQuantidade(1L);
		p.setFabricante(new Fabricante(30L, ""));
		dao.update(p);
		Produto select = dao.select(p);
		System.out.println("Result update: " + select);
	}

}
