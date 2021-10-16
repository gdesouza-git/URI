import java.util.*;

class bola {

    int valor = 0;
    boolean acessado = false;

}

public class Main {

    public static void main(String[] args) {

        //Entradas:
        Scanner s = new Scanner(System.in);

        int nLinhas;

        while (true) {
            nLinhas = s.nextInt();
            if (nLinhas == 0) break;

            bola[][] matriz = new bola[nLinhas][nLinhas];

            int k = 1;
            for (bola[] array : matriz) {
                for (int i = 0; i < k; i++) {
                    bola bola1 = new bola();
                    array[i] = bola1;
                    array[i].valor = s.nextInt();
                }
                k++;
            }
            int saida = solucao(matriz);
            System.out.println(Math.max(saida, 0));
        }
    }

    public static Integer solucao(bola[][] matriz) {

        SortedSet<Integer> lista = new TreeSet<>();
        for (int i = matriz.length; i > 0; i--) {
            int j = matriz[i-1].length;
            while(j > 0){
                reiniciarAcessado(matriz);
                soma(matriz, 0, i-1, j-1, lista);
                j--;
            }
        }

        return lista.last();
    }

    public static void soma(bola[][] matriz, int soma, int camada, int indice, SortedSet<Integer> lista) {

        if (camada == -1){
            lista.add(soma);
        }
        else {
            if (matriz[camada][indice] != null && !matriz[camada][indice].acessado) {
                soma += matriz[camada][indice].valor;
                matriz[camada][indice].acessado = true;
            }

            camada = camada - 1;
            soma(matriz, soma, camada, indice, lista);
            if (indice - 1 > 0) soma(matriz, soma, camada, indice - 1, lista);
        }
    }

    public static void reiniciarAcessado(bola[][] matriz) {
        for (bola[] bolas : matriz) {
            for (int j = 0; j < bolas.length; j++) {
                if (bolas[j] != null) bolas[j].acessado = false;
            }
        }
    }
}
