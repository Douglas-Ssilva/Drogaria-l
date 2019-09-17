package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.MyMessages;

@ManagedBean
@ViewScoped
public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private ProdutoDAO dao= new ProdutoDAO();
	private Produto produto= new Produto();
	private List<Produto> list= new ArrayList<>();
	private List<Produto> listFilter;
	
	public void init() {
		System.out.println("==Init Product==");
		list= dao.selectAll();
	}
	
	public void save() {
		System.out.println("Salvando");
		try {
			System.out.println(produto);
			dao.save(produto);
			init();
			produto= new Produto();
			MyMessages.addMessageSuccess("Product save successfully!");
		} catch (Exception e) {
			MyMessages.addMessageSuccess(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void clearInputsCancel() {
		produto= new Produto();
	}
	
	public void edit() {
		try {
			System.out.println(produto);
			dao.update(produto);
			init();
			produto= new Produto();
			MyMessages.addMessageSuccess("Updated successfully!");
		} catch (Exception e) {
			MyMessages.addMessageError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void delete() {
		try {
			System.out.println(produto);
			dao.delete(produto);
			init();
			produto= new Produto();
			MyMessages.addMessageSuccess("Deleted successfully!");
		} catch (Exception e) {
			MyMessages.addMessageError(e.getMessage());
			e.printStackTrace();
		}
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Produto> getList() {
		return list;
	}
	public void setList(List<Produto> list) {
		this.list = list;
	}
	public List<Produto> getListFilter() {
		return listFilter;
	}
	public void setListFilter(List<Produto> listFilter) {
		this.listFilter = listFilter;
	}

}
