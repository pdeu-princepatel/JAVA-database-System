This Java program allows you to manage student records through a simple menu-driven interface. You can add, view, search, update, and delete student records stored in a text file (`dataset.txt`).

## Features

1. **Add a Student Record**: Add a new student record with details such as roll number, name, phone number, age, and city.
2. **View All Records**: Display all student records stored in the `dataset.txt` file.
3. **Search a Record by Roll Number**: Search for a student record by their roll number.
4. **Update a Record**: Update the details of an existing student record identified by their roll number.
5. **Delete a Record**: Delete a student record by their roll number.
6. **Exit**: Exit the program.

## How to Use

1. **Compile and Run the Program**:
   - Open a terminal or command prompt.
   - Navigate to the directory containing the `Dataset.java` file.
   - Compile the program using the following command:
     ```bash
     javac Dataset.java
     ```
   - Run the program using the following command:
     ```bash
     java Dataset
     ```

2. **Interact with the Menu**:
   - When the program runs, a menu with options will be displayed.
   - Enter the number corresponding to the action you want to perform and follow the prompts.

## Program Flow

### Adding a Student Record
- Select option `1` to add a new student record.
- Enter the student's roll number, name, phone number, age, and city when prompted.
- The record will be saved to the `dataset.txt` file.

### Viewing All Records
- Select option `2` to view all student records.
- All records stored in `dataset.txt` will be displayed.

### Searching a Record by Roll Number
- Select option `3` to search for a student record by roll number.
- Enter the roll number of the student you want to search for.
- The program will display the record if found; otherwise, it will indicate that the record was not found.

### Updating a Record
- Select option `4` to update a student record.
- Enter the roll number of the student whose record you want to update.
- If the record is found, enter the new details for the student.
- The record will be updated in the `dataset.txt` file.

### Deleting a Record
- Select option `5` to delete a student record.
- Enter the roll number of the student whose record you want to delete.
- If the record is found, it will be deleted from the `dataset.txt` file.

### Exiting the Program
- Select option `6` to exit the program.
- The program will close the resources and exit.

## File Structure

- `Dataset.java`: The main Java program file.
- `dataset.txt`: The text file where student records are stored. This file is created automatically if it does not exist.

## Requirements

- Java Development Kit (JDK) installed on your system.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.
