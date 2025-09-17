package projeto2mod25.service;

import projeto2mod25.dao.IclienteDAO;
import projeto2mod25.domain.Cliente;
import projeto2mod25.exception.TipoChaveNaoEncontradaException;

public class ClienteService implements IClienteService {

    private IclienteDAO clienteDAO;

    public ClienteService(IclienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        return clienteDAO.cadastrar(cliente);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return clienteDAO.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
         clienteDAO.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDAO.alterar(cliente);
    }

}
