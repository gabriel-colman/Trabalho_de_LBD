<%-- 
    Document   : confirmacao
    Created on : 26/10/2021, 18:09:47
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/swiper.css">
        <link rel="stylesheet" type="text/css" href="styles/confirmacao.css">
        <link rel="shortcut icon" href="imagens/hotel.png"/>
        <title>Confirmação</title>
    </head>
     <body id="confirmacao-page">
        
        <!-- Envoltório do cabeçalho da página Carrinho -->
        <div class="header-wrap home-hw">

            <!-- Container da grade de navegação superior -->
            <div class="container-to-grid">

                <!-- Top bar (logo e opções de navegação) -->
                <nav class="top-bar">

                    <!-- Logotipo do Morro -->
                    <div class="morro">
                        <a href="${pageContext.request.contextPath}/home">
                            <img class="morro" src="imagens/hill.png" alt="morroPa"/>
                        </a>
                    </div>

                    <!-- Seção de opções de navegação -->
                    <div class="top-bar-section">
                        <ul class="options">
                            <li>
                                <a href="${pageContext.request.contextPath}/carrinho">
                                    <img class="carrinho" src="imagens/carrinho.jpg" alt="carrinho"/>
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        
        <!-- Conteúdo da página confirmação -->
        <div class="main-content"> 

            <c:if test="${not empty carrinho.itensCarrinho}">
                <header id="confirmation-top">
                    <div class="page-description">
                        <h1 class="confirmacao1">Confirmação de dados</h1>
                        <p class="confirmacao2">Confirme se seus dados estão corretos</p>
                    </div>
                </header>
            </c:if>

            <div class="confirm-content">
                
                <section class="confirmation-wrap">
            
                    <%-- Estrutura condicional baseada no que verificação de items no carrinho --%>
                    <c:choose>

                        <%-- Verifica se o carrinho está vazio --%>
                        <c:when test="${empty carrinho.itensCarrinho}">
                            <div class="empty-cart">
                                <p class="verificacao">não há reservas em seu nome</p>
                            </div>
                        </c:when>

                        <c:otherwise>
                            
                            <div class="user-container">
                                <div class="person-information">
                                    
                                    <form class="formulario-pessoa">
                                        <fieldset class="user">
                                            <legend>Dados do usuário</legend>

                                            <div id="input-name" class="input-wrap">
                                                <label class="input-wrap-label" for="nome">Nome</label>
                                                <input type="text" id="nome" value="${usuario.nome}" disabled>
                                            </div>

                                            <div id="input-cpf" class="input-wrap">
                                                <label class="input-wrap-label" for="cpf">Cpf</label>
                                                <input type="text" id="cpf" value="${usuario.cpf}" disabled>
                                            </div>

                                            <div id="input-phone" class="input-wrap">
                                                <label class="input-wrap-label" for="telefone">Telefone</label>
                                                <input type="text" id="telefone" value="${usuario.telefone}" disabled>
                                            </div>
                                            
                                            <div id="input-email" class="input-wrap">
                                                <label class="input-wrap-label" for="email">E-mail</label>
                                                <input type="text" id="email" value="${usuario.email}" disabled>
                                            </div>
                                        </fieldset>
                                    </form>
                                            
                                    <form class="formulario-cartao">       
                                        <fieldset class="user">
                                            <legend>Cartão cadastrado</legend>

                                            <div id="input-titular" class="input-wrap">
                                                <label class="input-wrap-label" for="titular">Titular</label>
                                                <input type="text" id="titular" value="${usuario.cartao.titular}" disabled>
                                            </div>

                                            <div id="input-numero-cartao" class="input-wrap">
                                                <label class="input-wrap-label" for="numeroCartao">Número do cartão</label>
                                                <input type="text" id="numeroCartao" value="${usuario.cartao.numeroCartao}" disabled>
                                            </div>

                                            <div id="input-vencimento" class="input-wrap">
                                                <label class="input-wrap-label" for="dataVencimento">Data vencimento</label>
                                                <input type="text" id="dataVencimento" value="${usuario.cartao.vencimento}" disabled>
                                            </div>
                                            
                                            <div id="input-codigo-seguranca" class="input-wrap">
                                                <label class="input-wrap-label" for="codigoSeguranca">Código de seguranca</label>
                                                <input type="text" id="codigoSeguranca" value="${usuario.cartao.codigoSeguranca}" disabled>
                                            </div>
                                        </fieldset>
                                    </form>

                                </div>           
                            </div>
                            
                            <div class="swiper-container">
                                <div class="swiper-wrapper">
                                    
                                    <!--Loop para retornar a lista de acomodações-->
                                    <c:forEach var="itemCarrinho" items="${carrinho.itensCarrinho}">
                                        <div class="swiper-slide">
                                            <div class="descricao">
                                                
                                                <form class="formulario-pessoa">
                                                    <fieldset class="guest">
                                                        <legend>Acomodação</legend>
                                                        <div id="input-value-accommodation" class="input-wrap">
                                                            <label class="input-wrap-label" for="dataEntradaAcomodacao">${itemCarrinho.acomodacao.descricao}</label>
                                                            <input type="hidden" id="valor" value="${itemCarrinho.acomodacao.valor}" disabled>
                                                        </div>
                                                        
                                                        <div id="input-initialdate-accommodation" class="input-wrap">
                                                            <label class="input-wrap-label" for="dataEntradaAcomodacao">Data de entrada</label>
                                                            <input type="text" id="dataEntradaAcomodacao" value="<fmt:formatDate value="${itemCarrinho.dataInicial}" pattern="dd/MM/yyyy" />" disabled>
                                                        </div>
                                                        <div id="input-finaldate-accommodation" class="input-wrap">
                                                            <label class="input-wrap-label" for="dataSaidaAcomodacao">Data de saída</label>
                                                            <input type="text" id="dataSaidaAcomodacao" value="<fmt:formatDate value="${itemCarrinho.dataFinal}" pattern="dd/MM/yyyy" />" disabled>
                                                        </div>
                                                    </fieldset>
                                                        
                                                    <fieldset class="guest">    
                                                        <legend>Hóspede responsável</legend>
                                                        <div id="input-guest-name" class="input-wrap">
                                                            <label class="input-wrap-label" for="nomeHospede">Nome</label>
                                                            <input type="text" id="nomeHospede" value="${itemCarrinho.hospede.nome}" disabled>
                                                        </div>
                                                        <div id="input-guest-cpf" class="input-wrap">
                                                            <label class="input-wrap-label" for="cpfHospede">Cpf</label>
                                                            <input type="text" id="cpfHospede" value="${itemCarrinho.hospede.cpf}" disabled>
                                                        </div>
                                                        <div id="input-guest-phone" class="input-wrap">
                                                            <label class="input-wrap-label" for="telefoneHospede">Telefone</label>
                                                            <input type="text" id="telefoneHospede" value="${itemCarrinho.hospede.telefone}" disabled>
                                                        </div>
                                                    </fieldset>
                                                </form>
                                                            
                                            </div>

                                        </div>
                                    </c:forEach>

                                    <!-- Swiper JS -->
                                   <script src="javascript/swiper.js"></script> 

                                    <!-- Initialize Swiper -->
                                    <script>
                                        var swiper = new Swiper('.swiper-container', {
                                            effect: 'coverflow',
                                            grabCursor: true,
                                            centeredSlides: true,
                                            slidesPerView: 'auto',
                                            coverflowEffect: {
                                                rotate: 50,
                                                stretch: 0,
                                                depth: 100,
                                                modifier: 1,
                                                slideShadows: true,
                                            },
                                            pagination: {
                                                el: '.swiper-pagination',
                                            },
                                        });
                                    </script>
                                    
                                </div>
                                
                                <div class="total-value">
                                    <div class="confirm">
                                        <h2>Valor Total</h2>
                                        <h3>R$ ${carrinho.valorTotal}</h3>
                                        
                                        <%-- Botão para confirmar dados --%>
                                        <a class="complete-purchase" href="${pageContext.request.contextPath}/resultado">Confirmar</a>    
                                    </div>                                    
                                </div>
                                
                            </div>

                        </c:otherwise>
                        
                    </c:choose>
                        
                </section>
                        
            </div>

        </div>

</body>
</html>
