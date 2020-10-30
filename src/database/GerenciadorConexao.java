package database;

import exceptions.DadosException;

import java.sql.*;

public class GerenciadorConexao {
    private static final String URL =
            "jdbc:mysql://127.0.0.1:3306/sakila?zeroDateTimeBehavior=convertToNull&useTimezone=true&serverTimezone=UTC";
    private static final String USER = "aluno";
    private static final String PASSWORD = "unip";

    public static Connection getConnection() throws DadosException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throw new DadosException(
                    "Não foi possível se conectar ao banco de dados",
                    throwables);
        }
        return connection;
    }

    public static void fechar(Connection connection) throws DadosException {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new DadosException(
                    "Não foi possivel desconectar ao banco de dados",
                    ex);
        }
    }

    public static void fechar(Connection connection,
                              Statement statement) throws DadosException {
        try {
            statement.close();
        } catch (SQLException throwables) {
            throw new DadosException(
                    "Não foi possível desconectar-se do banco de dados",
                    throwables);
        } finally {
            GerenciadorConexao.fechar(connection);
        }
    }

    public static void fechar(Connection connection,
                              Statement statement,
                              ResultSet resultSet) throws DadosException {
        try {
            resultSet.close();
        } catch (SQLException ex) {
            throw new DadosException(
                    "Não foi possivel desconectar ao banco de dados",
                    ex);
        } finally {
            GerenciadorConexao.fechar(connection, statement);
        }
    }
}
