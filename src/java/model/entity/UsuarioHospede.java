package model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "USUARIOHOSPEDE")
public class UsuarioHospede extends Usuario implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "numeroCartao", referencedColumnName = "numeroCartao")
    private Cartao cartao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Reserva> reserva;

    public UsuarioHospede() {
    }

    public UsuarioHospede(Cartao cartao, Collection<Reserva> reserva) {
        this.cartao = cartao;
        this.reserva = reserva;
    }

    public UsuarioHospede(String nome, String cpf, String telefone, String email, String senha) {
        super(nome, cpf, telefone, email, senha);
    }

    public UsuarioHospede(String email, String senha, Cartao cartao, Collection<Reserva> reserva) {
        super(email, senha);
        this.cartao = cartao;
        this.reserva = reserva;
    }

    public UsuarioHospede(Cartao numeroCartao, Collection<Reserva> reserva, String email, String senha) {
        super(email, senha);
        this.cartao = numeroCartao;
        this.reserva = reserva;
    }

    public UsuarioHospede(String nome, String cpf, String telefone, String email, String senha, Cartao cartao, Collection<Reserva> reserva) {
        super(nome, cpf, telefone, email, senha);
        this.cartao = cartao;
        this.reserva = reserva;
    }

    public UsuarioHospede(Integer id, String nome, String cpf, String telefone, String email, String senha, Cartao cartao, Collection<Reserva> reserva) {
        super(id, nome, cpf, telefone, email, senha);
        this.cartao = cartao;
        this.reserva = reserva;
    }

    public UsuarioHospede(Cartao numeroCartao, Collection<Reserva> reserva, String nome, String cpf, String telefone, String email, String senha) {
        super(nome, cpf, telefone, email, senha);
        this.cartao = numeroCartao;
        this.reserva = reserva;
    }

    public UsuarioHospede(Cartao numeroCartao, Collection<Reserva> reserva, Integer id, String nome, String cpf, String telefone, String email, String senha) {
        super(id, nome, cpf, telefone, email, senha);
        this.cartao = numeroCartao;
        this.reserva = reserva;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Collection<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(Collection<Reserva> reserva) {
        this.reserva = reserva;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.cartao);
        hash = 31 * hash + Objects.hashCode(this.reserva);
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
        final UsuarioHospede other = (UsuarioHospede) obj;
        if (!Objects.equals(this.cartao, other.cartao)) {
            return false;
        }
        if (!Objects.equals(this.reserva, other.reserva)) {
            return false;
        }
        return true;
    }

}
