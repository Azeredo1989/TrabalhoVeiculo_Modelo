/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ander
 */
@Entity
@Table(name = "deslocamento")
public class Deslocamento implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_deslocamento", sequenceName = "seq_deslocamento_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_deslocamento", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotNull(message = "O campo destino não pode ser nulo")
    @NotBlank(message = "O campo destino não pode ser vazio")
    @Length(max = 50, message = "O destino placa não pode ter mais que {max} caracteres")
    @Column(name = "destino", length = 50, nullable = false)
    private String destino;
    
    @NotNull(message = "O campo origem não pode ser nulo")
    @NotBlank(message = "O campo origem não pode ser vazio")
    @Length(max = 50, message = "A origem não pode ter mais que {max} caracteres")
    @Column(name = "origem", length = 50, nullable = false)
    private String origem;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "saida",nullable = false)
    private Calendar saida;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "chegada",nullable = false)
    private Calendar chegada;
    
    @NotNull(message = "O condutor deve ser informado")
    @ManyToOne
    @JoinColumn(name = "condutor", referencedColumnName = "codigo", nullable = false)
    private Condutor condutor;
    
    @NotNull(message = "O veiculo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "veiculo", referencedColumnName = "codigo", nullable = false)
    private Veiculo veiculo;
    

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the origem
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    /**
     * @return the saida
     */
    public Calendar getSaida() {
        return saida;
    }

    /**
     * @param saida the saida to set
     */
    public void setSaida(Calendar saida) {
        this.saida = saida;
    }

    /**
     * @return the chegada
     */
    public Calendar getChegada() {
        return chegada;
    }

    /**
     * @param chegada the chegada to set
     */
    public void setChegada(Calendar chegada) {
        this.chegada = chegada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Deslocamento other = (Deslocamento) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    /**
     * @return the condutor
     */
    public Condutor getCondutor() {
        return condutor;
    }

    /**
     * @param condutor the condutor to set
     */
    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    
    
}
