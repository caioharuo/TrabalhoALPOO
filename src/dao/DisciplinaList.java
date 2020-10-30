package dao;

import exceptions.DadosException;
import models.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaList {

    private final List<Disciplina> disciplinas;
    private static int contador = 1;

    public DisciplinaList() {
        disciplinas = new ArrayList<>();
        disciplinas.add(new Disciplina(contador++, "Disciplina 1", 20, "5"));
        disciplinas.add(new Disciplina(contador++, "Disciplina 2", 52, "2"));
        disciplinas.add(new Disciplina(contador++, "Disciplina 3", 25, "1"));
        disciplinas.add(new Disciplina(contador++, "Disciplina 4", 40, "6"));
    }

    public List<Disciplina> getTodas() throws DadosException {
        return disciplinas;
    }

}
