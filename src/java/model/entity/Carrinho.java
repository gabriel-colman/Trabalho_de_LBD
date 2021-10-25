package model.entity;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Carrinho {
    private float valorTotal;

    private List<ItemCarrinho> itensCarrinho;

    public Carrinho() {
        itensCarrinho = new LinkedList<ItemCarrinho>();
    }

    public Carrinho(LinkedList<ItemCarrinho> carrinho) {
        this.itensCarrinho = carrinho;
        setValorTotal();
    }

    public float getValorTotal() {
        return valorTotal;
    }

    private void setValorTotal() {
        valorTotal = 0;

        itensCarrinho.forEach((ic) -> {
            valorTotal += ic.getAcomodacao().getValor() * ic.getPeriodo();
        });
    }

    public List<ItemCarrinho> getItensCarrinho() {
        return itensCarrinho;
    }

    public void addItemCarrinho(ItemCarrinho itemCarrinho) {
        itensCarrinho.add(itemCarrinho);
        setValorTotal();
    }

    public void removeItemCarrinho(ItemCarrinho itemCarrinho) {
        itensCarrinho.remove(itemCarrinho);
        setValorTotal();
    }

    public void addHospedeItemCarrinho(int qtdHospede, Hospede hospede) {
        itensCarrinho.get(qtdHospede).setHospede(hospede);
    }

}
