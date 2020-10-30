package dao;

import database.GerenciadorConexao;
import exceptions.DadosException;
import models.Disciplina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaJdbc implements DisciplinaDAO {

    private static final String SQL_SELECT_ALL
            = "SELECT COD_DISC, NOME_DISC, CARGA_HORARIA, AULAS_SEMANA"
            + " FROM TB_DISCIPLINAS;";

    @Override
    public List<Disciplina> getTodas() throws DadosException {
        Connection connection = GerenciadorConexao.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Disciplina> listaDisciplinas = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL);
            rs = statement.executeQuery();
            while (rs.next()) {
                int codDisc = rs.getInt("COD_DISC");
                String nomeDisc = rs.getString("NOME_DISC");
                int cargaHoraria = rs.getInt("CARGA_HORARIA");
                String aulasSemana = rs.getString("AULAS_SEMANA");
                Disciplina disciplina = new Disciplina(codDisc, nomeDisc, cargaHoraria, aulasSemana);
                listaDisciplinas.add(disciplina);
            }
        } catch (SQLException ex) {
            throw new DadosException(
                    "Não foi possivel selecionar", ex);
        } finally {
            assert rs != null;
            GerenciadorConexao.fechar(connection, statement, rs);
        }
        return listaDisciplinas;
    }

    private static final String SQL_INSERT
            = "INSERT INTO TB_DISCIPLINAS (NOME_DISC, CARGA_HORARIA, AULAS_SEMANA) "
            + "VALUES (?, ?, ?);";

    @Override
    public void incluir(Disciplina disciplina) throws DadosException {
        Connection connection = GerenciadorConexao.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, disciplina.getNomeDisc());
            statement.setInt(2, disciplina.getCargaHoraria());
            statement.setString(3, disciplina.getAulasSemana());
            statement.executeUpdate();
            int idGerado = this.getIdGerado(statement);
            disciplina.setCodDisc(idGerado);
        } catch (SQLException ex) {
            throw new DadosException(
                    "Não foi possivel incluir", ex);
        } finally {
            assert statement != null;
            GerenciadorConexao.fechar(connection, statement);
        }
    }

    private static final String SQL_UPDATE
            = "UPDATE TB_DISCIPLINAS SET NOME_DISC = ?, CARGA_HORARIA = ? , AULAS_SEMANA = ?, WHERE COD_DISC = ?;";

    @Override
    public void atualizar(Disciplina disciplina) throws DadosException {
        Connection connection = GerenciadorConexao.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, disciplina.getNomeDisc());
            statement.setInt(2, disciplina.getCargaHoraria());
            statement.setString(3, disciplina.getAulasSemana());
            statement.setInt(4, disciplina.getCodDisc());
            statement.executeUpdate();
            int idGerado = this.getIdGerado(statement);
            disciplina.setCodDisc(idGerado);
        } catch (SQLException ex) {
            throw new DadosException(
                    "Não foi possivel atualizar", ex);
        } finally {
            assert statement != null;
            GerenciadorConexao.fechar(connection, statement);
        }
    }

    private static final String SQL_DELETE
            = "DELETE FROM TB_DISCIPLINAS WHERE COD_DISC = ?;";

    @Override
    public void excluir(Disciplina disciplina) throws DadosException {
        Connection connection = GerenciadorConexao.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setInt(1, disciplina.getCodDisc());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DadosException(
                    "Não foi possivel excluir", ex);
        } finally {
            assert statement != null;
            GerenciadorConexao.fechar(connection, statement);
        }
    }

    private DisciplinaJdbc() {
    }

    private static DisciplinaJdbc instance;

    public static DisciplinaJdbc getInstance() {
        if (instance == null) {
            instance = new DisciplinaJdbc();
        }
        return instance;
    }

    private int getIdGerado(PreparedStatement statement) throws SQLException {
        int id = 0;
        ResultSet chavesGeradas = statement.getGeneratedKeys();
        if (chavesGeradas.next()) {
            id = chavesGeradas.getInt(1);
        }
        return id;
    }

}
