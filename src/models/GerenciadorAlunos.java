package models;


import dao.AlunoList;
import exceptions.DadosException;

import java.util.List;

public class GerenciadorAlunos {

    private static GerenciadorAlunos instance;

    private GerenciadorAlunos() {
    }

    public static GerenciadorAlunos getInstance() {
        if (instance == null) {
            instance = new GerenciadorAlunos();
        }
        return instance;
    }

    private final AlunoList dao = new AlunoList();

    public List<Aluno> getTodas() throws DadosException {
        return dao.getTodas();
    }

}
