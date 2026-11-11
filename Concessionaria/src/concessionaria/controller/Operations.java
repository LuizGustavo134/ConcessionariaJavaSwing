package concessionaria.controller;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import concessionaria.model.*;
import concessionaria.controller.Autenticador;
import javax.swing.JOptionPane;
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
   public boolean inserir(Carro novoCarro) {

    String sql = "INSERT INTO carros (marca,ano,preco,quantidade) VALUES (?, ?, ?, ?)";

    try (Connection conn = conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, novoCarro.getMarca());
        stmt.setInt(2, novoCarro.getAno());
        stmt.setDouble(3, novoCarro.getPreco());
        stmt.setInt(4,novoCarro.getQuantidade());
        JOptionPane.showMessageDialog(null,
            "Operação bem sucedida",
            "Dados enviados com sucesso",
            JOptionPane.INFORMATION_MESSAGE);
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
    // verificação de acesso adm
    public boolean verificarAcesso(String nomeTemp, String senhaTemp) {

    String sql = "SELECT 1 FROM Adms "
               + "WHERE nome = ? AND senha = ? LIMIT 1";

    try (Connection conn = conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomeTemp);
            stmt.setString(2, senhaTemp);       
        try (ResultSet rs = stmt.executeQuery()) {
            return rs.next();
        }

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
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