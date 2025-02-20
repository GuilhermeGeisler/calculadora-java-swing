package com.mycompany.calculadora.controle;

import com.mycompany.calculadora.enums.EnumOperacao;

public class CalculadoraService {

    private Double total;
    private EnumOperacao ultimaOperacao;  // Para armazenar a última operação

    public CalculadoraService() {
        total = 0.0;
        ultimaOperacao = null;
    }

    // Este método realiza a operação com base na última operação selecionada
    public Double realizaOperacao(EnumOperacao operacao, Double valor) {
        if (ultimaOperacao == null) {
            total = valor;  // Se for a primeira operação, o total começa com o valor
        } else {
            switch (ultimaOperacao) {
                case SOMA:
                    total += valor;
                    break;
                case SUBTRACAO:
                    total -= valor;
                    break;
                case MULTIPLICACAO:
                    total *= valor;
                    break;
                case DIVISAO:
                    if (valor != 0) {
                        total /= valor;
                    } else {
                        System.out.println("Erro: Divisão por zero não permitida.");
                        total = Double.NaN;  // Para indicar erro de divisão por zero
                    }
                    break;
            }
        }
        ultimaOperacao = operacao;  // Atualiza a última operação
        return total;
    }

    // Método para usar quando o "=" for pressionado, para finalizar a operação
    public Double calcularResultado(Double valorAtual) {
        if (ultimaOperacao != null) {
            total = realizaOperacao(null, valorAtual);
        }
        return total;
    }

    // Limpa o valor armazenado
    public void zerar() {
        total = 0.0;
        ultimaOperacao = null;
    }
}