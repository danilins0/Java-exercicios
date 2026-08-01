package atividadeimpostos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pagamentos {
    private String nomeEmpresa;
    private List<Imposto> impostos;

    public Pagamentos() {
        this.impostos = new ArrayList<>();
    }

    public Pagamentos(String nomeEmpresa) {
        this();
        this.nomeEmpresa = nomeEmpresa;
    }

    public void adicionarImposto(Imposto imposto) {
        this.impostos.add(imposto);
    }

    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Imposto imposto : impostos) {
            total = total.add(imposto.calcular());
        }
        return total;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public List<Imposto> getImpostos() {
        return impostos;
    }

    public void setImpostos(List<Imposto> impostos) {
        this.impostos = impostos;
    }
}