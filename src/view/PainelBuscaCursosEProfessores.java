package view;

import exceptions.DadosException;
import models.GerenciadorCursos;
import models.GerenciadorProfessores;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class PainelBuscaCursosEProfessores extends JPanel {

    private final GerenciadorCursos gerenciadorCursos;
    private final GerenciadorProfessores gerenciadorProfessores;

    private static PainelBuscaCursosEProfessores instance;

    private PainelBuscaCursosEProfessores() {
        this.gerenciadorCursos = GerenciadorCursos.getInstance();
        this.gerenciadorProfessores = GerenciadorProfessores.getInstance();

        this.setLayout(new BorderLayout());

        JScrollPane painelTabelaCursos = montaPainelTabelaCursos();
        painelTabelaCursos.createHorizontalScrollBar();

        JScrollPane painelTabelProfessores = montaPainelTabelaProfessores();
        painelTabelProfessores.createHorizontalScrollBar();

        JPanel painelBotoes = montaPainelBotoes();

        this.add(painelTabelaCursos, BorderLayout.WEST);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
        this.add(painelTabelProfessores, BorderLayout.EAST);
        this.add(painelBotoes, BorderLayout.SOUTH);
    }

    public static PainelBuscaCursosEProfessores getInstance() {
        if (instance == null) {
            instance = new PainelBuscaCursosEProfessores();
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

    private JScrollPane montaPainelTabelaProfessores() {
        TableModel model = null;
        try {
            model = new ProfessorTableModel(gerenciadorProfessores.getTodas());
        } catch (DadosException ex) {
            ex.printStackTrace();
        }

        JTable tabelaProfessores = new JTable(model);
        tabelaProfessores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tabelaProfessores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollPaneProfessores = new JScrollPane(tabelaProfessores);

        scrollPaneProfessores.setPreferredSize(new Dimension(500, 450));

        scrollPaneProfessores.createHorizontalScrollBar();

        return scrollPaneProfessores;
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
