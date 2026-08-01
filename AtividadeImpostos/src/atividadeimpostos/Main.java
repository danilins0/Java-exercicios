package atividadeimpostos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        Scanner sc = new Scanner(System.in);
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        System.out.println("=== Cadastro de Pagamentos ===");

        Pagamentos pagamentos = new Pagamentos();
        pagamentos.setNomeEmpresa(lerTexto(sc, "Digite o nome da empresa: "));

        while (true) {
            System.out.println();
            String tipo = lerTexto(sc, "Digite o tipo do imposto (PIS, IPI ou PARE para encerrar): ").toUpperCase();

            if (tipo.equals("PARE")) {
                break;
            }

            if (tipo.equals("PIS")) {
                BigDecimal debito = lerDecimal(sc, "Digite o valor total de débito: ");
                BigDecimal credito = lerDecimal(sc, "Digite o valor total de crédito: ");

                Pis pis = new Pis(debito, credito);
                pagamentos.adicionarImposto(pis);

            } else if (tipo.equals("IPI")) {
                BigDecimal aliquota = lerDecimal(sc, "Digite a alíquota em %: ");
                BigDecimal valorProduto = lerDecimal(sc, "Digite o valor do produto: ");
                BigDecimal frete = lerDecimal(sc, "Digite o valor do frete: ");
                BigDecimal seguro = lerDecimal(sc, "Digite o valor do seguro: ");
                BigDecimal outrasDespesas = lerDecimal(sc, "Digite o valor de outras despesas: ");

                Ipi ipi = new Ipi(aliquota, valorProduto, frete, seguro, outrasDespesas);
                pagamentos.adicionarImposto(ipi);

            } else {
                System.out.println("Tipo inválido. Digite apenas PIS, IPI ou PARE.");
            }
        }

        System.out.println();
        System.out.println("=== Resultado Final ===");
        System.out.println("Empresa: " + pagamentos.getNomeEmpresa());
        System.out.println();

        if (pagamentos.getImpostos().isEmpty()) {
            System.out.println("Nenhum imposto foi cadastrado.");
        } else {
            for (Imposto imposto : pagamentos.getImpostos()) {
                System.out.println(imposto.getDescricao() + ": " + moeda.format(imposto.calcular()));
            }

            System.out.println();
            System.out.println("Total geral: " + moeda.format(pagamentos.calcularTotal()));
        }

        sc.close();
    }

    private static String lerTexto(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = sc.nextLine().trim();

            if (!texto.isEmpty() && texto.matches("[\\p{L} ]+")) {
                return texto;
            }

            System.out.println("Entrada inválida. Digite apenas letras.");
        }
    }

    private static BigDecimal lerDecimal(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String valor = sc.nextLine().trim().replace(",", ".");

            if (valor.matches("\\d+(\\.\\d+)?")) {
                BigDecimal numero = new BigDecimal(valor);

                if (numero.compareTo(BigDecimal.ZERO) >= 0) {
                    return numero.setScale(2, RoundingMode.HALF_UP);
                }
            }

            System.out.println("Entrada inválida. Digite apenas números. Você pode usar . ou , para centavos.");
        }
    }
}