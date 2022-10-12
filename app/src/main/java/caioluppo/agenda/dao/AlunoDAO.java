package caioluppo.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import caioluppo.agenda.model.Aluno;

public class AlunoDAO {

    private static final List<Aluno> alunos = new ArrayList<>();

    public void salva(Aluno alunoCriado) {
        alunos.add(alunoCriado);
    }

    public List<Aluno> todosAlunos() {
        return new ArrayList<>(alunos);
    }

}
