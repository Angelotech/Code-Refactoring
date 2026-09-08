package Service;

import Config.ConfigService;
import model.Abrigo;
import tools.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AbrigoService {

    ConfigService client = new ConfigService();

    public AbrigoService(ConfigService client){
        this.client = client;
    }

    public void ListarAbrigosCadastrados() throws IOException, InterruptedException {

        String uri = "http://localhost:8080/abrigos";
        HttpResponse<String> response = client.RequisicaoGet(uri);
        String responseBody = response.body();

        //converção do Json
        Abrigo [] abrigosLista = new ObjectMapper().readValue(responseBody, Abrigo[].class);
        //convertendo em lista
        List<Abrigo> abrigoList =  Arrays.stream(abrigosLista).toList();
        if(abrigoList.isEmpty()){
            System.out.println("Não a abrigos cadastrados");
        }else {
            mostrarAbrigos(abrigoList);
        }
    }
    private void mostrarAbrigos(List<Abrigo> abrigos) {
        for (Abrigo abrigo : abrigos) {
            long id = abrigo.getId();
            String nome = abrigo.getNome();
            System.out.println("Abrigos cadastrados:");
            System.out.println(id + "-" +  nome );
        }
    }

    public void CadastrarNovoAbrigo() throws IOException, InterruptedException {

        System.out.println("Digite o nome do abrigo:");
        String nome = new Scanner(System.in).nextLine();
        System.out.println("Digite o telefone do abrigo:");
        String telefone = new Scanner(System.in).nextLine();
        System.out.println("Digite o email do abrigo:");
        String email = new Scanner(System.in).nextLine();

        Abrigo abrigoNovo = new Abrigo(nome,telefone,email);
        String uri = "http://localhost:8080/abrigos";
        HttpResponse<String> response = client.RequisicaoPost(uri,abrigoNovo);

        int statusCode = response.statusCode();
        String responseBody = response.body();
        if (statusCode == 200) {
            System.out.println("Abrigo cadastrado com sucesso!");
            System.out.println(responseBody);
        } else if (statusCode == 400 || statusCode == 500) {
            System.out.println("Erro ao cadastrar o abrigo:");
            System.out.println(responseBody);
        }
    }
}
