# **Pooled Investment Portfolio Management Simulation Project Specification**

**Project Repository**

\&lt;[https://github.com/CSC207-UofT/course-project-codemonkeys](https://github.com/CSC207-UofT/course-project-codemonkeys)\&gt;

**CRC Representation**

[CRC Cards.pptx](https://docs.google.com/presentation/d/1qOXHUqKnqGVJKN6A0Vr4zOjAfkeX9VIW/edit?usp=sharing&amp;ouid=111568394588550955582&amp;rtpof=true&amp;sd=true)

**Contributors**

\&lt;Contributor name\&gt; \&lt;Contributor GitHub link\&gt;

...

\&lt;Tammy Yujin Liu\&gt; \&lt;[https://github.com/tammyliuu](https://github.com/tammyliuu)\&gt;

\&lt;Jiamu Sun\&gt; \&lt;[https://github.com/JackSunjm](https://github.com/JackSunjm)\&gt;

\&lt;Andrew Hanzhuo Zhang\&gt; \&lt;[https://github.com/a663E-36z1120](https://github.com/a663E-36z1120)\&gt;

\&lt;Peng Du\&gt; \&lt;[https://github.com/Vim0315](https://github.com/Vim0315)\&gt;

**1. Domain**

This project is a management tool for a simulated pooled investment portfolio, where multiple parties pool their funds together to form a single investment portfolio in the financial market. The project enables all invested parties to democratically make investment decisions for the portfolio through calling and casting votes. The voting power of each party varies according to the profitability of their past votes.

**2. Entity Classes**

**2.1. Assets and Portfolio**

Assets are either liquid or non-liquid. The only liquid asset in this simulation is USD, while non liquid assets include stocks, cryptocurrencies, precious metals, etc. All liquid assets form the liquidity pool and non-liquid assets the investment pool. Non-liquid assets will record when it was bought and at what price it was bought.

The portfolio is a collection of assets. There is a global portfolio representing the pooled investments. Every user also has a shadow portfolio to keep track of their past investment performances.

**2.2. Votes**

Each vote consists of 4 main pieces of information: what asset to buy/sell, volume to be bought/sold, when it was casted, and for or against.

**2.3. Users**

There are 3 classes of users: Regulars, Administrators, and Bots.

Investors are the most rudimentary class of users. The voting power of a regular investor is measured in USD, indicating how much liquidity/asset they have the power to make investment decisions for. If a regular investor wishes to make a transaction with a volume smaller than or equal to their voting power, they may do so without calling a vote. After successful registration, the regular investor brings in a variable amount of liquidity (USD) to the liquidity pool. The amount of liquidity brought in will be their initial voting power. The regular investor&#39;s voting power will be adjusted based on the profitability of their 10 most recent votes/transactions.

Administrators are regular investors with additional privileges. Administrators can directly veto or pass a vote, or ban other non-administrator users from the simulation.

Bots are investors that do not have voting power. A bot can also be owned by a regular investor, which means that the user will automatically cast a vote for every investment decision made by the bot.

**3. Use Case Classes**

**3.1. fetchAssetPrice**

Fetches and updates the price of an asset. All asset prices are obtained in real-time from Yahoo finance Java API, from which the profitability of the investment portfolio is calculated.

**3.2. decideVoteResult**

Decides the result of votes. A successful vote will be turned into a transaction, which the portfolio will be updated accordingly. A vote is considered successful if either of the following requirements are met:

1. The total weighted voting power for a transaction subtracting the total weighted voting power against a transaction exceeds the volume of the transaction.
2. 24 hours after the vote is cast, the total weighted votes for a transaction subtracting is greater than the total weighted votes against a transaction.

Otherwise the vote is considered a failure and the transaction will not proceed.

**3.3. calculateVotingPower**

Calculates and updates the voting power of a user. Voting power is calculated based on the profitability of their 10 most recent votes/transactions. For each vote/transaction that is profitable, the user&#39;s voting power increases by 10%, and for each vote/transaction that is not, the user&#39;s voting power decreases by 10%.

**3.4 updatePortfolio**

Updates a portfolio if a vote is successful by carrying out the transaction in simulation.

**3.5 determineProfitability**

Determines the profitability of a portfolio based on real-time prices.

**3.6 getStatus**

Provide a summary of the status of the pooled portfolio including current levels of profit and growth and how much of what assets are held each in the liquidity and investment pool.

**3.7 manageUser**

Ban an existing non-administrator user or register new users.

**4. Controllers**

**4.1. commandParser**

Parses the input command from the CLI and orchestrates actions accordingly.

**4.2. votingManager**

Manages ongoing votes and turns successful votes into transactions accordingly.

**4.3. portfolioManager**

Manages and records transactions and updates the portfolio accordingly.

**4.4. userManager**

Manages users.

**4.5 assetManager**

Manages assets.

**4.6 transactionManager**

Manages transactions.

**5. Interfaces**

**5.1 CLI**

buy \&lt;asset symbol\&gt; \&lt;volume in USD\&gt;

sell \&lt;asset symbol\&gt; \&lt;volume in USD\&gt;

for \&lt;vote ID\&gt; \&lt;optional admin flag &#39;-admin&#39;\&gt;

against \&lt;vote ID\&gt; \&lt;optional admin flag &#39;-admin&#39;\&gt;

getStatus \&lt;global portfolio &#39;global&#39; or user&#39;s shadow portfolio &#39;user&#39;\&gt; \&lt;optional user ID\&gt;

register \&lt;user ID\&gt; \&lt;user class &#39;admin&#39;, &#39;regular&#39;, or &#39;bot&#39;\&gt;

ban \&lt;user ID\&gt;

**5.2 GUI**

GUI includes a suite of graphs and charts to indicate how the pooled portfolio is performing.