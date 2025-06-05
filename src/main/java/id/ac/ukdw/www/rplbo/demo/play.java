package id.ac.ukdw.www.rplbo.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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
    private Pane paneNodes; // Pane untuk gambar node

    // Posisi setiap node (koordinat untuk digambar di Pane)
    private final Map<Integer, double[]> nodePositions = new HashMap<>();

    public play() {
        nodePositions.put(1, new double[]{50, 50});
        nodePositions.put(2, new double[]{100, 150});
        nodePositions.put(3, new double[]{130, 250});
        nodePositions.put(4, new double[]{230, 250});
        nodePositions.put(5, new double[]{300, 70});
        nodePositions.put(6, new double[]{70, 20});
        nodePositions.put(7, new double[]{300, 300});
        nodePositions.put(8, new double[]{400, 200});
        nodePositions.put(9, new double[]{500, 300});
        nodePositions.put(10, new double[]{600, 100});
        nodePositions.put(11, new double[]{450, 100});
        nodePositions.put(12, new double[]{400, 300});
    }

    @FXML private Circle Agape, Biblos, Chara, Didaktos, Euodia, Filia, Gnosis, Hagios, Iama, Koinonia, Logos, Makarios;

    private Map<Integer, Circle> circleMap;

    @FXML
    public void initialize() {
      // opsional kalau masih mau gambar manual
        circleMap = new HashMap<>();
        circleMap.put(1, Agape);
        circleMap.put(2, Biblos);
        circleMap.put(3, Chara);
        circleMap.put(4, Didaktos);
        circleMap.put(5, Euodia);
        circleMap.put(6, Filia);
        circleMap.put(7, Gnosis);
        circleMap.put(8, Hagios);
        circleMap.put(9, Iama);
        circleMap.put(10, Koinonia);
        circleMap.put(11, Logos);
        circleMap.put(12, Makarios);
    }



    @FXML
    protected void handleCariJalur() {
        try {
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

            List<Integer> path = HelloController.getPath(start, goal, edges);

            // Reset warna semua node jadi biru
            for (Circle c : circleMap.values()) {
                c.setFill(Color.DODGERBLUE);
            }

            if (path.isEmpty()) {
                textAreaHasil.setText("Tidak ada jalur ditemukan");
                return;
            }

            // Warnai node dalam path jadi hijau
            for (Integer nodeId : path) {
                Circle c = circleMap.get(nodeId);
                if (c != null) {
                    c.setFill(Color.LIMEGREEN);
                }
            }

            // Tampilkan path ke user dalam bentuk teks
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(HelloController.getGedung(path.get(i)));
                if (i < path.size() - 1) sb.append(" -> ");
            }
            textAreaHasil.setText(sb.toString());

        } catch (NumberFormatException e) {
            textAreaHasil.setText("Input tidak valid. Masukkan angka dari 1 sampai 12.");
        }
    }

}
