# Box

1. Run `BoxRunner`
    - Understand why it fails by inspecting the `BoxRunner` and `Box` class
2. Refactor `Box` so that it uses **generics** (see the slides).
    - If you've refactored `Box` successfully:
        - You no longer need to cast in `BoxRunner`
        - The last line in `BoxRunner` (the one with variable `contentOfBox3`) will no longer compile! 