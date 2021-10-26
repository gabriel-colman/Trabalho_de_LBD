package model.manager;

import java.io.Serializable;
import java.util.Collection;
import model.entity.Reserva;
import model.entity.Carrinho;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import model.entity.Acomodacao;
import model.entity.ItemCarrinho;
import model.entity.ItemReserva;
import model.entity.UsuarioHospede;

/**
 *
 * @author Gabriel
 */
public class ReservaManager {
    private final DAO factory;

    public ReservaManager() {

        factory = DAO.getFactory();

    }

    public Carrinho adicionarCarrinho(int idAcomodacao, int quantidade, Date dataInicial, Date dataFinal, Carrinho carrinho) {
        Acomodacao acomodacao = (Acomodacao) factory.buscar(new Acomodacao(), idAcomodacao);
        for (int i = 0; i < quantidade; i++) {
            ItemCarrinho itemCarrinho = new ItemCarrinho(dataInicial, dataFinal, acomodacao);
            if (carrinho == null) {
                carrinho = new Carrinho();
            }
            carrinho.addItemCarrinho(itemCarrinho);
        }
        return carrinho;
    }

    public Carrinho removerCarrinho(Carrinho carrinho, int idAcomodacao) {
        List<ItemCarrinho> car = carrinho.getItensCarrinho();
        Optional<ItemCarrinho> itemCarrinho = car.stream().filter(x -> x.getAcomodacao().getIdAcomodacao() == idAcomodacao).findFirst();

        carrinho.removeItemCarrinho(itemCarrinho.get());
        return carrinho;
    }

    public void excluirReserva(int idReserva) {

    }

    public void consultarReserva(int idReserva) {

    }

    public void listarReservas(int idUsuario) {

    }

    public void pagarReserva(int idPessoa, int idReserva) {

    }

    public Integer cadastrarReserva(Carrinho carrinho, Integer idUsuarioHospede) {
        UsuarioHospede usuarioHospede = (UsuarioHospede) factory.buscar(new UsuarioHospede(), idUsuarioHospede);
        Collection<ItemReserva> itensReserva = new LinkedList();
        Reserva reserva = new Reserva(usuarioHospede, itensReserva);
        carrinho.getItensCarrinho().forEach(item -> 
                itensReserva.add(new ItemReserva(item.getDataInicial(), item.getDataFinal(), item.getAcomodacao().getValor(), item.getAcomodacao(), item.getHospede(), reserva))
        );
        return (int) factory.salvar(reserva);
    }

}
