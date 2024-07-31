import java.util.*;

public class BooleanParenthesization {
    public static int countParenth(char symb[], char op[], int n) {
        int F[][] = new int[n][n];
        int T[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            F[i][i] = (symb[i] == 'F') ? 1 : 0;
            T[i][i] = (symb[i] == 'T') ? 1 : 0;
        }
        for (int gap = 1; gap < n; ++gap) {
            for (int i = 0, j = gap; j < n; ++i, ++j) {
                T[i][j] = F[i][j] = 0;
                for (int g = 0; g < gap; g++) {
                    int k = i + g;
                    int tik = T[i][k] + F[i][k];
                    int tjk = T[k + 1][j] + F[k + 1][j];
                    if (op[k] == '&') {
                        T[i][j] += T[i][k] * T[k + 1][j];
                        F[i][j] += (tik * tjk - T[i][k] * T[k + 1][j]);
                    }
                    if (op[k] == '|') {
                        F[i][j] += F[i][k] * F[k + 1][j];
                        T[i][j] += (tik * tjk - F[i][k] * F[k + 1][j]);
                    }
                    if (op[k] == '^') {
                        T[i][j] += F[i][k] * T[k + 1][j] + T[i][k] * F[k + 1][j];
                        F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j];
                    }
                }
            }
        }
        return T[0][n - 1];
    }

    public static void main(String[] args) {
        char symbols[] = "TTFT".toCharArray();
        char operators[] = "|&^".toCharArray();
        int n = symbols.length;
        System.out.println(
                countParenth(symbols, operators, n));
    }
}
