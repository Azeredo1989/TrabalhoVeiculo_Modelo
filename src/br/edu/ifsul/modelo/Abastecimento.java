/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
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
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Ander
 */
@Entity
@Table(name = "abastecimento")
public class Abastecimento implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_abastecimento", sequenceName = "seq_abastecimento_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_abastecimento", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data",nullable = false)
    private Calendar data;
    
    @NotNull(message = "O campo quantidade deve ser informado")
    @Column(name = "quantidade", nullable = false, columnDefinition = "decimal(12,2)")
    private Double quantidade;
    
    @NotNull(message = "O campo km deve ser informado")
    @Column(name = "km", nullable = false, columnDefinition = "decimal(12,2)")
    private Double km;
    
    @NotNull(message = "O campo valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valor;
    
    @NotNull(message = "O campo combustivel deve ser informado")
    @NotBlank(message = "O campo combustivel deve ser informado")
    @Length(max = 50, message = "O campo combustivel não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O campo combustivel deve ser informado")
    @Column(name = "combustivel", length = 50, nullable = false)
    private String combustivel;
    
    @NotNull(message = "O veiculo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "veiculo", referencedColumnName = "codigo", nullable = false)
    private Veiculo veiculo;
    
    
    @NotNull(message = "O posto deve ser informada")
    @ManyToOne
    @JoinColumn(name = "posto", referencedColumnName = "codigo", nullable = false)
    private Posto posto;
    

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
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
    }

    /**
     * @return the quantidade
     */
    public Double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the km
     */
    public Double getKm() {
        return km;
    }

    /**
     * @param km the km to set
     */
    public void setKm(Double km) {
        this.km = km;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the combustivel
     */
    public String getCombustivel() {
        return combustivel;
    }

    /**
     * @param combustivel the combustivel to set
     */
    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * @return the posto
     */
    public Posto getPosto() {
        return posto;
    }

    /**
     * @param posto the posto to set
     */
    public void setPosto(Posto posto) {
        this.posto = posto;
    }
}
