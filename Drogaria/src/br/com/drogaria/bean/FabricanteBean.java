package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.MyMessages;

@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private FabricanteDAO dao= new FabricanteDAO();
	private Fabricante fabricante= new Fabricante();;
//	private ListDataModel<Fabricante> listDataModel;
	private List<Fabricante> filteredFactory; 		//A partir do prime 5.0, todo dataTable exigirá 2 listas
	private List<Fabricante> list;
	
	@PostConstruct
	public void init() {
		System.out.println("====Init====");
		list= dao.selectAll();
	}
	
	public void save() {
		try {
			System.out.println(fabricante);
			dao.save(fabricante);
			MyMessages.addMessageSuccess("Saved successfully!");
			fabricante= new Fabricante();
			init();
		}catch(Exception e) {
			MyMessages.addMessageError(e.getMessage()); //pegando a msg do banco
			e.printStackTrace();
		}
	}
//	Substituí pelo setProperty
//	public void preparedDelete() {
//		fabricante= listDataModel.getRowData(); //recebendo o objeto da linha que foi clicada
//		System.out.println(fabricante);
//	}
	
	public void delete() {
		try {
			System.out.println(fabricante);
			dao.delete(fabricante);
			init();
			fabricante= new Fabricante(); 		//A fim de limpar o dialog
			MyMessages.addMessageSuccess("Removed successfully!");
		}catch(Exception e) {
			MyMessages.addMessageError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void clearInputs() {
		fabricante= new Fabricante(); 		//A fim de limpar o dialog
	}
//	
//	public void preparedEdit() {
//		fabricante= listDataModel.getRowData();
//		System.out.println(fabricante);
//	}
	
	public void edit() {
		try {
			System.out.println(fabricante);
			dao.update(fabricante);
			init();
			fabricante= new Fabricante();
			MyMessages.addMessageSuccess("Updated successfully!");
		} catch (Exception e) {
			MyMessages.addMessageError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Fabricante> getFilteredFactory() {
		return filteredFactory;
	}

	public void setFilteredFactory(List<Fabricante> filteredFactory) {
		this.filteredFactory = filteredFactory;
	}

	public List<Fabricante> getList() {
		return list;
	}

	public void setList(List<Fabricante> list) {
		this.list = list;
	}
}
