import java.util.*;
import java.io.*;

class mynovel {

    String Title;
    String Author;
    String Genre;
    String Status;

    Scanner sc = new Scanner(System.in);

    mynovel() {
        System.out.println();
    }

    void readDetails() {
        System.out.println("Enter the details of the book: ");

        System.out.print("What is the title? - ");
        Title = sc.nextLine();

        System.out.print("Who is the author of the book? - ");
        Author = sc.nextLine();

        System.out.print("What kind of book it is? - ");
        Genre = sc.nextLine();

        System.out.print("Enter the status (completed/reading/wantToRead) - ");
        Status = sc.next();

    }

    String saveDetails() {
        return "TITLE: " + Title + " | " + "AUTHOR: " + Author + " | " + "GENRE: " + Genre + " | " + "STATUS: "
                + Status;
    }
}

class mains {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        File file = new File("C:\\Users\\Priya\\Documents\\read.txt");
        FileReader fr = new FileReader(file);
        int i = fr.read();

        int choice;

        System.out.println();
        System.out.println("WELCOME TO YOUR PERSONAL LIBRARY");
        System.out.println("GET LOST IN THE BEAUTY OF LITERATURE");

        do {
            System.out.println();

            System.out.println("1. Add a book");
            System.out.println("2. List the books");
            System.out.println("3. Search for a book");
            System.out.println("4. Write a review");
            System.out.println("0. Exit");

            System.out.println();

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            mynovel m = new mynovel();

            switch (choice) {
                case 1:
                    m.readDetails();
                    add(m.saveDetails());
                    System.out.println("\n" + "Book added successfully!");
                    break;

                case 2:
                    if (file.length() == 0) {
                        System.out.println("No books added yet.");
                        System.out.println();
                        break;
                    }

                    else {
                        System.out.println("Your books in the list are: ");
                        System.out.println();

                        while (i != -1) {
                            System.out.print((char) i);
                            i = fr.read();
                        }

                        fr.close();
                        break;
                    }

                case 3:
                    if (file.length() == 0) {
                        System.out.println("No books added yet.");
                        break;
                    }

                    else {
                        System.out.print("Enter the title of the book you want to search for: ");
                        sc.nextLine();
                        String title = sc.nextLine();
                        System.out.println();

                        FileReader fr1 = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr1);
                        String line = br.readLine();
                        boolean found = false;

                        while (line != null) {
                            if (line.contains(title)) {
                                found = true;
                                break;
                            }
                            line = br.readLine();
                        }

                        if (found) {
                            System.out.println("Book found!");
                        }

                        else {
                            System.out.println("Book not found. Please try again");
                        }

                        fr1.close();
                    }

                    break;

                case 4:
                    if (file.length() == 0) {
                        System.out.println("No books added yet.");
                        break;
                    }

                    System.out.print("Which book do you want to review? ");
                    sc.nextLine();
                    String title1 = sc.nextLine();

                    FileReader fr2 = new FileReader(file);
                    BufferedReader br1 = new BufferedReader(fr2);

                    String line = br1.readLine();
                    boolean found = false;

                    while (line != null) {
                        if (line.contains(title1)) {
                            found = true;
                            break;
                        }
                        line = br1.readLine();
                    }

                    if (found) {
                        System.out.println("Book found!");
                        System.out.print("enter your review for the book: " + title1 + " - ");
                        String review = sc.nextLine();
                        FileWriter f = new FileWriter("C:\\Users\\Priya\\Documents\\read.txt", true);
                        f.write("\n" + "review of " + title1 + "-" + review + "\n");
                        f.write("\n");
                        System.out.println("Review added successfully!");
                        f.close();
                    }

                    else {
                        System.out.println("Book not found.");
                    }

                    fr2.close();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    System.out.println("HAPPY READING!");
                    System.out.println("A BOOK IS A DREAM THAT YOU HOLD IN YOUR HANDS");
                    System.out.println();
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }

    public static void add(String s) throws IOException {
        FileWriter f = new FileWriter("C:\\Users\\Priya\\Documents\\read.txt", true);
        f.write(s + "\n");
        f.close();
    }

}
