package view;

import models.EspecProf;
import models.TituloProf;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;

public class PainelCadastroProfessor extends JPanel {
    private JCheckBox[] checkBoxes;

    private static PainelCadastroProfessor instance;

    public PainelCadastroProfessor() {
        this.setLayout(new BorderLayout());

        JPanel painelCadastro = montaPainelCadastroProfessor();
        JPanel painelBotoes = montaPainelBotoes();

        this.add(painelCadastro, BorderLayout.CENTER);
        this.add(painelBotoes, BorderLayout.SOUTH);
    }

    public static PainelCadastroProfessor getInstance() {
        if (instance == null) {
            instance = new PainelCadastroProfessor();
        }
        return instance;
    }

    private JPanel montaPainelCadastroProfessor() {
        JPanel painelCadastroProfessor = new JPanel();

        JLabel lblIdentProf = new JLabel("Identificação");
        JTextField txtIdentProf = new JTextField();
        txtIdentProf.setColumns(5);
        txtIdentProf.setEditable(false);
        JLabel lblNomeProf = new JLabel("Nome");
        JTextField txtNomeProf = new JTextField();
        txtNomeProf.setColumns(5);
        JLabel lblEndProfLogradouro = new JLabel("Logradouro");
        JTextField txtEndProfLogradouro = new JTextField();
        txtEndProfLogradouro.setColumns(5);
        JLabel lblEndProfNumero = new JLabel("Número");
        JTextField txtEndProfNumero = new JTextField();
        txtEndProfNumero.setColumns(5);
        JLabel lblEndProfBairro = new JLabel("Bairro");
        JTextField txtEndProfBairro = new JTextField();
        txtEndProfBairro.setColumns(5);
        JLabel lblEndProfCidade = new JLabel("Cidade");
        JTextField txtEndProfCidade = new JTextField();
        txtEndProfCidade.setColumns(5);
        JLabel lblEndProfEstado = new JLabel("Estado");
        JTextField txtEndProfEstado = new JTextField();
        txtEndProfEstado.setColumns(5);
        JLabel lblEndProfTelFixo = new JLabel("Telefone fixo");
        JTextField txtEndProfTelFixo = new JTextField();
        txtEndProfTelFixo.setColumns(5);
        JLabel lblEndProfCelular = new JLabel("Celular");
        JTextField txtEndProfCelular = new JTextField();
        txtEndProfCelular.setColumns(5);
        JLabel lblDataNasc = new JLabel("Data de Nascimento");
        DateFormat dataFormatada = DateFormat.getDateInstance(DateFormat.SHORT);
        JFormattedTextField txtDataNasc = new JFormattedTextField(dataFormatada);

        txtDataNasc.setColumns(4);

        JLabel lblEspecProf = new JLabel("Especialização:");

        JPanel painelEspecProf = montaPainelEspecProf();

        JPanel painelTituloProf = montaPainelTituloProf();

        JLabel lblTituloProf = new JLabel("Título: ");

        GroupLayout layout = new GroupLayout(painelCadastroProfessor);
        painelCadastroProfessor.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        hGroup.addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(lblIdentProf)
                        .addComponent(lblNomeProf)
                        .addComponent(lblEndProfLogradouro)
                        .addComponent(lblEndProfNumero)
                        .addComponent(lblEndProfBairro)
                        .addComponent(lblEndProfCidade)
                        .addComponent(lblEndProfEstado)
                        .addComponent(lblEndProfTelFixo)
                        .addComponent(lblEndProfCelular)
                        .addComponent(lblDataNasc)
                        .addComponent(lblEspecProf)
                        .addComponent(lblTituloProf))
                .addGroup(layout.createParallelGroup()
                        .addComponent(txtIdentProf)
                        .addComponent(txtNomeProf)
                        .addComponent(txtEndProfLogradouro)
                        .addComponent(txtEndProfNumero)
                        .addComponent(txtEndProfBairro)
                        .addComponent(txtEndProfCidade)
                        .addComponent(txtEndProfEstado)
                        .addComponent(txtEndProfTelFixo)
                        .addComponent(txtEndProfCelular)
                        .addComponent(txtDataNasc)
                        .addComponent(painelEspecProf)
                        .addComponent(painelTituloProf)));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblIdentProf)
                .addComponent(txtIdentProf));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblNomeProf)
                .addComponent(txtNomeProf));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblEndProfLogradouro)
                .addComponent(txtEndProfLogradouro));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblEndProfNumero)
                .addComponent(txtEndProfNumero));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblEndProfBairro)
                .addComponent(txtEndProfBairro));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblEndProfCidade)
                .addComponent(txtEndProfCidade));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblEndProfEstado)
                .addComponent(txtEndProfEstado));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblEndProfTelFixo)
                .addComponent(txtEndProfTelFixo));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblEndProfCelular)
                .addComponent(txtEndProfCelular));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblDataNasc)
                .addComponent(txtDataNasc));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblEspecProf)
                .addComponent(painelEspecProf));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblTituloProf)
                .addComponent(painelTituloProf));

        layout.setVerticalGroup(vGroup);

        return painelCadastroProfessor;
    }

    private JPanel montaPainelBotoes() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnEditar = new JButton("Limpar");
        JButton btnExcluir = new JButton("Salvar");

        painel.add(btnEditar);
        painel.add(btnExcluir);
        return painel;
    }

    private JPanel montaPainelEspecProf() {
        JPanel painelEspecProf = new JPanel();
        EspecProf[] especializacoes = EspecProf.values();

        checkBoxes = new JCheckBox[especializacoes.length];

        for (int i = 0; i < especializacoes.length; i++) {
            checkBoxes[i] = new JCheckBox(especializacoes[i].getDescricao());
            checkBoxes[i].setActionCommand(especializacoes[i].getDescricao());
            painelEspecProf.add(checkBoxes[i]);
        }
        return painelEspecProf;
    }

    private JPanel montaPainelTituloProf() {
        JPanel painelTituloProf = new JPanel();
        TituloProf[] titulos = TituloProf.values();

        checkBoxes = new JCheckBox[titulos.length];

        for (int i = 0; i < titulos.length; i++) {
            checkBoxes[i] = new JCheckBox(titulos[i].getDescricao());
            checkBoxes[i].setActionCommand(titulos[i].getDescricao());
            painelTituloProf.add(checkBoxes[i]);
        }
        return painelTituloProf;
    }
}
