package br.com.alura;

import Config.ConfigService;
import Service.PetService;

import java.io.IOException;

public class ImportarPetsCommand implements Command {
    @Override
    public void execute() {
        ConfigService client  = new ConfigService();
        PetService pet = new PetService(client);
        try {
            pet.ImportaPetsDoAbrigo();
        } catch (IOException |InterruptedException  e) {
            System.out.println("Obtivemos uma exerceção ao importar Pets " + e.getMessage() );
        }


    }
}
