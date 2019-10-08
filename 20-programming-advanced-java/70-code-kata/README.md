# Game of Life - Switchfully

Game of Life Code Kata!

Using Maven, Angular and Spring Boot (2.2.0 +).

- You have to further developer the backend application, not the frontend.

## Usage: Backend

- If it's your first time using this application, read the **First time usage** section first... :)
- Start the backend by running `GameOfLifeApplication.java`
- Start the frontend with command `npx lite-server --baseDir="dist"` from inside directory `gameoflife-gui`
    - Leave the CMD open, if you close it, you will shut down the HTTP server (lite-server) which is required.
    - Open your browser and surf to http://localhost:3000/gameoflife-gui, this is the front end. 

## First time usage

- Install NPM (a JavasScript / Node package manager)
    - It will also install NPX
- After installation
  - run `npm --version` `npm -v` from inside the terminal, if it's correctly installed it will return a version number
  - run `npx --version` `npx -v` from inside the terminal, if it's correctly installed it will return a version number
- You can now start your front-end using the command as described in section **Usage**.

## Alternatively: use Docker for running the front end
1. Run `docker build -t switchfully/gameoflife:latest .` from inside the `gameoflife-gui` folder.
    - This will create the `switchfully/gameoflife` image (tagged as `latest`).
2. Then, run `docker run -d --name gameoflife -p 3000:80 switchfully/gameoflife:latest`
    - This will create and run a container based on our image: it will launch a NGINX webserver
    - Open your browser and surf to http://localhost:3000/gameoflife-gui, this is the front end.
3. When you're done with the code kata, don't forget to stop the container.

 
## Setting the proxy behind a corporate firewall

NPM (similar to Maven) manages dependencies, and needs access to the internet.\
This usually works fine. However, additional proxy configuration is required behind a corporate firewall.

To configure the proxy, execute the following commands (with the correct proxy url):
- `npm config set proxy http://your-corporate-proxy-url:port`
- `npm config set https-proxy http://your-corporate-proxy-url:port`
- `npm config set strict-ssl false`

It can happen that you also need to give access to your own backend
- `set NO_PROXY=localhost,127.0.0.*` (configure it in your system variables)

⚠ When NPM encounters proxy (or network) issues, the feedback you receive in the commandline is not very helpful.\
If the commandline is stuck when starting the UI with NPX, something is wrong.
- `C:\devenv\track-java\20-programming-advanced-java\70-code-kata\gameoflife-gui>npx lite-server --baseDir="dist"`\
- `[..................] / rollbackFailedOptional: verb npm-session e8ef6a88aa7d6f97`

## Some tips

- Tip 1: Run your entire build and all (backend) tests with command `mvn clean install` from inside the root folder (switchfully-gameoflife)
    - Tests run on JUnit 5
- Tip 2: the UI won't work properly without a running backend.
- Tip 3: You don't have to make any changes to the UI
- Tip 4: You can access the frontend by surfing to http://localhost:3000/gameoflife-gui/index.html
