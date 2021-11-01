<%-- 
    Document   : detalhes
    Created on : 26/10/2021, 22:20:03
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Detalhes Hotel</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
        <link rel="stylesheet" type="text/css" href="styles/swiper.css">
        <link rel="stylesheet" type="text/css" href="styles/detalhe.css">
        <link rel="shortcut icon" href="imagens/hotel.png"/>
    </head>
    <body id="detalhes-page">

        <!-- Envoltório do cabeçalho -->
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

        <div class="informacaohotel">     
            <!--Informa o nome da Pousada-->
            <h2>${hotel.nome}</h2>

            <!--Informa o endereco-->
            <p>${hotel.rua}, ${hotel.cidade} - ${hotel.estado}, ${hotel.pais}</p>

            <h3>Confira as fotos do Hotel</h3>
        </div>

        <!-- Swiper -->
        <div class="swiper-container">
            <div class="swiper-wrapper">
                <!--Apresenta as imagens do hotel-->
                <c:forEach var="nmr" begin="1" end="7">
                    <div class="swiper-slide">
                        <div class="img">
                            <img src="hotel/${hotel.idHotel}/${nmr}.jpg" alt="hotel">                            
                        </div>
                        <div class="detalhes">
                            <h3>Hotel<br><span>${hotel.nome}</span></h3>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>

        <!-- Add Pagination -->
        <div class="swiper-pagination"></div>



        <!-- Swiper JS -->
        <script src="javascript/swiper.min.js"></script> 

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
                    slideShadows: true
                },
                pagination: {
                    el: '.swiper-pagination'
                }
            });
        </script>
        <!--Apresenta a descricao do hotel-->
        <div class="descricao">
            <p>
                ${hotel.descricao}    
            </p>

        </div>
        <!--Verifica se existe acomodacoes relacionada ao hotel-->
        <c:choose>
            <c:when test="${empty hotel.acomodacao}">
                <p>- N&atilde;o h&aacute; acomodações para esse hotel </p>
            </c:when>
            <c:otherwise>
                <!--Apresenta as acomodacoes do hotel-->
                <div class="acomodacoes">

                    <!--Tabbelas com as acomodacoes-->
                    <table class="lista-acomodacao">
                        <tr>
                            <th>Tipo de  Quarto</th>
                            <th>Selecionar nº de quartos</th>
                            <th>Preço</th>
                            <th></th>
                        </tr>
                        <c:forEach var="acomodacoes" items="${hotel.acomodacao}">
                            <form method="POST" action="${pageContext.request.contextPath}/carrinho">
                                <tr>
                                    <td>${acomodacoes.descricao} </td>

                                    <td>
                                        <select name="quantidade" id="${acomodacoes.idAcomodacao}">
                                            <option value="0">0</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select> 
                                    </td>
                                    <td> R$ ${acomodacoes.valor} </td>
                                    <td>
                                        <input type="hidden" id="idAcomodacao" name="idAcomodacao" value="${acomodacoes.idAcomodacao}">
                                        <input type="hidden" id="dataEntrada" name="dataEntrada" value="${dataEntrada}">
                                        <input type="hidden" id="dataSaida" name="dataSaida" value="${dataSaida}">
                                        <input type="submit" value="Vou Reservar" id="adicionar" name="adicionar"></td>

                                </tr>
                            </form>
                        </c:forEach>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
        <footer>

        </footer>
    </body>
</html>
