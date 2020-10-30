package view;

import exceptions.DadosException;
import models.GerenciadorCursos;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class PainelBuscaCurso extends JPanel {

    private final GerenciadorCursos gerenciador;

    private static PainelBuscaCurso instance;

    private PainelBuscaCurso() {
        this.gerenciador = GerenciadorCursos.getInstance();

        this.setLayout(new BorderLayout());
        JScrollPane painelTabela = montaPainelTabela();
        JPanel painelBotoes = montaPainelBotoes();

        this.add(painelTabela, BorderLayout.CENTER);
        this.add(painelBotoes, BorderLayout.SOUTH);
    }

    public static PainelBuscaCurso getInstance() {
        if (instance == null) {
            instance = new PainelBuscaCurso();
        }
        return instance;
    }

    private JScrollPane montaPainelTabela() {
        TableModel model = null;
        try {
            model = new CursoTableModel(gerenciador.getTodas());
        } catch (DadosException ex) {
            ex.printStackTrace();
        }
        JTable tabelaCursos = new JTable(model);
        tabelaCursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return new JScrollPane(tabelaCursos);
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
