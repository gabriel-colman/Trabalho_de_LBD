package model.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Gabriel
 */

@Entity
@Table(name = "HOSPEDE")
public class Hospede extends Pessoa implements Serializable {

    @Column(nullable = false, length = 255)
    private String rua;

    @Column(nullable = false)
    private Integer numeroCasa;

    @Column(nullable = false, length = 255)
    private String cidade;

    @Column(nullable = false, length = 255)
    private String estado;

    @Column(nullable = false, length = 255)
    private String pais;

    public Hospede() {
    }

    public Hospede(String rua, Integer numeroCasa, String cidade, String estado, String pais) {
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Hospede(String nome, String cpf, String telefone, String rua, Integer numeroCasa, String cidade, String estado, String pais) {
        super(nome, cpf, telefone);
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Hospede(Integer id, String nome, String cpf, String telefone, String rua, Integer numeroCasa, String cidade, String estado, String pais) {
        super(id, nome, cpf, telefone);
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Hospede(String rua, Integer numeroCasa, String cidade, String estado, String pais, String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Hospede(String rua, Integer numeroCasa, String cidade, String estado, String pais, Integer id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.rua);
        hash = 53 * hash + Objects.hashCode(this.numeroCasa);
        hash = 53 * hash + Objects.hashCode(this.cidade);
        hash = 53 * hash + Objects.hashCode(this.estado);
        hash = 53 * hash + Objects.hashCode(this.pais);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hospede other = (Hospede) obj;
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        if (!Objects.equals(this.numeroCasa, other.numeroCasa)) {
            return false;
        }
        return true;
    }

}

