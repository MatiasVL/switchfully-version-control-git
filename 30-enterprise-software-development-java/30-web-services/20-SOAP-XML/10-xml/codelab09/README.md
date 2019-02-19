# Codelab 09

1. Start by creating an XML Schema that defines a `person` element the following way:
    - A `person` has a `firstname`, `lastname` and `birthDate`.
    - Use sensible types for all the elements.
        - For `birthDate` the format should be **YYYY-MM-DD** (e.g. 1980-12-25)
    - The order in which a valid XML document (instance) provides the child elements doesn't matter and should thus be allowed to be random.
    - Child element `firstname` is optional and we should thus be able to leave it completely out of an instance. **However**, if it is provided, its value should at least have **length 2**.
        - Allowed: no `firstname` element
        - Allowed: `<firstname>An</firstname>`
        - Not Allowed: `<firstname>A</firstname>`
        - Not Allowed: `<firstname></firstname>`
        - Not Allowed: `<firstname/>`
2. Create one or more valid (person) instances (XML documents) for this XML Schema.
    