public class Matrix {
    public int[][] innerMatrix;

    public Matrix(int len) {
        innerMatrix = new int[len][len];
    }

    public void setElement(int i, int j, int value) {
        innerMatrix[i][j] = value;
    }

    public int getMatrixSize() {
        return innerMatrix.length;
    }


    public int countPositivSum() {
        int plus = innerMatrix[0][0] * innerMatrix[1][1] * innerMatrix[2][2] + innerMatrix[1][0] * innerMatrix[2][1] * innerMatrix[0][2] + innerMatrix[2][0] * innerMatrix[0][1] * innerMatrix[1][2];
        return plus;
    }

    public int countNegativeSum() {
        int minus = innerMatrix[0][0] * innerMatrix[2][1] * innerMatrix[1][2] + innerMatrix[0][2] * innerMatrix[1][1] * innerMatrix[2][0] + innerMatrix[1][0] * innerMatrix[0][1] * innerMatrix[2][2];
        return minus;
    }

    public void printDeter(Matrix matrix) {
        Matrix.calculateTheDeterminant(matrix);
    }

    public static void calculateTheDeterminant(Matrix matrix) {
        if (matrix.getMatrixSize() == 3) {
            int determinant = matrix.countPositivSum() - matrix.countNegativeSum();
            System.out.println(determinant);
        } else {
            System.out.println("размер матрицы != 3");
        }
    }

}