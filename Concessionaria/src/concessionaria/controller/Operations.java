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
    // Retorna uma lista de arrays de String, ideal para popular JTables no Swing
    public List<String[]> listar() {
        String sql = "SELECT id, name, age FROM users";
        List<String[]> lista = new ArrayList<>();
        
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String name = rs.getString("name");
                String age = String.valueOf(rs.getInt("age"));
                
                lista.add(new String[]{id, name, age});
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return lista;
    }
   
   


    // ==================== 3. UPDATE ====================
    public boolean atualizar(int id, String newName, int newAge) {
        String sql = "UPDATE users SET name = ?, age = ? WHERE id = ?";
        
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, newName);
            stmt.setInt(2, newAge);
            stmt.setInt(3, id);
            
            int rows = stmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ==================== 4. DELETE ====================
    public boolean deletar(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            int rows = stmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}