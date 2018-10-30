# Book repo

Create a class BookRepository that accepts (`save`) new books (to be stored in a dummy in-memory database). 

Whenever a book has been added to the repository we want to do 2 additional actions:

- Print a message ("Book Saved") to the console (by the BookMessagePrinter)
- Send an e-mail to the author of the book (can be implemented as printing the message "Sending book-saved email to <authors_email>") (by the BookMessageEmailer)

Additional actions could be added in the near future.

There is one catch however. The BookRepository should not know about these additional actions in any way.
- The BookRepository can not be coupled with either the BookMessagePrinter or with the BookMessageEmailer.
- Thus, the BookRepository should not initiate the additional actions.
- Regarding the additional actions, all the BookRepository is allowed to do is to notify "interested listeners" (tip: by using an **event**).
- Furthermore, the BookMessagePrinter should not know about BookMessageEmailer and visa versa.

See how you can use the Observer behavioral design pattern to accomplish this. (yes, we are giving this one away).