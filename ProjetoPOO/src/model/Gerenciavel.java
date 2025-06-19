package model;

import java.util.List;

public interface Gerenciavel {
    void adicionarCurso(Curso curso);
    List<Curso> getCursosMinistrados();

}
