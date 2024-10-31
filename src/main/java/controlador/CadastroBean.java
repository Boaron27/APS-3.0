package controlador;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.Named;
import java.util.stream.Collectors;
import model.dao.CadastroDAO;


@Named
@SessionScoped
public class CadastroBean implements Serializable {
    
    

    private List<Cadastro> listaCadastro = new ArrayList<>();
    private Cadastro cadastro = new Cadastro();
    private String visivel = "lista";
    
    @Inject
    private CadastroDAO cadastroDAO;
    

    public String getVisivel() {
        return visivel;
    }

    public void preparaCadastro() {
        cadastro = new Cadastro();
        cadastro.setId(listaCadastro.size() + 1);
        visivel = "cadastrar";
    }

    public void adicionarCadastro() {
        listaCadastro.add(cadastro);
        //cadastro = new Cadastro();
        //cadastroDAO.Cadastro(cadastro);
        visivel = "lista";
    }
    
    public void voltarLista(){
        visivel = "lista";
    }

    public void preparaEdicao(Cadastro list) {
        this.cadastro = list;
        visivel = "atualizar";
    }

    public List<Cadastro> getListaCadastro() {
        if (filtroLista != null){
            return filtroLista;
        }else{
            return listaCadastro;
        }
        
    }

    public void atualiza() {
        Integer idx = null;

        for (int i = 0; i < listaCadastro.size(); i++) {

            if (listaCadastro.get(i).getId().intValue() == cadastro.getId().intValue()) {
                idx = i;
            }

        }

        if (idx != null) {
            listaCadastro.set(idx, cadastro);
        }

        visivel = "lista";
    }

    public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    
    
    public void excluirCadastro(Cadastro list) {

        Integer idx = null;

        for (int i = 0; i < listaCadastro.size(); i++) {

            if (listaCadastro.get(i).getId().intValue() == list.getId().intValue()) {
                idx = i;
            }

        }

        if (idx != null) {
            listaCadastro.remove(idx.intValue());
        }

      visivel = "lista";
    }

    private String termoPesquisa;
    private List<Cadastro> filtroLista;

    public void pesquisar() {
        filtroLista = listaCadastro.stream()
                .collect(Collectors.toList());
    }

    public String getTermoPesquisa() {
        return termoPesquisa;
    }

    public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }

    public List<Cadastro> getFiltroLista() {
        return filtroLista;
    }

    public void setFiltroLista(List<Cadastro> filtroLista) {
        this.filtroLista = filtroLista;
    }
    
    public void abrirInfo(){
        visivel = "informacoes";
    }
    
    public void preparaDialog(Cadastro list) {
        this.cadastro = list;
    }
    
    
    public void enviarCadastro(Cadastro list) {

        Integer idx = null;

        for (int i = 0; i < listaCadastro.size(); i++) {

            if (listaCadastro.get(i).getId().intValue() == list.getId().intValue()) {
                idx = i;
            }

        }

        if (idx != null) {
            cadastroDAO.Cadastro(cadastro);
            
        }

      visivel = "lista";
    }
    
    
    
   
    

}
