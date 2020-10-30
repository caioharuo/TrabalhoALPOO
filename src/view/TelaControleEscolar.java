package view;

import models.GerenciadorDisciplinas;

import javax.swing.*;

public class TelaControleEscolar extends JFrame {
    private final PainelCadastroCurso painelCadastroCurso;
    private final PainelCadastroDisciplina painelCadastroDisciplina;
    private final PainelCadastroAluno painelCadastroAluno;
    private final PainelCadastroProfessor painelCadastroProfessor;
    private final PainelBuscaCurso painelBuscaCurso;
    private final PainelBuscaDisciplina painelBuscaDisciplina;
    private final PainelBuscaAluno painelBuscaAluno;
    private final PainelBuscaProfessor painelBuscaProfessor;
    private final PainelBuscaCursosEProfessores painelBuscaCursosEProfessores;
    private final PainelBuscaCursosEDisciplinas painelBuscaCursosEDisciplinas;
    private final PainelBuscaProfessoresEDisciplinas painelBuscaProfessoresEDisciplinas;
    private final PainelBuscaAlunosEDisciplinas painelBuscaAlunosEDisciplinas;

    private static TelaControleEscolar instance;

    private GerenciadorDisciplinas gerenciador;

    private TelaControleEscolar() {
        gerenciador = GerenciadorDisciplinas.getInstance();

        this.setTitle("Controle Escolar");
        this.setSize(560, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        painelCadastroCurso = PainelCadastroCurso.getInstance();
        painelCadastroDisciplina = PainelCadastroDisciplina.getInstance();
        painelCadastroAluno = PainelCadastroAluno.getInstance();
        painelCadastroProfessor = PainelCadastroProfessor.getInstance();
        painelBuscaCurso = PainelBuscaCurso.getInstance();
        painelBuscaDisciplina = PainelBuscaDisciplina.getInstance();
        painelBuscaAluno = PainelBuscaAluno.getInstance();
        painelBuscaProfessor = PainelBuscaProfessor.getInstance();
        painelBuscaCursosEProfessores = PainelBuscaCursosEProfessores.getInstance();
        painelBuscaCursosEDisciplinas = PainelBuscaCursosEDisciplinas.getInstance();
        painelBuscaProfessoresEDisciplinas = PainelBuscaProfessoresEDisciplinas.getInstance();
        painelBuscaAlunosEDisciplinas = PainelBuscaAlunosEDisciplinas.getInstance();

        this.setJMenuBar(montaMenu());

        this.setVisible(true);
    }

    public static TelaControleEscolar getInstance() {
        if (instance == null) {
            instance = new TelaControleEscolar();
        }
        return instance;
    }

    private JMenuBar montaMenu() {
        JMenuBar barraMenu = new JMenuBar();

        JMenu cadastrar = new JMenu("Cadastrar");

        JMenuItem cadastrarCurso = new JMenuItem("Curso");
        cadastrarCurso.addActionListener(e -> {
            JFrame frame = new JFrame();

            frame.setTitle("Cadastrar cursos");
            frame.setSize(370, 370);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.add(painelCadastroCurso);

            frame.add(painel);

            frame.setVisible(true);
        });

        JMenuItem cadastrarDisciplina = new JMenuItem("Disciplina");
        cadastrarDisciplina.addActionListener(e -> {
            JFrame frame = new JFrame();

            painelCadastroDisciplina.setDisciplina(gerenciador.getNovaDisciplina());

            frame.setTitle("Cadastrar disciplinas");
            frame.setSize(560, 230);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();

            painel.add(painelCadastroDisciplina);

            frame.add(painel);

            frame.setVisible(true);
        });

        JMenuItem cadastrarAluno = new JMenuItem("Aluno");
        cadastrarAluno.addActionListener(e -> {
            JFrame frame = new JFrame();

            frame.setTitle("Cadastrar alunos");
            frame.setSize(300, 490);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.add(painelCadastroAluno);

            frame.add(painel);

            frame.setVisible(true);
        });

        JMenuItem cadastrarProfessor = new JMenuItem("Professor");
        cadastrarProfessor.addActionListener(e -> {
            JFrame frame = new JFrame();

            frame.setTitle("Cadastrar professores");
            frame.setSize(600, 430);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.add(painelCadastroProfessor);

            frame.add(painel);

            frame.setVisible(true);
        });

        JMenu mostrar = new JMenu("Mostrar");

        JMenuItem mostrarCurso = new JMenuItem("Curso");
        mostrarCurso.addActionListener(e -> {
            JFrame frame = new JFrame();

            frame.setTitle("Mostrar cursos");
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.add(painelBuscaCurso);

            frame.add(painel);

            frame.setVisible(true);
        });

        JMenuItem mostrarDisciplina = new JMenuItem("Disciplina");
        mostrarDisciplina.addActionListener(e -> {
            JFrame frame = new JFrame();

            frame.setTitle("Mostrar disciplinas");;
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.add(painelBuscaDisciplina);

            frame.add(painel);

            frame.setVisible(true);
        });

        JMenuItem mostrarAluno = new JMenuItem("Aluno");
        mostrarAluno.addActionListener(e -> {
            JFrame frame = new JFrame();

            frame.setTitle("Mostrar alunos");
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.add(painelBuscaAluno);

            frame.add(painel);

            frame.setVisible(true);
        });

        JMenuItem mostrarProfessor = new JMenuItem("Professor");
        mostrarProfessor.addActionListener(e -> {
            JFrame frame = new JFrame();

            frame.setTitle("Mostrar professores");
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.add(painelBuscaProfessor);

            frame.add(painel);

            frame.setVisible(true);
        });

        JMenuItem mostrarCursoEProfessor = new JMenuItem("Curso/Professor");
        mostrarCursoEProfessor.addActionListener(e -> {
            JFrame frame = new JFrame();

            frame.setTitle("Mostrar Cursos e Professores");
            frame.setSize(1080, 600);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.add(painelBuscaCursosEProfessores);

            frame.add(painel);

            frame.setVisible(true);
        });

        JMenuItem mostrarCursoEDisciplina = new JMenuItem("Curso/Disciplina");
        mostrarCursoEDisciplina.addActionListener(e -> {
            JFrame frame = new JFrame();

            frame.setTitle("Mostrar Cursos e Disciplinas");
            frame.setSize(1080, 600);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.add(painelBuscaCursosEDisciplinas);

            frame.add(painel);

            frame.setVisible(true);
        });

        JMenuItem mostrarProfessorEDisciplina = new JMenuItem("Professor/Disciplina");
        mostrarProfessorEDisciplina.addActionListener(e -> {
            JFrame frame = new JFrame();

            frame.setTitle("Mostrar Professores e Disciplinas");
            frame.setSize(1080, 600);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.add(painelBuscaProfessoresEDisciplinas);

            frame.add(painel);

            frame.setVisible(true);
        });

        JMenuItem mostrarAlunoEDisciplina = new JMenuItem("Aluno/Disciplina");
        mostrarAlunoEDisciplina.addActionListener(e -> {
            JFrame frame = new JFrame();

            frame.setTitle("Mostrar Alunos e Disciplinas");
            frame.setSize(1080, 600);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            JPanel painel = new JPanel();
            painel.add(painelBuscaAlunosEDisciplinas);

            frame.add(painel);

            frame.setVisible(true);
        });

        JMenu sair = new JMenu("Sair");

        cadastrar.add(cadastrarCurso);
        cadastrar.add(cadastrarDisciplina);
        cadastrar.add(cadastrarAluno);
        cadastrar.add(cadastrarProfessor);

        barraMenu.add(cadastrar);

        mostrar.add(mostrarCurso);
        mostrar.add(mostrarDisciplina);
        mostrar.add(mostrarAluno);
        mostrar.add(mostrarProfessor);
        mostrar.add(mostrarCursoEProfessor);
        mostrar.add(mostrarCursoEDisciplina);
        mostrar.add(mostrarProfessorEDisciplina);
        mostrar.add(mostrarAlunoEDisciplina);

        barraMenu.add(mostrar);

        barraMenu.add(sair);

        return barraMenu;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(TelaControleEscolar::getInstance);
    }
}
