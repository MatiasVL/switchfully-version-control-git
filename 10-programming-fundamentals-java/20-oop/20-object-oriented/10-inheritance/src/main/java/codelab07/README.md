# Battle sim. rank

First, make sure you've finished implementing codelab06 (Battle sim.)

Modify Soldier so that it has a rank (Hint: use an Enum for this)
- A rank can have the following values
    - PRIVATE_FIRST_CLASS
    - CORPORAL
    - SERGEANT
    - LIEUTENANT
    - CAPTAIN
    - MAJOR
    - COLONEL
    - GENERAL
- A Rank should have the following behavior:
    - get label which returns a more read-friendly textual representation of rank
        - e.g. PRIVATE_FIRST_CLASS --> "Private first class"
- A Soldier should receive new behavior
    - promote which promotes a soldier to his next rank
        - Question: Who should have the knowledge about the hierarchy of the ranks? Soldier or Rank?
        
Question: This Rank - Soldier relation, is it inheritance, composition or neither?