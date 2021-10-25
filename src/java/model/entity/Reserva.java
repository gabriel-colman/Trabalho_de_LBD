package model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "RESERVA")
public class Reserva implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserva_sequence")
    @SequenceGenerator(name = "reserva_sequence", sequenceName = "reserva_seq", allocationSize = 1)
    @Column(nullable = false)
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "idUsuarioHospede", referencedColumnName = "idPessoa")
    private UsuarioHospede usuarioHospede;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
    private Collection<ItemReserva> itemReserva;

    public Reserva() {
    }

    public Reserva(Integer idReserva, UsuarioHospede usuarioHospede, Collection<ItemReserva> itemReserva) {
        this.idReserva = idReserva;
        this.usuarioHospede = usuarioHospede;
        this.itemReserva = itemReserva;
    }

    public Reserva(Integer idReserva, Collection<ItemReserva> itemReserva) {
        this.idReserva = idReserva;
        this.itemReserva = itemReserva;
    }

    public Reserva(UsuarioHospede usuarioHospede, Collection<ItemReserva> itemReserva) {
        this.usuarioHospede = usuarioHospede;
        this.itemReserva = itemReserva;
    }
    
    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Collection<ItemReserva> getItemReserva() {
        return itemReserva;
    }

    public void setItemReserva(Collection<ItemReserva> itemReserva) {
        this.itemReserva = itemReserva;
    }

    public UsuarioHospede getUsuarioHospede() {
        return usuarioHospede;
    }

    public void setUsuarioHospede(UsuarioHospede usuarioHospede) {
        this.usuarioHospede = usuarioHospede;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.idReserva);
        hash = 31 * hash + Objects.hashCode(this.itemReserva);
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
        final Reserva other = (Reserva) obj;
        if (!Objects.equals(this.idReserva, other.idReserva)) {
            return false;
        }
        if (!Objects.equals(this.usuarioHospede, other.usuarioHospede)) {
            return false;
        }
        if (!Objects.equals(this.itemReserva, other.itemReserva)) {
            return false;
        }
        return true;
    }

}
