package model.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.ejb.CreateException;
import model.entity.Acomodacao;
import model.entity.Categoria;
import model.entity.Hotel;
import model.entity.UsuarioProprietario;

/**
 *
 * @author Gabriel
 */

// Aqui é feito as operações básicas do hotel
public class HotelManager {

    private final DAO factory;

    public HotelManager() {

        factory = DAO.getFactory();

    }

    public void cadastrarHotel(String nome, int quantidadeEstrela, String telefone, String rua, int numero, String cidade, String estado, String pais, String descricaoHotel, List<Integer> idCategoria, List<String> descricao, List<Double> valor, Integer idProprietario) throws CreateException {
        UsuarioProprietario proprietario = (UsuarioProprietario) factory.buscar(new UsuarioProprietario(), idProprietario);
        Hotel hotel = new Hotel(nome, quantidadeEstrela, telefone, rua, numero, cidade, proprietario, descricaoHotel);
        Collection<Acomodacao> acomodacao = new ArrayList<>();
        List<Categoria> categorias = factory.listar(new Categoria());
        for (int i = 0; i < descricao.size(); i++) {
            Categoria categoria = new Categoria();
            for (Categoria cat : categorias) {
                if (Objects.equals(cat.getIdCategoria(), idCategoria.get(i))) {
                    categoria = cat;
                    break;
                }
            }
            acomodacao.add(new Acomodacao(descricao.get(i), valor.get(i), categoria, hotel));
        }
        hotel.setAcomodacao(acomodacao);
        factory.salvar(hotel);
    }

    public void cadastrarAcomodacao(int idHotel, int idCategoria, String descricao, Double valor) {
        Acomodacao obj = new Acomodacao(descricao, valor, (Categoria) factory.buscar(new Categoria(), idCategoria));
        factory.salvar(obj);
    }

    public void cadastrarCategoria(String descricao) {
        Categoria obj = new Categoria(descricao);
        factory.salvar(obj);
    }

    public void excluirHotel(int id) {
        factory.deletar(factory.buscar(new Hotel(), id));
    }

    public void excluirAcomodacao(int id) {

    }

    public void excluirCategoria() {

    }

    public Hotel buscarHotel(int id) {
        return (Hotel) factory.buscar(new Hotel(), id);
    }

    public Collection<Hotel> listarHotel() {
        return factory.listar(new Hotel());
    }

    public Collection<Hotel> listarHotel(String destino) {
        List<Hotel> lista = factory.listar(new Hotel());
        return lista.stream().filter(x -> x.getCidade().equals(destino)).collect(Collectors.toList());
    }

    public void atualizarHotel(int id, String nome, int quantidadeEstrela, String telefone, String rua, int numero, String cidade, String estado, String pais, String descricaoHotel) {

    }

    public void atualizarAcomodacao(int id, int idHotel, int idCategoria, String descricao, double valor) {

    }

    public void atualizarCategoria(int id, String descricao) {

    }

}
