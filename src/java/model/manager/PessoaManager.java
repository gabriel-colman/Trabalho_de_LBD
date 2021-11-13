package model.manager;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import model.entity.Cartao;
import model.entity.Hospede;
import model.entity.Pessoa;
import model.entity.Usuario;
import model.entity.UsuarioHospede;
import model.entity.UsuarioProprietario;

/**
 *
 * @author Gabriel
 */
public class PessoaManager {

    private final DAO factory;

    public PessoaManager() {

        factory = DAO.getFactory();

    }

    public Usuario realizarLogin(String email, String senha) {

        List<Usuario> usuarios = factory.listar(new Usuario());

        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                return u;
            }
        }

        return null;

    }

    public Hospede cadastrarHospede(String nome, String cpf, String telefone, String rua, int numeroCasa, String cidade, String estado, String pais) {
        List<Hospede> buscar = factory.listar(new Hospede());
        Optional<Hospede> findFirst = buscar.stream().filter(x -> x.getCpf().equals(cpf)).findFirst();
        Hospede hospede = null;
        if (findFirst.isPresent()) {
            hospede = findFirst.get();
        }
        int id;
        if (hospede == null) {
            hospede = new Hospede(nome, cpf, telefone, rua, numeroCasa, cidade, estado, pais);
            id = (int) factory.salvar(hospede);
            hospede = (Hospede) factory.buscar(new Hospede(), id);
        }
        return hospede;

    }

     public Usuario cadastrarUsuario(Integer id, String nome, String cpf, String telefone, String email, String senha) {
        List<Usuario> buscar = factory.listar(new Usuario());
        Optional<Usuario> findFirst = buscar.stream().filter(x -> x.getCpf().equals(cpf)).findFirst();
        Usuario usuario = null;
        if (findFirst.isPresent()) {
            usuario = findFirst.get();
        }
        int id1;
        if (usuario == null) {
            usuario = new Usuario(email, senha, id, nome, cpf, telefone);
            id1 = (int) factory.salvar(usuario);
            usuario = (Usuario) factory.buscar(new Usuario(), id);
        }
        return usuario;
    }
    
    public Serializable cadastrarUsuarioHospede(String nome, String email, String senha, String cpf, String telefone) {

        UsuarioHospede usuarioHospede = new UsuarioHospede(nome, cpf, telefone, email, senha);

        return factory.salvar(usuarioHospede);

    }
   
    
    public Serializable cadastrarUsuarioProprietario(String nome, String email, String senha, String cpf, String telefone) {

        UsuarioProprietario usuarioProprietario = new UsuarioProprietario(nome, cpf, telefone, email, senha);

        return factory.salvar(usuarioProprietario);

    }

    public boolean excluirPessoa(int id) {

        Pessoa pessoa = (Pessoa) factory.buscar(new Pessoa(), id);

        boolean sucesso = false;

        if (pessoa != null) {
            sucesso = factory.deletar(pessoa);
        }

        return sucesso;

    }

    public Hospede consultarHospede(int id) {

        return (Hospede) factory.buscar(new Hospede(), id);

    }

    public UsuarioHospede consultarUsuarioHospede(int id) {

        return (UsuarioHospede) factory.buscar(new UsuarioHospede(), id);

    }

    public UsuarioProprietario consultarUsuarioProprietario(int id) {

        return (UsuarioProprietario) factory.buscar(new UsuarioProprietario(), id);

    }

    public Serializable cadastrarCartao(String titular, String numeroCartao, String vencimento, int codigoSeguranca, int idUsuarioHospede) {
        UsuarioHospede usuarioHospede = (UsuarioHospede) factory.buscar(new UsuarioHospede(), idUsuarioHospede);
        if (usuarioHospede != null && usuarioHospede.getCartao() == null) {
            Cartao cartao = new Cartao(titular, numeroCartao, vencimento, codigoSeguranca);
            usuarioHospede.setCartao(cartao);
            factory.editar(usuarioHospede);
            return factory.salvar(cartao);
        }
        return usuarioHospede.getCartao();
    }

    public boolean atualizarHospede(int id, String nome, String cpf, String telefone, String rua, int numeroCasa, String cidade, String estado, String pais) {

        Hospede hospede = (Hospede) factory.buscar(new Hospede(), id);

        boolean sucesso = false;

        if (hospede != null) {
            hospede.setNome(nome);
            hospede.setCpf(cpf);
            hospede.setTelefone(telefone);
            hospede.setRua(rua);
            hospede.setNumeroCasa(numeroCasa);
            hospede.setCidade(cidade);
            hospede.setEstado(estado);
            hospede.setPais(pais);

            sucesso = factory.editar(hospede);
        }

        return sucesso;

    }

    public boolean atualizarUsuarioHospede(int id, String nome, String email, String senha, String cpf, String telefone) {

        UsuarioHospede usuarioHospede = (UsuarioHospede) factory.buscar(new UsuarioHospede(), id);

        boolean sucesso = false;

        if (usuarioHospede != null) {
            usuarioHospede.setNome(nome);
            usuarioHospede.setEmail(email);
            usuarioHospede.setSenha(senha);
            usuarioHospede.setCpf(cpf);
            usuarioHospede.setTelefone(telefone);

            sucesso = factory.editar(usuarioHospede);
        }

        return sucesso;

    }

    public boolean atualizarUsuarioProprietario(int id, String nome, String email, String senha, String cpf, String telefone) {

        UsuarioProprietario usuarioProprietario = (UsuarioProprietario) factory.buscar(new UsuarioProprietario(), id);

        boolean sucesso = false;

        if (usuarioProprietario != null) {
            usuarioProprietario.setNome(nome);
            usuarioProprietario.setEmail(email);
            usuarioProprietario.setSenha(senha);
            usuarioProprietario.setCpf(cpf);
            usuarioProprietario.setTelefone(telefone);

            sucesso = factory.editar(usuarioProprietario);
        }

        return sucesso;

    }

}
