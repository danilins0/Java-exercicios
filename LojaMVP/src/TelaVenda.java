import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaVenda extends JFrame {

    private JTextField campoVenda;
    private JButton botaoCalcular;

    public TelaVenda() {

        setTitle("Sistema de Vendas");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JLabel label = new JLabel("Valor da venda:");

        campoVenda = new JTextField(15);

        botaoCalcular = new JButton("Calcular");

        add(label);
        add(campoVenda);
        add(botaoCalcular);

        botaoCalcular.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    double valorVenda = Double.parseDouble(campoVenda.getText());

                    if (valorVenda < 0) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Informe um valor válido!"
                        );

                        return;
                    }

                    double valorFinal = valorVenda;

                    if (valorVenda > 500) {

                        String descontoTexto =
                                JOptionPane.showInputDialog(
                                        "Informe o percentual de desconto:"
                                );

                        if (descontoTexto == null) {
                            return;
                        }

                        double percentual =
                                Double.parseDouble(descontoTexto);

                        if (percentual < 0 || percentual > 100) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Percentual inválido!"
                            );

                            return;
                        }

                        valorFinal =
                                valorVenda -
                                (valorVenda * percentual / 100);
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            String.format(
                                    "Valor final: R$ %.2f",
                                    valorFinal
                            )
                    );

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Digite apenas números válidos."
                    );
                }
            }
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            TelaVenda tela = new TelaVenda();
            tela.setVisible(true);

        });
    }
}