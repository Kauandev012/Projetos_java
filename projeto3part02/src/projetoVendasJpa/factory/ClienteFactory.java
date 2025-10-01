package projetoVendasJpa.factory;

import projetoVendasJpa.domain.ClienteJpa;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteFactory {

    public static ClienteJpa convert(ResultSet rs) throws SQLException {
        ClienteJpa cliente = new ClienteJpa();
        cliente.setId(rs.getLong("ID_CLIENTE"));
        cliente.setNome(rs.getString(("NOME")));
        cliente.setCpf(rs.getLong(("CPF")));
        cliente.setTel(rs.getLong(("TEL")));
        cliente.setEnd(rs.getString(("ENDERECO")));
        cliente.setNumero(rs.getInt(("NUMERO")));
        cliente.setCidade(rs.getString(("CIDADE")));
        cliente.setEstado(rs.getString(("ESTADO")));
        return cliente;
    }
}
