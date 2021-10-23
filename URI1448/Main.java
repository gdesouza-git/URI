import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            String frase = br.readLine();
            String fraseTime1 = br.readLine();
            String fraseTime2 = br.readLine();
            int[] info;
            info = verificarStrings(frase, fraseTime1, fraseTime2);
            System.out.println("Instancia "+(i+1));
            if(info[0] > info[1]) System.out.println("time 1\n");
            else if (info[1] > info[0]) System.out.println("time 2\n");
            else {
                if (info[2] == 0) System.out.println("empate\n");
                else if (info[2] == 1) System.out.println("time 1\n");
                else System.out.println("time 2\n");
            }
        }
    }
    static int[] verificarStrings(String esp, String ent1, String ent2){
        int[] resp = {0, 0, 0};
        boolean verificando = true;
        boolean time1 = false;
        boolean time2 = false;
        for (int i = 0; i < esp.length();i++){
                if (esp.charAt(i) == ent1.charAt(i)){
                    resp[0]++;
                    if (verificando) time1 = true;
                }
                if (esp.charAt(i) == ent2.charAt(i)){
                    resp[1]++;
                    if (verificando) time2 = true;
                }
                if(time1 && !time2) {
                    resp[2] = 1;
                    verificando = false;
                }
                else if (!time1 && time2){
                    resp[2] = 2;
                    verificando = false;
                }
            time1 = false;
            time2 = false;
        }
        return resp;
    }
}
