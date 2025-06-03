package id.ac.ukdw.www.rplbo.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.*;

public class play {

    @FXML
    private TextField inputA;

    @FXML
    private TextField inputB;

    @FXML
    private TextArea textAreaHasil;

    @FXML
    private Button btnCari;

    @FXML
    protected void handleCariJalur() {
        int start = Integer.parseInt(inputA.getText());
        int goal = Integer.parseInt(inputB.getText());

        List<int[]> edges = Arrays.asList(
                new int[]{1, 6, 2},
                new int[]{1, 2, 8},
                new int[]{2, 3, 6},
                new int[]{3, 4, 6},
                new int[]{4, 5, 10},
                new int[]{5, 6, 12},
                new int[]{4, 7, 6},
                new int[]{7, 8, 4},
                new int[]{5, 8, 10},
                new int[]{5, 11, 8},
                new int[]{8, 11, 4},
                new int[]{8, 12, 4},
                new int[]{12, 9, 2},
                new int[]{11, 9, 6},
                new int[]{11, 10, 6},
                new int[]{9, 10, 4}
        );

        String hasil = HelloController.solve(start, goal, edges);
        textAreaHasil.setText(hasil);
    }
}
