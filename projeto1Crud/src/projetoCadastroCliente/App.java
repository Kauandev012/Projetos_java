package projetoCadastroCliente;

import projetoCadastroCliente.dao.ClienteMapDAO;
import projetoCadastroCliente.dao.IclienteDAO;
import projetoCadastroCliente.domain.Cliente;

import javax.swing.*;

public class App {

    private static IclienteDAO iclienteDAO;

    public static void main(String[] args) {
        iclienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,"Digite 1 para cadastro, 2 para consulta, 3 para excluir , 4 para alterar ou 5 para sair","Green dinner",JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)){
            if(" ".equals(opcao)){
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,"opcao invalidada Digite 1 para cadastro, 2 para consulta, 3 para excluir , 4 para alterar ou 5 para sair","Green dinner",JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)){
            if(isOpcaoSair(opcao)){
                sair();
            }else if (isOpcaoCadastro(opcao)){
                String dados = JOptionPane.showInputDialog(null,"Digite os dados do cliente separados por virgula, Exemplo: nome, cpf, telefone, numero ,endereço, cidade, estado ","cadastrar clientes",JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isConsulta(opcao)){
                String dados = JOptionPane.showInputDialog(null,"digite o cpf do cliente","Consultar clientes",JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (isExcluir(opcao)){
                String dados = JOptionPane.showInputDialog(null,"digite o cpf do cliente","Excluir clientes",JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            }else{
                String dados = JOptionPane.showInputDialog(null,"Digite os dados do cliente separados por virgula, Exemplo: nome, cpf, telefone, numero ,endereço, cidade, estado ","Atualizar dados",JOptionPane.INFORMATION_MESSAGE);
                atualizar(dados);
            }

        }
    }

    private static void atualizar(String dados) {
        String[] dadosSplit = dados.split(",");
        Cliente cliente = new Cliente(dadosSplit[0],dadosSplit[1],dadosSplit[3],dadosSplit[4],dadosSplit[5],dadosSplit[6]);
        iclienteDAO.alterarCliente(cliente);
    }

    private static void excluir(String dados) {
        iclienteDAO.excluirCliente(Long.parseLong(dados));
        JOptionPane.showMessageDialog(null,"cliente excluido com sucesso","sucesso",JOptionPane.INFORMATION_MESSAGE);
    }

    private static void cadastrar(String dados) {
        String[] dadoSplit = dados.split(",");
        Cliente cliente = new Cliente(dadoSplit[0],dadoSplit[1],dadoSplit[3],dadoSplit[4],dadoSplit[5],dadoSplit[6]);
        boolean isCadastrado = iclienteDAO.cadastrarCliente(cliente);
        if(isCadastrado){
            JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso","sucesso",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar Cliente","erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void consultar(String dados) {
        Cliente cliente = iclienteDAO.consultarCliente(Long.parseLong(dados));
        if(cliente != null){
            JOptionPane.showMessageDialog(null,"Cliente encontrado com sucesso","sucesso",JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null,"Erro Cliente ja tem cadastro","erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void sair() {
        JOptionPane.showInputDialog("saindo da aplicação");
        System.exit(0);
    }

    private static boolean isExcluir(String opcao) {
        return "3".equals(opcao);
    }

    private static boolean isConsulta(String opcao) {
        return "2".equals(opcao);
    }

    private static boolean isOpcaoSair(String opcao) {
        return "5".equalsIgnoreCase(opcao);
    }

    private static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao);
    }

    private static boolean isOpcaoCadastro(String opcao) {
        return "1".equals(opcao);
    }

}
