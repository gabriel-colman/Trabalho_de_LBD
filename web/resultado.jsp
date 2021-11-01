<%-- 
    Document   : resultado
    Created on : 01/11/2021, 11:21:02
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/home.css"/>
        <link rel="shortcut icon" href="imagens/hotel.png"/>
        <title>Resultado</title>
    </head>
    <body id="resultado-page">
        
        <!-- Envoltório do cabeçalho da página resultado -->
        <div class="header-wrap carrinho-hw">

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
                </nav>
            </div>
        </div>
                            
        <!-- Conteúdo da página resultado -->
        <section class="main-content">

            <header id="home-top">
                <div class="result-mensage">
                    <c:choose>
                        <c:when test="${not empty idReserva}">
                            <h1 class="good-travel">Sua reserva foi realizada com sucesso!</h1>
                            <h2 class="good-travel">O número de pedido de sua reserva é ${idReserva}</h2>
                            <h2 class="email-response">Informações adicionais serão enviadas ao endereço de email ${usuario.email}</h2>
                            <h2 class="good-travel">Desejamos uma boa viagem ${usuario.nome}!</h2>
                        </c:when>
                        <c:when test="${empty idReserva}">
                            <h1 class="error">Desculpe pelo transtorno! Tivemos um problema durante o registro de sua reserva</h1>
                            <h2 class="error">Aguarde alguns minutos e tente novamente</h2>
                        </c:when>
                    </c:choose>
                </div>
            </header>
        </section>
    </body>
</html>

