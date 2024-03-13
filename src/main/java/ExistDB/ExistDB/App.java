package ExistDB.ExistDB;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
        AccessDB access = new AccessDB();
        access.connect();
        //access.viewBooksList();
        //access.viewBookID("bk101");
        //access.viewBookTitle("Midnight Rain");
        //access.viewBooksAuthor("Corets, Eva");
        //access.viewBooksGenre("Fantasy");
        //access.updateTitleBook("The Sundered Grail 2", "The Sundered Grail");
        //access.addBook("Project Sekai", "K","Games" , "33.33", "2018-02-01", "Proyecto mundo");
        //access.deleteBookTitle("K");
        //access.viewBooks();
        //access.checkBookTitle("MSXML3: A Comprehensive Guide");
        System.out.println("- Select an option");
        System.out.println("- 1 - View books");
        System.out.println("- 2 - Add books");
        System.out.println("- 3 - Modify books");
        System.out.println("- 4 - Delete books");
        System.out.println("- 0 - Close");
        int opt = sc.nextInt();
        switch (opt) {
        	case 1:
        		System.out.println(" - Select how do you want to view the books");
        		System.out.println(" - 1 - View all books");
        		System.out.println(" - 2 - Search by title");
        		System.out.println(" - 3 - Search by genre");
        		System.out.println(" - 4 - Search by author");
        		int opt_view = sc.nextInt();
        		sc.nextLine();
        		switch(opt_view) {
        			case 1:
        				access.viewBooks();
        				break;
        			case 2:
        				System.out.print(" - Title: ");
        				String title = sc.nextLine();
        				access.viewBookTitle(title);
        				break;
        			case 3:
        				System.out.print(" - Genre: ");
        				String genre = sc.nextLine();
        				access.viewBookTitle(genre);
        				break;
        			case 4:
        				System.out.print(" - Author: ");
        				String author = sc.nextLine();
        				access.viewBookTitle(author);
        				break;
        		}
        		break;
        	case 2:
        		sc.nextLine();
        		System.out.println(" - Insert the data for the new book");
        		System.out.print(" - Title: ");
        		String title = sc.nextLine();
        		System.out.print(" - Author: ");
        		String author = sc.nextLine();
        		System.out.print(" - Genre: ");
        		String genre = sc.nextLine();
        		System.out.print(" - Price: ");
        		String price = sc.nextLine();
        		System.out.print(" - Publish date: ");
        		String publish_date = sc.nextLine();
        		System.out.print(" - Description: ");
        		String description = sc.nextLine();
        		if (!access.checkBookTitle(title)) {
        			access.addBook(title, author, genre, price, publish_date, description);
        		} else {
            		System.out.print("  - There's already one book with that title. ");
        		}
        		break;
        	case 3:
        		sc.nextLine();
        		System.out.print(" - Actual book title: ");
        		String old_title = sc.nextLine();
        		System.out.print(" - New book title: ");
        		String new_title = sc.nextLine();
        		access.updateTitleBook(old_title, new_title);
        		break;
        	case 4:
        		sc.nextLine();
        		System.out.print(" - Title: ");
        		String del_title = sc.nextLine();
        		access.deleteBookTitle(del_title);
        		break;
        	case 0:
        		break;
        }
    }
}
