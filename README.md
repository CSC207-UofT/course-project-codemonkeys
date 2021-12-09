# **Pooled Investment Portfolio Management Simulation**

## Purpose
The purpose of the project is to develop a management tool for a simulated 
pooled investment portfolio, where multiple parties pool their funds together 
to form a single investment portfolio in the financial market. The program 
should enable all invested parties to democratically make investment decisions 
for the portfolio through calling and casting votes, given that the voting 
power of each party varies according to the profitability of their past votes.

## How to use it
The program is the backend of our simulation environment. To initate it, You 
first need to copy the secret key below,
```bash
OTEyMTQ0NTE2NTc0NzQ4Njcy?YZrqxw?lUVHOm1BqrTCkXBXWFUoJUYZV1Q
```
substitute the two questions marks in the middle with period (.) since Discord
does not allow use to post this key to the Internet, and paste it in the 
src/main/java/Interfaces/discord_secret_key.txt file.

Then, go to the main function and start the program.

You should see message in the terminal like:
```bash
118 [main] INFO org.reflections.Reflections - Reflections took 82 ms to scan 1 urls, producing 2 keys and 15 values
838 [main] INFO net.dv8tion.jda.api.JDA - Login Successful!
1015 [JDA MainWS-ReadThread] INFO net.dv8tion.jda.internal.requests.WebSocketClient - Connected to WebSocket
1197 [JDA MainWS-ReadThread] INFO net.dv8tion.jda.api.JDA - Finished Loading!
```
This means the bot is successfully loaded.

If you want, you can join the discord channel by
```bash
https://discord.gg/Hc29FEMa
```
and test the commands we used in our demo:)

## Potential bug caused by token
After running the main.java, if you see error message like:
```bash
Exception in thread "main" javax.security.auth.login.LoginException: The provided token is invalid!
```
This means the token is expired.
Just ask us for a new token.

## Design Document
It's in the project folder.

## Project Repository
[Click Here to see the code](https://github.com/CSC207-UofT/course-project-codemonkeys.git);
