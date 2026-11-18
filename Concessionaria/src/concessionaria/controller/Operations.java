package concessionaria.controller;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import concessionaria.model.*;
public class Operations {

    // conexão com o Banco
    private static final String URL = "jdbc:mysql://localhost:3306/concessionaria";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    // Método auxiliar para abrir a conexão
    private Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do MySQL não encontrado!", e);
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // ==================== 1. CREATE (INSERT) ====================
    public int inserirCliente(cliente novoCliente) {

        String sql = "INSERT INTO cliente (nome, contato) VALUES (?, ?)";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(
                     sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, novoCliente.getNome());
            stmt.setString(2, novoCliente.getContato());

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
    public int inserirVeiculo(Veiculo novoVeiculo) {

        String sql = "INSERT INTO veiculo (marca, ano) VALUES (?, ?)";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(
                     sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, novoVeiculo.getMarca());
            stmt.setInt(2, novoVeiculo.getAno());

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public boolean inserirServico(OrdemdeServico novoServico) {

        String sql = "INSERT INTO ordemServico "
                + "(servico, pagamento, cliente_id, veiculo_id) "
                + "VALUES (?, ?, ?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoServico.getServico());
            stmt.setString(2, novoServico.getPagamento());
            stmt.setInt(3, novoServico.getCliente_id());
            stmt.setInt(4, novoServico.getVeiculo_id());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ==================== 2. READ (SELECT) ====================
    // Cada registro vem como um array:
    // {id, nome, contato, marca, ano, servico, pagamento}
    // Listagem 1: todos os registros (no máximo 10)
    public List<String[]> listar() {
        String sql = "SELECT c.cliente_id, c.nome, c.contato, v.marca, v.ano, "
                + "os.servico, os.pagamento "
                + "FROM ordemServico os "
                + "INNER JOIN cliente c ON os.cliente_id = c.cliente_id "
                + "INNER JOIN veiculo v ON os.veiculo_id = v.veiculo_id "
                + "ORDER BY c.cliente_id LIMIT 10";
        List<String[]> lista = new ArrayList<>();

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new String[]{
                        String.valueOf(rs.getInt("cliente_id")),
                        rs.getString("nome"),
                        rs.getString("contato"),
                        rs.getString("marca"),
                        String.valueOf(rs.getInt("ano")),
                        rs.getString("servico"),
                        rs.getString("pagamento")
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Listagem 2: só os registros de um tipo de serviço
    public List<String[]> listarPorServico(String servico) {
        return consultar("WHERE os.servico = ? ", servico);
    }

    // Listagem 3: só os registros de uma forma de pagamento
    public List<String[]> listarPorPagamento(String pagamento) {
        return consultar("WHERE os.pagamento = ? ", pagamento);
    }

    // Método auxiliar das listagens com filtro (mesmo SELECT do listar, com um WHERE)
    private List<String[]> consultar(String where, String valor) {
        String sql = "SELECT c.cliente_id, c.nome, c.contato, v.marca, v.ano, "
                + "os.servico, os.pagamento "
                + "FROM ordemServico os "
                + "INNER JOIN cliente c ON os.cliente_id = c.cliente_id "
                + "INNER JOIN veiculo v ON os.veiculo_id = v.veiculo_id "
                + where
                + "ORDER BY c.cliente_id LIMIT 10";
        List<String[]> lista = new ArrayList<>();

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, valor);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new String[]{
                            String.valueOf(rs.getInt("cliente_id")),
                            rs.getString("nome"),
                            rs.getString("contato"),
                            rs.getString("marca"),
                            String.valueOf(rs.getInt("ano")),
                            rs.getString("servico"),
                            rs.getString("pagamento")
                    });
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Busca um único registro pelo ID do cliente (retorna null se não achar)
    public String[] buscarPorId(int idCliente) {
        String sql = "SELECT c.cliente_id, c.nome, c.contato, v.marca, v.ano, "
                + "os.servico, os.pagamento "
                + "FROM ordemServico os "
                + "INNER JOIN cliente c ON os.cliente_id = c.cliente_id "
                + "INNER JOIN veiculo v ON os.veiculo_id = v.veiculo_id "
                + "WHERE c.cliente_id = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new String[]{
                            String.valueOf(rs.getInt("cliente_id")),
                            rs.getString("nome"),
                            rs.getString("contato"),
                            rs.getString("marca"),
                            String.valueOf(rs.getInt("ano")),
                            rs.getString("servico"),
                            rs.getString("pagamento")
                    };
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // ==================== 3. UPDATE ====================
    // Atualiza cliente, veículo e serviço de uma vez, usando o ID do cliente
    public boolean atualizar(int idCliente, String nome, String contato,
                             String marca, int ano, String servico, String pagamento) {
        String sql = "UPDATE cliente c "
                + "INNER JOIN ordemServico os ON os.cliente_id = c.cliente_id "
                + "INNER JOIN veiculo v ON os.veiculo_id = v.veiculo_id "
                + "SET c.nome = ?, c.contato = ?, v.marca = ?, v.ano = ?, "
                + "os.servico = ?, os.pagamento = ? "
                + "WHERE c.cliente_id = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, contato);
            stmt.setString(3, marca);
            stmt.setInt(4, ano);
            stmt.setString(5, servico);
            stmt.setString(6, pagamento);
            stmt.setInt(7, idCliente);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ==================== 4. DELETE ====================
    // A ordem de serviço tem que ser apagada primeiro (por causa das chaves estrangeiras),
    // depois o cliente e o veículo
    public boolean deletar(int idCliente) {
        String sqlBuscaVeiculo = "SELECT veiculo_id FROM ordemServico WHERE cliente_id = ?";
        String sqlOrdem = "DELETE FROM ordemServico WHERE cliente_id = ?";
        String sqlCliente = "DELETE FROM cliente WHERE cliente_id = ?";
        String sqlVeiculo = "DELETE FROM veiculo WHERE veiculo_id = ?";

        try (Connection conn = conectar()) {

            int idVeiculo = -1;
            try (PreparedStatement stmt = conn.prepareStatement(sqlBuscaVeiculo)) {
                stmt.setInt(1, idCliente);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        idVeiculo = rs.getInt("veiculo_id");
                    }
                }
            }

            if (idVeiculo == -1) {
                return false; // cliente não encontrado
            }

            try (PreparedStatement stmt = conn.prepareStatement(sqlOrdem)) {
                stmt.setInt(1, idCliente);
                stmt.executeUpdate();
            }

            try (PreparedStatement stmt = conn.prepareStatement(sqlCliente)) {
                stmt.setInt(1, idCliente);
                stmt.executeUpdate();
            }

            try (PreparedStatement stmt = conn.prepareStatement(sqlVeiculo)) {
                stmt.setInt(1, idVeiculo);
                stmt.executeUpdate();
            }

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}