/* 
 Questão A)
        Acredito que nosso programa seja um pouco desfavorável para essa implementação, pois nós utilizamos           |
os arquivos de maneira muito direta no nosso programa, o'que talvez poderia ser mudado com classes intermediárias     |
que auxiliaram de fato as funções de salvar e buscar dos arquivos, um bom exemplo no nosso programa do bom uso de     |
classes intermediarias que auxiliariam é o'que fazemos quando efetuamos um login de um usuário, e salvamos suas       |
informações em uma classe chamada “Pessoa”, e a partir dessa classe chamamos as funções de salvar e  regatar como um  |
pequeno exemplo:                                                                                                      |
                                                                                                                      |
            PessoaFisica pessoa=newPessoaFisica(nomenCompletoLogin,telefone2,email,cpf,senha2,endereco);              |
            pessoa.salvarDadosArquivo();                                                                              |
                                                                                                                      |
        Porem o resto das nossas classes que salvam assim como o estoque de remedio, a listagem de remedios, o contato|
de medicos e de farmacias, são salvos e resgatados de maneira mais direta dos arquivos oq prejudica esse tipo de      |
implementação. Como ja possuimos um bom exemplo disso com a classe Pessoa, poderiamos adapitar as outras como fizemos |
essa, assim também alterando a função "salvarDadosArquivo()", para salvar da maneira desejada pelo cliente desse jeito|
seria capaz de implementar varias maneiras e lugares diferentes de salvar as informações                              |
        Acredito que criando essas classes intermediarias, dando opções dentro delas de salvar em diferentes maneiras |
e resgatando as informações dessa classe intermediaria ao invés de resgata-las direto dos arquivos poderiamos         |
implementar os diversos modos de persistência dos dados dessa maneira satisfazendo o desejo do cliente.               |

Questão B)
    Na questão B eu imaginei em criar uma classe chamada "EscolhaOndeSalavar" em que essa classe serviria para definir| 
de qual maneira nos manipulariamos as informações, escolhendo uma classe para definir o modo de manipulação e assim   |
se direcionando para as classes especificas de cada modo que estao na pasta salvar, ali manipulariamos as informações |                                  |
*/

package inicio;

import backend.gerenciamento.Gerenciador;
//import backend.gerenciamento.Notificacao;
import backend.usuario.PessoaFisica;
import frontend.Inicio;
import frontend.Home;

public class MedAlerta {
    private static PessoaFisica pessoa = null;
    private static boolean emEspera = true;
    private static boolean usuarioPessoa = true; // quem esta logado é pessoa fisica ou juridica?

    //utilizado para devolver objeto pessoa ao main para que seja utilizado por outras threads
    public static void setFimDaEspera(boolean emEspera, PessoaFisica pessoa) {
        MedAlerta.pessoa = pessoa;
        MedAlerta.emEspera = emEspera;
    }

    //utilizado para devolver objeto pessoa ao main para que seja utilizado por outras threads
    public static void setFimDaEspera(boolean emEspera) {
        MedAlerta.emEspera = emEspera;
        MedAlerta.usuarioPessoa = false;
    }

    public static void main(String[] args) {
        // thread para tela principal do aplicativo
        Inicio telaInicial = new Inicio();
        Thread interfaceComUsuario = new Thread(telaInicial);
        interfaceComUsuario.start();

        while (emEspera) {
            try {
                Thread.sleep(2000); // dorme por 2 segundos
                System.out.println("Sistema em espera..."); //esperando login
            } catch (InterruptedException e) {}
        }

        // thread para iniciar a tela home
        if(usuarioPessoa){
            Home tela = new Home();
            tela.receber(MedAlerta.pessoa);
            tela.setVisible(true);
        }
    
        // thread para o gerenciador do aplicativo
        if(usuarioPessoa){
            Gerenciador.setPessoa(pessoa);
            Gerenciador g = new Gerenciador();
            Thread gerenciador = new Thread(g);
            gerenciador.start();
        }

        // boolean t = Notificacao.notificar("Notificação Teste");
        // System.out.println(t);
    }
}
