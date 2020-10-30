package dao;

import exceptions.DadosException;
import models.Curso;
import models.NomeCurso;

import java.util.ArrayList;
import java.util.List;

public class CursoList {

    private final List<Curso> cursos;
    private static int contador = 1;

    public CursoList() {
        cursos = new ArrayList<>();
        cursos.add(new Curso(contador++, NomeCurso.ADMINISTRACAO_EMPRESAS, "Tipo 1", 30, 10));
        cursos.add(new Curso(contador++, NomeCurso.BIOMEDICINA, "Tipo 1", 30, 10));
        cursos.add(new Curso(contador++, NomeCurso.CIENCIAS_DA_COMPUTACAO, "Tipo 1", 30, 10));
        cursos.add(new Curso(contador++, NomeCurso.REDE_DE_COMPUTADORES, "Tipo 1", 30, 10));
        cursos.add(new Curso(contador++, NomeCurso.ADMINISTRACAO_EMPRESAS, "Tipo 1", 30, 10));
        cursos.add(new Curso(contador++, NomeCurso.FARMACOLOGIA, "Tipo 1", 30, 10));
        cursos.add(new Curso(contador++, NomeCurso.ADMINISTRACAO_EMPRESAS, "Tipo 1", 30, 10));
        cursos.add(new Curso(contador++, NomeCurso.SISTEMAS_DE_INFORMACOES, "Tipo 1", 30, 10));
        cursos.add(new Curso(contador++, NomeCurso.ADMINISTRACAO_EMPRESAS, "Tipo 1", 30, 10));
    }

    public List<Curso> getTodas() throws DadosException {
        return cursos;
    }

}
