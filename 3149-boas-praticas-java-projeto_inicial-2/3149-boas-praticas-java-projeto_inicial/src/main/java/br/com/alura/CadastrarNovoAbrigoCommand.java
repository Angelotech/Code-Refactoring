package br.com.alura;

import Config.ConfigService;
import Service.AbrigoService;

import java.io.IOException;

public class CadastrarNovoAbrigoCommand implements Command{
    @Override
    public void execute() {
        ConfigService client = new ConfigService();
        AbrigoService abrigo = new AbrigoService(client);

        try {
            abrigo.CadastrarNovoAbrigo();
        } catch (IOException | InterruptedException e) {
            System.out.println("Obtivemos uma exceção " + e.getMessage());
        }

    }

}
