package projetoVendas.dao.Venda;

import projetoVendas.domain.Venda;
import projetoVendas.dao.generic.IGenericDAO;
import projetoVendas.exceptions.DAOException;
import projetoVendas.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String>{


    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
