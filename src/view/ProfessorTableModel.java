package view;

import models.Professor;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class ProfessorTableModel implements TableModel {

    private final List<Professor> professores;

    public ProfessorTableModel(List<Professor> professores) {
        this.professores = professores;
    }

    @Override
    public int getRowCount() {
        return professores.size();
    }

    @Override
    public int getColumnCount() {
        return 12;
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Identificação";
            case 1:
                return "Nome";
            case 2:
                return "Logradouro";
            case 3:
                return "Número";
            case 4:
                return "Bairro";
            case 5:
                return "Cidade";
            case 6:
                return "Estado";
            case 7:
                return "Telefone fixo";
            case 8:
                return "Celular";
            case 9:
                return "Data de Nascimento";
            case 10:
                return "Especialização";
            case 11:
                return "Título";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int coluna) {
        switch (coluna) {
            case 0:
            case 3:
            case 7:
            case 8:
                return Integer.class;
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 9:
            case 10:
            case 11:
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
        Professor professorAtual = professores.get(linha);
        switch (coluna) {
            case 0:
                return professorAtual.getIdentProf();
            case 1:
                return professorAtual.getNomeProf();
            case 2:
                return professorAtual.getEndProf().getLogradouro();
            case 3:
                return professorAtual.getEndProf().getNumero();
            case 4:
                return professorAtual.getEndProf().getBairro();
            case 5:
                return professorAtual.getEndProf().getCidade();
            case 6:
                return professorAtual.getEndProf().getEstado();
            case 7:
                return professorAtual.getEndProf().getTelFixo();
            case 8:
                return professorAtual.getEndProf().getCelular();
            case 9:
                Date data = professorAtual.getDataNasc();
                return DateFormat.getDateInstance().format(data);
            case 10:
                return professorAtual.getEspecProf();
            case 11:
                return professorAtual.getTituloProf();

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
