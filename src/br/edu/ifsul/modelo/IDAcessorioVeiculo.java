/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ander
 */
@Embeddable
public class IDAcessorioVeiculo implements Serializable{
    @NotNull(message = "O veiculo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "veiculo", referencedColumnName = "codigo", nullable = false)
    private Veiculo veiculo;
    
    @NotNull(message = "O acessorio deve ser informado")
    @ManyToOne
    @JoinColumn(name = "acessorio", referencedColumnName = "codigo", nullable = false)
    private Acessorio acessorio;

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Acessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }
    
    
}
