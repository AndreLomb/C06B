package util;

import model.Aluno;
import model.Professor;
import model.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoLogin {
    private static final String ARQUIVO_USUARIOS = "usuarios.dat";

    public static void salvarUsuarios(List<Usuario> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_USUARIOS))) {
            oos.writeObject(usuarios);
        }catch (FileNotFoundException e){
            System.err.println("Arquivo não encontrado " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado ao salvar usuários");
        }
    }

    public static List<Usuario> carregarUsuarios() {
        File arquivo = new File(ARQUIVO_USUARIOS);

        // Se o arquivo não existir, cria dados padrão
        if (!arquivo.exists()) {
            try{
                List<Usuario> usuariosPadrao = new ArrayList<>();
                usuariosPadrao.add(new Aluno(1, "aluno1@email.com", "senha123", "20230001"));
                usuariosPadrao.add(new Aluno(2, "aluno2@email.com", "senha123", "20230002"));
                usuariosPadrao.add(new Professor(3, "professor1@email.com", "senha123"));
                usuariosPadrao.add(new Professor(4, "professor2@email.com", "senha123"));

                salvarUsuarios(usuariosPadrao); // Salva os dados padrão no arquivo
                return usuariosPadrao;
            }catch (Exception e){
                System.err.println("Erro ao criar usuários padrão: " + e.getMessage());
                return new ArrayList<>();
            }
        }

        // Se o arquivo existir, carrega normalmente
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_USUARIOS))) {
            return (List<Usuario>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro de I/O ao carregar usuários: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Classe não encontrada: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado ao carregar usuários: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}