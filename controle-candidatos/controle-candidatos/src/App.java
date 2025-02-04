import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    private static double salarioBase = 2000.0;
    public static void main(String[] args) throws Exception {
        System.out.println("Processo Seletivo");
 
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","NATALIA"};
        ArrayList<String>  candidatosContratados = new ArrayList<String>();

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioPretendido = 0.0;
        while (candidatosSelecionados<5){
            candidatoAtual = SorteiaCandidato();
            salarioPretendido = SalarioPretendido();
            String candidato = candidatos[candidatoAtual];
            

            System.out.println("O candidato" + candidato + " pretende receber um salario de R$ " + salarioPretendido + " reais");
            if (salarioPretendido <= salarioBase){
                if (!candidatosContratados.contains(candidato)){
                    System.out.println("Candidato selecionado para a vaga");
                    candidatosContratados.add(candidato);
                    candidatosSelecionados++;
                }
            }
 
        }  //fim do while

        ImprimirCandidatosContratados(candidatosContratados);
        EntrarEmContato(candidatosContratados);


    }

    static void AnalisarCandidato(double salarioPretendido){
        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato.");
        }
        else if (salarioBase==salarioPretendido) {
            System.out.println("Ligar para o candidato com contraproposta.");
        }
        else{
            System.out.println("Aguardando o resultado dos demais candidatos.");
        }
    }

    static double SalarioPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static int SorteiaCandidato(){
        return ThreadLocalRandom.current().nextInt(0,9);
    }

    static void ImprimirCandidatosContratados(ArrayList<String> contratados){
        System.out.println("");
        System.out.println("Listagem dos candidatos contratados");
        for (String contratado : contratados) {
            System.out.println("O candidato " + contratado + " foi contratado");
        }
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void EntrarEmContato(ArrayList<String> contratados){

        System.out.println("");
        System.out.println("Entrando em contato com os candidatos contratados");
        for (String contratado : contratados) {



            int tentativasRealizadas = 1;
            boolean continuarTentando = true;
            boolean atendeu = false;

            do{
                atendeu = atender();
                continuarTentando = !atendeu;
                if (continuarTentando) {
                    tentativasRealizadas++;
                } else
                {   
                    System.out.println("Candidato " + contratado +" - Contato realizado com sucesso.");
                }


            }while(continuarTentando && tentativasRealizadas <= 3);

            if (atendeu) {
                System.out.println("Conseguimos contato com o candidato " + contratado + " na " + tentativasRealizadas + "ª tentativa");
            }else{
                System.out.println("Não conseguimos entrar em contato com o candidato " + contratado);
            }


        }
            
    }

}
