import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.US);

        //  TRANSPORTE 

        System.out.println("Tipo de transporte:");
        String tipo = scanner.nextLine();

        System.out.println("Valor do transporte (dólar):");
        double valorTransporte = scanner.nextDouble();
        scanner.nextLine();

        Transporte transporte = new Transporte(tipo, valorTransporte);

        // HOSPEDAGEM

        System.out.println("Descrição da hospedagem:");
        String descricao = scanner.nextLine();

        System.out.println("Valor da diária (dólar):");
        double diaria = scanner.nextDouble();

        Hospedagem hospedagem = new Hospedagem(descricao, diaria);

        // PACOTE

        scanner.nextLine();

        System.out.println("Destino da viagem:");
        String destino = scanner.nextLine();

        System.out.println("Quantidade de dias:");
        int dias = scanner.nextInt();

        PacoteViagem pacote = new PacoteViagem(transporte, hospedagem, destino, dias);

        // margem e taxas

        System.out.println("Margem de lucro (%):");
        double margem = scanner.nextDouble();

        System.out.println("Taxas adicionais:");
        double taxas = scanner.nextDouble();

        double totalPacote = pacote.calcularTotalPacote(margem, taxas);

        // VENDA 

        scanner.nextLine();

        System.out.println("Nome do cliente:");
        String cliente = scanner.nextLine();

        System.out.println("Forma de pagamento:");
        String pagamento = scanner.nextLine();
        
        System.out.println("Data da venda:");
        String data = scanner.nextLine();

        Venda venda = new Venda(cliente, pagamento, data, pacote);

        System.out.println("Cotação do dólar:");
        double cotacao = scanner.nextDouble();

        // RESULTADO 

        System.out.println("\n===== RESUMO DA VENDA =====");

        venda.mostrarVenda(totalPacote, cotacao);

    }
}
