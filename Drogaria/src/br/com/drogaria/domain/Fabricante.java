package br.com.drogaria.domain;

import java.io.Serializable;

public class Fabricante implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	
	
	public Fabricante() {
	}
	
	public Fabricante(String descricao) {
		this.descricao = descricao;
	}
	
	public Fabricante(Long codigo, String descricao) {
		this(descricao);
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
	
	@Override
	public String toString() {
		return "Fabricante [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
	
	

}
