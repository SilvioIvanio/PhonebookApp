# Phonebook Application
## Introduction

This documentation describes the structure and functionality of the **Phonebook Application**. 

The application manages contacts, allowing users to add, search, delete, update, sort, and analyze contacts. The project has been implemented in Java, and this documentation outlines the key algorithms, data structures, and core functionalities used in the application.

## Actions Taken (%)

| Student Name & Number | Pseudocode (Modules, Fuctions) | Flowchart | Program Implematation | Documentation |
| --- | --- | --- | --- | --- |
| Silvio Etiambulo (224046179) | 80% | 30% | 10% | 10% |
| Sebulon Kalombo (224063057) |  | 20% |  |  |
| Cherman Shivolo (224063057) |  |  | 90% | 10% |
| Lourena Lourenço (224087924) |  |  |  | 80% |
| Clive Kamenye (224087921) |  | 50% |  |  |
| Pinto Kambinda (224085573) | 20% |  |  |  |

## Section A: Algorithm Representation

This section presents the pseudocode and flowchart for the core operations in the phonebook application. It outlines the data structures used and the logic behind the functionalities.

### **1. Data Structure**

- **Contact Struct**: Represents individual contact information.
    - Fields:
        - `name`: The contact's name (required).
        - `phone_number`: The contact's phone number (required).
        - `email`: The contact's email (optional).
- **Contacts Array**: An array of `Contact` structs, sorted by the contact's name.

### **2. Functionalities**

 **2.1 Insert Contact**

This function adds a new contact to the phonebook.

**Parameters:**

- `name`: The contact's name.
- `phone_number`: The contact's phone number.
- `email`: The contact's email (optional).

**Returns:**

- Success if the contact is inserted, otherwise failure if the contact already exists.

**Operation:**

- Checks for existing contacts with the same name or phone number using the `searchContact()` function.
- Inserts the new contact and ensures the array remains sorted by calling `sortContacts()` if needed.

**2.2 Search Contact**

Searches for a contact by name or phone number.

**Parameters:**

- `query`: The name or phone number to search for.

**Returns:**

- The matching contact if found, otherwise `null`.

**Operation:**

- Implements binary search for names (since the list is sorted) and linear search for phone numbers.

**2.3 Display All Contacts**

Displays all contacts in the phonebook.

**Operation:**

- Loops through the contacts array and prints each contact's name, phone number, and email (or "N/A" if email is absent).

**2.4 Delete Contact**

Removes a contact based on name or phone number.

**Parameters:**

- `query`: The name or phone number to delete.

**Returns:**

- Success if the contact is deleted, otherwise failure if not found.

**2.5 Update Contact**

Updates the details of an existing contact.

**Parameters:**

- `query`: The name or phone number of the contact to update.
- `new_name`: The updated name of the contact.
- `new_phone_number`: The updated phone number.
- `new_email`: The updated email (optional).

**Returns:**

- Success if the contact is updated, otherwise failure if the contact is not found or if new details conflict with existing contacts.

**Operation:**

- Searches for the contact using `searchContact()`.
- If found, it checks for conflicts with existing contacts and updates the contact's details.
- Calls `sortContacts()` after updating to maintain the order.

**2.6 Sort Contacts**

Sorts the contacts alphabetically by name using the **Merge Sort** algorithm.

**Operation:**

- Splits the contacts array into sub-arrays, recursively sorts them, and then merges them back together.

**2.7 Analyze Search Efficiency**

Provides an analysis of the search algorithms used in the application.

**Details:**

- **Best Case (Binary Search)**: `O(1)` – Contact found in the middle of the sorted array.
- **Average Case (Binary Search)**: `O(log n)` – When searching by name.
- **Worst Case (Linear Search)**: `O(n)` – When searching by phone number.

## Section B: Practical Implementation

### **1. User Interface Design**

The user interface (UI) is built using the Java Swing library, providing an interactive and intuitive experience for managing contacts. Key components of the UI include:

- **Main Window**: Displays the contact management interface with input fields and action buttons.
- **Input Fields**: Text fields where users enter the contact’s name, phone number, and email.
- **Buttons**: Rounded buttons to perform actions like adding, searching, updating, deleting, and sorting contacts.

### **2. Application Workflow**

1. **Introduction Page**: Users start at a welcome screen and click a "Get Started" button to proceed to the main contact management interface.
2. **Main Interface**: Users can add, search, delete, update, or display all contacts through intuitive buttons.
3. **Search Efficiency Analysis**: Users can also analyze the efficiency of the search algorithms by entering a name or phone number and viewing the time taken by each algorithm.

### **3. Error Handling**

The application includes comprehensive error handling for invalid inputs and duplicate contacts. Messages are displayed when:

- Required fields are left blank.
- A contact already exists in the list.
- No contacts are found during a search or delete operation.

## Conclusion

This **Phonebook Application** offers a complete solution for managing contacts with robust functionality and efficient analysis. The combination of Java's `ArrayList` and sorting/searching algorithms ensures the application can handle operations with optimal performance while maintaining an easy-to-use interface. The use of binary search for name-based searches significantly reduces search times, while the merge sort ensures the list is always sorted for efficient operations.
