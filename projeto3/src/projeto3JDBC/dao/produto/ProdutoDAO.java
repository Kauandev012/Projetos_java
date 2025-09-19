package projeto3JDBC.dao.produto;

import projeto3JDBC.domain.Produto;
import projeto3JDBC.jdbc.ConnectionFactory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {

    //imolimentados do IProdutoDAO
    @Override
    public Integer casdastrar(Produto produto) throws Exception {
        Connection connexao = null;
        PreparedStatement stm = null;
        try{
            connexao = ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            stm = connexao.prepareStatement(sql);
            adicionarParametroInsert(stm, produto);
            return stm.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            closeConnection(connexao, stm, null);
        }
    }

    @Override
    public Produto buscar(String nome) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelect();
            stm = connection.prepareStatement(sql);
            adicionarParametrosSelect(stm, nome);
            rs = stm.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                Long id = rs.getLong("ID");
                String nm = rs.getString("NOME");
                Integer qd = rs.getInt("QUANTIDADE");
                produto.setID(id);
                produto.setNome(nm);
                produto.setQuantidade(qd);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, rs);
        }
        return produto;
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            stm = connection.prepareStatement(sql);
            adicionarParametrosDelete(stm, produto);
            return stm.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Produto> list = new ArrayList<>();
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                produto = new Produto();
                Long id = rs.getLong("ID");
                String nome = rs.getString("NOME");
                Integer qd = rs.getInt("QUANTIDADE");
                produto.setID(id);
                produto.setNome(nome);
                produto.setQuantidade(qd);
                list.add(produto);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, rs);
        }
        return list;
    }

    @Override
    public Integer update(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            stm = connection.prepareStatement(sql);
            adicionarParametrosUpdate(stm, produto);
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    //fecha conexão com o banco
    private void closeConnection(Connection connection, PreparedStatement stm,  ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    // metados de get
    private String getSqlUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_PRODUTO ");
        sb.append("SET NOME = ?, QUANTIDADE = ? ");
        sb.append("WHERE ID = ?");
        return sb.toString();
    }

    private String getSqlSelectAll() {
        StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM TB_PRODUTO");
        return sb.toString();
    }


    private String getSqlSelect() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM TB_PRODUTO ");
        sb.append("WHERE NOME = ?");
        return sb.toString();
    }

    private String getSqlDelete() {
      StringBuilder sb = new StringBuilder();
      sb.append("DELETE FROM TB_PRODUTO ");
      sb.append("WHERE NOME = ?");
      return sb.toString();
    }

    private String getSqlInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_PRODUTO (ID, NOME, QUANTIDADE) ");
        sb.append("VALUES (nextval('SQ_PRODUTO'),?,?)");
        return sb.toString();
    }

    //metados de adicionar
    private void adicionarParametrosUpdate(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getNome());
        stm.setInt(2, produto.getQuantidade());
        stm.setLong(3, produto.getId());
    }

    private void adicionarParametrosSelect(PreparedStatement stm, String nome) throws SQLException {
        stm.setString(1, nome);
    }

    private void adicionarParametrosDelete(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getNome());
    }

    private void adicionarParametroInsert(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setInt(1, produto.getQuantidade());
        stm.setString(2, produto.getNome());
    }
}
