import model.Aluno;
import model.Curso;
import model.Professor;
import model.Usuario;
import util.ArquivoCurso;
import util.SistemaConta;
import util.SistemaLogin;
import view.MenuAluno;
import view.MenuPrincipal;
import view.MenuProfessor;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaConta sistemaConta = new SistemaConta();
        SistemaLogin sistemaLogin = new SistemaLogin();


         while (true) {
             try {
             MenuPrincipal.exibir();
             char op = sc.nextLine().charAt(0);

             if (op == 'n') {
                 sistemaConta.criarConta();
             } else if (op == 's') {
                 Usuario usuarioLogado = sistemaLogin.fazerLogin();

                 if (usuarioLogado != null) {
                     List<Curso> listaDeCursos = ArquivoCurso.carregarCursos();
                     if (listaDeCursos == null) listaDeCursos = new ArrayList<>();

                     if (usuarioLogado instanceof Aluno aluno) {
                         MenuAluno.exibir(aluno, listaDeCursos);
                     } else if (usuarioLogado instanceof Professor professor) {
                         MenuProfessor.exibirProfessor(professor);
                     }
                 }

             } else if (op == 'v') {
                 sistemaConta.visualizarCadastros();
             } else if (op == 'q') {
                 System.out.println("Saindo do sistema...");
                 break;
             } else {
                 System.out.println("Opção inválida!");
             }
             } catch (InputMismatchException e) {
                 System.err.println("Erro: Insira numeros de 1 a 5 ");
             }catch (StringIndexOutOfBoundsException e ){
                 System.err.println("Erro : Voce esqueceu de digitar uma opção");
             } catch (IndexOutOfBoundsException e ){
                 System.err.println("Erro: Digite um numeros de 1 a 5");
             }
             System.out.println();
         }
         }

}
