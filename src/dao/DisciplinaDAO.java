package dao;

import exceptions.DadosException;
import models.Disciplina;

import java.util.List;

public interface DisciplinaDAO {

    public void incluir(Disciplina disciplina) throws DadosException;

    public void atualizar(Disciplina disciplina) throws DadosException;

    public void excluir(Disciplina disciplina) throws DadosException;

    public List<Disciplina> getTodas() throws DadosException;

}
