package br.com.drogaria.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MyMessages {
	
	public static void addMessageSuccess(String msg) {
		//sumary- título da mensagem
		//detail- mensagem detalhada
		FacesMessage message= new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
		FacesContext.getCurrentInstance().addMessage(null, message); //adicionando a msg ao contento da minha aplicação
	}
	
	public static void addMessageError(String msg) {
		FacesMessage message= new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
}
