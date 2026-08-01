public class Venda {

    String nomeCliente;
    String formaPagamento;
    String data;
    PacoteViagem pacote;

    public Venda(String nomeCliente, String formaPagamento, String data, PacoteViagem pacote) {
        this.nomeCliente = nomeCliente;
        this.formaPagamento = formaPagamento;
        this.data = data;
        this.pacote = pacote;
    }

    public double converterParaReais(double valorDolar, double cotacao) {

        return valorDolar * cotacao;
    }

    public void mostrarVenda(double totalDolar, double cotacao) {

        double totalReais = converterParaReais(totalDolar, cotacao);

        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Forma de pagamento: " + formaPagamento);
        System.out.println("Data da venda: " + data);

        System.out.printf("Total em dólar: $%.2f\n", totalDolar);
        System.out.printf("Total em reais: R$ %.2f\n", totalReais);
    }
}
