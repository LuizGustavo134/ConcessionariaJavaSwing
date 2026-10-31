import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import concessionaria.model.Carro;
public class Operations {
    
    // conexão com o Banco 
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USERNAME = "your_username";
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
    public boolean inserir(String name, int age) {
        String sql = "INSERT INTO users (name, age) VALUES (?, ?)";
        
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, name);
            stmt.setInt(2, age);
            
            int rows = stmt.executeUpdate();
            return rows > 0;
            
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