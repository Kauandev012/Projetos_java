package projetoCadastroCliente.dao;

import projetoCadastroCliente.domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements IclienteDAO{

    private final Map<Long, Cliente> map;

    public ClienteMapDAO() {
        map = new HashMap<>();
    }

    //metados implementados do IclienteDAO
    @Override
    public boolean cadastrarCliente(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())) {
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluirCliente(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);

        if (clienteCadastrado != null) {
            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
        }
    }

    @Override
    public void alterarCliente(Cliente cliente) {
        Cliente  clienteCadastrado = this.map.get(cliente.getCpf());

        if  (clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setCpf(cliente.getCpf());
            clienteCadastrado.setTelefone(cliente.getTelefone());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setEndereco(cliente.getEndereco());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
        }
    }

    @Override
    public Cliente consultarCliente(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodosOsClientes() {
        return this.map.values();
    }
}
