# Blog

We're going to create a Blog application

## BlogPost

A BlogPost has the following state
- An Author
- A title
- A body
- A Category
- A creationDate

A BlogPost has the following behavior
- A method to get all the unique words from the body.
- A method to get all the unique urls from the body
    - Tip 1: urls always start with "http://"
    - Tip 2: you can use the unique words method

## Blog

A Blog has the following state
- BlogPosts

A Blog has the following behavior
- A method getting all the authors (of the BlogPosts written for the Blog)
    - Make sure that the Map / List / Set of Authors can be efficiently searched based on the Author's unique reference.
- A method returning the amount of BlogPosts per Category
- A method "suggestABlogPost" which returns the most recent BlogPost