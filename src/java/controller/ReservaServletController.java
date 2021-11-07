package controller;

import model.entity.Carrinho;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import model.manager.*;
import model.entity.*;

/**
 *
 * @author Gabriel
 */
// Para utilizar o conteiner GlassFish
public class ReservaServletController extends HttpServlet {
    
    //É declarada as classes que fazem o (crud) e colocom no banco de dados,
    // Ou seja recebendo do browser, chamando as funcionalidades das classes modelos e colocando no banco de dados
    HotelManager hotelManager = new HotelManager();
    PessoaManager pessoaManager = new PessoaManager();
    ReservaManager reservaManager = new ReservaManager();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jsp = null;

        if (request.getRequestURI().endsWith("/home")) {
            jsp = "/home.jsp";
        } else if (request.getRequestURI().endsWith("/carrinho")) {
            if (request.getParameter("adicionar") != null) {
                adicionarCarrinho(request);
            } else if (request.getParameter("remover") != null) {
                removerCarrinho(request);
            }
            jsp = "/carrinho.jsp";
        } else if (request.getRequestURI().endsWith("/confirmacao")) {
            dadosPagamento(request);
            jsp = "/confirmacao.jsp";
        } else if (request.getRequestURI().endsWith("/consulta")) {
            consulta(request);
            jsp = "/consulta.jsp";
        } else if (request.getRequestURI().endsWith("/login")) {
            request.getSession().setAttribute("qtdHospede", 0);
            request.getSession().setAttribute("descricaoAcomodacao", ((Carrinho) request.getSession().getAttribute("carrinho"))
                    .getItensCarrinho().get(
                            (int) request.getSession().getAttribute("qtdHospede")).getAcomodacao().getDescricao()
            );
            if (request.getSession().getAttribute("usuario") == null) {
                jsp = "/login.jsp";
            } else {
                jsp = "/dadoshospede.jsp";
            }
        } else if (request.getRequestURI().endsWith("/dadoshospede")) {
            login(request);
            if (request.getSession().getAttribute("usuario") == null) {
                jsp = "/login.jsp";
                request.getSession().setAttribute("acesso", 0);
            } else {
                jsp = "/dadoshospede.jsp";
            }
        } else if (request.getRequestURI().endsWith("/detalhes")) {
            detalhe(request);
            jsp = "/detalhes.jsp";
        } else if (request.getRequestURI().endsWith("/pagamento")) {
            dadosHospede(request);
            if (Integer.parseInt(request.getSession().getAttribute("qtdHospede").toString()) < ((Carrinho) request.getSession().getAttribute("carrinho")).getItensCarrinho().size()) {
                jsp = "/dadoshospede.jsp";
            } else {
                jsp = "/pagamento.jsp";
            }
        } else if (request.getRequestURI().endsWith("/resultado")) {
            salvarReserva(request);
            jsp = "/resultado.jsp";
        } else if (request.getRequestURI().endsWith("/login")) {
            jsp = "/login.jsp";
        }

        request.getRequestDispatcher(jsp).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void consulta(HttpServletRequest request) {
        String destino = request.getParameter("destino");
        String dataEntrada = request.getParameter("dataEntrada");
        String dataSaida = request.getParameter("dataSaida");
        int qtdPessoas = Integer.parseInt(request.getParameter("quantidadePessoas"));
        Collection<Hotel> resultadoConsulta = hotelManager.listarHotel(destino);
        request.setAttribute("consulta", resultadoConsulta);
        request.setAttribute("destino", destino);
        request.setAttribute("dataEntrada", dataEntrada);
        request.setAttribute("dataSaida", dataSaida);
        request.setAttribute("qtdPessoas", qtdPessoas);
    }

    public void detalhe(HttpServletRequest request) {
        int idHotel = Integer.parseInt(request.getParameter("idHotel"));
        Hotel hotel = hotelManager.buscarHotel(idHotel);
        request.setAttribute("hotel", hotel);
        String dataEntrada = request.getParameter("dataEntrada");
        String dataSaida = request.getParameter("dataSaida");
        request.setAttribute("dataEntrada", dataEntrada);
        request.setAttribute("dataSaida", dataSaida);
    }

    public void adicionarCarrinho(HttpServletRequest request) {

        Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");

        int idAcomodacao = Integer.parseInt(request.getParameter("idAcomodacao"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dataEntrada = format.parse((String) request.getParameter("dataEntrada"));
            Date dataSaida = format.parse((String) request.getParameter("dataSaida"));
            carrinho = reservaManager.adicionarCarrinho(idAcomodacao, quantidade, dataEntrada, dataSaida, carrinho);
        } catch (ParseException ex) {
            Logger.getLogger(ReservaServletController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        request.getSession().setAttribute("carrinho", carrinho);
    }

    public void removerCarrinho(HttpServletRequest request) {
        Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");

        int idAcomodacao = Integer.parseInt(request.getParameter("idAcomodacao"));

        carrinho = reservaManager.removerCarrinho(carrinho, idAcomodacao);
        request.getSession().setAttribute("carrinho", carrinho);
    }

    private void login(HttpServletRequest request) {

        if (request.getSession().getAttribute("usuario") == null) {
            String login = request.getParameter("email");
            String senha = request.getParameter("senha");

            Usuario usuario = pessoaManager.realizarLogin(login, senha);
            request.getSession().setAttribute("usuario", usuario);
        }
    }

    public void dadosHospede(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String rua = request.getParameter("rua");
        int numCasa = Integer.parseInt(request.getParameter("numeroCasa"));
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String pais = request.getParameter("pais");

        Hospede hospede = pessoaManager.cadastrarHospede(nome, cpf, telefone, rua, numCasa, cidade, estado, pais);
        int qtdHospede = Integer.parseInt(request.getParameter("itemCarrinho"));
        Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
        carrinho.addHospedeItemCarrinho(qtdHospede, hospede);
        request.getSession().setAttribute("qtdHospede", ++qtdHospede);
        if ((int) request.getSession().getAttribute("qtdHospede") < carrinho.getItensCarrinho().size())
        request.getSession().setAttribute("descricaoAcomodacao", ((Carrinho) request.getSession().getAttribute("carrinho"))
                    .getItensCarrinho().get(
                            (int) request.getSession().getAttribute("qtdHospede")).getAcomodacao().getDescricao()
            );
    }

    public void dadosPagamento(HttpServletRequest request) {
        String titular = request.getParameter("titular");
        String numCartao = request.getParameter("numeroCartao");
        String vencimento = request.getParameter("vencimento");
        int codSeguranca = Integer.parseInt(request.getParameter("codigoSeguranca"));
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        pessoaManager.cadastrarCartao(titular, numCartao, vencimento, codSeguranca, usuario.getIdPessoa());
    }

    public void salvarReserva(HttpServletRequest request) {
        Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        Integer idReserva = reservaManager.cadastrarReserva(carrinho, usuario.getIdPessoa());
        request.setAttribute("idReserva", idReserva);
        request.getSession().setAttribute("carrinho", null);
    }


}
