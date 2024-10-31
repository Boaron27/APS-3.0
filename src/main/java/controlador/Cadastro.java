package controlador;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;


public class Cadastro implements Serializable {

    private Integer id;
    

    
    @NotBlank(message = "O patrimonio não pode ser nulo!")
    private String patrimonio;
    @NotBlank(message = "A data deve ser informada")
    private String dataIni;
    @NotBlank(message = "O departamento deve ser informado!")
    private String dataFec;
    @Pattern(regexp = "^(Fechado|Aberto)$", message = "O status do chamado deve ser 'Fechado' ou 'Aberto'.")
    private String status;
    @NotBlank (message = "É necessario o motivo do chamado.")
    private String ajuda;
    @NotBlank (message = "É necessario o nome do requisitor.")
    private String requisitor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }


    public String getDataIni() {
        return dataIni;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }

    public String getDataFec() {
        if(dataFec == null){
            return null;
        }else{
            return dataFec;
            
            
        }
        
        
        
    }

    public void setDataFec(String dataFec) {
        this.dataFec = dataFec;
    }

    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public String getAjuda() {
        return ajuda;
    }

    public void setAjuda(String ajuda) {
        this.ajuda = ajuda;
    }

    public String getRequisitor() {
        return requisitor;
    }

    public void setRequisitor(String requisitor) {
        this.requisitor = requisitor;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cadastro other = (Cadastro) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    


}
