import java.util.Scanner;
import java.util.Stack;
import java.util.List;

import edu.uvg.hdt4.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StackFactory<String> stackFactory = new StackFactory<String>();

        System.out.println("Seleccione implementación de Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");

        int option = scanner.nextInt();

        switch (option) {

            case 1:
                stackForConversion = stackFactory.getStack(1);
                stackForEvaluation = stackFactory.getStack(1);
                break;

            case 2:
                stackForConversion = stackFactory.getStack(2);
                stackForEvaluation = stackFactory.getStack(2);
                break;

            case 3:
                System.out.println("Seleccione tipo de lista:");
                System.out.println("1. Simplemente encadenada");
                System.out.println("2. Doblemente encadenada");

                int listOption = scanner.nextInt();

                if (listOption == 1) {
                    List<Character> listChar = new SinglyLinkedList<>();
                    List<Integer> listInt = new SinglyLinkedList<>();

                    stackForConversion = new StackLista<>(listChar);
                    stackForEvaluation = new StackLista<>(listInt);

                } else {
                    List<Character> listChar = new DoublyLinkedList<>();
                    List<Integer> listInt = new DoublyLinkedList<>();

                    stackForConversion = new StackLista<>(listChar);
                    stackForEvaluation = new StackLista<>(listInt);
                }

                break;

            default:
                System.out.println("Opción inválida.");
                System.exit(0);
        }

        // Leer expresión del archivo
        String expression = FileReaderUtil.readExpression("datos.txt");

        if (expression == null) {
            System.out.println("No se pudo leer la expresión.");
            return;
        }

        System.out.println("Expresión Infix: " + expression);

        // Convertir a postfix
        String postfix = InfixToPostfix.convert(expression, stackForConversion);

        System.out.println("Expresión Postfix: " + postfix);

        // Evaluar postfix
        int result = PostfixEvaluator.evaluate(postfix, stackForEvaluation);

        System.out.println("Resultado: " + result);

        scanner.close();
    }
}

