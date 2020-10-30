package view;

import exceptions.DadosException;
import models.GerenciadorAlunos;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class PainelBuscaAluno extends JPanel {

    private final GerenciadorAlunos gerenciador;

    private static PainelBuscaAluno instance;

    private PainelBuscaAluno() {
        this.gerenciador = GerenciadorAlunos.getInstance();

        this.setLayout(new BorderLayout());
        JScrollPane painelTabela = montaPainelTabela();
        JPanel painelBotoes = montaPainelBotoes();

        this.add(painelTabela, BorderLayout.CENTER);
        this.add(painelBotoes, BorderLayout.SOUTH);
    }

    public static PainelBuscaAluno getInstance() {
        if (instance == null) {
            instance = new PainelBuscaAluno();
        }
        return instance;
    }

    private JScrollPane montaPainelTabela() {
        TableModel model = null;
        try {
            model = new AlunoTableModel(gerenciador.getTodas());
        } catch (DadosException ex) {
            ex.printStackTrace();
        }
        JTable tabelaAlunos = new JTable(model);
        tabelaAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return new JScrollPane(tabelaAlunos);
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
