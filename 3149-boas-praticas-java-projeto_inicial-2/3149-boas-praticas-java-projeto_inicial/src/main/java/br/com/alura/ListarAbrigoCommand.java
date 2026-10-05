package br.com.alura;

import Config.ConfigService;
import Service.AbrigoService;
import java.io.IOException;

public class ListarAbrigoCommand implements Command{
    @Override
    public void execute() {
        ConfigService client  = new ConfigService();
        AbrigoService abrigo = new AbrigoService(client);

        try {
            abrigo.ListarAbrigosCadastrados();
        } catch (IOException | InterruptedException e) {
            System.out.println("temos uma exerceção " + e.getMessage());
        }
    }
}
