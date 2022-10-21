package caioluppo.agenda.dao;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import caioluppo.agenda.model.Aluno;

public class AlunoDAO {

    private static final List<Aluno> alunos = new ArrayList<>();
    private static int contadorId = 1;

    public void salva(Aluno alunoCriado) {
        alunoCriado.setId(contadorId);
        alunos.add(alunoCriado);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorId++;
    }

    public void editar(Aluno aluno) {
        Aluno alunoEncontrado = buscaAlunoPorId(aluno);
        if (alunoEncontrado != null) {
            int posicaoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoAluno, aluno);
        }
    }

    @Nullable
    private Aluno buscaAlunoPorId(Aluno aluno) {
        for (Aluno a :
                alunos) {
            if (a.getId() == aluno.getId()) {
               return a;
            }
        }
        return null;
    }

    public List<Aluno> todosAlunos() {
        return new ArrayList<>(alunos);
    }

    public void remove(Aluno aluno) {

        Aluno alunoDevolvido = buscaAlunoPorId(aluno);

        if (alunoDevolvido != null) {
            alunos.remove(alunoDevolvido);
        }


    }
}
