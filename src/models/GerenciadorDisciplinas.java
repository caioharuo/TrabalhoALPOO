package models;

import dao.DisciplinaDAO;
import dao.DisciplinaJdbc;
import exceptions.DadosException;

import java.util.List;

public class GerenciadorDisciplinas {

    private static GerenciadorDisciplinas instance;

    private GerenciadorDisciplinas() {
    }

    public static GerenciadorDisciplinas getInstance() {
        if (instance == null) {
            instance = new GerenciadorDisciplinas();
        }
        return instance;
    }

    private final DisciplinaDAO dao = DisciplinaJdbc.getInstance();

    public Disciplina getNovaDisciplina() {
        Disciplina disciplina = new Disciplina();
        disciplina.setCodDisc(0);
        disciplina.setNomeDisc("");
        disciplina.setCargaHoraria(0);
        disciplina.setAulasSemana("1");
        return disciplina;
    }

    public List<Disciplina> getTodas() throws DadosException {
        return dao.getTodas();
    }

    public void salvar(Disciplina disciplina) throws DadosException {
        boolean ehNova = disciplina != null && disciplina.getCodDisc() != null
                && !(disciplina.getCodDisc() > 0);
        if (ehNova) {
            dao.incluir(disciplina);
        } else {
            dao.atualizar(disciplina);
        }
    }

    public void excluir(Disciplina disciplina) throws DadosException {
        dao.excluir(disciplina);
    }

}
