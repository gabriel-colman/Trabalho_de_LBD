package model.entity;

/**
 * @author Gabriel
 */
import java.io.Serializable;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ACOMODACAO")
public class Acomodacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acomodacao_sequence")
    @SequenceGenerator(name = "acomodacao_sequence", sequenceName = "acomodacao_seq", allocationSize = 1)
    @Column
    private Integer idAcomodacao;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false)
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idHotel", referencedColumnName = "idHotel")
    private Hotel hotel;

    public Acomodacao() {
    }

    public Acomodacao(String descricao, Double valor, Categoria categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Acomodacao(String descricao, Double valor, Categoria categoria, Hotel hotel) {
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.hotel = hotel;
    }

    public Acomodacao(Integer idAcomodacao, String descricao, Double valor, Categoria categoria) {
        this.idAcomodacao = idAcomodacao;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Acomodacao(Integer idAcomodacao, String descricao, Double valor, Categoria categoria, Hotel hotel) {
        this.idAcomodacao = idAcomodacao;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.hotel = hotel;
    }

    public Integer getIdAcomodacao() {
        return idAcomodacao;
    }

    public void setIdAcomodacao(Integer idAcomodacao) {
        this.idAcomodacao = idAcomodacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idAcomodacao);
        hash = 89 * hash + Objects.hashCode(this.descricao);
        hash = 89 * hash + Objects.hashCode(this.valor);
        hash = 89 * hash + Objects.hashCode(this.categoria);
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
        final Acomodacao other = (Acomodacao) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.idAcomodacao, other.idAcomodacao)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.hotel, other.hotel)) {
            return false;
        }
        return true;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    } 
}
