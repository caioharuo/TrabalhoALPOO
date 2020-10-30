package dao;

import exceptions.DadosException;
import models.EnderecoProfessor;
import models.EspecProf;
import models.Professor;
import models.TituloProf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static models.TituloProf.BACHAREL;

public class ProfessorList {

    private final List<Professor> professores;
    private static int contador = 1;

    public ProfessorList() {
        professores = new ArrayList<>();
        professores.add(new Professor(contador++, "Nome 1",
                new EnderecoProfessor("Rua Teste", 960, "Bairro 1", "Cidade 1",
                        "Estado 1", 12345678, 123456789),
                new Date(), EspecProf.INFORMATICA, TituloProf.DOUTORADO));
        professores.add(new Professor(contador++, "Nome 2",
                new EnderecoProfessor("Rua Teste 2", 123, "Bairro 2", "Cidade 2",
                        "Estado 3", 12345678, 123456789),
                new Date(), EspecProf.MATEMATICA, BACHAREL));
        professores.add(new Professor(contador++, "Nome 1",
                new EnderecoProfessor("Rua Teste 3", 32, "Bairro 4", "Cidade 4",
                        "Estado 5", 12345678, 123456789),
                new Date(), EspecProf.DIGITO, TituloProf.MESTRADO));
        professores.add(new Professor(contador++, "Nome 1",
                new EnderecoProfessor("Rua Teste 4", 321, "Bairro 9", "Cidade 10",
                        "Estado 2", 12345678, 123456789),
                new Date(), EspecProf.MEDICINA, TituloProf.ESPECIALISTA_LATO_SENSU));
    }

    public List<Professor> getTodas() throws DadosException {
        return professores;
    }

}
