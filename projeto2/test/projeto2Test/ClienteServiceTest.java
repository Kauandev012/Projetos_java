package projeto2Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import projeto2Test.dao.ClienteDaoMock;
import projeto2mod25.dao.IclienteDAO;
import projeto2mod25.domain.Cliente;
import projeto2mod25.exception.TipoChaveNaoEncontradaException;
import projeto2mod25.service.ClienteService;
import projeto2mod25.service.IClienteService;

public class ClienteServiceTest {

    //variaveis
    private IClienteService clienteService;
    private Cliente cliente;

    //construtor
    public ClienteServiceTest() {
        IclienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before //executa antes do teste
    public void init(){
        cliente = new Cliente();
        cliente.setCpf(30271619932L);
        cliente.setNome("kauan");
        cliente.setCidade("Sao Paulo");
        cliente.setEstado("Sao Paulo");
        cliente.setEndereco("rua teste");
        cliente.setNumero(22);
        cliente.setTelefone(11983754301L);

    }

    @Test //teste pesquisar cliente service
    public void pesquisarCLiente(){
        Cliente clienteConstultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConstultado);
    }

    @Test //teste salvar cliente service
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        boolean retorno = clienteService.salvar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test //teste excluir cliente service
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }

    @Test //teste atualizar cliente service
    public void atualizarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("kauan araujo");
        clienteService.alterar(cliente);

        Assert.assertEquals("kauan araujo", cliente.getNome());
    }

}
