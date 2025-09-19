package projeto3TestJDBC;

import org.junit.Assert;
import org.junit.Test;
import projeto3JDBC.dao.produto.IProdutoDAO;
import projeto3JDBC.dao.produto.ProdutoDAO;
import projeto3JDBC.domain.Produto;

import static org.junit.Assert.*;
import java.util.List;
import java.util.Optional;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarProdutoTest() throws Exception{
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("teclado");
        produto.setQuantidade(4L);
        Long qtd = produtoDAO.casdastrar(produto);
        assertEquals(1L, (long) qtd);

        Produto produtoBD = produtoDAO.buscar(produto.getNome());
        assertNotNull( produtoBD );
        assertNotNull( produtoBD.getId());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getQuantidade(), produtoBD.getQuantidade());

        Long countDe1 = produtoDAO.excluir(produtoBD);
        assertEquals(1L, (long) countDe1);
    }

    @Test
    public void buscarProdutoTest()throws Exception{
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("teclado");
        produto.setQuantidade(4L);
        Long qtd = produtoDAO.casdastrar(produto);
        assertEquals(1L, (long) qtd);

        Produto produtoDB =  produtoDAO.buscar("teclado");
        assertNotNull(produtoDAO );
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getQuantidade(), produtoDB.getQuantidade());

        Long countDe1 = produtoDAO.excluir(produtoDB);
        assertEquals(1, (long) countDe1);
    }

    @Test
    public void excluirProdutoTest()throws Exception{
        produtoDAO  = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("teclado");
        produto.setQuantidade(4L);
        Long qtd = produtoDAO.casdastrar(produto);
        assertEquals(1, (long) qtd);

        Produto produtoDB =  produtoDAO.buscar("teclado");
        assertNotNull(produtoDB );
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getQuantidade(),produtoDB.getQuantidade());

        Long countDe1 = produtoDAO.excluir(produtoDB);
        assertEquals(1, (long) countDe1);
    }

    @Test
    public void buscarTodosProdutosTest()throws Exception{
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("teclado");
        produto.setQuantidade(4L);
        Long qtd = produtoDAO.casdastrar(produto);
        assertEquals(1, (long) qtd);

        Produto produto2 = new Produto();
        produto2.setNome("mouse");
        produto2.setQuantidade(10L);
        Long qtd2 = produtoDAO.casdastrar(produto2);
        assertEquals(1, (long) qtd2);

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
        assertEquals(0, List.size());
    }

    @Test
    public void updateTest() throws Exception{
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("teclado");
        produto.setQuantidade(4L);
        Long qtd = produtoDAO.casdastrar(produto);
        assertEquals(1, (long) qtd);

        Produto produtoDB =  produtoDAO.buscar("teclado");
        assertNotNull(produtoDB );
        assertEquals(produto.getNome(), produtoDB.getNome());
        assertEquals(produto.getQuantidade(),produtoDB.getQuantidade());

        produtoDB.setNome("monitor");
        produtoDB.setQuantidade(10L);
        Long qtd2 = produtoDAO.update(produtoDB);
        assertEquals(1, (long) qtd2);

        Produto produtoBD1 = produtoDAO.buscar("teclado");
        assertNull(produtoBD1);

        Produto produtoBD2 = produtoDAO.buscar("monitor");
        assertNotNull(produtoBD2);
        assertEquals(produtoDB.getId(), produtoBD2.getId());
        assertEquals(produtoDB.getNome(), produtoBD2.getNome());
        assertEquals(produtoDB.getQuantidade(), produtoBD2.getQuantidade());

        List<Produto> list = produtoDAO.buscarTodos();
        for(Produto p : list){
            produtoDAO.excluir(p);
        }
    }
}
