package view;

import exceptions.DadosException;
import models.Disciplina;
import models.GerenciadorDisciplinas;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelBuscaDisciplina extends JPanel {

    private final GerenciadorDisciplinas gerenciador;

    private static PainelBuscaDisciplina instance;
    private JTable tabelaDisciplinas;

    private PainelBuscaDisciplina() {
        this.gerenciador = GerenciadorDisciplinas.getInstance();

        this.setLayout(new BorderLayout());
        JScrollPane painelTabela = montaPainelTabela();
        JPanel painelBotoes = montaPainelBotoes();

        this.add(painelTabela, BorderLayout.CENTER);
        this.add(painelBotoes, BorderLayout.SOUTH);
    }

    public static PainelBuscaDisciplina getInstance() {
        if (instance == null) {
            instance = new PainelBuscaDisciplina();
        }
        return instance;
    }

    private JScrollPane montaPainelTabela() {
        TableModel model = null;
        try {
            model = new DisciplinaTableModel(gerenciador.getTodas());
        } catch (DadosException ex) {
            ex.printStackTrace();
        }
        tabelaDisciplinas = new JTable(model);
        tabelaDisciplinas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return new JScrollPane(tabelaDisciplinas);
    }

    private JPanel montaPainelBotoes() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new AtualizarDisciplina());
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Thread threadDao = new Thread(new ExcluirDisciplina());
                threadDao.start();
            }

        });

        painel.add(btnEditar);
        painel.add(btnExcluir);
        return painel;
    }

    public void atualizaTabela() {
        new Thread(() -> {
            try {
                SwingUtilities.invokeLater(() -> {
                    tabelaDisciplinas.repaint();
                    tabelaDisciplinas.revalidate();
                });
                gerenciador.getTodas();
            } catch (DadosException e) {
                e.printStackTrace();
            }

        }).start();
    }

    private Disciplina getDisciplinaSelecionada() {
        int linhaSelecionada = tabelaDisciplinas.getSelectedRow();
        Disciplina disciplinaSelecionada;
        if (linhaSelecionada >= 0) {
            DisciplinaTableModel model
                    = (DisciplinaTableModel) tabelaDisciplinas.getModel();
            disciplinaSelecionada = model.getDisciplina(linhaSelecionada);
        } else {
            disciplinaSelecionada = null;
        }
        return disciplinaSelecionada;
    }

    private class AtualizarDisciplina implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Disciplina disciplinaSelecionada = getDisciplinaSelecionada();
            if (disciplinaSelecionada == null) {
                JOptionPane.showMessageDialog(null, "Selecione uma linha",
                        "Sobre", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            PainelCadastroDisciplina.getInstance().setDisciplina(disciplinaSelecionada);
        }
    }

    private class ExcluirDisciplina implements Runnable {

        @Override
        public void run() {
            Disciplina disciplina = getDisciplinaSelecionada();
            if (disciplina == null) {
                JOptionPane.showMessageDialog(null, "Selecione uma disciplina",
                        "Selecione", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            String mensagem = "Confirma a exclusão da atividade "
                    + disciplina.getCodDisc() + "?";
            int opcao = JOptionPane.showConfirmDialog(null, mensagem, "Confirmação",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            try {
                if (opcao == JOptionPane.OK_OPTION) {
                    gerenciador.excluir(disciplina);
                    JOptionPane.showMessageDialog(null, "Disciplina excluida com sucesso!",
                            "", JOptionPane.INFORMATION_MESSAGE);
                    atualizaTabela();
                }
            } catch (DadosException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar a exclusão",
                        "Exclusão", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
