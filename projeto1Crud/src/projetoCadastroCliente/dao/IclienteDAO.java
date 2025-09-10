package projetoCadastroCliente.dao;

import projetoCadastroCliente.domain.Cliente;

import java.util.Collection;

public interface IclienteDAO {

    public boolean cadastrarCliente(Cliente cliente);

    public void excluirCliente(Long cpf);

    public void alterarCliente(Cliente cliente);

    public Cliente consultarCliente(Long cpf);

    public Collection<Cliente> buscarTodosOsClientes();

}

