package model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "USUARIOPROPRIETARIO")
public class UsuarioProprietario extends Usuario implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proprietario")
    private Collection<Hotel> hotel;

    public UsuarioProprietario() {
    }

    public UsuarioProprietario(Collection<Hotel> hotel) {
        this.hotel = hotel;
    }

    public UsuarioProprietario(String email, String senha, Collection<Hotel> hotel) {
        super(email, senha);
        this.hotel = hotel;
    }

    public UsuarioProprietario(Collection<Hotel> hotel, String email, String senha) {
        super(email, senha);
        this.hotel = hotel;
    }

    public UsuarioProprietario(String nome, String cpf, String telefone, String email, String senha) {
        super(nome, cpf, telefone, email, senha);
    }

    public UsuarioProprietario(String nome, String cpf, String telefone, String email, String senha, Collection<Hotel> hotel) {
        super(nome, cpf, telefone, email, senha);
        this.hotel = hotel;
    }

    public UsuarioProprietario(Integer id, String nome, String cpf, String telefone, String email, String senha, Collection<Hotel> hotel) {
        super(id, nome, cpf, telefone, email, senha);
        this.hotel = hotel;
    }

    public UsuarioProprietario(Collection<Hotel> hotel, String nome, String cpf, String telefone, String email, String senha) {
        super(nome, cpf, telefone, email, senha);
        this.hotel = hotel;
    }

    public UsuarioProprietario(Collection<Hotel> hotel, Integer id, String nome, String cpf, String telefone, String email, String senha) {
        super(id, nome, cpf, telefone, email, senha);
        this.hotel = hotel;
    }

    public Collection<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(Collection<Hotel> hotel) {
        if (this.hotel == null) {
            this.hotel = new LinkedList<Hotel>();
        }
        this.hotel = hotel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.hotel);
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
        final UsuarioProprietario other = (UsuarioProprietario) obj;
        if (!Objects.equals(this.hotel, other.hotel)) {
            return false;
        }
        return true;
    }

}
