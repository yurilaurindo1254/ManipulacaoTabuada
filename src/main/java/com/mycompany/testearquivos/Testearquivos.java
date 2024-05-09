/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testearquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author yuriz
 */
public class Testearquivos {

    public static void main(String[] args) {
        String directoryPath = "TabuadaDir";
        String filePath = directoryPath + "/tabuada.txt";

        // Criar diretório
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdir();  
        }

        // Criar arquivo
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("Arquivo criado: " + filePath);
            } else {
                System.out.println("O arquivo já existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao criar o arquivo.");
            e.printStackTrace();
        }

        // Escrever a tabuada do 9 no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 1; i <= 10; i++) {
                writer.write("9 x " + i + " = " + (9 * i));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo.");
            e.printStackTrace();
        }

        // Ler e imprimir o conteúdo do arquivo
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }

        // Excluir o arquivo
        if (file.delete()) {
            System.out.println("Arquivo excluído.");
        } else {
            System.out.println("Erro ao excluir o arquivo.");
        }
    }
  }