package jdbcaula;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class JDBCAula {
    
    static void inserir(Connection c1) throws SQLException{
        String sql = "INSERT INTO contatos (nome,endereco,email,data_nascimento) values (?,?,?,?)";
        PreparedStatement escuta_ai = c1.prepareStatement(sql);
        escuta_ai.setString(1, "Diozefe");
        escuta_ai.setString(2, "Na beira do Rio mais belo, de esquina do equador");
        escuta_ai.setString(3, "diozefe.f.morais@gmail.com");
        escuta_ai.setDate(4, data(06,02,1998));
        escuta_ai.execute();
    }
    static void deletar(Connection c1, int id) throws SQLException{
        String sql = "DELETE FROM contatos WHERE id=?";
        PreparedStatement passa_a_borracha = c1.prepareStatement(sql);
        passa_a_borracha.setInt(1, id);
        passa_a_borracha.execute();
    }
    static void atualizar(Connection c1, String id) throws SQLException{
        String sql = "UPDATE contaos set name=?,endereco=?,email=?,data_nascimento=? WHERE id ="+id;
        PreparedStatement troca_ai = c1.prepareStatement(sql);
        troca_ai.setString(1, "Diozefezaum");
        troca_ai.setString(2, "Congos Olha a Faca");
        troca_ai.setString(3, "quem_ler_e_viado@hotmail.com");
        troca_ai.setDate(4, data(06,02,3080));
        troca_ai.execute();
    }
    static Date data(int dia, int mes, int ano){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,ano);
        calendar.set(Calendar.MONTH,mes);
        calendar.set(Calendar.DAY_OF_MONTH,dia);
        return new Date(calendar.getTimeInMillis());
    }
    static void selecionar(Connection c2, String tb) throws SQLException{
        String sql = "SELECT * FROM "+tb;
        PreparedStatement selecionando = c2.prepareStatement(sql);
        ResultSet rSet = selecionando.executeQuery();
        while (rSet.next()) {
            System.out.println("ID: "+rSet.getString("id"));
            System.out.println("NOME: "+rSet.getString("nome"));
            System.out.println("ENDEREÇO: "+rSet.getString("endereco"));
            System.out.println("DATA DE NASCIMENTO: "+rSet.getString("data_nascimento"));
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String conexao = "valor";
        try {
            Connection mysql = DriverManager.getConnection(
                    "jdbc:mysql://localhost/agenda",
                    "root",
                    "dfm123123");
                    System.out.println("Conectado!");
        } catch (SQLException e) {
            System.out.println("Ocorreu um Erro!");
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
       }    
    
}
