package com.coleta.monetiza.model;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Conta implements Serializable {
	public Conta(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    private static final long serialVersionUID = -4205156507257923921L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Integer agencia;
	private String numero;
	private String titular;
	private Double saldo;
    public Integer getAgencia() {
        return agencia;
    }
    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public void setId(Long newId) {

        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}