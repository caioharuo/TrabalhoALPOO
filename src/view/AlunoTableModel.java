package view;

import models.Aluno;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class AlunoTableModel implements TableModel {

    private final List<Aluno> alunos;

    public AlunoTableModel(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public int getRowCount() {
        return alunos.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Matrícula";
            case 1:
                return "Nome";
            case 2:
                return "Data de Nascimento";
            case 3:
                return "Código Curso";
            case 4:
                return "Nome Curso";
            case 5:
                return "Código Disciplina";
            case 6:
                return "Nome Disciplina";
            case 7:
                return "Nota NP1";
            case 8:
                return "Nota NP2";
            case 9:
                return "Média";
            case 10:
                return "Faltas";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int coluna) {
        switch (coluna) {
            case 0:
            case 3:
            case 10:
                return Integer.class;
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
                return String.class;
            case 7:
            case 8:
            case 9:
                return Double.class;
        }
        return void.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Aluno alunoAtual = alunos.get(linha);
        switch (coluna) {
            case 0:
                return alunoAtual.getMatricula();
            case 1:
                return alunoAtual.getNome();
            case 2:
                Date data = alunoAtual.getDataNasc();
                return DateFormat.getDateInstance().format(data);
            case 3:
                return alunoAtual.getCodCurso();
            case 4:
                return alunoAtual.getNomeCurso();
            case 5:
                return alunoAtual.getDisciplina().getCodDisc();
            case 6:
                return alunoAtual.getDisciplina().getNomeDisc();
            case 7:
                return alunoAtual.getNp1();
            case 8:
                return alunoAtual.getNp2();
            case 9:
                return alunoAtual.media(alunoAtual.getNp1(), alunoAtual.getNp2());
            case 10:
                return alunoAtual.getFaltas();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }
}
