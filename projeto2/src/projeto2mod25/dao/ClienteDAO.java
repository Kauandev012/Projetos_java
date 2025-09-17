package projeto2mod25.dao;

import projeto2mod25.dao.generic.GenericDAO;
import projeto2mod25.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> implements IclienteDAO {


    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }
}
