/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.dao.NovoLoginDAO;

@Named
@SessionScoped
public class NovoLoginBean implements  Serializable{
    private List<NovoLogin> listaNovoLogin = new ArrayList<>();
    private NovoLogin novoLogin = new NovoLogin();
    
    @Inject
    private NovoLoginDAO novoLoginDAO;
    
    
    
    public void preparaNovoLogin() {
        novoLogin = new NovoLogin();
        novoLogin.setId(listaNovoLogin.size() + 1);
        
    }

    public void adicionarNovoLogin() {
        listaNovoLogin.add(novoLogin);
        //novoLogin = new NovoLogin();
        novoLoginDAO.novoLogin(novoLogin);
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", " Cadastrado com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, message);

        
    }
    
    public NovoLogin getNovoLogin() {
        return novoLogin;
    }

    public void setNovoLogin(NovoLogin novoLogin) {
        this.novoLogin = novoLogin;
    }
    
}
