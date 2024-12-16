# MP4
A repository for our MP4 final project, where we can copy and paste code for our classes :)

AUTHOR INFO

- Full Name: Ethan E. Lopez, Chantelle Chan, Asiyah Speight, Aidan Tran
- Student ID: 2425516, 2428795, 2426311
- Chapman Email: etlopez@chapman.edu, aidtran@chapman.edu, aspeight@chapman.edu, chachan@chapman.edu
- Course Number And Section: CPSC-231-01
- Assignment Or Exercise Number: MP4: Build What You Want

ERRORS (RUNTIME)

- Multiple scanner issues in "cart" methods
- Conceptually, our team followed the Scanner structure to the precise detail, however, 'no line found' exceptions still arise when removing books from the customer's carts and clearing them
- Adding books to the cart works, but you'll most likely find another issue that happens even when commenting out the firstRemove() and clearMyCart() methods... it doesn't allow you to purchase because another Scanner issue comes up
- Formatting of this specific exception will often appear as follows:

-- Exception in thread "main" java.util.NoSuchElementException: No line found
        at java.util.Scanner.nextLine(Scanner.java:1540)
        at Customer.firstRemove(Customer.java:116)
        at BookShop.main(BookShop.java:318)

- To Avoid Reaching The Above Exception, always choose Option 2 (Purchasing Directly) to run the program all the way through

SOURCES

- Worked alongside a Computer Science student, David Sohn, who showed me how to identify a number in a String using (String).matches(".*\\d.*")
- Used geeksforgeeks.org for guidance using the LocalDate package
     https://www.geeksforgeeks.org/java-time-localdate-class-in-java/
- stackoverflow.com was used to find a method to calculate the time elapsed between 2 dates
     https://stackoverflow.com/questions/27005861/calculate-days-between-two-dates-in-java-8
- ChatGPT was used to error check and make corrections within the createBooksToAdd() method inside of the Administrator.java class. 
     Roughly 60-70% of that specific code was originally written by us
- Did some research on Scanner objects to see how we could implement them more neatly
     https://stackoverflow.com/questions/65503259/should-a-scanner-only-be-instantiated-only-once-if-thats-the-case-why-so / 
     https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-Scanner-User-Input-example-String-next-int-long-char / 
     https://www.geeksforgeeks.org/passing-scanner-object-as-a-parameter-in-java/
- Comments have been added to the following classes, according to the general understanding of what the class does
