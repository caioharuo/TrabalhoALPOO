package view;

import models.Curso;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class CursoTableModel implements TableModel {

    private final List<Curso> cursos;

    public CursoTableModel(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public int getRowCount() {
        return cursos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Código";
            case 1:
                return "Nome";
            case 2:
                return "Tipo";
            case 3:
                return "Carga Horária";
            case 4:
                return "Código do Instituto";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int coluna) {
        switch (coluna) {
            case 0:
            case 4:
            case 3:
                return Integer.class;
            case 1:
            case 2:
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
        Curso cursoAtual = cursos.get(linha);
        switch (coluna) {
            case 0:
                return cursoAtual.getCodCurso();
            case 1:
                return cursoAtual.getNomeCurso();
            case 2:
                return cursoAtual.getTipoCurso();
            case 3:
                return cursoAtual.getCargaHoraria();
            case 4:
                return cursoAtual.getCodInstituto();
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
