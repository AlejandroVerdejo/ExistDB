package ExistDB.ExistDB;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AccessDB access = new AccessDB();
        access.connect();
        //access.viewBooksList();
        //access.viewBookID("bk101");
        //access.viewBookTitle("Midnight Rain");
        //access.viewBooksAuthor("Corets, Eva");
        //access.viewBooksGenre("Fantasy");
        //access.updateTitleBook("The Sundered Grail 2", "The Sundered Grail");
        access.addBook("K", "Project Sekai","Games" , "33.33", "2018-02-01", "Proyecto mundo");
        //access.deleteBookTitle("K");
        access.viewBooks();
    }
}
