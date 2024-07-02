package com.javaintern;
import java.io.*;
public class FileEncryptDecrypt {
    // Simple XOR encryption/decryption key
        private static final int XOR_KEY = 7;

        public static void main(String[] args) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                // Prompt user for operation choice
                System.out.println("Choose operation:");
                System.out.println("1. Encrypt");
                System.out.println("2. Decrypt");
                int choice = Integer.parseInt(reader.readLine());

                // Prompt user for file path
                System.out.println("Enter file name or path:");
                String filePath = reader.readLine();

                // Determine input and output file names
                String inputFileName = filePath;
                String outputFileName;
                if (choice == 1) {
                    outputFileName = "encrypted_" + getFileName(filePath);
                } else {
                    outputFileName = "decrypted_" + getFileName(filePath);
                }

                // Perform encryption or decryption
                if (choice == 1) {
                    encryptFile(inputFileName, outputFileName);
                    System.out.println("File encrypted successfully.");
                } else if (choice == 2) {
                    decryptFile(inputFileName, outputFileName);
                    System.out.println("File decrypted successfully.");
                } else {
                    System.out.println("Invalid choice. Please choose 1 or 2.");
                }

                reader.close();
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }

        // Method to encrypt file
        private static void encryptFile(String inputFileName, String outputFileName) throws IOException {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                int currentChar;
                while ((currentChar = reader.read()) != -1) {
                    char encryptedChar = (char) (currentChar ^ XOR_KEY);
                    writer.write(encryptedChar);
                }
            }
        }

        // Method to decrypt file
        private static void decryptFile(String inputFileName, String outputFileName) throws IOException {
            // Decryption is the same as encryption (due to XOR properties)
            encryptFile(inputFileName, outputFileName);
        }

        // Utility method to get file name from path
        private static String getFileName(String filePath) {
            File file = new File(filePath);
            return file.getName();
        }
    }


