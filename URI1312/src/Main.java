import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Entradas:
        Scanner s = new Scanner(System.in);

        int nLinhas;

        while(true) {
            nLinhas = s.nextInt();
            if (nLinhas == 0) break;

            Pair[][] matriz = new int[nLinhas][nLinhas];
            for (int[] array: matriz)
                Arrays.fill(array,0);

            int k = 1;
            for (int[] array : matriz) {
                for (int i = 0; i < k; i++) {
                    array[i] = s.nextInt();
                }
                k++;
            }
            System.out.println(solucao(matriz));
        }
    }

    public static int solucao(int[][] matriz){

        int somaFinal = 0;

        for (int i = 1; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int somaAtual = soma(matriz, 0, i, j);
                if (somaAtual > somaFinal) somaFinal = somaAtual;
            }
        }

        return 0;
    }

    public static int soma(int[][] matriz, int soma, int camada, int indice) {

        if(camada == 0) return soma;

        soma += matriz[camada][indice-1] + matriz[camada][indice];

        camada -= 1;
        soma(matriz, soma, camada, indice);

        return soma;
    }

}
