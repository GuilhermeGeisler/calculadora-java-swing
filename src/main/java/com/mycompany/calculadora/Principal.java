package com.mycompany.calculadora;

import com.mycompany.calculadora.visao.JFrTela;

public class Principal {

    public static void main(String[] args) {
        // Usando lambda para simplificar o código
        java.awt.EventQueue.invokeLater(() -> new JFrTela().setVisible(true));
    }
}