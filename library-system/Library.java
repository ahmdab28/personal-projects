package review;



public class Library {

    String address;
    Book[] books;
    int numBooks;

   public Library(String address) {
	  this.address=address;
	  books=new Book[100];
	   numBooks =0;
   }
   
   public void addBook(Book book) {
	   books[numBooks]=book;
	   numBooks++;
   }
   public static void printOpeningHours() {
	   System.out.println("Libraries are open daily from 9am to 5pm.");
	   
   }
   public void printAddress() {
	   System.out.println(address);
   }
   public void borrowBook(String title) {
	   for(int i=0; i<numBooks;i++) {
		   if(books[i].getTitle().equals(title)) {
			   if(!books[i].isBorrowed()) {
				   books[i].borrowed();
				   System.out.println("You successfully borrowed "+ title);
			   }else {
				   System.out.println("Sorry, this book is already borrowed");
			   }
			   return;
		   }
		  
	   }
	   System.out.println("Sorry, this book is not in our catalog.");
   }
   
   
   public void printAvailableBooks() {
	  boolean hasBooks =false;
	  for (int i =0;i<numBooks;i++) {
		  if(!books[i].borrowed) {
			  hasBooks=true;
			  System.out.println(books[i].getTitle());
			  
		  } 
	  }
	  if(!hasBooks) {
		  System.out.println("No books in catalog.");
	  }
   }
 
   public void returnBook(String title) {
	  for(int i =0;i<numBooks;i++) {
		  if(books[i].getTitle().equals(title)) {
			  books[i].returned();
			  System.out.println("You successfully returned "+title);
			  return;
		  }
		  
	  }
	  System.out.println("This book does not belong to this library.");
   }


	public static void main(String[] args) {
		// Create two libraries
		
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");
		
		// Add four books to the first library
		firstLibrary.addBook(new Book("The Da Vinci Code"));
		firstLibrary.addBook(new Book("Le Petit Prince"));
		firstLibrary.addBook(new Book("A Tale of Two Cities"));
		firstLibrary.addBook(new Book("The Lord of the Rings"));
		// Print opening hours and the addresses
		System.out.println("Library hours:");
		printOpeningHours();
		System.out.println();
		System.out.println("Library addresses:");
		firstLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();
		// Try to borrow The Lords of the Rings from both libraries
		System.out.println("Borrowing The Lord of the Rings:");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings");
		System.out.println();
		 //Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.printAvailableBooks();
		System.out.println();
		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();
		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
	}
}