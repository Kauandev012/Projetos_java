package testProjetoVendas;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import projetoVendas.dao.Cliente.ClienteDAO;
import projetoVendas.dao.Cliente.IClienteDAO;
import projetoVendas.domain.Cliente;
import projetoVendas.exceptions.DAOException;
import projetoVendas.exceptions.MaisDeUmRegistroException;
import projetoVendas.exceptions.TableException;
import projetoVendas.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

import static org.junit.Assert.*;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    public ClienteDAOTest() {
        clienteDao = new ClienteDAO();
    }

    @After
    public void end() throws DAOException {
        Collection<Cliente> list = clienteDao.buscarTodos();
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli.getCpf());
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(123123123L);
        cliente.setNome("alisson");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        cliente.setSobreNome("alvez");
        clienteDao.cadastrar(cliente);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(5656565656800L);
        cliente.setNome("alisson");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        cliente.setSobreNome("alvez");
        Boolean retorno = clienteDao.cadastrar(cliente);
        assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente.getCpf());
    }


    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(565656565906L);
        cliente.setNome("alisson");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        cliente.setSobreNome("alvez");
        Boolean retorno = clienteDao.cadastrar(cliente);
        assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente.getCpf());
        clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(565656565891L);
        cliente.setNome("alisson");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        cliente.setSobreNome("alvez");
        Boolean retorno = clienteDao.cadastrar(cliente);
        assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Kauan");
        clienteDao.alterar(clienteConsultado);

        Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getCpf());
        Assert.assertNotNull(clienteAlterado);
        Assert.assertEquals("Kauan", clienteAlterado.getNome());

        clienteDao.excluir(cliente.getCpf());
        clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(5656565657533L);
        cliente.setNome("alisson");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        cliente.setSobreNome("alvez");
        Boolean retorno = clienteDao.cadastrar(cliente);
        assertTrue(retorno);

        Cliente cliente1 = new Cliente();
        cliente1.setCpf(56565656554912L);
        cliente1.setNome("valeria");
        cliente1.setCidade("São Paulo");
        cliente1.setEnd("End");
        cliente1.setEstado("SP");
        cliente1.setNumero(10);
        cliente1.setTel(1199999999L);
        cliente1.setSobreNome("mercedez");
        Boolean retorno1 = clienteDao.cadastrar(cliente1);
        assertTrue(retorno1);

        Collection<Cliente> list = clienteDao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli.getCpf());
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });

        Collection<Cliente> list1 = clienteDao.buscarTodos();
        assertNotNull(list1);
        assertEquals(0, list1.size());
    }

}
