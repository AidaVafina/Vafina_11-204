import java.util.*;
public class Main12{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Matrix matrix = new Matrix(3);
        for (int i = 0; i < matrix.getMatrixSize(); i++) {
            for (int j = 0; j < matrix.getMatrixSize(); j++) {
                matrix.setElement(i,j,scanner.nextInt());
            }
        }
        matrix.printDeter(matrix);
    }
}