
package model.entity;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "CARTAO")
public class Cartao implements Serializable{

    @Column(nullable = false, length = 255)
    private String titular;

    @Id
    @Column(nullable = false, length = 16)
    private String numeroCartao;

    @Column(nullable = false, length = 255)
    private String vencimento;

    @Column(nullable = false)
    private Integer codigoSeguranca;

    public Cartao() {
    }

    public Cartao(String titular, String numeroCartao, String vencimento, Integer codigoSeguranca) {
        this.titular = titular;
        this.numeroCartao = numeroCartao;
        this.vencimento = vencimento;
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public Integer getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(Integer codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.titular);
        hash = 31 * hash + Objects.hashCode(this.numeroCartao);
        hash = 31 * hash + Objects.hashCode(this.vencimento);
        hash = 31 * hash + Objects.hashCode(this.codigoSeguranca);
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
        final Cartao other = (Cartao) obj;
        if (!Objects.equals(this.titular, other.titular)) {
            return false;
        }
        if (!Objects.equals(this.numeroCartao, other.numeroCartao)) {
            return false;
        }
        if (!Objects.equals(this.vencimento, other.vencimento)) {
            return false;
        }
        if (!Objects.equals(this.codigoSeguranca, other.codigoSeguranca)) {
            return false;
        }
        return true;
    }

}
