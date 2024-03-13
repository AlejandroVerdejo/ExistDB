package ExistDB.ExistDB;

import org.xmldb.api.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;

public class AccessDB {

	private String uri = "xmldb:exist://localhost:8080/exist/xmlrpc/db";
	private String user = "admin";
	private String pass = "1234";
	
	private Collection collection;
	private XPathQueryService service;
	
	public void connect() {
		String driver = "org.exist.xmldb.DatabaseImpl";
		collection = null;
		try {
			Class cl = Class.forName(driver);
			Database db = (Database) cl.newInstance();
			DatabaseManager.registerDatabase(db);
			collection = DatabaseManager.getCollection(uri, user, pass);
			if (collection == null) {
				System.out.println("Collection not found");
			} else {
				System.out.println("Connected successfully. Collections: "  + collection.getResourceCount());
			}
			service = (XPathQueryService) collection.getService("XPathQueryService", "1.0");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			collection.close();
		} catch (XMLDBException e) {
			e.printStackTrace();
		}
	}
	public boolean checkBookTitle(String title) {
		try {
			ResourceSet resources = service.query("for $b in /catalog/book[title='" + title + "'] return $b/title/text()");
			ResourceIterator it = resources.getIterator();
			while (it.hasMoreResources()) {
				Resource r = (Resource) it.nextResource();
				if (r.getContent().equals(title)) {
					return true;
				}
			}
			return false;
		} catch (XMLDBException e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	public void viewBooksList() {
		try {
			ResourceSet resources = service.query("for $b in /catalog/book/title/text() return $b");
			System.out.println(" --------BOOKS--------");
			System.out.println(" ---------------------");
			ResourceIterator it = resources.getIterator();
			while (it.hasMoreResources()) {
				System.out.println(" ---------------------");
				Resource r = (Resource) it.nextResource();
				System.out.println("  - " + (String) r.getContent());
			}
			System.out.println(" ---------------------");
			System.out.println("  - Total: " + resources.getSize());
			System.out.println(" ---------------------");
		} catch (XMLDBException e) {
			e.printStackTrace();
		}		
	}
	
	public void viewBooks() {
		try {
			ResourceSet resources = service.query("for $b in /catalog/book return ($b/title/text(),$b/author/text(),$b/genre/text(),$b/price/text(),$b/publish_date/text(),$b/description/text())");
			System.out.println(" --------BOOK---------");
			System.out.println(" ---------------------");
			ResourceIterator it = resources.getIterator();
			while (it.hasMoreResources()) {
				System.out.println(" ---------------------");
				Resource r = (Resource) it.nextResource();
				System.out.println("  - Title: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Author: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Genre: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Price: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Publish date: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Description: " + (String) r.getContent());
			}
			System.out.println(" ---------------------");
		} catch (XMLDBException e) {
			e.printStackTrace();
		}	
	}
	
	public void viewBookID(String id) {
		try {
			ResourceSet resources = service.query("for $b in /catalog/book[@id='" + id + "'] return ($b/title/text(),$b/author/text(),$b/genre/text(),$b/price/text(),$b/publish_date/text(),$b/description/text())");
			System.out.println(" --------BOOK---------");
			System.out.println(" ---------------------");
			ResourceIterator it = resources.getIterator();
			while (it.hasMoreResources()) {
				System.out.println(" ---------------------");
				Resource r = (Resource) it.nextResource();
				System.out.println("  - Title: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Author: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Genre: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Price: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Publish date: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Description: " + (String) r.getContent());
			}
			System.out.println(" ---------------------");
		} catch (XMLDBException e) {
			e.printStackTrace();
		}		
	}
	
	public void viewBookTitle(String title) {
		try {
			ResourceSet resources = service.query("for $b in /catalog/book[title='" + title + "'] return ($b/title/text(),$b/author/text(),$b/genre/text(),$b/price/text(),$b/publish_date/text(),$b/description/text())");
			System.out.println(" --------BOOK---------");
			System.out.println(" ---------------------");
			ResourceIterator it = resources.getIterator();
			while (it.hasMoreResources()) {
				Resource r = (Resource) it.nextResource();
				System.out.println("  - Title: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Author: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Genre: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Price: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Publish date: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Description: " + (String) r.getContent());
			}
			System.out.println("---------------------");
		} catch (XMLDBException e) {
			e.printStackTrace();
		}	
	}
	
	public void viewBooksAuthor(String author) {
		try {
			ResourceSet resources = service.query("for $b in /catalog/book[author='" + author + "'] return ($b/title/text(),$b/genre/text(),$b/price/text(),$b/publish_date/text(),$b/description/text())");
			System.out.println(" --------BOOKS--------");
			System.out.println(" ---------------------");
			System.out.println(" - Author: " + author);
			ResourceIterator it = resources.getIterator();
			int count = 0;
			while (it.hasMoreResources()) {
				System.out.println(" ---------------------");
				Resource r = (Resource) it.nextResource();
				System.out.println("  - Title: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Genre: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Price: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Publish date: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Description: " + (String) r.getContent());
				count++;
			}
			System.out.println(" ---------------------");
			System.out.println("  - Total: " + count);
			System.out.println(" ---------------------");
		} catch (XMLDBException e) {
			e.printStackTrace();
		}	
	}
	
	public void viewBooksGenre(String genre) {
		try {
			ResourceSet resources = service.query("for $b in /catalog/book[genre='" + genre + "'] return ($b/title/text(),$b/author/text(),$b/price/text(),$b/publish_date/text(),$b/description/text())");
			System.out.println(" --------BOOKS--------");
			System.out.println(" ---------------------");
			System.out.println("  - Genre: " + genre);
			ResourceIterator it = resources.getIterator();
			int count = 0;
			while (it.hasMoreResources()) {
				System.out.println(" ---------------------");
				Resource r = (Resource) it.nextResource();
				System.out.println("  - Title: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Author: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Price: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Publish date: " + (String) r.getContent());
				r = (Resource) it.nextResource();
				System.out.println("  - Description: " + (String) r.getContent());
				count++;
			}
			System.out.println(" ---------------------");
			System.out.println("  - Total: " + count);
			System.out.println(" ---------------------");
		} catch (XMLDBException e) {
			e.printStackTrace();
		}	
	}
	
	public void updateTitleBook(String old_title,String new_title) {
		try {
			ResourceSet resources = service.query("update value /catalog/book[title='" + old_title + "']/title with '" + new_title + "'");
			System.out.println(" - Book title " + old_title + " updated to " + new_title);
		} catch (XMLDBException e) {
			e.printStackTrace();
		}
	}
	
	public void getID() {
		try {
			ResourceSet resources = service.query("for $b in /catalog/book return $b");
			System.out.println(" --------BOOKS--------");
			System.out.println(" ---------------------");
			ResourceIterator it = resources.getIterator();
			Resource r = (Resource) it.nextResource();
			System.out.println("  - " + (String) r.getContent());
			System.out.println(" ---------------------");
			System.out.println(" - Total: " + resources.getSize());
			System.out.println(" ---------------------");
		} catch (XMLDBException e) {
			e.printStackTrace();
		}	
	}
	
	public void addBook(String title,String author,String genre,String price,String publish_date,String description) {
		try {
			ResourceSet resources = service.query("update insert <book><author>" + author + "</author><title>" + title + "</title><genre>" + genre + "</genre><price>" + price + "</price><publish_date>" + publish_date + "</publish_date><description>" + description + "</description></book> into /catalog");
			System.out.println("  - Book '" + title + "' added");
		} catch (XMLDBException e) {
			e.printStackTrace();
		}
	}
	public void deleteBookTitle(String title) {
		try {
			ResourceSet resources = service.query("update delete /catalog/book[title='" + title + "']");
			System.out.println(" - Book '" + title + "' deleted");
		} catch (XMLDBException e) {
			e.printStackTrace();
		}
	}
}
