package dao;

import exceptions.DadosException;
import models.Aluno;
import models.Disciplina;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlunoList {

    private final List<Aluno> alunos;
    private static int contador = 1;

    public AlunoList() {
        alunos = new ArrayList<>();
        alunos.add(new Aluno(contador++, "Nome 1", new Date(), 10, "Curso 1",
                new Disciplina(1, "Disciplina 2"), 8.3, 10.0, 10));
        alunos.add(new Aluno(contador++, "Nome 2", new Date(), 10, "Curso 2",
                new Disciplina(2, "Disciplina 1"), 9.3, 5.0, 2));
        alunos.add(new Aluno(contador++, "Nome 3", new Date(), 10, "Curso 2",
                new Disciplina(3, "Disciplina 3"), 7.3, 10.0, 10));
        alunos.add(new Aluno(contador++, "Nome 4", new Date(), 10, "Curso 4",
                new Disciplina(4, "Disciplina 5"), 7.3, 10.0, 5));
    }

    public List<Aluno> getTodas() throws DadosException {
        return alunos;
    }

}
