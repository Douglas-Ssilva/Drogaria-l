package br.com.drogaria.domain;

import java.io.Serializable;

public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	// int tem por padrão 0 que aparecerá no input, Long= null
	private Long codigo;
	private String descricao;
	private Long quantidade;
	private Double preco;
	private Fabricante fabricante= new Fabricante(); //Sempre que criar um produto, será criado um fab, assim não da null
	
	public Produto() {
	}
	
	public Produto(String descricao, Long quantidade, Double preco, Fabricante fabricante) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.fabricante = fabricante;
	}
	
	public Produto(Long codigo, String descricao, Long quantidade, Double preco, Fabricante fabricante) {
		this(descricao,quantidade, preco,fabricante);
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", quantidade=" + quantidade + ", preco="
				+ preco + ", fabricante=" + fabricante.getDescricao() + "]";
	}
	
	
	
	
	
	
	

}
