/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author Ander
 */
@Entity
@Table(name = "posto")
public class Posto extends Pessoa implements Serializable{
    
    @CNPJ(message = "O CNPJ deve ser valido")
    @NotNull(message = "O CNPJ não pode ser nulo")
    @NotBlank(message = "O CNPJ não pode ser vazio")
    @Length(max = 50, message = "O CNPJ não pode ter mais que {max} caracteres")
    @Column(name = "cnpj",length = 50, nullable = false)   
    private String cnpj;
    
    @NotNull(message = "O endereço não pode ser nulo")
    @NotBlank(message = "O endereço não pode ser vazio")
    @Length(max = 50, message = "O endereço não pode ter mais que {max} caracteres")
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;
    
    @NotNull(message = "O bairro não pode ser nulo")
    @NotBlank(message = "O bairro não pode ser vazio")
    @Length(max = 50, message = "O bairro não pode ter mais que {max} caracteres")
    @Column(name = "bairro", length = 50, nullable = false)
    private String bairro;
    
    @NotNull(message = "O campo telefone não pode ser nulo")
    @NotBlank(message = "O campo telefone não pode ser vazio")
    @Length(max = 10, message = "O campo telefone não pode ter mais que {max} caracteres")
    @Column(name = "telefone", length = 10, nullable = false)
    private String telefone;

    public Posto() {
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
            
}
