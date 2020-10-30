package view;

import exceptions.DadosException;
import models.GerenciadorCursos;
import models.GerenciadorDisciplinas;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class PainelBuscaCursosEDisciplinas extends JPanel {

    private final GerenciadorCursos gerenciadorCursos;
    private final GerenciadorDisciplinas gerenciadorDisciplinas;

    private static PainelBuscaCursosEDisciplinas instance;

    private PainelBuscaCursosEDisciplinas() {
        this.gerenciadorCursos = GerenciadorCursos.getInstance();
        this.gerenciadorDisciplinas = GerenciadorDisciplinas.getInstance();

        this.setLayout(new BorderLayout());

        JScrollPane painelTabelaCursos = montaPainelTabelaCursos();
        painelTabelaCursos.createHorizontalScrollBar();

        JScrollPane painelTabelaDisciplinas = montaPainelTabelaDisciplinas();
        painelTabelaDisciplinas.createHorizontalScrollBar();

        JPanel painelBotoes = montaPainelBotoes();

        this.add(painelTabelaCursos, BorderLayout.WEST);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
        this.add(painelTabelaDisciplinas, BorderLayout.EAST);
        this.add(painelBotoes, BorderLayout.SOUTH);
    }

    public static PainelBuscaCursosEDisciplinas getInstance() {
        if (instance == null) {
            instance = new PainelBuscaCursosEDisciplinas();
        }
        return instance;
    }

    private JScrollPane montaPainelTabelaCursos() {
        TableModel model = null;
        try {
            model = new CursoTableModel(gerenciadorCursos.getTodas());
        } catch (DadosException ex) {
            ex.printStackTrace();
        }

        JTable tabelaCursos = new JTable(model);
        tabelaCursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tabelaCursos.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

        JScrollPane scrollPaneCursos = new JScrollPane(tabelaCursos);

        scrollPaneCursos.setPreferredSize(new Dimension(500, 450));

        scrollPaneCursos.createHorizontalScrollBar();

        return new JScrollPane(scrollPaneCursos);
    }

    private JScrollPane montaPainelTabelaDisciplinas() {
        TableModel model = null;
        try {
            model = new DisciplinaTableModel(gerenciadorDisciplinas.getTodas());
        } catch (DadosException ex) {
            ex.printStackTrace();
        }

        JTable tabelaDisciplinas = new JTable(model);
        tabelaDisciplinas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tabelaDisciplinas.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

        JScrollPane scrollPaneDisciplinas = new JScrollPane(tabelaDisciplinas);

        scrollPaneDisciplinas.setPreferredSize(new Dimension(500, 450));

        scrollPaneDisciplinas.createHorizontalScrollBar();

        return scrollPaneDisciplinas;
    }

    private JPanel montaPainelBotoes() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");

        painel.add(btnEditar);
        painel.add(btnExcluir);
        return painel;
    }
}
