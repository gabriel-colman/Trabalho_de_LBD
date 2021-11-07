<%-- 
    Document   : pagamento
    Created on : 01/11/2021, 11:17:17
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/pagamento-consulta.css"/>
        <link rel="shortcut icon" href="images/favicon.ico"/>
        <title>TaVago - Pagamento</title>
    </head>
    <body id="pagamento-page">
        
        <!-- Envoltório do cabeçalho -->
        <div class="header-wrap home-hw">

            <!-- Container da grade de navegação superior -->
            <div class="container-to-grid">

                <!-- Top bar (logo e opções de navegação) -->
                <nav class="top-bar">

                    <!-- Logotipo TaVago -->
                    <div class="logo-tavago">
                        <a href="${pageContext.request.contextPath}/home">
                            <img class="logo-tavago" src="images/logo-tavago.png" alt="tavago"/>
                        </a>
                    </div>

                    <!-- Seção de opções de navegação -->
                    <div class="top-bar-section">
                        <ul class="options">
                            <li>
                                <a href="${pageContext.request.contextPath}/carrinho">
                                    <img class="carrinho" src="images/carrinho.png" alt="carrinho"/>
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
                                    
        <div class="descricao-pagamento">
            <h3 class="realizar-pagamento">
                Realizar pagamento
            </h3>
            <p>
                Insira seus dados nos campos obrigatórios abaixo.
            </p>
        </div>
        <div class="form-pagamento">
            <form class="formulario-pagamento" method="POST" action="${pageContext.request.contextPath}/confirmacao">
                <div class="titular">
                    <label for="titular">Titular: </label><br>
                    <input type="text" name="titular" id="titular" required><br>
                </div>
                <div class="numeroCartao">
                    <label for="numeroCartao">Número do cartão: </label><br>
                    <input type="text" name="numeroCartao" id="numeroCartao" required><br>
                </div>
                <div class="vencimento">
                    <label for="vencimento">Vencimento: </label><br>
                    <input type="text" placeholder="mm/aa" name="vencimento" id="vencimento" required><br>
                </div>
                <div class="codigoSeguranca">
                    <label for="codigoSeguranca">Código de seguranca: </label><br>
                    <input type="text" name="codigoSeguranca" id="codigoSeguranca" required><br>
                </div>
                <input class="realizar-pagamento-input" type="submit" name="realizarPagamento" value="REALIZAR PAGAMENTO">
            </form>
        </div>
    </body>
</html>
