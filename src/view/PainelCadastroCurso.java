package view;

import models.NomeCurso;

import javax.swing.*;
import java.awt.*;

public class PainelCadastroCurso extends JPanel {
    private static PainelCadastroCurso instance;

    private PainelCadastroCurso() {
        this.setLayout(new BorderLayout());

        JPanel painelCadastro = montaPainelCadastroCurso();
        JPanel painelBotoes = montaPainelBotoes();

        this.add(painelCadastro, BorderLayout.CENTER);
        this.add(painelBotoes, BorderLayout.SOUTH);
    }

    public static PainelCadastroCurso getInstance() {
        if (instance == null) {
            instance = new PainelCadastroCurso();
        }
        return instance;
    }

    JPanel montaPainelCadastroCurso() {
        JPanel painelCadastroCurso = new JPanel();

        JLabel lblCodCurso = new JLabel("Código");

        JTextField txtCodCurso = new JTextField();
        txtCodCurso.setEditable(false);
        txtCodCurso.setColumns(10);

        JLabel lblNomeCurso = new JLabel("Nome");

        JPanel painelNomeCurso = new JPanel();

        DefaultListModel listModel = new DefaultListModel();
        NomeCurso[] nomeCursos = NomeCurso.values();
        for (NomeCurso nomeCurso : nomeCursos) {
            listModel.addElement(nomeCurso.getDescricao());
        }

        JList listaNomeCurso = new JList(listModel);
        listaNomeCurso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollLista = new JScrollPane(listaNomeCurso);

        painelNomeCurso.add(scrollLista);

        JLabel lblTipoCurso = new JLabel("Tipo");

        JRadioButton rbtTipoCursoBacharel = new JRadioButton("Bacharel");
        JRadioButton rbtTipoCursoGestao = new JRadioButton("Gestão");
        JRadioButton rbtTipoCursoOutros = new JRadioButton("Outros");

        JPanel painelTipoCurso = new JPanel();

        ButtonGroup group = new ButtonGroup();

        group.add(rbtTipoCursoBacharel);
        group.add(rbtTipoCursoGestao);
        group.add(rbtTipoCursoOutros);

        painelTipoCurso.add(rbtTipoCursoBacharel);
        painelTipoCurso.add(rbtTipoCursoGestao);
        painelTipoCurso.add(rbtTipoCursoOutros);

        JLabel lblCargaHoraria = new JLabel("Carga horária");
        JTextField txtCargaHoraria = new JTextField();
        txtCargaHoraria.setColumns(10);

        JLabel lblCodInstituto = new JLabel("Código instituto");
        JTextField txtCodInstituto = new JTextField();
        txtCodInstituto.setColumns(10);

        GroupLayout layout = new GroupLayout(painelCadastroCurso);
        painelCadastroCurso.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        hGroup.addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(lblCodCurso)
                        .addComponent(lblNomeCurso)
                        .addComponent(lblTipoCurso)
                        .addComponent(lblCargaHoraria)
                        .addComponent(lblCodInstituto))
                .addGroup(layout.createParallelGroup()
                        .addComponent(txtCodCurso)
                        .addComponent(painelNomeCurso)
                        .addComponent(painelTipoCurso)
                        .addComponent(txtCargaHoraria)
                        .addComponent(txtCodInstituto)));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblCodCurso)
                .addComponent(txtCodCurso));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblNomeCurso)
                .addComponent(painelNomeCurso));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblTipoCurso)
                .addComponent(painelTipoCurso));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblCargaHoraria)
                .addComponent(txtCargaHoraria));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblCodInstituto)
                .addComponent(txtCodInstituto));

        layout.setVerticalGroup(vGroup);

        return painelCadastroCurso;
    }

    private JPanel montaPainelBotoes() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnEditar = new JButton("Limpar");
        JButton btnExcluir = new JButton("Salvar");

        painel.add(btnEditar);
        painel.add(btnExcluir);
        return painel;
    }
}