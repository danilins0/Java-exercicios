package atividadeimpostos;

import java.math.BigDecimal;

public interface Imposto {
    String getDescricao();
    BigDecimal calcular();
}