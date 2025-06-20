package util;

import model.Aluno;
import model.Professor;
import model.Usuario;
import util.ArquivoLogin;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaConta {

    private static int proximoId = 1;

    public void criarConta() {
        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuarios = ArquivoLogin.carregarUsuarios(); // carrega a info do arquivo
        if (usuarios == null) usuarios = new ArrayList<>(); // se nulo cria uma lista de usuarios

        System.out.println("== Criar Conta ===");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.print("Escolha o tipo de usuário: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario novoUsuario; // cria um novo usuario

        if (tipo == 1) {
            System.out.print("Matrícula: "); // se for aluno tem que botar a matricula
            String matricula = scanner.nextLine();
            novoUsuario = new Aluno(proximoId++, email, senha, matricula); // cria um novo objeto aluno
        } else if (tipo == 2) {
            novoUsuario = new Professor(proximoId++, email, senha); // se for professor cria um novo objeto professor
        } else {
            System.out.println("Tipo inválido."); // validação
            return;
        }

        usuarios.add(novoUsuario); // coloca essa bomba na lista
        ArquivoLogin.salvarUsuarios(usuarios); // e finalmente consegui salvar essa bomba aqui no arquivo
        System.out.println("Conta criada com sucesso!"); // agora e só chamar na main
    }

    public void visualizarCadastros() {
        List<Usuario> usuarios = ArquivoLogin.carregarUsuarios();
        List<Curso> cursos = ArquivoCurso.carregarCursos();

        System.out.println("\n=== USUÁRIOS CADASTRADOS ===");
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getIdUsuario() +
                    " | Email: " + u.getEmail() +
                    " | Tipo: " + u.getTipo());
        }

        System.out.println("\n=== CURSOS CADASTRADOS ===");
        for (Curso c : cursos) {
            System.out.println("ID: " + c.getIdCurso() +
                    " | Nome: " + c.getNome() +
                    " | Professor: " + c.getProfessor().getEmail());
        }
    }
}
