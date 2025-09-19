package projeto3TestJDBC;

import org.junit.Test;
import projeto3JDBC.dao.ClienteDAO;
import projeto3JDBC.dao.IClienteDAO;
import projeto3JDBC.domain.Cliente;

import java.util.List;

import static org.junit.Assert.*;

public class ClienteTest {

    private IClienteDAO clienteDAO;

    @Test
    public void cadastrarTeste() throws Exception {
        clienteDAO  = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Fulano");

        Integer qtd = clienteDAO.casdastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = clienteDAO.buscar(cliente.getCodigo());
        assertNotNull( clienteBD );
        assertNotNull( clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDe1 = clienteDAO.excluir(clienteBD);
        assertTrue(countDe1 == 1);
    }

    @Test
    public void buscarTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Fulano");
        Integer qtd = clienteDAO.casdastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD =  clienteDAO.buscar("01");
        assertNotNull(clienteBD );
        assertEquals(cliente.getCodigo() ,clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDe1 = clienteDAO.excluir(clienteBD);
        assertEquals(1, (int) countDe1);
    }

    @Test
    public void excluirTest() throws Exception {
        clienteDAO  = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Fulano");
        Integer qtd = clienteDAO.casdastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD =  clienteDAO.buscar("01");
        assertNotNull(clienteBD );
        assertEquals(cliente.getCodigo(),clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDe1 = clienteDAO.excluir(clienteBD);
        assertTrue(countDe1 == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Fulano");
        Integer qtd = clienteDAO.casdastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clientes = new Cliente();
        clientes.setCodigo("02");
        clientes.setNome("Fulano2");
        Integer qtd2 = clienteDAO.casdastrar(cliente);
        assertTrue(qtd2 == 1);

        List<Cliente> List = clienteDAO.buscarTodos();
        assertNotNull(List);
        assertEquals(2, List.size());

        int countDe1 = 0;
        for(Cliente c : List){
            clienteDAO.excluir(c);
            countDe1++;
        }
        assertEquals(List.size(), countDe1);

        List = clienteDAO.buscarTodos();
        assertEquals(List.size(), 0);
    }

    @Test
    public void updateTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Fulano");
        Integer qtd = clienteDAO.casdastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD =  clienteDAO.buscar("01");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(),clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        clienteBD.setCodigo("02");
        clienteBD.setNome("fulano nome teste");
        Integer qtd2 = clienteDAO.update(clienteBD);
        assertTrue(qtd2 == 1);

        Cliente clienteBD1 = clienteDAO.buscar("01");
        assertNull(clienteBD1);

        Cliente clienteBD2 = clienteDAO.buscar("02");
        assertNotNull(clienteBD2);
        assertEquals(clienteBD.getId(), clienteBD2.getId());
        assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
        assertEquals(clienteBD.getNome(), clienteBD2.getNome());

        List<Cliente> list = clienteDAO.buscarTodos();
        for(Cliente c : list){
            clienteDAO.excluir(c);
        }
    }
}
