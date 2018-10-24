package jdbcaula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCAula {

    public static void main(String[] args) {
        // TODO code application logic here
        String conexao = "valor";
        try {
            Connection mariadb = DriverManager.getConnection(
                    "jdbc:mariadb://localhost/",
                    "root",
                    "q1");
            String sql = "insert into contatos (nome, endereco, email) values (?,?,?)";
            PreparedStatement instrucao =
                    mariadb.prepareStatement(sql);
                    instrucao.setString(1, "Pedro Cookie");
                    instrucao.setString(2, "Av FAB, 60");
                    instrucao.setString(3, "pedrocookie@gmail.com");
                    instrucao.execute();
            System.out.println("Conectado!");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um Erro");
            throw new RuntimeException(ex.getMessage());
        }
    }
    
}
