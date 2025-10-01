package projetoVendasJpa.dao;

import projetoVendasJpa.dao.generic.IGenericJpaDAO;
import projetoVendasJpa.domain.VendaJpa;
import projetoVendasJpa.exceptions.DAOException;
import projetoVendasJpa.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaJpaDAO extends IGenericJpaDAO<VendaJpa, Long> {

    public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;

    public VendaJpa consultarComCollection(Long id);
}
