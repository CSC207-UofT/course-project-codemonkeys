# **Pooled Investment Portfolio Management Simulation**
[Design document for this project.](https://github.com/CSC207-UofT/course-project-codemonkeys/blob/93318c5e8154993b1de3ce2532a8cf7ee5f3fba8/Design%20Document%20Phase%202.pdf)

## Purpose
The purpose of the project is to develop a management tool for a simulated 
pooled investment portfolio, where multiple parties pool their funds together 
to form a single investment portfolio in the financial market. The program 
should enable all invested parties to democratically make investment decisions 
for the portfolio through calling and casting votes, given that the voting 
power of each party varies according to the profitability of their past votes.

## How to use it
The program is the backend of our simulation environment. To initate it, You 
first need a secret key. We cannot post this on github for security reasons, and therefore please ask us for the key. Alternatively, we can start up the application for you.
Once you have the secret key, paste it into this file:
```src/main/java/Interfaces/discord_secret_key.txt```

Then, go to the main method and start the program.

You should sees something like this in the terminal:
```bash
838 [main] INFO net.dv8tion.jda.api.JDA - Login Successful!
1015 [JDA MainWS-ReadThread] INFO net.dv8tion.jda.internal.requests.WebSocketClient - Connected to WebSocket
1197 [JDA MainWS-ReadThread] INFO net.dv8tion.jda.api.JDA - Finished Loading!
```
This means the bot has successfully loaded. You may join the Discord channel at the following link
```bash
https://discord.gg/Hc29FEMa
```
and test the commands we demonstrated in our presentation.

## Potential bug caused by token
After running the main.java, if you see error message like:
```bash
Exception in thread "main" javax.security.auth.login.LoginException: The provided token is invalid!
```
This means the token is expired. Just ask us for a new token.

## Design Document
It can be found in the project folder and the GitHub repository.

## Project Repository
[Click Here to see the code](https://github.com/CSC207-UofT/course-project-codemonkeys.git);
