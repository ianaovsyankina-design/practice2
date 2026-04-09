package part3.part3_1;

public class MatrixOperations {

    public static void print(int[][] matrix) {
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            System.out.println("Ошибка: несовместимые размеры матриц");
            return null;
        }
        int m = a.length;
        int n = b[0].length;
        int p = b.length;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < p; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    public static int diagonalSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int sum = 0;
        // ▼ ВАШ КОД ЗДЕСЬ ▼
        // Определяем минимальный размер, чтобы не выйти за границы массива
        int minDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < minDim; i++) {
            sum += matrix[i][i];
        }
        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        return sum;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] b = {
                {7,  8},
                {9,  10},
                {11, 12}
        };

        System.out.println("Матрица A (2x3):");
        print(a);

        System.out.println("\nТранспонированная A (3x2):");
        print(transpose(a));

        System.out.println("\nМатрица B (3x2):");
        print(b);

        int[][] c = multiply(a, b);
        if (c != null) {
            System.out.println("\nA * B (2x2):");
            print(c);
            System.out.println("\nСумма диагонали A*B: " + diagonalSum(c));
        }
    }
}