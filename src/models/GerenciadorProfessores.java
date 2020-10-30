package models;

import dao.ProfessorList;
import exceptions.DadosException;

import java.util.List;

public class GerenciadorProfessores {

    private static GerenciadorProfessores instance;

    private GerenciadorProfessores() {
    }

    public static GerenciadorProfessores getInstance() {
        if (instance == null) {
            instance = new GerenciadorProfessores();
        }
        return instance;
    }

    private final ProfessorList dao = new ProfessorList();

    public List<Professor> getTodas() throws DadosException {
        return dao.getTodas();
    }

}
