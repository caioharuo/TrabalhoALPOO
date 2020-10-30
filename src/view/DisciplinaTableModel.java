package view;

import models.Disciplina;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class DisciplinaTableModel implements TableModel {

    private final List<Disciplina> disciplinas;

    public DisciplinaTableModel(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public int getRowCount() {
        return disciplinas.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Código";
            case 1:
                return "Nome";
            case 2:
                return "Carga Horária";
            case 3:
                return "Aulas Semana";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int coluna) {
        switch (coluna) {
            case 0:
            case 2:
            case 3:
                return Integer.class;
            case 1:
                return String.class;
        }
        return void.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Disciplina discAtual = disciplinas.get(linha);
        switch (coluna) {
            case 0:
                return discAtual.getCodDisc();
            case 1:
                return discAtual.getNomeDisc();
            case 2:
                return discAtual.getCargaHoraria();
            case 3:
                return discAtual.getAulasSemana();
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

    Disciplina getDisciplina(int linha){
        return disciplinas.get(linha);
    }
}
