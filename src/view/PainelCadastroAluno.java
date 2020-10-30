package view;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;

import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

public class PainelCadastroAluno extends JPanel {

    private static PainelCadastroAluno instance;

    private PainelCadastroAluno() {
        this.setLayout(new BorderLayout());

        JPanel painelCadastro = montaPainelCadastroAluno();
        JPanel painelBotoes = montaPainelBotoes();

        this.add(painelCadastro, BorderLayout.CENTER);
        this.add(painelBotoes, BorderLayout.SOUTH);
    }

    public static PainelCadastroAluno getInstance() {
        if (instance == null) {
            instance = new PainelCadastroAluno();
        }
        return instance;
    }

    private JPanel montaPainelCadastroAluno() {
        JPanel painelCadastroAluno = new JPanel();

        JLabel lblMatricula = new JLabel("Matrícula: ");
        JTextField txtMatricula = new JTextField();
        txtMatricula.setColumns(5);
        txtMatricula.setEditable(false);
        JLabel lblNome = new JLabel("Nome: ");
        JTextField txtNome = new JTextField();
        txtNome.setColumns(10);
        JLabel lblDataNasc = new JLabel("Data de nascimento: ");
        DateFormat dataFormatada = DateFormat.getDateInstance(DateFormat.SHORT);
        JFormattedTextField txtDataNasc = new JFormattedTextField(dataFormatada);
        txtDataNasc.setColumns(5);
        JLabel lblCodCurso = new JLabel("Código do curso: ");
        JTextField txtCodCurso = new JTextField();
        txtCodCurso.setColumns(5);
        JLabel lblNomeCurso = new JLabel("Nome do curso: ");
        JTextField txtNomeCurso = new JTextField();
        txtNomeCurso.setColumns(10);

        JLabel lblCodENomeDisc = new JLabel("Disciplina Código | Nome");

        JPanel painelCodENomeDisc = new JPanel();

        DefaultListModel listModel = new DefaultListModel();
        Integer[] listaCodDisc = {1, 2, 3, 4};
        String[] listaNomeDisc = {"Disciplina 1", "Disciplina 2", "Disciplina 3", "Disciplina 4"};

        for (int i = 0; i < 4; i++) {
            listModel.addElement(" " + listaCodDisc[i] + " " + listaNomeDisc[i] + " ");
        }

        JList listaCodENomeDisc = new JList(listModel);
        listaCodENomeDisc.setSelectionMode(SINGLE_SELECTION);
        JScrollPane scrollLista = new JScrollPane(listaCodENomeDisc);

        painelCodENomeDisc.add(scrollLista);

        JLabel lblNp1 = new JLabel("Nota da NP1: ");
        JTextField txtNp1 = new JTextField();
        txtNp1.setColumns(2);
        JLabel lblNp2 = new JLabel("Nota da NP2: ");
        JTextField txtNp2 = new JTextField();
        txtNp2.setColumns(2);
        JLabel lblMedia = new JLabel("Média: ");
        JTextField txtMedia = new JTextField();
        txtMedia.setEditable(false);
        txtMedia.setColumns(2);
        JLabel lblFaltas = new JLabel("Faltas: ");
        JTextField txtFaltas = new JTextField();
        txtFaltas.setColumns(2);

        GroupLayout layout = new GroupLayout(painelCadastroAluno);
        painelCadastroAluno.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
        hGroup.addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(lblMatricula)
                        .addComponent(lblNome)
                        .addComponent(lblDataNasc)
                        .addComponent(lblCodCurso)
                        .addComponent(lblNomeCurso)
                        .addComponent(lblCodENomeDisc)
                        .addComponent(lblNp1)
                        .addComponent(lblNp2)
                        .addComponent(lblMedia)
                        .addComponent(lblFaltas)
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(txtMatricula)
                        .addComponent(txtNome)
                        .addComponent(txtDataNasc)
                        .addComponent(txtCodCurso)
                        .addComponent(txtNomeCurso)
                        .addComponent(painelCodENomeDisc)
                        .addComponent(txtNp1)
                        .addComponent(txtNp2)
                        .addComponent(txtMedia)
                        .addComponent(txtFaltas)));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblMatricula)
                .addComponent(txtMatricula));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblNome)
                .addComponent(txtNome));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblDataNasc)
                .addComponent(txtDataNasc));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblCodCurso)
                .addComponent(txtCodCurso));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblNomeCurso)
                .addComponent(txtNomeCurso));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblCodENomeDisc)
                .addComponent(painelCodENomeDisc));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblNp1)
                .addComponent(txtNp1));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblNp2)
                .addComponent(txtNp2));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblMedia)
                .addComponent(txtMedia));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblFaltas)
                .addComponent(txtFaltas));

        layout.setVerticalGroup(vGroup);

        return painelCadastroAluno;
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
