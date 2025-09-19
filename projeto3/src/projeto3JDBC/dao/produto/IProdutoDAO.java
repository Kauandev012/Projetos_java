package projeto3JDBC.dao.produto;

import projeto3JDBC.domain.Produto;

import java.util.List;

public interface IProdutoDAO {
    Long casdastrar(Produto produto) throws Exception;

    Produto buscar(String nome) throws Exception;

    Long excluir(Produto produto) throws Exception;

    List<Produto> buscarTodos() throws Exception;

    Long update(Produto produto) throws Exception;
}
