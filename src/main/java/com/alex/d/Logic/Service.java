package com.alex.d.Logic;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Service {
    static HashMap<String, HashMap<Integer, Integer>> cityFloorCounts = new HashMap<>();
    static HashMap<String, Integer> duplicateCount = new HashMap<>();

    public static void readCSV(String csvFileName) {
        String csvSplitBy = ";";
        try (BufferedReader br = Files.newBufferedReader(Path.of("src\\main\\resources\\" + csvFileName + ".csv"))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] row = line.split(csvSplitBy);
                if (row.length >= 4) {
                    String city = row[0];
                    int floors = Integer.parseInt(row[3]);

                    cityFloorCounts.putIfAbsent(city, new HashMap<>());
                    HashMap<Integer, Integer> floorCounts = cityFloorCounts.get(city);

                    floorCounts.put(floors, floorCounts.getOrDefault(floors, 0) + 1);

                    String rowString = String.join(",", row);
                    duplicateCount.put(rowString, duplicateCount.getOrDefault(rowString, 0) + 1);
                }
            }

            dublicates();
            cityFloorCount();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readXML(String xmlFileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("src\\main\\resources\\" + xmlFileName + ".xml"));

            NodeList itemNodes = document.getElementsByTagName("item");
            for (int i = 0; i < itemNodes.getLength(); i++) {
                Node itemNode = itemNodes.item(i);
                if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element itemElement = (Element) itemNode;

                    String city = itemElement.getAttribute("city");
                    int floors = Integer.parseInt(itemElement.getAttribute("floor"));

                    cityFloorCounts.putIfAbsent(city, new HashMap<>());
                    HashMap<Integer, Integer> floorCounts = cityFloorCounts.get(city);

                    floorCounts.put(floors, floorCounts.getOrDefault(floors, 0) + 1);

                    String rowString = city + "," + itemElement.getAttribute("street") + "," + itemElement.getAttribute("house") + "," + itemElement.getAttribute("floor");

                    duplicateCount.put(rowString, duplicateCount.getOrDefault(rowString, 0) + 1);
                }
            }
            dublicates();
            cityFloorCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void dublicates() {
        if (!duplicateCount.isEmpty()) {
            System.out.println(" ");
            System.out.println("Повторы:");
            for (String duplicate : duplicateCount.keySet()) {
                int count = duplicateCount.get(duplicate);
                if (count > 1) {
                    System.out.println(duplicate + " - Количество: " + count);
                    System.out.println(" ");
                }
            }
        } else {
            System.out.println("Повторы не найдены.");
        }
    }
    public static void cityFloorCount() {
        for (String city : cityFloorCounts.keySet()) {

            System.out.println("Город: " + city);
            HashMap<Integer, Integer> floorCounts = cityFloorCounts.get(city);
            for (int floors = 1; floors <= 5; floors++) {
                int count = floorCounts.getOrDefault(floors, 0);
                System.out.println(floors + " этажное: " + count + " дом(ов)(а)");
            }
            System.out.println();
        }
    }
}
