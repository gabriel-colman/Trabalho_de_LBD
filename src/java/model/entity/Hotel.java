package model.entity;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "HOTEL")
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_sequence")
    @SequenceGenerator(name = "hotel_sequence", sequenceName = "hotel_seq", allocationSize = 1)
    @Column
    private Integer idHotel;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false)
    private Integer quantidadeEstrela;

    @Column(nullable = false, length = 255)
    private String telefone;

    @Column(nullable = false, length = 255)
    private String rua;

    @Column(nullable = false)
    private Integer numeroHotel;

    @Column(nullable = false, length = 255)
    private String cidade;

//    @Column(nullable = false, length = 255)
//    private String estado;
//
//    @Column(nullable = false, length = 255)
//    private String pais;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProprietario", referencedColumnName = "idPessoa")
    private UsuarioProprietario proprietario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel", fetch = FetchType.EAGER)
    private Collection<Acomodacao> acomodacao;

    @Column(nullable = false, length = 255)
    private String descricao;

    public Hotel() {
    }

    public Hotel(String nome, Integer quantidadeEstrela, String telefone, String rua, Integer numeroHotel, String cidade, String estado, String pais, Collection<Acomodacao> acomodacao, UsuarioProprietario proprietario, String descricao) {
        this.nome = nome;
        this.quantidadeEstrela = quantidadeEstrela;
        this.telefone = telefone;
        this.rua = rua;
        this.numeroHotel = numeroHotel;
        this.cidade = cidade;
//        this.estado = estado;
//        this.pais = pais;
        this.acomodacao = acomodacao;
        this.proprietario = proprietario;
    }

    public Hotel(String nome, Integer quantidadeEstrela, String telefone, String rua, Integer numeroHotel, String cidade, UsuarioProprietario proprietario, String descricao) {
        this.nome = nome;
        this.quantidadeEstrela = quantidadeEstrela;
        this.telefone = telefone;
        this.rua = rua;
        this.numeroHotel = numeroHotel;
        this.cidade = cidade;
//        this.estado = estado;
//        this.pais = pais;
        this.proprietario = proprietario;
        this.descricao = descricao;
    }

    public Hotel(String nome, Integer quantidadeEstrela, String telefone, String rua, Integer numeroHotel, String cidade) {
        this.nome = nome;
        this.quantidadeEstrela = quantidadeEstrela;
        this.telefone = telefone;
        this.rua = rua;
        this.numeroHotel = numeroHotel;
        this.cidade = cidade;
//        this.estado = estado;
//        this.pais = pais;
    }

    public Hotel(Integer idHotel, String nome, Integer quantidadeEstrela, String telefone, String rua, Integer numeroHotel, String cidade, String estado, String pais, Collection<Acomodacao> acomodacao, UsuarioProprietario proprietario, String descricao) {
        this.idHotel = idHotel;
        this.nome = nome;
        this.quantidadeEstrela = quantidadeEstrela;
        this.telefone = telefone;
        this.rua = rua;
        this.numeroHotel = numeroHotel;
        this.cidade = cidade;
//        this.estado = estado;
//        this.pais = pais;
        this.acomodacao = acomodacao;
        this.proprietario = proprietario;
        this.descricao = descricao;
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeEstrela() {
        return quantidadeEstrela;
    }

    public void setQuantidadeEstrela(Integer quantidadeEstrela) {
        this.quantidadeEstrela = quantidadeEstrela;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumeroHotel() {
        return numeroHotel;
    }

    public void setNumeroHotel(Integer numeroHotel) {
        this.numeroHotel = numeroHotel;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

//    public String getEstado() {
//        return estado;
//    }
//
//    public void setEstado(String estado) {
//        this.estado = estado;
//    }
//
//    public String getPais() {
//        return pais;
//    }
//
//    public void setPais(String pais) {
//        this.pais = pais;
//    }

    public Collection<Acomodacao> getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(Collection<Acomodacao> acomodacao) {
        this.acomodacao = acomodacao;
    }

    public UsuarioProprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(UsuarioProprietario proprietario) {
        this.proprietario = proprietario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Hotel(Integer idHotel, String nome, Integer quantidadeEstrela, String telefone, String rua, Integer numeroHotel, String cidade, String estado, String pais, UsuarioProprietario proprietario, Collection<Acomodacao> acomodacao, String descricao) {
        this.idHotel = idHotel;
        this.nome = nome;
        this.quantidadeEstrela = quantidadeEstrela;
        this.telefone = telefone;
        this.rua = rua;
        this.numeroHotel = numeroHotel;
        this.cidade = cidade;
//        this.estado = estado;
//        this.pais = pais;
        this.proprietario = proprietario;
        this.acomodacao = acomodacao;
        this.descricao = descricao;

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.idHotel);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.quantidadeEstrela);
        hash = 89 * hash + Objects.hashCode(this.telefone);
        hash = 89 * hash + Objects.hashCode(this.rua);
        hash = 89 * hash + Objects.hashCode(this.numeroHotel);
        hash = 89 * hash + Objects.hashCode(this.cidade);
//        hash = 89 * hash + Objects.hashCode(this.estado);
//        hash = 89 * hash + Objects.hashCode(this.pais);
        hash = 89 * hash + Objects.hashCode(this.descricao);
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
        final Hotel other = (Hotel) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
//        if (!Objects.equals(this.estado, other.estado)) {
//            return false;
//        }
//        if (!Objects.equals(this.pais, other.pais)) {
//            return false;
//        }
        if (!Objects.equals(this.idHotel, other.idHotel)) {
            return false;
        }
        if (!Objects.equals(this.quantidadeEstrela, other.quantidadeEstrela)) {
            return false;
        }
        if (!Objects.equals(this.numeroHotel, other.numeroHotel)) {
            return false;
        }
        if (!Objects.equals(this.proprietario, other.proprietario)) {
            return false;
        }
        if (!Objects.equals(this.acomodacao, other.acomodacao)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

}
