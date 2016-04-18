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

/**
 *
 * @author Ander
 */
@Entity
@Table(name = "cidade")
public class Cidade implements Serializable{
    @Id    
    @Column(name = "codigo", nullable = false)
    @SequenceGenerator(name = "seq_cidade", sequenceName = "seq_cidade_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_cidade", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotNull(message = "O campo UF deve ser informado")
    @NotBlank(message = "O campo UF deve ser informado")
    @Length(max = 2, message = "O campo UF não deve possuir mais de {max} caracteres")
    @Column(name = "uf", length = 2, nullable = false)
    private String uf;
    
    @NotNull(message = "O nome deve ser informado")
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve possuir mais de {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

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
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.codigo);
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
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    public String toString() {
        return nome ;
    }
}
