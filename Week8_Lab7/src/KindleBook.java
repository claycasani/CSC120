import java.util.Scanner;

public class KindleBook {

    private static Scanner keyboard = new Scanner(System.in);

// Variables to hold system values
    static int numPages, currentPage;

// Constructor
    public KindleBook(int numPages) {
        this.numPages = numPages;
        this.currentPage = 1;
    }

// toString method
    public String toString() {
        return String.format("Page %3d of %3d", currentPage, numPages);
    }

// Method: increaseCurrentPage()
    public void increaseCurrentPage() {

        if (currentPage + 1 > numPages) {
            System.out.println("You were on:              " + toString());
            System.out.println("Turning on page would take you past the last page.");
            currentPage = numPages;
        } else {
            currentPage++;
        }
        System.out.println("You are now on: " + toString());
    }

// Method: increaseCurrentPage(int pages)
    public void increaseCurrentPage(int pages) {
        if (currentPage + pages > numPages) {
            System.out.println("You were on:                " + toString());
            System.out.println("Turning " + pages + " pages would take you past the last page.");
            currentPage = numPages;
        } else {
            currentPage += pages;
        }
        System.out.println("You are now on:             " + toString());
    }

// Main method for testing:
    public static void main(String[] args) {

//  Get total pages from input
        System.out.print("How many pages in the book: ");
        numPages = keyboard.nextInt();

        KindleBook book = new KindleBook(numPages);

//  Display initial position in book
        System.out.println("Initially:                  "+ book);

//  Increase current page by 4
        book.increaseCurrentPage(4);
        System.out.println("A bit later:                " + book);

//  Increase current page by 27
        book.increaseCurrentPage(27);
        System.out.println("After skipping 27 pages:    " + book);

//  Attempt to increase current page by 8
        book.increaseCurrentPage(8);

    } //  End of main method
} //  End of class KindleBook
