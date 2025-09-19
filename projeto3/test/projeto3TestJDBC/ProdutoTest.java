package projeto3TestJDBC;

import org.junit.Test;
import projeto3JDBC.dao.produto.IProdutoDAO;
import projeto3JDBC.dao.produto.ProdutoDAO;
import projeto3JDBC.domain.Produto;

import static org.junit.Assert.*;
import java.util.List;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarProdutoTest() throws Exception{
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("teclado");
        produto.setQuantidade(4);

        Integer qtd = produtoDAO.casdastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = produtoDAO.buscar(produto.getNome());
        assertNotNull( produtoBD );
        assertNotNull( produtoBD.getId());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getQuantidade(), produtoBD.getQuantidade());

        Integer countDe1 = produtoDAO.excluir(produtoBD);
        assertTrue(countDe1 == 1);
    }

    @Test
    public void buscarProdutoTest()throws Exception{
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("teclado");
        produto.setQuantidade(4);
        Integer qtd = produtoDAO.casdastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoDB =  produtoDAO.buscar("teclado");
        assertNotNull(produtoDAO );
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getQuantidade(), produtoDB.getQuantidade());

        Integer countDe1 = produtoDAO.excluir(produtoDB);
        assertTrue(countDe1 == 1);
    }

    @Test
    public void excluirProdutoTest()throws Exception{
        produtoDAO  = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("teclado");
        produto.setQuantidade(4);
        Integer qtd = produtoDAO.casdastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoDB =  produtoDAO.buscar("01");
        assertNotNull(produtoDB );
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getQuantidade(),produtoDB.getQuantidade());

        Integer countDe1 = produtoDAO.excluir(produtoDB);
        assertTrue(countDe1 == 1);
    }

    @Test
    public void buscarTodosProdutosTest()throws Exception{
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("teclado");
        produto.setQuantidade(4);
        Integer qtd = produtoDAO.casdastrar(produto);
        assertTrue(qtd == 1);

        Produto produto2 = new Produto();
        produto2.setNome("mouse");
        produto2.setQuantidade(10);
        Integer qtd2 = produtoDAO.casdastrar(produto2);
        assertTrue(qtd2 == 1);

        List<Produto> List = produtoDAO.buscarTodos();
        assertNotNull(List);
        assertEquals(2,List.size());

        int countDe1 = 0;
        for(Produto p : List){
            produtoDAO.excluir(p);
            countDe1++;
        }
        assertEquals(List.size(), countDe1);

        List = produtoDAO.buscarTodos();
        assertEquals(List.size(), 0);
    }

    @Test
    public void updateTest() throws Exception{
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("teclado");
        produto.setQuantidade(4);
        Integer qtd = produtoDAO.casdastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoDB =  produtoDAO.buscar("01");
        assertNotNull(produtoDB );
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getQuantidade(),produtoDB.getQuantidade());

        produtoDB.setNome("monitor");
        produtoDB.setQuantidade(10);
        Integer qtd2 = produtoDAO.update(produtoDB);
        assertTrue(qtd2 == 1);

        Produto produtoBD1 = produtoDAO.buscar("teclado");
        assertNull(produtoBD1);

        Produto produtoBD2 = produtoDAO.buscar("monitor");
        assertNull(produtoDAO);
        assertEquals(produtoBD1.getId(), produtoBD2.getId());
        assertEquals(produtoBD1.getQuantidade(), produtoBD2.getQuantidade());
        assertEquals(produtoBD1.getNome(), produtoBD2.getNome());

        List<Produto> list = produtoDAO.buscarTodos();
        for(Produto p : list){
            produtoDAO.excluir(p);
        }
    }
}
