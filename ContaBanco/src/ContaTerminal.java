import java.util.Scanner;


public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Por favor, digite o número da conta: ");
        int numero=Integer.parseInt(sc.nextLine());
        System.out.print("Por favor, digite o número da agência: " );
        String agencia=sc.nextLine(); 
        System.out.print("Por favor, digite o nome do cliente: " );
        String nomeCliente=sc.nextLine();
        System.out.print(" Por favor, digite o saldo para saque: " );
        float saldo=Float.parseFloat(sc.nextLine());

        System.out.print("Olá " + nomeCliente +", obrigado por criar uma conta em nosso banco, sua agência é " + agencia +", conta " + numero + " e seu saldo " + saldo + " já está disponível para saque.");

        


    }
}
