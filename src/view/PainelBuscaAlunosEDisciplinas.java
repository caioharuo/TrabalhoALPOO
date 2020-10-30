package view;

import exceptions.DadosException;
import models.GerenciadorAlunos;
import models.GerenciadorDisciplinas;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class PainelBuscaAlunosEDisciplinas extends JPanel {

    private final GerenciadorDisciplinas gerenciadorDisciplinas;
    private final GerenciadorAlunos gerenciadorAlunos;

    private static PainelBuscaAlunosEDisciplinas instance;

    private PainelBuscaAlunosEDisciplinas() {
        this.gerenciadorAlunos = GerenciadorAlunos.getInstance();
        this.gerenciadorDisciplinas = GerenciadorDisciplinas.getInstance();

        this.setLayout(new BorderLayout());

        JScrollPane painelTabelaAlunos = montaPainelTabelaAlunos();
        painelTabelaAlunos.createHorizontalScrollBar();

        JScrollPane painelTabelaDisciplinas = montaPainelTabelaDisciplinas();
        painelTabelaDisciplinas.createHorizontalScrollBar();

        JPanel painelBotoes = montaPainelBotoes();

        this.add(painelTabelaAlunos, BorderLayout.WEST);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
        this.add(painelTabelaDisciplinas, BorderLayout.EAST);
        this.add(painelBotoes, BorderLayout.SOUTH);
    }

    public static PainelBuscaAlunosEDisciplinas getInstance() {
        if (instance == null) {
            instance = new PainelBuscaAlunosEDisciplinas();
        }
        return instance;
    }

    private JScrollPane montaPainelTabelaAlunos() {
        TableModel model = null;
        try {
            model = new AlunoTableModel(gerenciadorAlunos.getTodas());
        } catch (DadosException ex) {
            ex.printStackTrace();
        }

        JTable tabelaAlunos = new JTable(model);
        tabelaAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tabelaAlunos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollPaneAlunos = new JScrollPane(tabelaAlunos);

        scrollPaneAlunos.setPreferredSize(new Dimension(500, 450));

        scrollPaneAlunos.createHorizontalScrollBar();

        return scrollPaneAlunos;
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

        return new JScrollPane(scrollPaneDisciplinas);
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
