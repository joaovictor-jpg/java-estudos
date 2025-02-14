package br.com.jota.ui.custom.screen;

import br.com.jota.entities.Space;
import br.com.jota.service.BoardService;
import br.com.jota.ui.custom.button.ChecGamestatusButton;
import br.com.jota.ui.custom.button.FinishGameButton;
import br.com.jota.ui.custom.button.ResetButton;
import br.com.jota.ui.custom.frame.MainFrame;
import br.com.jota.ui.custom.input.NumberText;
import br.com.jota.ui.custom.panel.MainPainel;
import br.com.jota.ui.custom.panel.SudokuSector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;

public class MainScreen {

    private final static Dimension DIMENSION = new Dimension(600, 600);

    private final BoardService boardService;

    private JButton finishGameButton;
    private JButton checkGameStatusButton;
    private JButton resetButton;


    public MainScreen(final Map<String, String> gameConfig) {
        this.boardService = new BoardService(gameConfig);
    }

    public void buildMainScreen() {
        JPanel mainPanel = new MainPainel(DIMENSION);
        JFrame mainFrame = new MainFrame(DIMENSION, mainPanel);

        for (int r = 0; r < 9; r += 3) {
            var endRow = r + 2;
            for (int c = 0; c < 9; c += 3) {
                var endCol = c + 2;
                var spaces = getSpacesFromSector(boardService.getSpaces(), c, endCol, r,endRow);
                JPanel sector = generateSection(spaces);
                mainPanel.add(sector);
            }
        }

        addResetButton(mainPanel);
        addShowGameStatusButton(mainPanel);
        addFinishGameButton(mainPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private List<Space> getSpacesFromSector(final List<List<Space>> spaces, final Integer initColl, final Integer endCol, final Integer initRow, final Integer endRow) {
        List<Space> spaceSector = new ArrayList<>();
        for (int r = initRow; r <= endRow; r++) {
            for (int c = initColl; c <= endCol; c++) {
                spaceSector.add(spaces.get(c).get(r));
            }
        }

        return spaceSector;
    }

    private JPanel generateSection(final List<Space> spaces) {
        List<NumberText> fields = new ArrayList<>(spaces.stream().map(NumberText::new).toList());
        return new SudokuSector(fields);
    }

    private void addFinishGameButton(JPanel mainPanel) {
        finishGameButton = new FinishGameButton(e -> {
            if (boardService.gameIsFinished()) {
                JOptionPane.showConfirmDialog(null, "Parabéns você concluiu o game");
                resetButton.setEnabled(false);
                checkGameStatusButton.setEnabled(false);
                finishGameButton.setEnabled(false);
            } else {
                JOptionPane.showConfirmDialog(null, "O game tem algumas inconsistências, ajuste e tente novamente");
            }
        });
        mainPanel.add(finishGameButton);
    }

    private void addShowGameStatusButton(JPanel mainPanel) {
        checkGameStatusButton = new ChecGamestatusButton(e -> {
            var hasErrors = boardService.hasErrors();
            var gameStatus = boardService.getStatus();
            var message = switch (gameStatus) {
                case NON_STARTED -> "O game não foi inicializado";
                case INCOMPLETE -> "O game está incompleto";
                case COMPLETE -> "O game está completo";
            };
            message += hasErrors ? " e contém erros" : "não contém erros";
            JOptionPane.showConfirmDialog(null, message);
        });
        mainPanel.add(checkGameStatusButton);
    }

    private void addResetButton(JPanel mainPanel) {
        resetButton = new ResetButton(e -> {
            var dialogResult = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja realmente reseta seu game?",
                    "Limpar o game",
                    YES_NO_OPTION,
                    QUESTION_MESSAGE
            );

            if (dialogResult == 0) {
                boardService.reset();
            }
        });
        mainPanel.add(resetButton);
    }
}
