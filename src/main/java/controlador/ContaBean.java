
package controlador;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.dao.ContaDAO;

@Named
@SessionScoped
public class ContaBean implements  Serializable{
    private List<Conta> listaConta = new ArrayList<>(); 
    private Conta conta = new Conta();
    
    
    @Inject
    private ContaDAO contaDAO;
    
    public void preparaConta() {
        conta = new Conta();
        conta.setId(listaConta.size() + 1);
        
    }

    public void adicionarConta() {
        listaConta.add(conta);
        conta = new Conta();
        
        
        contaDAO.Conta(conta);

        
    }

    
    public void atualiza() {
        Integer idx = null;

        for (int i = 0; i < listaConta.size(); i++) {

            if (listaConta.get(i).getId().intValue() == conta.getId().intValue()) {
                idx = i;
            }

        }

        if (idx != null) {
            listaConta.set(idx, conta);
        }

       
    }


    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    

        
        
}


    
    

    
    

    
    
    

