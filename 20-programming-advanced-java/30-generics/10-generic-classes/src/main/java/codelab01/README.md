# Box

Seriously... What's in the box?

## Refactor the Box to a more generic variant

1. Run `BoxRunner`
    - Understand why it fails by inspecting the `BoxRunner` and `Box` class
2. Refactor `Box` so that it uses **generics**.
    - `Box` should declare one type parameter, which it uses for the type of its content (`boxContent`).
    - If you've refactored `Box` successfully:
        - You no longer need to cast the returned results (in `BoxRunner`)
        - The last line in `BoxRunner` (the one with variable `contentOfBox3`) will no longer compile!
            - This is a good thing, we want to fail fast (during compilation), not during run-time!
            - After validating that line no longer compiles, comment it out. 
