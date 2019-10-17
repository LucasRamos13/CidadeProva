/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Cidade;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Administrador
 */
public class DaoCidade {
     public static boolean inserir(Cidade objeto) {
        String sql = "INSERT INTO Cidade (sigla, nome, habitantes, emancipacao, area, distancia_capital) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSigla());
            ps.setString(2, objeto.getNome());
            ps.setInt(3, objeto.getHabitantes());
            ps.setDate(4, Date.valueOf(objeto.getEmancipacao()));
            ps.setDouble(5, objeto.getArea());
            ps.setDouble(6, objeto.getDistancia());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     
       public static boolean alterar(Cidade objeto) {
        String sql = "UPDATE Cidade SET sigla = ?, nome = ?, habitantes = ?, emancipacao = ?, area = ?, distancia_capital = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSigla());
            ps.setString(2, objeto.getNome());
            ps.setInt(3, objeto.getHabitantes());
            ps.setDate(4, Date.valueOf(objeto.getEmancipacao()));
            ps.setDouble(5, objeto.getArea());
            ps.setDouble(6, objeto.getDistancia());
            ps.setInt(7, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
       
         public static boolean excluir(Cidade objeto) {
        String sql = "DELETE FROM Cidade WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
         
         public static List<Cidade> consultar() {
        List<Cidade> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, sigla, distancia_capital, habitantes, area, emancipacao FROM Cidade";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cidade objeto = new Cidade();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                objeto.setSigla(rs.getString("sigla"));
                objeto.setDistancia(rs.getDouble("distancia_capital"));
                objeto.setHabitantes(rs.getInt("habitantes"));
                objeto.setArea(rs.getDouble("area"));
                objeto.setEmancipacao(rs.getDate("emancipacao").toLocalDate());
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
         
          public static Cidade consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, sigla, distancia_capital, habitantes, area, emancipacao FROM Cidade WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cidade objeto = new Cidade();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                objeto.setSigla(rs.getString("sigla"));
                objeto.setDistancia(rs.getDouble("distancia_capital"));
                objeto.setHabitantes(rs.getInt("habitantes"));
                objeto.setArea(rs.getDouble("area"));
                objeto.setEmancipacao(rs.getDate("emancipacao").toLocalDate());
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
