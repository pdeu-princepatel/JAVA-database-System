import java.io.*;
import java.util.*;

public class Dataset {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        File infile = new File("dataset.txt"); // input file creation
        BufferedWriter bw = new BufferedWriter(new FileWriter(infile, true)); // append is enabled

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a Student Record");
            System.out.println("2. View all Records");
            System.out.println("3. Search a Record by Roll Number");
            System.out.println("4. Update a Record");
            System.out.println("5. Delete a Record");
            System.out.println("6. Exit");
            int cs = sc.nextInt();

            switch (cs) {
                case 1:
                    // data storing
                    sc.nextLine(); // Consume the newline character after nextInt()
                    System.out.println("Enter Roll Number of Student:");
                    String roll = sc.nextLine();
                    System.out.println("Enter Student Name:");
                    String name = sc.nextLine();
                    System.out.println("Enter Student Phone number:");
                    String phone = sc.nextLine();
                    System.out.println("Enter Student Age:");
                    String age = sc.nextLine();
                    System.out.println("Enter Student City:");
                    String city = sc.nextLine();
                    bw.write(roll + " " + name + " " + phone + " " + age + " " + city + "\n");
                    bw.flush();
                    System.out.println("Data saved");
                    break;

                case 2:
                    // records printing
                    try (BufferedReader br = new BufferedReader(new FileReader(infile))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    break;

                case 3:
                    // searching by roll number
                    try (BufferedReader br1 = new BufferedReader(new FileReader(infile))) {
                        System.out.println("Enter roll number to search:");
                        String s_roll = sc.next();
                        String line1;
                        boolean found = false;

                        while ((line1 = br1.readLine()) != null) {
                            String[] ROLL = line1.split(" ");
                            if (ROLL[0].equals(s_roll)) {
                                System.out.println(line1);
                                found = true;
                                break; // Exit loop after finding the record
                            }
                        }
                        if (!found) {
                            System.out.println("Record not found.");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Update a record
                    try {
                        sc.nextLine(); // Consume newline left by nextInt()
                        System.out.println("Enter the roll number of student to update:");
                        String us_roll = sc.nextLine();
                        boolean ufound = false;

                        // Create a temporary file to update the record
                        File tempFile = new File("temp.txt");
                        BufferedWriter tempWriter = new BufferedWriter(new FileWriter(tempFile));
                        BufferedReader br = new BufferedReader(new FileReader(infile));

                        String uline;
                        while ((uline = br.readLine()) != null) {
                            String[] uRoll = uline.split(" ");
                            if (uRoll[0].equals(us_roll)) {
                                // Record found, update it
                                System.out.println("Enter the new name of student:");
                                String uname = sc.nextLine();
                                System.out.println("Enter the new age of student:");
                                String uage = sc.nextLine();
                                System.out.println("Enter the new phone number of student:");
                                String uphone = sc.nextLine();
                                System.out.println("Enter the new city of student:");
                                String ucity = sc.nextLine();
                                tempWriter.write(us_roll + " " + uname + " " + uphone + " " + uage + " " + ucity + "\n");
                                ufound = true;
                            } else {
                                tempWriter.write(uline + "\n"); // Write old record
                            }
                        }

                        // Close both readers/writers
                        br.close();
                        tempWriter.close();

                        if (!ufound) {
                            System.out.println("STUDENT not found");
                        } else {
                           // Replace original file with the updated file
                            BufferedReader tbr = new BufferedReader(new FileReader(tempFile));
                            BufferedWriter obw = new BufferedWriter(new FileWriter(infile));
                            String templine;
                            while ((templine = tbr.readLine()) != null) {
                                obw.write(templine);
                                obw.newLine(); // Correct method to write a new line
                            }
                            tbr.close();
                            obw.close();
                            System.out.println("Student details updated successfully.");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    break;

                case 5:
                    // Delete a record
                    try {
                        sc.nextLine(); // Consume newline left by nextInt()
                        System.out.println("Enter the roll number of student to delete:");
                        String droll = sc.nextLine();
                        boolean dfound = false;

                        // Create a temporary file to store records after deletion
                        File tempFile = new File("temp.txt");
                        BufferedWriter tempWriter = new BufferedWriter(new FileWriter(tempFile));
                        BufferedReader dbr = new BufferedReader(new FileReader(infile));

                        String dline;
                        while ((dline = dbr.readLine()) != null) {
                            String[] dROLL = dline.split(" ");
                            if (dROLL[0].equals(droll)) {
                                dfound = true;
                                System.out.println("Student with roll number " + droll + " has been deleted.");
                            } else {
                                tempWriter.write(dline + "\n"); // Retain record
                            }
                        }

                        // Close both readers/writers
                        dbr.close();
                        tempWriter.close();

                        if (!dfound) {
                            System.out.println("Record not found.");
                        } else {
                           // Replace original file with the updated file
                            BufferedReader tbr1 = new BufferedReader(new FileReader(tempFile));
                            BufferedWriter obw1 = new BufferedWriter(new FileWriter(infile));
                            String templine;
                            while ((templine = tbr1.readLine()) != null) {
                                obw1.write(templine);
                                obw1.newLine(); // Correct method to write a new line
                            }
                            tbr1.close();
                            obw1.close();                        
                        }

                    } catch (IOException e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    break;

                case 6:
                    bw.close(); // Close the BufferedWriter before exiting
                    sc.close(); // Close the Scanner
                    return; // Exit the program

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
