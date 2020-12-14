package backend;

import java.util.Scanner;

import backend.salvar.SalavrArquivo;
import backend.salvar.SalvarMongoDB;
import backend.salvar.SalvarMySQL;
import backend.salvar.SalvarOracle;



public class EscolhaOndeSalvar {
    public void escolhaSalvar(){
        System.out.println("escolha uma opção: 1- arquivo, 2- MySQL, 3-Oracle, 4-MongoDB");
        Scanner sc1 = new Scanner(System.in);
        int escolha = sc1.nextInt();

        switch (escolha){
            case 1: SalavrArquivo.inserir();
            case 2: SalvarMySQL.inserir();
            case 3: SalvarOracle.inserir();
            case 4: SalvarMongoDB.inserir();
        }
    }

    public void escolhaExcluir(){
        System.out.println("escolha uma opção: 1- arquivo, 2- MySQL, 3-Oracle, 4-MongoDB");
        Scanner sc1 = new Scanner(System.in);
        int escolha = sc1.nextInt();

        switch (escolha){
            case 1: SalavrArquivo.remover();
            case 2: SalvarMySQL.remover();
            case 3: SalvarOracle.remover();
            case 4: SalvarMongoDB.remover();
        }
    }

    public void escolhaBuscar(){
        System.out.println("escolha uma opção: 1- arquivo, 2- MySQL, 3-Oracle, 4-MongoDB");
        Scanner sc1 = new Scanner(System.in);
        int escolha = sc1.nextInt();

        switch (escolha){
            case 1: SalavrArquivo.buscar();;
            case 2: SalvarMySQL.buscar();
            case 3: SalvarOracle.buscar();
            case 4: SalvarMongoDB.buscar();
        }
    }

    public void escolhaListar(){
        System.out.println("escolha uma opção: 1- arquivo, 2- MySQL, 3-Oracle, 4-MongoDB");
        Scanner sc1 = new Scanner(System.in);
        int escolha = sc1.nextInt();

        switch (escolha){
            case 1: SalavrArquivo.listar();
            case 2: SalvarMySQL.listar();
            case 3: SalvarOracle.listar();
            case 4: SalvarMongoDB.listar();
        }
    }
}
