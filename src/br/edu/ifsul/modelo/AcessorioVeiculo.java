/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ander
 */
@Entity
@Table (name = "acessorio_veiculo")
public class AcessorioVeiculo implements Serializable{
    @EmbeddedId
    private IDAcessorioVeiculo id;
    @NotNull(message = "A data do cadastro deve ser informada!")
    @Temporal(TemporalType.DATE)
    @Column(name = "dataCadastro", nullable = false)
    private Calendar dataCadastro;
    
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;
    
    

    public AcessorioVeiculo() {
    }

    /**
     * @return the dataCadastro
     */
    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the id
     */
    public IDAcessorioVeiculo getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(IDAcessorioVeiculo id) {
        this.id = id;
    }

    /**
     * @return the veiculo
     */
    
    
}
