package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptsFileManager {
    public void writeReceiptToFile(String customerName, String receiptInfo) {
        String filePath = "main/resource/Receipts.txt";

        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write("Name: " + customerName + System.lineSeparator());
            fileWriter.write("Transaction Details: " + receiptInfo + System.lineSeparator());

        } catch (IOException e) {
            System.err.println("Error writing receipt information to file: " + e.getMessage());
        }
    }
}
