package projetoVendasJpa.dao;

import projetoVendasJpa.dao.generic.GenericJpaDAO;
import projetoVendasJpa.domain.ProdutoJpa;

public class ProdutoJpaDAO  extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

    public ProdutoJpaDAO() {
        super(ProdutoJpa.class);
    }

}
