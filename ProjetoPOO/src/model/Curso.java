package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Curso implements Serializable, Avaliavel {
    private static final long serialVersionUID = 1L;
    private int idCurso;
    private String nome;
    private String descricao;
    private Professor professor;
    private List<Inscricao> inscricoes;
    private List<Double> avaliacoes;
    private double mediaAvaliacoes;

    public Curso(int idCurso, String nome, String descricao, Professor professor) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.descricao = descricao;
        this.professor = professor;
        this.inscricoes = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
        this.mediaAvaliacoes = 0.0;
    }
    // Getters
    public int getIdCurso() {
        return idCurso;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Professor getProfessor() {
        return professor;
    }


    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public double getMediaAvaliacoes(){
        return mediaAvaliacoes;
    }

    public List<Double> getAvaliacoes() {
        return avaliacoes;
    }

    // Métodos auxiliares

    public void adicionarInscricao(Inscricao inscricao) {
        inscricoes.add(inscricao);
    }
    public void adicionarAvaliacao(double nota){
        if(nota >= 1 && nota <= 5){
            avaliacoes.add(nota);
            calcularMedia();
        }
    }

    private void calcularMedia(){
        if(avaliacoes.isEmpty()){
            mediaAvaliacoes = 0.0;
            return;
        }
        double soma = 0.0;
        for(Double nota : avaliacoes)
            soma += nota;
        mediaAvaliacoes = soma/avaliacoes.size();
    }
}