package model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "ITEMRESERVA")
public class ItemReserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemreserva_sequence")
    @SequenceGenerator(name = "itemreserva_sequence", sequenceName = "itemreserva_seq", allocationSize = 1)
    @Column(nullable = false)
    private Integer idItemReserva;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicial;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFinal;

    @Column(nullable = false)
    private Double valor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAcomodacao", referencedColumnName = "idAcomodacao")
    private Acomodacao acomodacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idHospede", referencedColumnName = "idPessoa")
    private Hospede hospede;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idReserva", referencedColumnName = "idReserva")
    private Reserva reserva;

    public ItemReserva() {
    }

    public ItemReserva(Integer idItemReserva, Date dataInicial, Date dataFinal, Double valor, Acomodacao acomodacao, Hospede hospede, Reserva reserva) {
        this.idItemReserva = idItemReserva;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.valor = valor;
        this.acomodacao = acomodacao;
        this.hospede = hospede;
        this.reserva = reserva;
    }

    public ItemReserva(Integer idItemReserva, Date dataInicial, Date dataFinal, Double valor, Acomodacao acomodacao, Hospede hospede) {
        this.idItemReserva = idItemReserva;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.valor = valor;
        this.acomodacao = acomodacao;
        this.hospede = hospede;
    }

    public ItemReserva(Date dataInicial, Date dataFinal, Double valor, Acomodacao acomodacao, Hospede hospede) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.valor = valor;
        this.acomodacao = acomodacao;
        this.hospede = hospede;
    }

    public ItemReserva(Date dataInicial, Date dataFinal, Double valor, Acomodacao acomodacao, Hospede hospede, Reserva reserva) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.valor = valor;
        this.acomodacao = acomodacao;
        this.hospede = hospede;
        this.reserva = reserva;
    }

    public Integer getIdItemReserva() {
        return idItemReserva;
    }

    public void setIdItemReserva(Integer idItemReserva) {
        this.idItemReserva = idItemReserva;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(Acomodacao acomodacao) {
        this.acomodacao = acomodacao;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idItemReserva);
        hash = 97 * hash + Objects.hashCode(this.dataInicial);
        hash = 97 * hash + Objects.hashCode(this.dataFinal);
        hash = 97 * hash + Objects.hashCode(this.valor);
        hash = 97 * hash + Objects.hashCode(this.acomodacao);
        hash = 97 * hash + Objects.hashCode(this.hospede);
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
        final ItemReserva other = (ItemReserva) obj;
        if (!Objects.equals(this.idItemReserva, other.idItemReserva)) {
            return false;
        }
        if (!Objects.equals(this.dataInicial, other.dataInicial)) {
            return false;
        }
        if (!Objects.equals(this.dataFinal, other.dataFinal)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.acomodacao, other.acomodacao)) {
            return false;
        }
        if (!Objects.equals(this.hospede, other.hospede)) {
            return false;
        }
        if (!Objects.equals(this.reserva, other.reserva)) {
            return false;
        }
        return true;
    }

}
