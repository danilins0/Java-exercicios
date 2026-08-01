package atividadeimpostos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ipi implements Imposto {
    private BigDecimal aliquota;
    private BigDecimal valorProduto;
    private BigDecimal frete;
    private BigDecimal seguro;
    private BigDecimal outrasDespesas;

    public Ipi() {
        this.aliquota = BigDecimal.ZERO;
        this.valorProduto = BigDecimal.ZERO;
        this.frete = BigDecimal.ZERO;
        this.seguro = BigDecimal.ZERO;
        this.outrasDespesas = BigDecimal.ZERO;
    }

    public Ipi(BigDecimal aliquota, BigDecimal valorProduto, BigDecimal frete, BigDecimal seguro, BigDecimal outrasDespesas) {
        this.aliquota = aliquota;
        this.valorProduto = valorProduto;
        this.frete = frete;
        this.seguro = seguro;
        this.outrasDespesas = outrasDespesas;
    }

    @Override
    public String getDescricao() {
        return "IPI";
    }

    @Override
    public BigDecimal calcular() {
        BigDecimal base = valorProduto.add(frete).add(seguro).add(outrasDespesas);
        BigDecimal percentual = aliquota.divide(new BigDecimal("100"), 10, RoundingMode.HALF_UP);
        return base.multiply(percentual).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public void setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public BigDecimal getFrete() {
        return frete;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }

    public BigDecimal getSeguro() {
        return seguro;
    }

    public void setSeguro(BigDecimal seguro) {
        this.seguro = seguro;
    }

    public BigDecimal getOutrasDespesas() {
        return outrasDespesas;
    }

    public void setOutrasDespesas(BigDecimal outrasDespesas) {
        this.outrasDespesas = outrasDespesas;
    }
}