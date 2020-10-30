package view;

import exceptions.DadosException;
import models.GerenciadorProfessores;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class PainelBuscaProfessor extends JPanel {

    private final GerenciadorProfessores gerenciador;

    private static PainelBuscaProfessor instance;

    private PainelBuscaProfessor() {
        this.gerenciador = GerenciadorProfessores.getInstance();

        this.setLayout(new BorderLayout());
        JScrollPane painelTabela = montaPainelTabela();
        JPanel painelBotoes = montaPainelBotoes();

        this.add(painelTabela, BorderLayout.CENTER);
        this.add(painelBotoes, BorderLayout.SOUTH);
    }

    public static PainelBuscaProfessor getInstance() {
        if (instance == null) {
            instance = new PainelBuscaProfessor();
        }
        return instance;
    }

    private JScrollPane montaPainelTabela() {
        TableModel model = null;
        try {
            model = new ProfessorTableModel(gerenciador.getTodas());
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
