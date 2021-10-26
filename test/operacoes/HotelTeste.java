package operacoes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.CreateException;
import model.entity.Hotel;

//import static org.junit.Assert.*;

/**
 *
 * @author Gabriel
 */
public class HotelTeste {
   
    /**
     * Test of cadastrarCategoria method, of class HotelManager.
     */
    /*    @Test
    public void testCadastrarCategoria() {
    try {
    System.out.println("cadastrarCategoria");
    String descricao = "teste";
    HotelManager instance = new HotelManager();
    instance.cadastrarCategoria(descricao);
    } catch (Exception e) {
    fail(e.getMessage());
    }
    }*/

    /**
     * Test of cadastrarHotel method, of class HotelManager.
     */
//    @Test
    public void testCadastrarHotel() {
//        try {
            System.out.println("cadastrarHotel");
            String nome = "Novo Teste";
            int quantidadeEstrela = 0;
            String telefone = "123";
            String rua = "Rua Teste";
            int numero = 1;
            String cidade = "Teste";
            String estado = "Teste";
            String pais = "Teste";
            List<Integer> idCategoria = new ArrayList();
            List<String> descricao = new ArrayList();
            List<Double> valor = new ArrayList();
            int idProprietario = 4;
            idCategoria.add(1);
            idCategoria.add(1);
            descricao.add("Teste 1");
            descricao.add("Teste 2");
            valor.add(100.00);
            valor.add(200.00);
            HotelTeste instance = new HotelTeste();
//            instance.cadastrarHotel(nome, quantidadeEstrela, telefone, rua, numero, cidade, estado, pais, idCategoria, descricao, valor, idProprietario);
//        } catch (CreateException e) {
//            fail(e.getMessage());
//        }
    }

    /**
     * Test of buscarHotel method, of class HotelManager.
     */
    /*@Test
    public void testBuscarHotel() {
    try {
    System.out.println("buscarHotel");
    int id = 1;
    HotelManager instance = new HotelManager();
    Hotel expResult = null;
    Hotel result = instance.buscarHotel(id);
    System.out.println(result.getNome());
    assertNotEquals(expResult, result);
    } catch (Exception e) {
    fail(e.getMessage());
    }
    }
    
    /**
    * Test of listarHotel method, of class HotelManager.
    */
    /*@Test
    public void testListarHotel() {
        try {
            System.out.println("listarHotel");
            HotelManager instance = new HotelManager();
            Collection<Hotel> expResult = null;
            Collection<Hotel> result = instance.listarHotel();
            result.forEach((hot) -> {
                System.out.println(hot.getNome());
            });
            assertNotEquals(expResult, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }*/

    /**
     * Test of excluirHotel method, of class HotelManager.
     */
    /*    @Test
    public void testExcluirHotel() {
    System.out.println("excluirHotel");
    int id = 0;
    HotelManager instance = new HotelManager();
    instance.excluirHotel(id);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/

}
