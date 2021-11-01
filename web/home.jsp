<%-- 
    Document   : home
    Created on : 26/10/2021, 14:59:03
    Author     : Gabriel
--%>

<%-- Optei Jsp por ser uma página da web criada pelo servidor --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/home.css"/>
        <link rel="shortcut icon" href="imagens/hotel.png"/>
        <title>Hotel Morro</title>
    </head>
  <body id="home-page">

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

            <!-- Cabeçalho -->
            <header class="header-welcome">
                <h1>Bem-vindo ao Morro do Paxixi!</h1>
                <h3>O recanto aonde não falta hoteis </h3>
            </header>
        </div>

        <!-- Conteúdo da página principal -->
        <div class="main-content"> 

            <!-- <header id="home-top"></header> -->

            <div class="home-content">

                <!-- Formulário de consulta -->
                <form class="formulario-consulta" method="GET" action="${pageContext.request.contextPath}/consulta">

                    <div class="destino">
                        <label for="destino">Destino</label><br>
                        <input type="text" name="destino" id="destino" required><br>
                    </div>

                    <div class="datas">
                        <div class="entrada">
                            <label for="dataEntrada">Data de check-in</label><br>
                            <input type="date" name="dataEntrada" id="dataEntrada" required><br>
                        </div>

                        <div class="saida">
                            <label for="dataSaida">Data de check-out</label><br>
                            <input type="date" name="dataSaida" id="dataSaida" required><br>
                        </div>
                    </div>

                    <div class="quantidade">
                        <label for="quantidadePessoas">Quantidade hóspedes</label><br>
                        <select name="quantidadePessoas" id="quantidadePessoas">
                            <c:forEach begin="1" end="9" var="qtd">
                                <option value="${qtd}">${qtd}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <input type="submit" value="BUSCAR HOTEL">

                </form>

            </div>

        </div>

    </body>
</html>
