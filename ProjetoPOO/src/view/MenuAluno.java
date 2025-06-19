package view;

import model.Aluno;
import model.Curso;
import model.Inscricao;
import model.Professor;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MenuAluno {
    public static void exibir(Aluno aluno, List<Curso> todosOsCursos) {
        Scanner sc = new Scanner(System.in);
        char op;

        do {
            System.out.println("\n=== MENU ALUNO ===");
            System.out.println("1 - Fazer inscrição");
            System.out.println("2 - Ver os cursos que estou inscrito");
            System.out.println("3 - Ver os integrantes de um curso");
            System.out.println("4 - Avaliar um curso"); // Nova opção
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            op = sc.nextLine().charAt(0);

            switch (op) {
                case '1':
                    inscreverEmCurso(aluno, todosOsCursos);
                    break;
                case '2':
                    verCursosInscritos(aluno);
                    break;
                case '3':
                    verIntegrantesDeCurso(aluno);
                    break;
                case '4': // Nova opção
                    avaliarCurso(aluno);
                    break;
                case '0':
                    System.out.println("Saindo do menu do aluno...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (op != '0');
    }

    private static void inscreverEmCurso(Aluno aluno, List<Curso> todosOsCursos) {

        System.out.println("Escolha um curso para se inscrever: ");

        for (int i = 0; i < todosOsCursos.size(); i++) // mostra os cursos criados
        {
            Curso curso = todosOsCursos.get(i);
            System.out.println(i + " " + curso.getNome() + ": " + curso.getDescricao());
        }

        System.out.println("Digite o número do curso para se inscrever");
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        sc.nextLine();

        Curso cursoEscolhido = todosOsCursos.get(op); // pega o curso escolhido

        Inscricao nova = new Inscricao(new Random().nextInt(), cursoEscolhido, aluno, LocalDate.now()); // cria objeto inscricao
        cursoEscolhido.adicionarInscricao(nova);
        aluno.inscreverCurso(cursoEscolhido);
        System.out.println("Inscrição realizada com sucesso no curso: " + cursoEscolhido.getNome());
    }

    private static void verCursosInscritos(Aluno aluno) {
        List<Curso> cursos = aluno.getCursosInscritos();

        if (cursos.isEmpty()) {
            System.out.println("Você ainda não está inscrito em nenhum curso.");
        } else {
            System.out.println("\n=== Cursos Inscritos ===");
            for (Curso curso : cursos) {
                System.out.println("- " + curso.getNome() + ": " + curso.getDescricao());
            }
        }
    }

    private static void verIntegrantesDeCurso(Aluno aluno) {
        List<Curso> cursos = aluno.getCursosInscritos();

        if (cursos.isEmpty()) {
            System.out.println("Você não está inscrito em nenhum curso.");
            return;
        }

        System.out.println("\n=== Seus Cursos Inscritos ===");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, cursos.get(i).getNome());
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Escolha o número do curso para ver os integrantes: ");
        int op = Integer.parseInt(sc.nextLine());

        if (op < 1 || op > cursos.size()) {
            System.out.println("Curso inválido.");
            return;
        }

        Curso cursoEscolhido = cursos.get(op - 1);
        List<Inscricao> inscricoes = cursoEscolhido.getInscricoes();

        if (inscricoes.isEmpty()) {
            System.out.println("Nenhum aluno inscrito neste curso.");
            return;
        }

        System.out.println("\n=== Alunos inscritos no curso " + cursoEscolhido.getNome() + " ===");
        for (Inscricao i : inscricoes) {
            Aluno inscrito = i.getAluno();
            System.out.println("- " + inscrito.getEmail() + " | Matrícula: " + inscrito.getMatricula());
        }
    }

    private static void avaliarCurso(Aluno aluno) {
        Scanner sc = new Scanner(System.in);

        try {
            List<Curso> cursosInscritos = aluno.getCursosInscritos();

            if (cursosInscritos.isEmpty()) {
                System.out.println("Você não está inscrito em nenhum curso para avaliar.");
                return;
            }

            System.out.println("\n=== Cursos Inscritos Disponíveis para Avaliação ===");
            for (int i = 0; i < cursosInscritos.size(); i++) {
                Curso curso = cursosInscritos.get(i);
                System.out.printf("%d - %s (Média atual: %.1f)\n", i + 1, curso.getNome(), curso.getMediaAvaliacoes());
            }

            System.out.print("Escolha o número do curso para avaliar: ");
            int escolha = Integer.parseInt(sc.nextLine()) - 1;

            if (escolha < 0 || escolha >= cursosInscritos.size()) {
                System.out.println("Opção inválida!");
                return;
            }

            Curso cursoEscolhido = cursosInscritos.get(escolha);
            Professor professor = cursoEscolhido.getProfessor();

            System.out.printf("\nAvaliando o curso: %s\n", cursoEscolhido.getNome());
            System.out.print("Digite sua nota para o curso (1 a 5): ");
            double notaCurso = Double.parseDouble(sc.nextLine());

            System.out.printf("\nAvaliando o professor: %s\n", professor.getEmail());
            System.out.print("Digite sua nota para o professor (1 a 5): ");
            double notaProfessor = Double.parseDouble(sc.nextLine());

            // Adiciona as avaliações
            if (notaCurso >= 1 && notaCurso <= 5 && notaProfessor >= 1 && notaProfessor <= 5) {
                cursoEscolhido.adicionarAvaliacao(notaCurso);
                professor.adicionarAvaliacao(notaProfessor);
                System.out.println("Avaliação registrada com sucesso!");
            } else {
                System.out.println("Nota inválida! Deve ser entre 1 e 5.");
            }
        }catch (NumberFormatException e) {
            System.err.println("Erro: Você deve digitar um número válido.");
        } catch (NullPointerException e) {
            System.err.println("Erro: Dados inválidos encontrados.");
        } catch (InputMismatchException e) {
            System.err.println("Erro: Insira numeros de 1 a 5"+ e.getMessage()) ;
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }
}