/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table (name = "veiculo")
public class Veiculo implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_veiculo", sequenceName = "seq_veiculo_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_veiculo", strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotNull(message = "O campo placa não pode ser nulo")
    @NotBlank(message = "O campo placa não pode ser vazio")
    @Length(max = 8, message = "O campo placa não pode ter mais que {max} caracteres")
    @Column(name = "placa", length = 8, nullable = false)
    private String placa;
    
    @NotNull(message = "O campo modelo não pode ser nulo")
    @NotBlank(message = "O campo modelo não pode ser vazio")
    @Length(max = 50, message = "O campo modelo não pode ter mais que {max} caracteres")
    @Column(name = "modelo", length = 50, nullable = false)
    private String modelo;
    
    @NotNull(message = "O campo cor não pode ser nulo")
    @NotBlank(message = "O campo cor não pode ser vazio")
    @Length(max = 50, message = "O cor modelo não pode ter mais que {max} caracteres")
    @Column(name = "cor", length = 50, nullable = false)
    private String cor;
    
    //@CPF(message = "O campo renavam deve ser valido")
    @NotNull(message = "O campo renavam não pode ser nulo")
    @NotBlank(message = "O campo renavam não pode ser vazio")
    @Length(max = 20, message = "O campo renavam não pode ter mais que {max} caracteres")
    @Column(name = "renavam",length = 20, nullable = false) 
    private String renavam;
    
    @NotNull(message = "O campo cidade deve ser informado")
    @ManyToOne
    @JoinColumn(name = "cidade", referencedColumnName = "codigo", nullable = false)     
    private Cidade cidade;
    
    @NotNull(message = "O campo condutor deve ser informado")
    @ManyToOne
    @JoinColumn(name = "condutor", referencedColumnName = "codigo", nullable = false)     
    private Condutor condutor;
    
    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Deslocamento> deslocamentos = new ArrayList<>();
    
   @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Abastecimento> abastecimentos = new ArrayList<>();
   
   
    @NotNull(message = "A marca deve ser informada")
    @ManyToOne
    @JoinColumn(name = "marca", referencedColumnName = "id", nullable = false)
    private Marca marca;
    
    @OneToMany(mappedBy = "id.veiculo", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AcessorioVeiculo> acessoriosveiculos = new ArrayList<>();
 
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
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the renavam
     */
    public String getRenavam() {
        return renavam;
    }

    /**
     * @param renavam the renavam to set
     */
    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public Veiculo() {
    }
    
    public void adicionarAbastecimento(Abastecimento obj){
        obj.setVeiculo(this);// seto a venda do objeto venda itens
        this.abastecimentos.add(obj); // adiciono o abastecimento no veiculo
    }
    public void adicionarDeslocamento(Deslocamento obj){
        obj.setVeiculo(this);// seto a venda do objeto venda itens
        this.deslocamentos.add(obj); // adiciono um deslocamento no veiculo
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
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return placa;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    /**
     * @return the deslocamento
     */
    

    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    /**
     * @return the deslocamentos
     */
    public List<Deslocamento> getDeslocamentos() {
        return deslocamentos;
    }

    /**
     * @param deslocamentos the deslocamentos to set
     */
    public void setDeslocamentos(List<Deslocamento> deslocamentos) {
        this.deslocamentos = deslocamentos;
    }

    /**
     * @return the abastecimentos
     */
    public List<Abastecimento> getAbastecimentos() {
        return abastecimentos;
    }

    /**
     * @param abastecimentos the abastecimentos to set
     */
    public void setAbastecimentos(List<Abastecimento> abastecimentos) {
        this.abastecimentos = abastecimentos;
    }

    public List<AcessorioVeiculo> getAcessoriosveiculos() {
        return acessoriosveiculos;
    }

    public void setAcessoriosveiculos(List<AcessorioVeiculo> acessoriosveiculos) {
        this.acessoriosveiculos = acessoriosveiculos;
    }

    
}
