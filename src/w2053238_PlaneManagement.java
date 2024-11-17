import java.util.Arrays;
import java.util.Scanner;

public class w2053238_PlaneManagement {
    static int[] rowA = new int[14];
    static int[] rowB = new int[12];
    static int[] rowC = new int[12];
    static int[] rowD = new int[14];
    static Ticket[] tickets = new Ticket[52];

    public static void main(String[] args) {
        System.out.println("Welcome to the Plane Management application");
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            printMenu();
            System.out.print("Please select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    buy_seat();
                    break;
                case 2:
                    cancel_seat();
                    break;
                case 3:
                    find_first_available();
                    break;
                case 4:
                    show_seating_plan();
                    break;
                case 5:
                    print_tickets_info();
                    break;
                case 6:
                    search_ticket();
                    break;
                case 0:
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 0);
    }

    static void printMenu() {
        System.out.println("***********************");
        System.out.println("       MENU OPTIONS    ");
        System.out.println("***********************");
        System.out.println("1. Buy a seat");
        System.out.println("2. Cancel a seat");
        System.out.println("3. Find first available seat");
        System.out.println("4. Show seating plan");
        System.out.println("5. Print tickets information and total sales");
        System.out.println("6. Search ticket");
        System.out.println("0. Quit");
        System.out.println("***********************");
    }

    static void buy_seat() {
        Scanner scanner = new Scanner(System.in);

        boolean addAnother = true;
        while (addAnother) {

            System.out.println("Enter your name:");
            String name = scanner.next();
            while (!name.matches("[a-zA-Z]+")) {
                System.out.println("Invalid name. Name should only contain alphabets. Please enter again:");
                name = scanner.next();
            }

            System.out.println("Enter your surname:");
            String surname = scanner.next();
            while (!surname.matches("[a-zA-Z]+")) {
                System.out.println("Invalid surname. Surname should only contain alphabets. Please enter again:");
                surname = scanner.next();
            }

            System.out.println("Enter your email:");
            String email = scanner.next();
            while (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                System.out.println("Invalid email. Please enter a valid email address:");
                email = scanner.next();
            }

            Person person = new Person(name, surname, email);

            System.out.println("Enter a row letter from A - D");
            char rowLetter = Character.toUpperCase(scanner.next().charAt(0));

            System.out.println("Enter a seat number from 1 - 14");
            int seatNumber = scanner.nextInt();

            double price;
            switch (rowLetter) {
                case 'A', 'D' -> {
                    if (seatNumber >= 1 && seatNumber <= 14) {
                        if (seatNumber <= 7) {
                            price = 200.0;
                        } else {
                            price = 180.0;
                        }
                        if (rowLetter == 'A' && rowA[seatNumber - 1] == 0) {
                            rowA[seatNumber - 1] = 1;
                            System.out.println("Seat " + seatNumber + " in row " + rowLetter + " has been successfully purchased for £" + price);
                            // Create a new Ticket object
                            Ticket newTicket = new Ticket(String.valueOf(rowLetter), seatNumber, person);
                            // Add the ticket to the tickets array
                            for (int i = 0; i < tickets.length; i++) {
                                if (tickets[i] == null) {
                                    tickets[i] = newTicket;
                                    break;
                                }
                            }
                            // Save ticket information to a file
                            newTicket.save();
                        } else if (rowLetter == 'D' && rowD[seatNumber - 1] == 0) {
                            rowD[seatNumber - 1] = 1;
                            System.out.println("Seat " + seatNumber + " in row " + rowLetter + " has been successfully purchased for £" + price);
                            // Create a new Ticket object
                            Ticket newTicket = new Ticket(String.valueOf(rowLetter), seatNumber, person);
                            // Add the ticket to the tickets array
                            for (int i = 0; i < tickets.length; i++) {
                                if (tickets[i] == null) {
                                    tickets[i] = newTicket;
                                    break;
                                }
                            }
                            // Save ticket information to a file
                            newTicket.save();
                        } else {
                            System.out.println("Seat " + seatNumber + " in row " + rowLetter + " is already booked.");
                        }
                    } else {
                        System.out.println("Invalid seat number. Seat number should be between 1 and 14.");
                    }
                }
                case 'B', 'C' -> {
                    if (seatNumber >= 1 && seatNumber <= 12) {
                        if (seatNumber <= 7) {
                            price = 150.0;
                        } else {
                            price = 180.0;
                        }
                        if (rowLetter == 'B' && rowB[seatNumber - 1] == 0) {
                            rowB[seatNumber - 1] = 1;
                            System.out.println("Seat " + seatNumber + " in row " + rowLetter + " has been successfully purchased for £" + price);
                            // Create a new Ticket object
                            Ticket newTicket = new Ticket(String.valueOf(rowLetter), seatNumber, person);
                            // Add the ticket to the tickets array
                            for (int i = 0; i < tickets.length; i++) {
                                if (tickets[i] == null) {
                                    tickets[i] = newTicket;
                                    break;
                                }
                            }
                            // Save ticket information to a file
                            newTicket.save();
                        } else if (rowLetter == 'C' && rowC[seatNumber - 1] == 0) {
                            rowC[seatNumber - 1] = 1;
                            System.out.println("Seat " + seatNumber + " in row " + rowLetter + " has been successfully purchased for £" + price);
                            // Create a new Ticket object
                            Ticket newTicket = new Ticket(String.valueOf(rowLetter), seatNumber, person);
                            // Add the ticket to the tickets array
                            for (int i = 0; i < tickets.length; i++) {
                                if (tickets[i] == null) {
                                    tickets[i] = newTicket;
                                    break;
                                }
                            }
                            // Save ticket information to a file
                            newTicket.save();
                        } else {
                            System.out.println("Seat " + seatNumber + " in row " + rowLetter + " is already booked.");
                        }
                    } else {
                        System.out.println("Invalid seat number. Seat number should be between 1 and 12.");
                    }
                }
                default -> System.out.println("Invalid row letter. Please try again.");
            }

            System.out.println("Do you want to add another one? Y/N");
            String choice = scanner.next().toUpperCase();
            if (!choice.equals("Y")) {
                addAnother = false;
            }
        }
    }



    static void cancel_seat() {
        Scanner scanner = new Scanner(System.in);
        boolean cancelAnother = true;
        while (cancelAnother) {
            System.out.print("Enter row letter (A-D): ");
            char rowLetter = Character.toUpperCase(scanner.next().charAt(0));
            System.out.print("Enter seat number (1-14): ");
            int seatNumber = scanner.nextInt();
            int[] selectedRow;
            switch (rowLetter) {
                case 'A':
                case 'D':
                    selectedRow = (rowLetter == 'A') ? rowA : rowD;
                    break;
                case 'B':
                case 'C':
                    selectedRow = (rowLetter == 'B') ? rowB : rowC;
                    break;
                default:
                    System.out.println("Invalid row letter. Please try again.");
                    return;
            }

            if (seatNumber >= 1 && seatNumber <= selectedRow.length && selectedRow[seatNumber - 1] == 1) {
                selectedRow[seatNumber - 1] = 0;
                System.out.println("Seat " + rowLetter +" "+ seatNumber + " has been successfully canceled.");

                // Remove the ticket from the tickets array
                for (int i = 0; i < tickets.length; i++) {
                    if (tickets[i] != null && tickets[i].getRow().equals(String.valueOf(rowLetter)) && tickets[i].getSeat() == seatNumber) {
                        // Shift all elements to the left
                        for (int j = i; j < tickets.length - 1; j++) {
                            tickets[j] = tickets[j + 1];
                        }

                        tickets[tickets.length - 1] = null;
                        break;
                    }
                }
            } else {
                System.out.println("Already available seat. Please try again.");
                continue;
            }
            System.out.println("Do you want to cancel another one? Y/N");
            String choice = scanner.next().toUpperCase();
            if (!choice.equals("Y")) {
                cancelAnother = false;
            }
        }
        System.out.println("Row A: " + Arrays.toString(rowA));
        System.out.println("Row B: " + Arrays.toString(rowB));
        System.out.println("Row C: " + Arrays.toString(rowC));
        System.out.println("Row D: " + Arrays.toString(rowD));
    }


    static void find_first_available() {
        char[] rows = {'A', 'B', 'C', 'D'};

        for (int rowIndex = 0; rowIndex < rows.length; rowIndex++) {
            char rowLetter = rows[rowIndex];
            int[] selectedRow = getRowArray(rowLetter);

            // Iterate through seats in the row
            for (int i = 0; i < selectedRow.length; i++) {
                if (selectedRow[i] == 0) {
                    System.out.println("First available seat: " + rowLetter + (i + 1));
                    return;
                }
            }
        }
        System.out.println("No available seats.");
    }

    static int[] getRowArray(char rowLetter) {
        switch (rowLetter) {
            case 'A':
            case 'D':
                return (rowLetter == 'A') ? rowA : rowD;
            case 'B':
            case 'C':
                return (rowLetter == 'B') ? rowB : rowC;
            default:
                return new int[0];
        }
    }

    static void show_seating_plan() {
        System.out.println("Seating Plan:");
        System.out.println("Row\tSeats");
        char[] rows = {'A', 'B', 'C', 'D'};

        for (char rowLetter : rows) {
            int[] selectedRow = getRowArray(rowLetter);
            System.out.print(rowLetter + "\t");

            for (int i = 0; i < selectedRow.length; i++) {
                if (selectedRow[i] == 0) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }

            System.out.println();
        }
    }


    static void print_tickets_info() {
        double totalSales = 0.0;

        System.out.println("Tickets Information:");

        for (Ticket ticket : tickets) {
            if (ticket != null) {
                ticket.printTicketInfo();
                totalSales += ticket.getPrice();
                System.out.println();
            }
        }

        System.out.printf("Total Sales: £%.2f\n", totalSales);
    }


    static void search_ticket() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter a row letter from A - D:");
        char rowLetter = Character.toUpperCase(scanner.next().charAt(0));

        System.out.println("Enter a seat number from 1 - 14:");
        int seatNumber = scanner.nextInt();


        switch (rowLetter) {
            case 'A', 'D' -> {
                if (seatNumber >= 1 && seatNumber <= 14) {
                    if ((rowLetter == 'A' && rowA[seatNumber - 1] == 1) || (rowLetter == 'D' && rowD[seatNumber - 1] == 1)) {
                        // Seat is booked, print Ticket and Person information
                        System.out.println("Ticket Information:");
                        Ticket ticket = findTicket(rowLetter, seatNumber);
                        assert ticket != null;
                        Person person = ticket.getPerson();
                        System.out.println("Seat " + seatNumber + " in row " + rowLetter + " has been booked.");
                        System.out.println("Person Information:");
                        person.printInfo();
                    } else {
                        System.out.println("Seat " + seatNumber + " in row " + rowLetter + " is available.");
                    }
                } else {
                    System.out.println("Invalid seat number. Seat number should be between 1 and 14.");
                }
            }
            case 'B', 'C' -> {
                if (seatNumber >= 1 && seatNumber <= 12) {
                    if ((rowLetter == 'B' && rowB[seatNumber - 1] == 1) || (rowLetter == 'C' && rowC[seatNumber - 1] == 1)) {
                        System.out.println("Ticket Information:");
                        Ticket ticket = findTicket(rowLetter, seatNumber);
                        assert ticket != null;
                        Person person = ticket.getPerson();
                        System.out.println("Seat " + seatNumber + " in row " + rowLetter + " has been booked.");
                        System.out.println("Person Information:");
                        person.printInfo();
                    } else {
                        System.out.println("Seat " + seatNumber + " in row " + rowLetter + " is available.");
                    }
                } else {
                    System.out.println("Invalid seat number. Seat number should be between 1 and 12.");
                }
            }
            default -> System.out.println("Invalid row letter. Please try again.");
        }
    }

    static Ticket findTicket(char rowLetter, int seatNumber) {
        for (Ticket ticket : tickets) {
            if (ticket != null && ticket.getRow().charAt(0) == rowLetter && ticket.getSeat() == seatNumber) {
                return ticket;
            }
        }
        return null;
    }

}
