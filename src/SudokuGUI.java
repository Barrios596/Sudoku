import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SudokuGUI {
    private JPanel panel;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JButton solve1;
    private JTextField input1;
    private JTextArea output1;
    private JTextField input2;
    private JTextArea output2;
    private JButton solve2;
    private JLabel first00;
    private JLabel first01;
    private JLabel first02;
    private JLabel first03;
    private JLabel first10;
    private JLabel first11;
    private JLabel first12;
    private JLabel first13;
    private JLabel first20;
    private JLabel first21;
    private JLabel first22;
    private JLabel first23;
    private JLabel first30;
    private JLabel first31;
    private JLabel first32;
    private JLabel first33;
    private JLabel second00;
    private JLabel second01;
    private JLabel second02;
    private JLabel second03;
    private JLabel second04;
    private JLabel second05;
    private JLabel second06;
    private JLabel second07;
    private JLabel second08;
    private JLabel second10;
    private JLabel second11;
    private JLabel second12;
    private JLabel second13;
    private JLabel second14;
    private JLabel second15;
    private JLabel second16;
    private JLabel second17;
    private JLabel second18;
    private JLabel second20;
    private JLabel second21;
    private JLabel second22;
    private JLabel second23;
    private JLabel second24;
    private JLabel second25;
    private JLabel second26;
    private JLabel second27;
    private JLabel second28;
    private JLabel second30;
    private JLabel second31;
    private JLabel second32;
    private JLabel second33;
    private JLabel second34;
    private JLabel second35;
    private JLabel second36;
    private JLabel second37;
    private JLabel second38;
    private JLabel second40;
    private JLabel second41;
    private JLabel second42;
    private JLabel second43;
    private JLabel second44;
    private JLabel second45;
    private JLabel second46;
    private JLabel second47;
    private JLabel second48;
    private JLabel second50;
    private JLabel second51;
    private JLabel second52;
    private JLabel second53;
    private JLabel second54;
    private JLabel second55;
    private JLabel second56;
    private JLabel second57;
    private JLabel second58;
    private JLabel second60;
    private JLabel second61;
    private JLabel second62;
    private JLabel second63;
    private JLabel second64;
    private JLabel second65;
    private JLabel second66;
    private JLabel second67;
    private JLabel second68;
    private JLabel second70;
    private JLabel second71;
    private JLabel second72;
    private JLabel second73;
    private JLabel second74;
    private JLabel second75;
    private JLabel second76;
    private JLabel second77;
    private JLabel second78;
    private JLabel second80;
    private JLabel second81;
    private JLabel second82;
    private JLabel second83;
    private JLabel second84;
    private JLabel second85;
    private JLabel second86;
    private JLabel second87;
    private JLabel second88;

    public SudokuGUI() {
        solve1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = input1.getText();
                if (!input.matches("[0-9.]+") || input.length() < 16) {
                    error("The input is bad written. Use only numbers and '.' for spaces. The size must be of 16.");
                }
                else {
                    Sudoku sudoku = new Sudoku(2, input);
                    if (sudoku.isSolvable()) {
                        ArrayList<State> solution = sudoku.solve();
                        if (solution.size() > 0) {
                            String output = "";
                            for (int i = 0; i < solution.size(); i++)
                                output += "Step: " + i + "\n\n" + solution.get(solution.size() - i - 1).toString() + "\n\n";
                            output1.setText(output);
                            int[][] lastState = solution.get(0).getGrid();
                            first00.setText(String.valueOf(lastState[0][0]));
                            first01.setText(String.valueOf(lastState[0][1]));
                            first02.setText(String.valueOf(lastState[0][2]));
                            first03.setText(String.valueOf(lastState[0][3]));
                            first10.setText(String.valueOf(lastState[1][0]));
                            first11.setText(String.valueOf(lastState[1][1]));
                            first12.setText(String.valueOf(lastState[1][2]));
                            first13.setText(String.valueOf(lastState[1][3]));
                            first20.setText(String.valueOf(lastState[2][0]));
                            first21.setText(String.valueOf(lastState[2][1]));
                            first22.setText(String.valueOf(lastState[2][2]));
                            first23.setText(String.valueOf(lastState[2][3]));
                            first30.setText(String.valueOf(lastState[3][0]));
                            first31.setText(String.valueOf(lastState[3][1]));
                            first32.setText(String.valueOf(lastState[3][2]));
                            first33.setText(String.valueOf(lastState[3][3]));
                        }
                        else error("The algorithm didn't find a solution for the sudoku.");
                    }
                    else {
                        error("The sudoku is unsolvable.");
                    }
                }
            }
        });
        solve2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = input2.getText();
                if (!input.matches("[0-9.]+") || input.length() < 81) {
                    error("The input is bad written. Use only numbers and '.' for spaces. The size must be of 16.");
                }
                else {
                    Sudoku sudoku = new Sudoku(3, input);
                    if (sudoku.isSolvable()) {
                        ArrayList<State> solution = sudoku.solve();
                        if (solution.size() > 0) {
                            String output = "";
                            for (int i = 0; i < solution.size(); i++)
                                output += "Step: " + i + "\n\n" + solution.get(solution.size() - i - 1).toString() + "\n\n";
                            output2.setText(output);
                            int[][] lastState = solution.get(0).getGrid();
                            second00.setText(String.valueOf(lastState[0][0]));
                            second01.setText(String.valueOf(lastState[0][1]));
                            second02.setText(String.valueOf(lastState[0][2]));
                            second03.setText(String.valueOf(lastState[0][3]));
                            second04.setText(String.valueOf(lastState[0][4]));
                            second05.setText(String.valueOf(lastState[0][5]));
                            second06.setText(String.valueOf(lastState[0][6]));
                            second07.setText(String.valueOf(lastState[0][7]));
                            second08.setText(String.valueOf(lastState[0][8]));
                            second10.setText(String.valueOf(lastState[1][0]));
                            second11.setText(String.valueOf(lastState[1][1]));
                            second12.setText(String.valueOf(lastState[1][2]));
                            second13.setText(String.valueOf(lastState[1][3]));
                            second14.setText(String.valueOf(lastState[1][4]));
                            second15.setText(String.valueOf(lastState[1][5]));
                            second16.setText(String.valueOf(lastState[1][6]));
                            second17.setText(String.valueOf(lastState[1][7]));
                            second18.setText(String.valueOf(lastState[1][8]));
                            second20.setText(String.valueOf(lastState[2][0]));
                            second21.setText(String.valueOf(lastState[2][1]));
                            second22.setText(String.valueOf(lastState[2][2]));
                            second23.setText(String.valueOf(lastState[2][3]));
                            second24.setText(String.valueOf(lastState[2][4]));
                            second25.setText(String.valueOf(lastState[2][5]));
                            second26.setText(String.valueOf(lastState[2][6]));
                            second27.setText(String.valueOf(lastState[2][7]));
                            second28.setText(String.valueOf(lastState[2][8]));
                            second30.setText(String.valueOf(lastState[3][0]));
                            second31.setText(String.valueOf(lastState[3][1]));
                            second32.setText(String.valueOf(lastState[3][2]));
                            second33.setText(String.valueOf(lastState[3][3]));
                            second34.setText(String.valueOf(lastState[3][4]));
                            second35.setText(String.valueOf(lastState[3][5]));
                            second36.setText(String.valueOf(lastState[3][6]));
                            second37.setText(String.valueOf(lastState[3][7]));
                            second38.setText(String.valueOf(lastState[3][8]));
                            second40.setText(String.valueOf(lastState[4][0]));
                            second41.setText(String.valueOf(lastState[4][1]));
                            second42.setText(String.valueOf(lastState[4][2]));
                            second43.setText(String.valueOf(lastState[4][3]));
                            second44.setText(String.valueOf(lastState[4][4]));
                            second45.setText(String.valueOf(lastState[4][5]));
                            second46.setText(String.valueOf(lastState[4][6]));
                            second47.setText(String.valueOf(lastState[4][7]));
                            second48.setText(String.valueOf(lastState[4][8]));
                            second50.setText(String.valueOf(lastState[5][0]));
                            second51.setText(String.valueOf(lastState[5][1]));
                            second52.setText(String.valueOf(lastState[5][2]));
                            second53.setText(String.valueOf(lastState[5][3]));
                            second54.setText(String.valueOf(lastState[5][4]));
                            second55.setText(String.valueOf(lastState[5][5]));
                            second56.setText(String.valueOf(lastState[5][6]));
                            second57.setText(String.valueOf(lastState[5][7]));
                            second58.setText(String.valueOf(lastState[5][8]));
                            second60.setText(String.valueOf(lastState[6][0]));
                            second61.setText(String.valueOf(lastState[6][1]));
                            second62.setText(String.valueOf(lastState[6][2]));
                            second63.setText(String.valueOf(lastState[6][3]));
                            second64.setText(String.valueOf(lastState[6][4]));
                            second65.setText(String.valueOf(lastState[6][5]));
                            second66.setText(String.valueOf(lastState[6][6]));
                            second67.setText(String.valueOf(lastState[6][7]));
                            second68.setText(String.valueOf(lastState[6][8]));
                            second70.setText(String.valueOf(lastState[7][0]));
                            second71.setText(String.valueOf(lastState[7][1]));
                            second72.setText(String.valueOf(lastState[7][2]));
                            second73.setText(String.valueOf(lastState[7][3]));
                            second74.setText(String.valueOf(lastState[7][4]));
                            second75.setText(String.valueOf(lastState[7][5]));
                            second76.setText(String.valueOf(lastState[7][6]));
                            second77.setText(String.valueOf(lastState[7][7]));
                            second78.setText(String.valueOf(lastState[7][8]));
                            second80.setText(String.valueOf(lastState[8][0]));
                            second81.setText(String.valueOf(lastState[8][1]));
                            second82.setText(String.valueOf(lastState[8][2]));
                            second83.setText(String.valueOf(lastState[8][3]));
                            second84.setText(String.valueOf(lastState[8][4]));
                            second85.setText(String.valueOf(lastState[8][5]));
                            second86.setText(String.valueOf(lastState[8][6]));
                            second87.setText(String.valueOf(lastState[8][7]));
                            second88.setText(String.valueOf(lastState[8][8]));
                        }
                        else error("The algorithm didn't find a solution for the sudoku.");
                    }
                    else {
                        error("The sudoku is unsolvable.");
                    }
                }
            }
        });
    }

    void error(String error) {
        JDialog dialog = new JDialog();
        Container contentPane = dialog.getContentPane();
        contentPane.add(new JLabel(error));
        contentPane.setBackground(Color.white);
        dialog.setTitle("Error while trying to solve the sudoku.");
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    public static void main(String args[]) {
        JFrame jframe = new JFrame("Sudoku");
        jframe.setContentPane(new SudokuGUI().panel);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(800, 450);
        jframe.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }
}
