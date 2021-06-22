package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LinkedList;

public class Main {


    static boolean solve(String s){

        List lista = new LinkedList();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') lista.add("1");
            if (s.charAt(i) == ')') {
                if (!lista.contains("1")) return false;
                lista.remove("1");
            }
        }

        if(lista.contains("1")) return false;

        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            if(solve(str)) System.out.println("correct");
            else System.out.println("incorrect");
        }
    }
}
