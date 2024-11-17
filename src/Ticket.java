import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    private String row;
    private int seat;
    private double price;
    private Person person;

    public Ticket(String row, int seat, Person person) {
        this.row = row;
        this.seat = seat;
        this.person = person;
        this.price = calculatePrice(row, seat);
    }
    private double calculatePrice(String row, int seat) {
        double price = 0.0;

        if (seat >= 1 && seat <= 5) {
            price = 200.0;
        } else if (seat >= 6 && seat <= 9) {
            price = 150.0;
        } else if (seat >= 10 && seat <= 14) {
            if (row.equals("A") || row.equals("D")) {
                price = 180.0;
            } else if (row.equals("B") || row.equals("C")) {
                price = 180.0;
            }
        }

        return price;
    }


    public void setRow(String row) {
        this.row = row;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    // Getters and Setters
    public String getRow() {
        return row;
    }


    public int getSeat() {
        return seat;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public void printTicketInfo() {
        System.out.println("Ticket Information:");
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: £" + price);
        System.out.println("Person Information:");
        person.printInfo();
    }

    public void save() {
        String fileName = row + getSeat() + ".txt";
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Ticket Information:\n");
            writer.write("Row: " + row + "\n");
            writer.write("Seat Number: " + getSeat() + "\n");
            writer.write("Person Information:\n");
            writer.write("Name: " + person.getName() + "\n");
            writer.write("Surname: " + person.getSurname() + "\n");
            writer.write("Email: " + person.getEmail() + "\n");
            writer.close();
            System.out.println("Ticket information saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the ticket information.");
            e.printStackTrace();
        }
    }


}
