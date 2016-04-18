/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Ander
 */
@Entity
@Table (name = "condutor")
public class Condutor extends Pessoa implements Serializable{
    @NotNull(message = "O campo CHN não pode ser nulo")
    @NotBlank(message = "O campo não pode ser vazio")
    @Length(max = 10, message = "O campo não pode ter mais que {max} caracteres")
    @Column(name = "cnh",length = 11, nullable = false)
    private String cnh;
    
    @NotBlank(message = "O RG deve ser informado")
    @Length(max = 11, message = "O RG não deve ultrapassar {max} caracteres")
    @Column(name = "rg", nullable = false, length = 11)
    private String rg;
    
    @CPF(message = "O CPF deve ser valido")
    @NotBlank(message = "O CPF deve ser informado")
    @Length(max = 14, message = "O Cpf não deve ultrapassar {max} caracteres")
    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;
    
     public Condutor(){
        
    }

    /**
     * @return the cnh
     */
    public String getCnh() {
        return cnh;
    }

    /**
     * @param cnh the cnh to set
     */
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }  

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
