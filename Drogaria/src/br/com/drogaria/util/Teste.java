package br.com.drogaria.util;

import java.util.List;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class Teste {

	public static void main(String[] args) {
		Fabricante fabricante= new Fabricante("Biol");
		FabricanteDAO dao= new FabricanteDAO();
//		dao.save(fabricante);
//		List<Fabricante> list = dao.selectAll();
//		for (Fabricante fabricante2 : list) {
//			System.out.println(fabricante2);
//		}
//		dao.delete(fabricante);
//		Fabricante fabricante2 = dao.select(fabricante);
//		dao.update(fabricante);
		List<Fabricante> list = dao.selectForDescription(fabricante);
		for (Fabricante fabricante2 : list) {
			System.out.println(fabricante2);
		}
	}

}
