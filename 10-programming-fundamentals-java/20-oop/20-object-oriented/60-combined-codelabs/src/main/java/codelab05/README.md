# Mails

Think about your design before implementing.
Which concepts will you need? 
What state should these concepts have? 
How will you make them interact with each other?

Then, implement the following use-case:

The company ABC receives a large number of mails on the mailbox "info@abc.com". 
Therefore, they would like to have an automatic and swappable sorting algorithm to sort and clear the mails.

The algorithm will call the service to retrieve all mails from the "info@abc.com" mailbox.
- Sorting algorithm:
    - Mails containing text "CV" should be sent to the "recruitment" mailbox
    - Mails containing text "promotion" or "coupon" should be sent to the "spam" mailbox
    - Mails containing "proposal" should be sent to the "sales" mailbox
    - Other mails should be sent to the "reception" mailbox
- Make sure all mails are deleted from the original "info@abc.com" mailbox.
- After sorting the list print out some information about the sorting itself.
    - Total amount of mails sorted
    - Amount of mails sent to each mailbox

Check for responsibilities of a class. 
Should the sorting class print the information? 
Should the sorting class know all information about the sorted items?

Create and run an application in which you simulate the problem company ABC is having.

Create a new sorting algorithm, 
which sends all mails send from "@abc.com" mail addresses to the "reception" mailbox, 
all other mails to the "spam" mailbox.
If you implemented the sorting algorithm in a flexible and swappable way, 
you should be able to easily swap out the old sorting algorithm for the new one. 
