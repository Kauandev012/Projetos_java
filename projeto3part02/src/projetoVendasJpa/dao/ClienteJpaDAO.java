package projetoVendasJpa.dao;

import projetoVendasJpa.dao.generic.GenericJpaDAO;
import projetoVendasJpa.domain.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

    public ClienteJpaDAO() {
        super(ClienteJpa.class);
    }
}
