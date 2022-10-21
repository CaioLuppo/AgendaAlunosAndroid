package caioluppo.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import caioluppo.agenda.R;
import caioluppo.agenda.model.Aluno;

public class ListaAlunosAdapter extends BaseAdapter {

    private final List<Aluno> alunos = new ArrayList<>();
    private final Context contexto;

    public ListaAlunosAdapter(Context contexto) {
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int posicao) {
        return alunos.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return alunos.get(posicao).getId();
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        View viewCriada = criaView(viewGroup);
        Aluno alunoDevolvido = alunos.get(posicao);
        vinculaAluno(viewCriada, alunoDevolvido);
        return viewCriada;
    }

    private void vinculaAluno(View viewCriada, Aluno alunoDevolvido) {
        TextView nomeAluno = viewCriada.findViewById(R.id.item_aluno_nome);
        TextView telefoneAluno = viewCriada.findViewById(R.id.item_aluno_telefone);
        nomeAluno.setText(alunoDevolvido.getNome());
        telefoneAluno.setText(alunoDevolvido.getTelefone());
    }

    private View criaView(ViewGroup viewGroup) {
        return LayoutInflater
                .from(contexto)
                .inflate(R.layout.item_aluno, viewGroup, false);
    }

    public void atualiza(List<Aluno> alunos) {
        this.alunos.clear();
        this.alunos.addAll(alunos);
        notifyDataSetChanged();
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
        notifyDataSetChanged();
    }
}
