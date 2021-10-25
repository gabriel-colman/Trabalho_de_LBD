package model.entity;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Gabriel
 */
public class ItemCarrinho {

    private Date dataInicial;
    private Date dataFinal;
    private int periodo;
    private Acomodacao acomodacao;
    private Hospede hospede;

    public ItemCarrinho() {
    }

    public ItemCarrinho(Date dataInicial, Date dataFinal, Acomodacao acomodacao) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.acomodacao = acomodacao;
        this.periodo = (int) TimeUnit.DAYS.convert(dataFinal.getTime() - dataInicial.getTime(), TimeUnit.MILLISECONDS);
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
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

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

}
