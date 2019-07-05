# Game of Life - Switchfully

Game of Life Code Kata!

Using Maven, Angular and Spring Boot (2.1.0.RELEASE).

- You have to further developer the backend application, not the frontend.

## Usage

- If it's your first time using this application, read the **First time usage** section first... :)
- Start the backend by running `GameOfLifeApplication.java`
- Start the frontend with command `npx lite-server --baseDir="dist"` from inside directory `gameoflife-gui`
    - Leave the CMD open, if you close it, you will shut down the HTTP server (lite-server) which is required.
    - Open your browser and surf to http://localhost:3000/gameoflife-gui/index.html, this is the front end. 

## First time usage

- Install NPM (a JavasSript / Node package manager)
    - It will also install NPX
- After installation
  - run `npm --version` `npm -v` from inside the terminal, if it's correctly installed it will return a version number
  - run `npx --version` `npx -v` from inside the terminal, if it's correctly installed it will return a version number
- You can now start your front-end using the command as described in section **Usage**.

## Some tips

- Tip 1: Run your entire build and all (backend) tests with command `mvn clean install` from inside the root folder (switchfully-gameoflife)
    - Tests run on JUnit 4, not 5!
- Tip 2: the UI won't work properly without a running backend.
- Tip 3: You don't have to make any changes to the UI
- Tip 4: You can access the frontend by surfing to http://localhost:3000/gameoflife-gui/index.html
