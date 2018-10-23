# Movie Rental

 Take a look at the `statement` method of `Customer`. Sure seems like it could use some proper refactoring.
 We detect multiple code smells (long method, wrong responsibility, undescriptive names, temporary variables,...).
 
 It's up to you to take a good look at the code and start refactoring it.
 In your refactoring process, you will most likely also have to refactor parts of `Movie`. Class `Rental` can stay unchanged.
 - Maybe you wonder why you should refactor the `Movie` class? Currently, the `Movie` class breaks the **open-closed principle** (part of the `SOLID` design principles).
 This and other principles will be seen during the **design principles and patterns** module. For now, do your own research (DYOR) or ask for help.
 
 There are some tests available, but they surely don't test every different case. So be careful not to introduce any bugs (change any existing behavior) while refactoring...
 
 During refactoring, it's possible you break the compilation of your tests. When this happens, 
 you obviously have to fix the errors. The actual result each test is asserting should however stay exactly the same!