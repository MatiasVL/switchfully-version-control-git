# Operation Baobab (starting point: `2-operation-baobab`)

Now that we've got authentication covered, let's move on the authorisation. 

Our app has four roles:
- CIVILIAN, who can join the army
- PRIVATE, who can deployed army info
- HUMAN_RELATIONSHIPS. He can promote privates and discharge soldiers
- GENERAL, who can do everything the PRIVATE can. He can also launch the nukes (but he'd rather not. Because he's not [MAD](https://en.wikipedia.org/wiki/Mutual_assured_destruction)).

On top of the existing authentication code, implement security that blocks authenticated users from accessing certain endpoints if they don't have the necessary roles.

Extra info:
- http://www.baeldung.com/spring-security-expressions-basic

Extra assignment:
- The article offers multiple ways to fix this problem. Try implementing both and see if they both do the job.
- Users can have multiple roles. Create a user who is both a PRIVATE and a HUMAN_RELATIONSHIPS and check if he can do everything both roles can.
