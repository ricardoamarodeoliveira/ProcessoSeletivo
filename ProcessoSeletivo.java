package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) {
        analisarCandidato(1000.0);
        analisarCandidato(2200.0);
        analisarCandidato(1000.0);

        selecaoCandidatos();

        imprimirSelecionados();

        String [] candidatos = {"RICARDO","FRANCIELE","ENZO","JAQUELINE","THIAGO"};
        for (String candidato: candidatos){
            entrandoEmContato(candidato);

        }

        
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)   
                tentativasRealizadas++;          
            
            
        } while (continuarTentando && tentativasRealizadas < 3);

        if(atendeu)
        System.out.println("CONSEGUIMOS CONTATO COM O CANDIDATO " + candidato + " NA " + tentativasRealizadas + " TENTATIVA REALIZADA");
        else
        System.out.println("NÃO CONSEGUIMOS CONTATO COM O CANDIDATO " + candidato + ", NUMERO MAXIMO DE " + tentativasRealizadas + " TENTATIVAS REALIZADAS");
        
        


    }

    static boolean atender(){
        return new Random().nextInt(3)==1;



    }

   

    static void imprimirSelecionados(){
        String [] candidatos = {"RICARDO","FRANCIELE","ENZO","JAQUELINE","THIAGO"};

        System.out.println("Imprimindo os candidatos selecionados: ");

        for(int indice = 0; indice < candidatos.length; indice++){

            System.out.println("O candidato numero " + (indice+1) + " é " + candidatos[indice]);
        }



    }

    static void selecaoCandidatos(){

        String [] candidatos = {"RICARDO","FRANCIELE","ENZO","JAQUELINE","THIAGO","LUIZ","GIZELIA","MARCOS","BETE","PAULINHO","MARCELA","RAFAELA"};
        
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + ", solicitou o valor de salario: " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + ", foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        
        
        }


    }

    static  double  valorPretendido(){
        return ThreadLocalRandom.current().nextDouble (1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){

        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
        System.out.println("LIGAR PARA O CANDIDATO");

    }else if(salarioBase == salarioPretendido)
    System.out.println("LIGAR PARA O CANDIDATO COM UMA CONTRA PROPOSTA");

    else {
        System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
    }

    }

}
