package util;

import model.Curso;
import model.*;
import model.Professor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoCurso {
    private static final String ARQUIVO_CURSOS = "cursos.dat";

    public static void salvarCursos(List<Curso> cursos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CURSOS))) {
            oos.writeObject(cursos);
            oos.close();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao salvar cursos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado ao salvar cursos: " + e.getMessage());
        }
    }

    public static List<Curso> carregarCursos() {
        File arquivo = new File(ARQUIVO_CURSOS);

        // Se o arquivo não existir, cria dados padrão
        if (!arquivo.exists()) {
            try {
                List<Usuario> usuarios = ArquivoLogin.carregarUsuarios(); // Carrega professores
                List<Curso> cursosPadrao = new ArrayList<>();

                // Obtém professores (IDs 3 e 4, conforme dados padrão de usuários)
                Professor professor1 = (Professor) usuarios.get(2); // professor1@email.com
                Professor professor2 = (Professor) usuarios.get(3); // professor2@email.com

                cursosPadrao.add(new Curso(1, "Programação Java", "Aprenda Java do básico ao avançado", professor1));
                cursosPadrao.add(new Curso(2, "Banco de Dados", "SQL e modelagem de dados", professor2));
                cursosPadrao.add(new Curso(3, "Spring Boot", "Desenvolvimento web com Spring", professor1));

                salvarCursos(cursosPadrao); // Salva os dados padrão no arquivo
                return cursosPadrao;
            } catch (Exception e) {
                System.err.println("Erro ao criar cursos padrão: " + e.getMessage());
                return new ArrayList<>();
            }
        }
        // Se o arquivo existir, carrega normalmente
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_CURSOS))) {
            return (List<Curso>) ois.readObject();
        }catch (FileNotFoundException e){
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        }catch (IOException e) {
            System.err.println("Erro de I/O ao carregar cursos: " + e.getMessage());
        }catch (ClassNotFoundException e){
            System.err.println("Classe não encontrado: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}