package view;

import exceptions.DadosException;
import models.Disciplina;
import models.GerenciadorDisciplinas;

import javax.swing.*;
import java.awt.*;

public class PainelCadastroDisciplina extends JPanel {
    private JLabel lblCodDisc;
    private JTextField txtCodDisc;
    private JLabel lblNomeDisc;
    private JTextField txtNomeDisc;
    private JLabel lblCargaHoraria;
    private JTextField txtCargaHoraria;
    private JLabel lblAulasSemana;
    private ButtonGroup group;
    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;
    private JRadioButton radio4;
    private JRadioButton radio5;
    private JRadioButton radio6;
    private JButton btnSalvar;
    private JButton btnCancelar;

    private GerenciadorDisciplinas gerenciador;

    private Disciplina disciplina;

    private PainelBuscaDisciplina painelBuscaDisciplina;

    private static PainelCadastroDisciplina instance;


    private PainelCadastroDisciplina() {

        gerenciador = GerenciadorDisciplinas.getInstance();
        this.setLayout(new BorderLayout());

        JPanel painelCadastro = montaPainelCadastroDisciplina();
        JPanel painelBotoes = montaPainelBotoes();

        this.add(painelCadastro, BorderLayout.CENTER);
        this.add(painelBotoes, BorderLayout.SOUTH);
    }

    public static PainelCadastroDisciplina getInstance() {
        if (instance == null) {
            instance = new PainelCadastroDisciplina();
        }
        return instance;
    }

    private JPanel montaPainelCadastroDisciplina() {
        JPanel painel = new JPanel();

        lblCodDisc = new JLabel("Codigo da Disciplina");
        txtCodDisc = new JTextField();
        txtCodDisc.setEditable(false);
        txtCodDisc.setColumns(3);
        lblNomeDisc = new JLabel("Nome da Disciplina: ");
        txtNomeDisc = new JTextField();
        txtNomeDisc.setColumns(10);
        lblCargaHoraria = new JLabel("Carga Horária: ");
        txtCargaHoraria = new JTextField();
        txtCargaHoraria.setColumns(3);
        lblAulasSemana = new JLabel("Aulas na Semana: ");

        JPanel painelRadioButton = new JPanel();

        radio1 = new JRadioButton("1 dia");
        radio2 = new JRadioButton("2 dias");
        radio3 = new JRadioButton("3 dias");
        radio4 = new JRadioButton("4 dias");
        radio5 = new JRadioButton("5 dias");
        radio6 = new JRadioButton("6 dias");

        radio1.setActionCommand("1");
        radio2.setActionCommand("2");
        radio3.setActionCommand("3");
        radio4.setActionCommand("4");
        radio5.setActionCommand("5");
        radio6.setActionCommand("6");

        group = new ButtonGroup();

        group.add(radio1);
        group.add(radio2);
        group.add(radio3);
        group.add(radio4);
        group.add(radio5);
        group.add(radio6);

        painelRadioButton.add(radio1);
        painelRadioButton.add(radio2);
        painelRadioButton.add(radio3);
        painelRadioButton.add(radio4);
        painelRadioButton.add(radio5);
        painelRadioButton.add(radio6);

        painel.add(lblCodDisc);
        painel.add(txtCodDisc);
        painel.add(lblNomeDisc);
        painel.add(txtNomeDisc);
        painel.add(lblCargaHoraria);
        painel.add(txtCargaHoraria);
        painel.add(lblAulasSemana);
        painel.add(painelRadioButton);

        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        hGroup.addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(lblCodDisc)
                        .addComponent(lblNomeDisc)
                        .addComponent(lblCargaHoraria)
                        .addComponent(lblAulasSemana))
                .addGroup(layout.createParallelGroup()
                        .addComponent(txtCodDisc)
                        .addComponent(txtNomeDisc)
                        .addComponent(txtCargaHoraria)
                        .addComponent(painelRadioButton)));

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblCodDisc)
                .addComponent(txtCodDisc));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblNomeDisc)
                .addComponent(txtNomeDisc));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblCargaHoraria)
                .addComponent(txtCargaHoraria));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblAulasSemana)
                .addComponent(painelRadioButton));

        layout.setVerticalGroup(vGroup);

        painelRadioButton.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));

        return painel;
    }

    private JPanel montaPainelBotoes() {
        JPanel painelBotoes = new JPanel();
        FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
        painelBotoes.setLayout(layout);
        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> {
            btnSalvar.setEnabled(false);
            Thread threadDao = new Thread(new SalvarDisciplina());
            threadDao.start();
            if (painelBuscaDisciplina != null) {
                painelBuscaDisciplina.atualizaTabela();
            }
        });

        btnCancelar = new JButton("Limpar");
        btnCancelar.addActionListener(e -> setDisciplina(disciplina));
        painelBotoes.add(btnCancelar);
        painelBotoes.add(btnSalvar);
        return painelBotoes;
    }

    void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
        txtCodDisc.setText(disciplina.getCodDisc().toString());
        txtNomeDisc.setText(disciplina.getNomeDisc());
        txtCargaHoraria.setText(disciplina.getCargaHoraria().toString());
    }

    private Disciplina getDisciplinaAlterada() {
        Disciplina disciplinaAlterada = new Disciplina();
        disciplinaAlterada.setCodDisc(Integer.parseInt(txtCodDisc.getText()));
        disciplinaAlterada.setNomeDisc(txtNomeDisc.getText());
        disciplinaAlterada.setCargaHoraria(Integer.parseInt(txtCargaHoraria.getText()));
        disciplinaAlterada.setAulasSemana(group.getSelection().getActionCommand());
        return disciplinaAlterada;
    }

    private class SalvarDisciplina implements Runnable {

        @Override
        public void run() {
            Disciplina disciplinaAlterada = getDisciplinaAlterada();
            try {
                gerenciador.salvar(disciplinaAlterada);
                JOptionPane.showMessageDialog(null, "Disciplina salva com sucesso!",
                        "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            } catch (DadosException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível confirmar a operação",
                        "Confirmação", JOptionPane.ERROR_MESSAGE);
            }
            disciplina = disciplinaAlterada;
            PainelBuscaDisciplina.getInstance().atualizaTabela();
            SwingUtilities.invokeLater(() -> {
                btnSalvar.setEnabled(true);
                txtCodDisc.setText(disciplina.getCodDisc().toString());
            });
        }
    }
}
