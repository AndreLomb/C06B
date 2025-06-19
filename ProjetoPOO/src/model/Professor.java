package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario implements Serializable, Avaliavel, Gerenciavel {
    private static final long serialVersionUID = 1L;
    private List<Curso> cursosMinistrados;
    private List<Double> avaliacoes; // Notas de 1 a 5
    private double mediaAvaliacoes;

    public Professor(int idUsuario, String email, String senha) {
        super(idUsuario, email, senha, "professor");
        this.cursosMinistrados = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
        this.mediaAvaliacoes = 0.0;
    }

    // Getter
    public List<Curso> getCursosMinistrados() {
        return cursosMinistrados;
    }

    public double getMediaAvaliacoes() {
        return mediaAvaliacoes;
    }

    public List<Double> getAvaliacoes() {
        return avaliacoes;
    }

    // Métodos auxiliares
    public void adicionarCurso(Curso curso) {
        if (!cursosMinistrados.contains(curso)) {
            cursosMinistrados.add(curso);
        }
    }

    public void adicionarAvaliacao(double nota) {
        if (nota >= 1 && nota <= 5) {
            avaliacoes.add(nota);
            calcularMedia();
        }
    }

    private void calcularMedia() {
        if (avaliacoes.isEmpty()) {
            mediaAvaliacoes = 0.0;
            return;
        }
        double soma = 0.0;
        for (Double nota : avaliacoes) {
            soma += nota;
        }
        mediaAvaliacoes = soma / avaliacoes.size();
    }

    @Override
    public boolean autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

}