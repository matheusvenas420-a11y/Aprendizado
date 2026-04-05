package com.mycompany.aprendizado.dao;

import com.mycompany.aprendizado.model.OrdemServico;
import com.mycompany.aprendizado.util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoCRUD_dao {

    public void inserir(OrdemServico os) {
    String sql = "INSERT INTO ordem_servico (nome_cliente, valor, prazo, tipo_servico) VALUES (?, ?, ?, ?)";

    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, os.getNome());
        ps.setDouble(2, os.getValor());
        ps.setInt(3, os.getPrazo());
        ps.setString(4, os.getTipo_servico());

        ps.executeUpdate(); // 🔥 ISSO FALTAVA

    } catch (Exception e) {
        System.out.println("Erro ao inserir: " + e.getMessage());
    }
}

    public List<OrdemServico> listar() {
        List<OrdemServico> lista = new ArrayList<>();
        String sql = "SELECT * FROM ordem_servico";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                OrdemServico os = new OrdemServico(
                        rs.getInt("id"),
                        rs.getString("nome_cliente"),
                        rs.getDouble("valor"),
                        rs.getInt("prazo"),
                        rs.getString("tipo_servico")
                );
                lista.add(os);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }

    public OrdemServico buscarPorId(int id) {
        String sql = "SELECT * FROM ordem_servico WHERE id = ?";
        OrdemServico os = null;

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                os = new OrdemServico(
                        rs.getInt("id"),
                        rs.getString("nome_cliente"),
                        rs.getDouble("valor"),
                        rs.getInt("prazo"),
                        rs.getString("tipo_servico")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar por id: " + e.getMessage());
        }

        return os;
    }

    public void atualizar(OrdemServico os) {
        String sql = "UPDATE ordem_servico SET nome_cliente = ?, valor = ?, prazo = ?, tipo_servico = ? WHERE id = ?";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, os.getNome());
            ps.setDouble(2, os.getValor());
            ps.setInt(3, os.getPrazo());
            ps.setString(4, os.getTipo_servico());
            ps.setInt(5, os.getId());

            int linhas = ps.executeUpdate();

            if (linhas > 0) {
                System.out.println("Atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com esse id.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM ordem_servico WHERE id = ?";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int linhas = ps.executeUpdate();

            if (linhas > 0) {
                System.out.println("Excluído com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com esse id.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }
}