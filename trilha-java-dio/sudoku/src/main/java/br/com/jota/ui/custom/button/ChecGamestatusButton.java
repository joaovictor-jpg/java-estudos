package br.com.jota.ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ChecGamestatusButton extends JButton {

    public ChecGamestatusButton(final ActionListener actionListener) {
        this.setText("Verificar Jogo");
        this.addActionListener(actionListener);
    }
}
