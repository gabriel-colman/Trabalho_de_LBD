<%-- 
    Document   : dadoshospede
    Created on : 26/10/2021, 19:17:07
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/home-carrinho-login-dadoshospedes-resultado.css"/>
        <link rel="shortcut icon" href="imagens/hotel.png"/>
        <title>Dados hospede</title>
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
                    <h2>Formulário de hóspede - ${qtdHospede+1}/${fn:length(carrinho.itensCarrinho)}</h2>
                    <h2>Acomodação - ${descricaoAcomodacao}</h2>
                    <p>Preencha as informações abaixo para podermos cadastrar sua reserva</p>
                </div>
            </header>

            <div class="home-content">
                <div class="form-wrap">

                    <form class="formulario-hospede" method="POST" action="${pageContext.request.contextPath}/pagamento">
                        <input type="hidden" id="itemCarrinho" name="itemCarrinho" value="${qtdHospede}">
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

                        </fieldset>

                        <fieldset class="address">
                            <legend>Endereço</legend>

                            <div id="input-street" class="input-wrap">
                                <label class="input-wrap-label" for="rua">Rua</label>
                                <input type="text" class="form-control street-mask input-wrap-input" id="rua" name="rua" placeholder="Ex.: Carlos Ferreira" required>
                            </div>

                            <div id="input-house-number" class="input-wrap">
                                <label class="input-wrap-label" for="numeroCasa">Número casa</label>
                                <input type="number" class="form-control house-number-mask input-wrap-input" id="numeroCasa" name="numeroCasa" placeholder="Ex.: 22" required>
                            </div>

                            <div id="input-city" class="input-wrap">
                                <label class="input-wrap-label" for="cidade">Cidade</label>
                                <input type="text" class="form-control city-mask input-wrap-input" id="cidade" name="cidade" placeholder="Ex.: Aquidauana" required>
                            </div>

                            <div id="input-state" class="input-wrap">
                                <label class="input-wrap-label" for="estado">Estado</label>
                                <input type="text" class="form-control state-mask input-wrap-input" id="estado" name="estado" placeholder="Ex.: Mato Grosso do Sul" required>
                            </div>

                            <div id="input-country" class="input-wrap">
                                <label class="input-wrap-label" for="pais">País</label>
                                <input type="text" class="form-control country-mask input-wrap-input" id="pais" name="pais" placeholder="Ex.: Brasil" required>
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
