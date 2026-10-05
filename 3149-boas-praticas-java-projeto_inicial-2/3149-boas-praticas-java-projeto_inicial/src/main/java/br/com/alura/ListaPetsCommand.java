package br.com.alura;

import Config.ConfigService;
import Service.AbrigoService;
import Service.PetService;

import java.io.IOException;

public class ListaPetsCommand implements Command {
    @Override
    public void execute() {
        ConfigService client  = new ConfigService();
        PetService pet = new PetService(client);

        try {
            pet.ListarPets();
        } catch (IOException | InterruptedException e) {
            System.out.println("temos uma exerceção ao listar pets " + e.getMessage());
        }

    }
}
