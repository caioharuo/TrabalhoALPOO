package models;


import dao.CursoList;
import exceptions.DadosException;

import java.util.List;

public class GerenciadorCursos {

    private static GerenciadorCursos instance;

    private GerenciadorCursos() {
    }

    public static GerenciadorCursos getInstance() {
        if (instance == null) {
            instance = new GerenciadorCursos();
        }
        return instance;
    }

    private final CursoList dao = new CursoList();

    public List<Curso> getTodas() throws DadosException {
        return dao.getTodas();
    }

}
