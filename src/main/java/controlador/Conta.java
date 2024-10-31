
package controlador;

import jakarta.validation.constraints.NotBlank;


public class Conta {
    
    
    private Integer id;
    @NotBlank(message = "A senha deve ser informada!")
    private String senha;
    @NotBlank(message = "o email deve ser informado!")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
   
    
}
