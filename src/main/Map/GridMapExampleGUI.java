package Map;
import javax.swing.*;
import java.awt.*;

public class GridMapExampleGUI extends JFrame {

    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final int CELL_SIZE = 30;

    private boolean[][] grid;

    public GridMapExampleGUI() {
        grid = new boolean[ROWS][COLS];
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Grid Map Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(COLS * CELL_SIZE, ROWS * CELL_SIZE);

        final JPanel gridPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGrid(g);
            }
        };

        gridPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = evt.getY() / CELL_SIZE;
                int col = evt.getX() / CELL_SIZE;
                toggleCell(row, col);
                gridPanel.repaint();
            }
        });

        add(gridPanel);
    }

    private void drawGrid(Graphics g) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col]) {
                    g.setColor(Color.BLACK);
                    g.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                } else {
                    g.setColor(Color.WHITE);
                    g.fillRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    g.setColor(Color.BLACK);
                    g.drawRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }

    private void toggleCell(int row, int col) {
        grid[row][col] = !grid[row][col];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GridMapExampleGUI example = new GridMapExampleGUI();
                example.setVisible(true);
            }
        });
    }
}
