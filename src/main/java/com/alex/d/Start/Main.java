package com.alex.d.Start;
import java.util.*;
import com.alex.d.Logic.Service;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Выберите файл:");
            System.out.println("CSV / XML формата");
            System.out.println(" Выход ");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("csv")) {
                System.out.print("Введите CSV имя файла: ");
                String csvFileName = scanner.next();
                Service.readCSV(csvFileName);
            } else if (input.equalsIgnoreCase("xml")) {
                System.out.print("Введите XML имя файла: ");
                String xmlFileName = scanner.next();
                Service.readXML(xmlFileName);
            } else if (input.equalsIgnoreCase("выход")) {
                System.out.println("Выходим...");
                break;
            }

            while (true) {
                System.out.println("Хотите продолжить?");
                System.out.println("Введите 'CSV' или 'XML' формат файла");
                System.out.println("Выход");
                String continueInput = scanner.next();
                if (continueInput.equalsIgnoreCase("выход")) {
                    System.out.println("Выходим...");
                    return;
                } else if (continueInput.equalsIgnoreCase("csv")) {
                    System.out.print("Введите имя CSV файла: ");
                    String csvFileName = scanner.next();
                    Service.readCSV(csvFileName);
                    break;
                } else if (continueInput.equalsIgnoreCase("xml")) {
                    System.out.print("Введите имя XML файла: ");
                    String xmlFileName = scanner.next();
                    Service.readXML(xmlFileName);
                    break;
                } else {
                    System.out.println("Повторите ввод. Или выберите 'выход'");
                }
            }
        }
    }
}






    
