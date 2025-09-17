package projeto2Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import projeto2Test.dao.ClienteDaoMock;
import projeto2mod25.dao.IclienteDAO;
import projeto2mod25.domain.Cliente;
import projeto2mod25.exception.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {

    //variaveis
    private IclienteDAO clienteDAO;
    private Cliente cliente;

    //construtor
    public ClienteDAOTest() {
        clienteDAO = new ClienteDaoMock();
    }

    @Before //executa antes do teste
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(30271619932L);
        cliente.setNome("kauan");
        cliente.setCidade("Sao Paulo");
        cliente.setEstado("Sao Paulo");
        cliente.setEndereco("rua teste");
        cliente.setNumero(22);
        cliente.setTelefone(11983754301L);
        clienteDAO.cadastrar(cliente);

    }

    @Test //teste pesquisar cliente service
    public void pesquisarCLiente(){
        Cliente clienteConstultado = clienteDAO.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConstultado);
    }

    @Test //teste salvar cliente service
    public void salvarCliente() throws TipoChaveNaoEncontradaException{
        boolean retorno = clienteDAO.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test //teste excluir cliente service
    public void excluirCliente(){
        clienteDAO.excluir(cliente.getCpf());
    }

    @Test //teste atualizar cliente service
    public void atualizarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("kauan araujo");
        clienteDAO.alterar(cliente);

        Assert.assertEquals("kauan araujo", cliente.getNome());
    }
}
