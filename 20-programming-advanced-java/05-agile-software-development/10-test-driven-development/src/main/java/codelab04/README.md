# Spacebook

For every requirement (you can even split requirements up into smaller bits):
1. Write a test
2. Run the test, see it fail
3. Let your pair implement a solution to fix that test (nothing more, quick and dirty!)
4. Run the test, it should succeed
5. Refactor (if needed)
6. Repeat step 1, but switch roles. 

Repeat this process until the requirement is completely tested (happy path and boundary tests) and fully implemented.
Only then go to the next requirement

Remember to keep the XP practices in mind:
- Pair programming
- Good tests
- Incremental design
- Write clean code

## Design
Start by **drawing the design** for the initial requirement(s).
Expand your design when taking up more requirements.
Remember: communication over complex tools (e.g.: use a whiteboard, pencil and paper)

## Requirement 1
A Storm trooper has a username and friends.
- A storm trooper can add other storm troopers as friends. This should be a **bidirectional relationship**!
- A storm trooper can not have duplicate (same username) friends 

## Requirement 2
A Storm trooper can receive messages from a friend.
A message has a date, sender and body (text)

## Requirement 3
You can ask a Storm trooper for all received messages, **sorted** by date (latest message first). 
You can ask a Storm trooper for received messages from a certain friend, **sorted** by date. 

## Requirement 4
Storm troopers have a rank (Soldier, Officer, General)
- Soldiers can be friends with other soldiers and officers
- Officers can be friends with everyone
- General can be friends with other generals and officers

When an attempt is made for a non-allowed friendship, an exception should be thrown with a custom message.

