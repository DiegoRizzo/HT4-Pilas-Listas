package edu.uvg.hdt4;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Revisa si existe un archivo de entrada, si no, usa "datos.txt" por defecto
        String fileName;
        if (args.length > 0) {
            fileName = args[0];
        } else {
            fileName = "datos.txt";
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;

            while(running) {
                System.out.println("¿Deseas usar un Stack(S) o una Lista(L)?");
                String choice = scanner.nextLine().trim().toUpperCase();

                if (choice.equals("S")) {
                    boolean validStackChoice = false;
                    while (!validStackChoice) {
                        System.out.println("¿Qué implementación de Stack deseas usar?\n1 - Vector\n2 - ArrayList\n3 - Lista");
                        int stackChoice = scanner.nextInt();
                        
                        switch(stackChoice) {
                            case 1:
                                // Implementación de StackVector
                                IStack<Character> stackVector = new StackVector();
                                validStackChoice = true;
                                break;
                            case 2:
                                // Implementación de StackArrayList
                                IStack<Character> stackArrayList = new StackArrayList();
                                validStackChoice = true;
                                break;
                            case 3:
                                // Implementación de StackLista
                                IStack<Character> stackLista = new StackLista(100); // Capacidad de 100
                                validStackChoice = true;
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, elige 1, 2 o 3.");
                        }
                    }
                    running = false;
                } else if (choice.equals("L")) {
                    boolean validListChoice = false;
                    while (!validListChoice) {
                        System.out.println("¿Qué implementación de Lista deseas usar?\n1 - Lista Simplemente Encadenada\n2 - Lista Doblemente Encadenada");
                        int listChoice = scanner.nextInt();
                        
                        switch(listChoice) {
                            case 1:
                                // Implementación de Lista Simplemente Encadenada
                                validListChoice = true;
                                break;
                            case 2:
                                // Implementación de Lista Doblemente Encadenada
                                validListChoice = true;
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, elige 1 o 2.");
                        }
                    }
                    running = false;
                } else {
                    System.out.println("Opción no válida. Por favor, elige 'S' para Stack o 'L' para Lista.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}