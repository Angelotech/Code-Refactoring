package br.com.Alura.Service;
import Config.ConfigService;
import Service.PetService;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PetServiceTeste {
    private ConfigService client = mock(ConfigService.class); //logica puxar metodos get e set
    private PetService petAbrigo = new PetService(client); //
    private HttpResponse<String> response = mock(HttpResponse.class);

    @Test
    public void deverListarDePets()
            throws IOException, InterruptedException {

        // 1. Simula o que o usuário digita
        String userInput = "Teste" + System.lineSeparator();

        ByteArrayInputStream bais =
                new ByteArrayInputStream(userInput.getBytes());

        System.setIn(bais);

        // 2. Configura a resposta falsa da API
        when(response.statusCode()).thenReturn(200);

        when(response.body()).thenReturn("""
        [
            {
                "id": 1,
                "tipo": "CACHORRO",
                "nome": "Rex",
                "raca": "Poodle",
                "idade": 5
            }
        ]
        """);


        when(client.RequisicaoGet(anyString()))
                .thenReturn(response);

        ByteArrayOutputStream baos =
                new ByteArrayOutputStream();

        PrintStream printStream =
                new PrintStream(baos);

        System.setOut(printStream);

       petAbrigo.ListarPets();

        String saida = baos.toString();

        // 7. Verifica se Rex foi listado
        assertTrue(saida.contains("Rex"));
    }


}
