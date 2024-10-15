import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {
    	Scanner scanner = new Scanner(System.in);
    	String caminhoDoArquivo;
    	List<String> linhas;
    	String[] instrucoes;
    	Processador processador;
        System.out.println("Deseja habilitar predição? S/N");
        String resposta = scanner.nextLine();
        if(resposta.equals("S")) {
        	caminhoDoArquivo = "InstrucoesParte2.txt";
        	linhas = Files.readAllLines(Paths.get(caminhoDoArquivo));
        	instrucoes = linhas.toArray(new String[0]);
        	processador = new Processador(instrucoes, true);
        }
        else {
        	caminhoDoArquivo = "InstrucoesParte1.txt";
        	linhas = Files.readAllLines(Paths.get(caminhoDoArquivo));
        	instrucoes = linhas.toArray(new String[0]);
        	processador = new Processador(instrucoes, false);
        }
        System.out.println();
        while(processador.acabou == 0) {
            // Espera o usuário pressionar Enter para continuar
            System.out.print("Pressione Enter para continuar...");
            scanner.nextLine(); // Aguarda a entrada do usuário
            processador.writeback();
            processador.memoria();
            processador.execucao();
            processador.decodificacao();
            processador.busca();
            processador.imprimirEstado();
        }
        scanner.close();
        System.out.println("Instruções Finalizadas!");
        if(resposta.equals("S")) {
        	System.out.println("Preveu corretamente "+processador.preveuCerto+" vezes");
        	System.out.println("Preveu incorretamente "+processador.preveuErrado+" vezes");
        }
    }
}