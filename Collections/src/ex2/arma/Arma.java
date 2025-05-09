package ex2.arma;

public abstract class Arma implements Comparable<Arma>{
    protected String nome;
    protected int qualidade;

    public Arma(String nome, int qualidade) {
        this.nome = nome;
        this.qualidade = qualidade;
    }

    public String getNome(){ return nome; }

    @Override
    public int compareTo(Arma o){
        return this.nome.compareTo(o.getNome());
    }
}
