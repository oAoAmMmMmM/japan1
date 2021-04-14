import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Cells {

    Scanner scanner = new Scanner(System.in);

    ArrayList<ArrayList<Integer>> straka = new ArrayList<>();
    ArrayList<ArrayList<Integer>> stalbec = new ArrayList<>();

    public Cells() throws IOException { // объединение данных в массивы
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        System.out.println("Ввдите значения");
        System.out.println("Строки");
        for (int v = 1; v <= 5; v = v + 1) {
            ArrayList<Integer> values = new ArrayList<Integer>(v);
            String s = in.readLine();
            StringTokenizer tokenizer = new StringTokenizer(s);
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                int value = Integer.parseInt(token);
                values.add(value);
            }
            straka.add(values);
        }
        System.out.println("Столбцы");
        for (int v = 1; v <= 5; v = v + 1) {
            ArrayList<Integer> values = new ArrayList<Integer>(v);
            String s = in.readLine();
            StringTokenizer tokenizer = new StringTokenizer(s);
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                int value = Integer.parseInt(token);
                values.add(value);
            }
            stalbec.add(values);
        }
    }


    public void drawYes(Graphics g, int x, int y) { // обозначение заполненных клеток
        g.fillRect(750 / 2 - 175 + 70 * (x - 1), 750 / 2 - 175 + 70 * (y - 1), 70, 70);
    }

    public void drawNo(Graphics g, int x, int y) { // обозначение незаполненных клеток
        g.drawLine(750 / 2 - 175 + 70 * (x - 1), 750 / 2 - 175 + 70 * (y - 1), 750 / 2 - 175 + 70 * x, 750 / 2 - 175 + 70 * y);
        g.drawLine(750 / 2 - 175 + 70 * (x - 1), 750 / 2 - 175 + 70 * y, 750 / 2 - 175 + 70 * x, 750 / 2 - 175 + 70 * (y - 1));

    }


    public void Znacheniya(Graphics g) { // вывод на экран значений
        for (int a = 0; a < straka.size(); a = a + 1) {
            for (int b = 0; b < straka.get(a).size(); b = b + 1) {
                Font font = g.getFont().deriveFont(20.0f);
                g.setFont(font);
                g.drawString("" + straka.get(a).get(b), 200 - 50 * straka.get(a).size() + 50 * b, 200 + 70 * a + 35);
            }
        }
        for (int a = 0; a < stalbec.size(); a = a + 1) {
            for (int b = 0; b < stalbec.get(a).size(); b = b + 1) {
                Font font = g.getFont().deriveFont(20.0f);
                g.setFont(font);
                g.drawString("" + stalbec.get(a).get(b), 200 + 70 * a + 35, 200 - 50 * stalbec.get(a).size() + 50 * b + 35);
            }
        }
    }

    public int SummStraka(int a) { // сколько должно быть блоков в строке
        int sum = 0;
        for (int b = 0; b < straka.get(a).size(); b = b + 1) {
            sum += straka.get(a).get(b);
        }
        return sum;
    }

    public int SummStalbec(int a) {// сколько должно быть блоков в столбце
        int sum = 0;
        for (int b = 0; b < stalbec.get(a).size(); b = b + 1) {
            sum += stalbec.get(a).get(b);
        }
        return sum;
    }

    public int NoSummStraka(int a) { // сколько точно не заполнено в строке на момент вопроса в строке
        int sum = 0;
        for (int b = 0; b < 5; b++) {
            if (field[b][a] == -1) {
                sum = sum - 1;
            }
        }
        return sum;
    }

    public int NoSummStalbec(int a) { // сколько точно не заполнено в строке на момент вопроса в столбце
        int sum = 0;
        for (int b = 0; b < 5; b++) {
            if (field[a][b] == -1) {
                sum = sum - 1;
            }
        }
        return sum;
    }

    public int StrakaSumm(int a) { // сколько блоков заполнено сейчас в строке
        int sum = 0;
        for (int f = 0; f < 5; f++) {
            if (field[f][a] == 1) {
                sum = sum + field[f][a];
            }
        }
        return sum;
    }

    public int StalbecSumm(int a) {//сколько блоков заполнено сейчас в столбце
        int sum = 0;
        for (int f = 0; f < 5; f++) {
            if (field[a][f] == 1) {
                sum = sum + field[a][f];
            }
        }
        return sum;
    }

    public int StrakaNo1(int a) {
        int no1 = 0;
        for (int z = 0; z < 5; z++) {
            if (field[a][z] == -1) {
                no1++;
            } else {
                break;
            }
        }
        return no1;
    }

    public int StrakaNo2(int a) {
        int no1 = 0;
        for (int z = 4; z > -1; z--) {
            if (field[a][z] == -1) {
                no1++;
            } else {
                break;
            }
        }
        return no1;
    }

    public int StalbecNo1(int a) {
        int no1 = 0;
        for (int z = 0; z < 5; z++) {
            if (field[z][a] == -1) {
                no1++;
            } else {
                break;
            }
        }
        return no1;
    }

    public int StalbecNo2(int a) {
        int no1 = 0;
        for (int z = 4; z > -1; z--) {
            if (field[z][a] == -1) {
                no1++;
            } else {
                break;
            }
        }
        return no1;
    }

    int[][] field = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
    };


    public void Algoritm(Graphics g) {
        for (int k = 0; k < 100; k++) {
            for (int z = 0; z < 5; z++) {
                for (int l = 0; l < 5; l++) {
                    //if (field[z][l] == 0) { // изменять можно только 0 клетки
                    //while (field[z][l] == 0) {
                    for (int a = 0; a < straka.size(); a = a + 1) {
                        int offset = 0;
                        for (int b = 0; b < straka.get(a).size(); b++) {
                            for (int c = 0; c < straka.get(a).get(b); c++) {
                                for (int h = 0; h < 5; h++) {
                                    if (SummStraka(a) + straka.get(a).size() - 1 == stalbec.size() - StrakaNo1(a) - StrakaNo2(a) && field[c + offset + StrakaNo1(a)][a] == 0) { //для полных строк
                                        field[c + offset + StrakaNo1(a)][a] = 1;
                                        if ((straka.get(a).get(b) + offset + StrakaNo1(a) < 5) && (field[straka.get(a).get(b) + offset + StrakaNo1(a)][a] == 0)) {
                                            field[straka.get(a).get(b) + offset + StrakaNo1(a)][a] = -1;
                                        }
                                    }
                                    if (0 + StrakaNo1(a) < 5 && field[0 + StrakaNo1(a)][a] == 1 && b == 0 && straka.get(a).get(b) + StrakaNo1(a) < 5 && field[c + StrakaNo1(a)][a] == 0 && field[straka.get(a).get(b) + StrakaNo1(a)][a] == 0) { // края
                                        field[c + StrakaNo1(a)][a] = 1;
                                        field[straka.get(a).get(b) + StrakaNo1(a)][a] = -1;
                                    }
                                    if (4 - StrakaNo2(a) > -1 && field[4 - StrakaNo2(a)][a] == 1 && b == straka.get(a).size() - StrakaNo2(a) && straka.get(a).get(b) - StrakaNo2(a) < 5 &&c + 5 - StrakaNo2(a) - straka.get(a).get(b) > -1 && field[c + 5 - StrakaNo2(a) - straka.get(a).get(b)][a] == 0 && 5 - straka.get(a).get(b) - StrakaNo2(a) > -1 && field[5 - straka.get(a).get(b) - StrakaNo2(a)][a] == 0) {
                                        field[c + 5 - StrakaNo2(a) - straka.get(a).get(b)][a] = 1;
                                        field[5 - straka.get(a).get(b) - StrakaNo2(a)][a] = -1;
                                    }
                                    if (StrakaSumm(a) == SummStraka(a) && field[h][a] == 0) { // строка заполнена полностью
                                        field[h][a] = -1;
                                    }
                                    if (NoSummStraka(a) == SummStraka(a) - 5 && field[h][a] == 0) { // строка не заполнена полностью
                                        field[h][a] = 1;
                                    }
                                }
                            }
                            offset = offset + straka.get(a).get(b) + 1;
                        }
                    }
                    for (int a1 = 0; a1 < stalbec.size(); a1 = a1 + 1) {
                        int offset = 0;
                        for (int b1 = 0; b1 < stalbec.get(a1).size(); b1++) {
                            for (int c1 = 0; c1 < stalbec.get(a1).get(b1); c1++) {
                                for (int h1 = 0; h1 < 5; h1++) {
                                    if (SummStalbec(a1) + stalbec.get(a1).size() - 1 == straka.size() - StalbecNo1(a1) - StalbecNo2(a1) && field[a1][c1 + offset + StalbecNo1(a1)] == 0) { //для полных столбцов
                                        field[a1][c1 + offset + StalbecNo1(a1)] = 1;
                                        if (stalbec.get(a1).get(b1) + offset + StalbecNo1(a1) < 5 && field[a1][stalbec.get(a1).get(b1) + offset + StalbecNo1(a1)] == 0) {
                                            field[a1][stalbec.get(a1).get(b1) + offset + StalbecNo1(a1)] = -1;
                                        }
                                    }
                                    if ( 0 + StalbecNo1(a1) < 5 && field[a1][0 + StalbecNo1(a1)] == 1 && b1 == 0 && stalbec.get(a1).get(b1) + StalbecNo1(a1) < 5 && field[a1][c1 + StalbecNo1(a1)] == 0 && field[a1][stalbec.get(a1).get(b1) + StalbecNo1(a1)] == 0) { // края
                                        field[a1][c1 + StalbecNo1(a1)] = 1;
                                        field[a1][stalbec.get(a1).get(b1) + StalbecNo1(a1)] = -1;
                                    }
                                    if (4 - StalbecNo2(a1) > -1 && field[a1][4 - StalbecNo2(a1)] == 1 && b1 == stalbec.get(a1).size() - StalbecNo2(a1) && stalbec.get(a1).get(b1) - StalbecNo2(a1) < 5 && c1 + 5 - StalbecNo2(a1) - stalbec.get(a1).get(b1) > -1 && field[a1][c1 + 5 - StalbecNo2(a1) - stalbec.get(a1).get(b1)] == 0 && 5 - stalbec.get(a1).get(b1) - StalbecNo2(a1) > -1 && field[a1][5 - stalbec.get(a1).get(b1) - StalbecNo2(a1)] == 0) {
                                        field[a1][c1 + 5 - StalbecNo2(a1) - stalbec.get(a1).get(b1)] = 1;
                                        field[a1][5 - stalbec.get(a1).get(b1) - StalbecNo2(a1)] = -1;
                                    }
                                    if (StalbecSumm(a1) == SummStalbec(a1) && field[a1][h1] == 0) { // столбец заполнен полностью
                                        field[a1][h1] = -1;
                                    }
                                    if (NoSummStalbec(a1) == SummStalbec(a1) - 5 && field[a1][h1] == 0) { // столбец не заполнен полностью
                                        field[a1][h1] = 1;
                                    }
                                }
                            }
                            offset = offset + stalbec.get(a1).get(b1) + 1;
                        }
                    }
                    //}
                    //}
                }
            }
        }
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[0].length; col++) {
                Color color;
                switch (field[row][col]) {
                    case -1:
                        drawNo(g, row + 1, col + 1);
                        break;
                    case 0:
                        color = Color.WHITE;
                        break;
                    case 1:
                        drawYes(g, row + 1, col + 1);
                        break;
                }
            }
        }
    }
}