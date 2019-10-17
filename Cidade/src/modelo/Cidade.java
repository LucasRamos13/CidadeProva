/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Administrador
 */
public class Cidade {
    private Integer habitantes;
    private Integer codigo;
    private Double area;
    private Double distancia;
    private String nome;
    private String sigla;
    private LocalDate emancipacao;

    public Integer getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(Integer habitantes) {
        this.habitantes = habitantes;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public LocalDate getEmancipacao() {
        return emancipacao;
    }

    public void setEmancipacao(LocalDate emancipacao) {
        this.emancipacao = emancipacao;
    }

    @Override
    public String toString() {
        return "Cidade{" + "nome=" + nome + '}';
    }
    
    
}
