package atividadeimpostos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pis implements Imposto {
    private BigDecimal debito;
    private BigDecimal credito;

    public Pis() {
        this.debito = BigDecimal.ZERO;
        this.credito = BigDecimal.ZERO;
    }

    public Pis(BigDecimal debito, BigDecimal credito) {
        this.debito = debito;
        this.credito = credito;
    }

    @Override
    public String getDescricao() {
        return "PIS";
    }

    @Override
    public BigDecimal calcular() {
        BigDecimal base = debito.subtract(credito);
        BigDecimal aliquota = new BigDecimal("0.0165");
        return base.multiply(aliquota).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getDebito() {
        return debito;
    }

    public void setDebito(BigDecimal debito) {
        this.debito = debito;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }
}