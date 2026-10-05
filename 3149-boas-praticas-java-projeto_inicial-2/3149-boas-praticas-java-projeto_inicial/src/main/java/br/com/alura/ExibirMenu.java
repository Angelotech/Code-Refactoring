package br.com.alura;

import java.util.Scanner;

public class ExibirMenu {
    void Menu(){
        CommandExecute command = new CommandExecute();

        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        try {
            int opcaoEscolhida = 0;
            while (opcaoEscolhida != 5) {
                System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
                System.out.println("1 -> Listar abrigos cadastrados");
                System.out.println("2 -> Cadastrar novo abrigo");
                System.out.println("3 -> Listar pets do abrigo");
                System.out.println("4 -> Importar pets do abrigo");
                System.out.println("5 -> Sair");

                String textoDigitado = new Scanner(System.in).nextLine();
                opcaoEscolhida = Integer.parseInt(textoDigitado);

                switch (opcaoEscolhida){
                    case 1 -> command.execute(new ListarAbrigoCommand());
                    case 2 -> command.execute(new CadastrarNovoAbrigoCommand());
                    case 3 -> command.execute(new ListaPetsCommand());
                    case 4 -> command.execute(new ImportarPetsCommand());
                    case 5 ->  System.exit(0);
                    default -> System.out.println("NÚMERO INVÁLIDO!");

                }

            }
            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
