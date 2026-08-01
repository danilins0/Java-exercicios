public class PacoteViagem {

    Transporte transporte;
    Hospedagem hospedagem;

    String destino;
    int quantidadeDias;

    public PacoteViagem(Transporte transporte, Hospedagem hospedagem, String destino, int quantidadeDias) {

        this.transporte = transporte;
        this.hospedagem = hospedagem;
        this.destino = destino;
        this.quantidadeDias = quantidadeDias;
    }

    public double calcularTotalHospedagem() {

        return hospedagem.getValorDiaria() * quantidadeDias;
    }

    public double calcularLucro(double margem, double valor) {

        double lucro = valor * (margem / 100);

        return valor + lucro;
    }

    public double calcularTotalPacote(double margem, double taxas) {

        double transporteValor = transporte.getValor();

        double hospedagemTotal = calcularTotalHospedagem();

        double subtotal = transporteValor + hospedagemTotal;

        double valorComLucro = calcularLucro(margem, subtotal);

        return valorComLucro + taxas;
    }
}
