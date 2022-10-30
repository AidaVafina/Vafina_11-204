public class Matrix {
    public int[][] innerMatrix;

    public Matrix(int len) {
        innerMatrix = new int[len][len];
    }

    public void setElement(int i, int j, int value) {
        innerMatrix[i][j] = value;
    }

    public int getElement(int i, int j){
        return innerMatrix[i][j];
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
        System.out.println("определитель матрицы равен " + Matrix.calculateTheDeterminant(matrix));
    }

    public static int calculateTheDeterminant(Matrix matrix) {
        if (matrix.getMatrixSize() == 3) {
            int determinant = matrix.countPositivSum() - matrix.countNegativeSum();
            return determinant;
        } else {
            return 0;
        }
    }

    public static int countSumElem(Matrix matrix){
        int sumEl = 0;
        for (int i = 0; i < matrix.getMatrixSize(); i++) {
            for (int j = 0; j < matrix.getMatrixSize(); j++) {
                sumEl += matrix.getElement(i,j);
            }
        }
        return sumEl;
    }



}