<%-- 
    Document   : cadastroLogin
    Created on : 09/11/2021, 22:33:06
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/home.css"/>
        <link rel="shortcut icon" href="imagens/hotel.png"/>
        <title>Cadastro Usuario</title>
    </head>
    <body id="dadoshospede-page">

        <!-- Envoltório do cabeçalho da página Dados hospede -->
        <div class="header-wrap dadoshospede-hw">

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

        <!-- Conteúdo da página principal -->
        <section class="main-content">

            <header id="home-top">
                <div class="form-description">
                    <h2>Formulário do Usuario</h2>
                    <h2>Acomodação - ${descricaoAcomodacao}</h2>
                    <p>Preencha as informações abaixo para podermos cadastrar sua reserva</p>
                </div>
            </header>

            <div class="home-content">
                <div class="form-wrap">

                    <form class="formulario-hospede" method="POST" action="${pageContext.request.contextPath}/login">
                        <fieldset class="personal">
                            <legend>Pessoal</legend>

                            <div id="input-name" class="input-wrap">
                                <label class="input-wrap-label" for="nome">Nome</label>
                                <input type="text" class="form-control name-mask input-wrap-input" id="nome" name="nome" placeholder="Ex.: Gabriel" required>
                            </div>

                            <div id="input-cpf" class="input-wrap">
                                <label class="input-wrap-label" for="cpf">Cpf</label>
                                <input type="text" class="form-control cpf-mask input-wrap-input" id="cpf" name="cpf" placeholder="Ex.: 000.000.000-00" maxlength="14" pattern="[0-9]{3}.?[0-9]{3}.?[0-9]{3}-?[0-9]{2}" required>
                            </div>

                            <div id="input-phone" class="input-wrap">
                                <label class="input-wrap-label-optional" for="telefone">Telefone - </label>
                                <label class="input-wrap-label-optional italic">Optional</label>
                                <input type="text" class="form-control phone-mask input-wrap-input" id="telefone" name="telefone" placeholder="Ex.: (00) 0000-0000" >
                            </div>

                            <div id="input-name" class="input-wrap">
                                <label class="input-wrap-label" for="email">Email</label>
                                <input type="text" class="form-control name-mask input-wrap-input" id="email" name="email" placeholder="Ex.: gabrie@gmail.com" required>
                            </div>

                            <div id="input-password" class="input-wrap">
                                <label class="input-wrap-label" for="senha">Senha</label>
                                <input type="password" class="form-control password-mask input-wrap-input" name="senha" id="senha" autocomplete="off" required>
                            </div>

                        </fieldset>
                        
                        <div id="input-submit" class="input-wrap">
                            <input type="submit" value="Continuar">    
                        </div>

                    </form>

                </div>
            </div>


        </section>

    </body>
</html>