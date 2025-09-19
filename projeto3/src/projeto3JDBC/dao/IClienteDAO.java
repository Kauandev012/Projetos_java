package projeto3JDBC.dao;

import projeto3JDBC.domain.Cliente;

import java.util.List;

public interface IClienteDAO {

    public Integer casdastrar (Cliente cliente) throws Exception;

    Cliente buscar(String codigo) throws Exception;

    Integer excluir(Cliente cliente) throws Exception;

    List<Cliente> buscarTodos() throws Exception;

    Integer update(Cliente cliente) throws Exception;
}
