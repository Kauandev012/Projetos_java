package projeto3JDBC.dao.produto;

import projeto3JDBC.domain.Produto;

import java.util.List;

public interface IProdutoDAO {
    Integer casdastrar(Produto produto) throws Exception;

    Produto buscar(String nome) throws Exception;

    Integer excluir(Produto produtoBD) throws Exception;

    List<Produto> buscarTodos() throws Exception;

    Integer update(Produto produtoDB) throws Exception;
}
