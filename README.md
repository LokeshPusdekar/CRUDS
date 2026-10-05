# Employee Management System (Java)

A console-based Java application that performs **CRUDS** operations (**C**reate, **R**ead, **U**pdate, **D**elete, **S**ort) on employee records. It is built with core Java concepts: OOP, inheritance, polymorphism, abstract classes, collections, `Comparable` and `Comparator`.

## Features

| Operation | Description |
|-----------|-------------|
| **Create** | Add one or more employees (HR, Admin, Sales Manager) with type-specific details |
| **Read** | Display all employees, or search a single employee by ID or Name |
| **Update** | Find an employee by ID or Name and update their name, salary, or role-specific fields |
| **Delete** | Remove an employee by ID or Name |
| **Sort** | Sort the records by ID, Salary, Name, or Post |

## Employee Types

All types extend the abstract `Employee` class and implement their own `calsal()` method.

| Class | Extra fields | Total salary formula |
|-------|--------------|----------------------|
| `HR` | `commision` | `salary + commision` |
| `Admin` | `allowance` | `salary + allowance` |
| `Salesmanager` | `target`, `incentive` | `salary + (incentive * target)` |

## Concepts Used

- **Abstraction:** `Employee` is an abstract class with the abstract method `calsal()`
- **Inheritance:** `HR`, `Admin`, and `Salesmanager` extend `Employee`
- **Polymorphism:** `calsal()` and `toString()` are overridden in each subclass
- **Collections:** employees are stored in a `LinkedList<Employee>`
- **Sorting:**
  - `Comparable` (`compareTo`) provides the natural order (by ID)
  - `Comparator` classes provide sorting by Salary, Name, and Post
- **Type checking:** `instanceof` and casting to show role-specific update options
- **Input handling:** `Scanner` for console input

## Project Structure

```
Employee.java
 ├── Employee (abstract)   -> base class, implements Comparable<Employee>
 ├── HR                    -> extends Employee
 ├── Admin                 -> extends Employee
 ├── Salesmanager          -> extends Employee
 ├── Salary / Name / Post  -> Comparator implementations
 └── operations            -> Create, Display, show, Update, Delete, Sort, main
```

## Getting Started

### Prerequisites

- Java JDK 8 or later

### Compile and Run

```bash
javac Employee.java
java operations
```

## Usage

The program shows a menu in the console:

```
1.Create 2.Display 3.Show 4.Update 5.Delete 6.Sort 7.Exit
```

Example: adding an employee

```
How many Employee details you want to Add :
1
Name   :
Riya
ID     :
101
Salary :
40000
Post   :
HR
Commision :
5000
Employee HR is created Successfully.
```

Valid values for **Post** are `HR`, `Admin`, and `Salesmanager` (case-sensitive).

Example: sorting

```
Sort By :
1. ID
2. Salary
3. Name
4. Post
```

## Sorting Logic

```java
// By ID (natural order, uses compareTo)
Collections.sort(list);

// By Salary, Name, or Post (uses Comparator classes)
Collections.sort(list, new Salary());
Collections.sort(list, new Name());
Collections.sort(list, new Post());
```

## Possible Improvements

- Reject duplicate IDs during creation
- Add input validation for numbers and empty names
- Save and load records from a file or database
- Add a GUI, or convert to a Spring Boot REST API
- Add unit tests with JUnit

## Author

**Your Name**
GitHub: [LokeshPusdekar](https://github.com/LokeshPusdekar)

