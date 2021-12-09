# Project Accessibility Report

 CSC207 CodeMonkeys <br/><br/>
 

 ## Universal Design Principles

-   Principle of Equitable Use

For graphs in the data visualization suite of our GUI, where distinguishing the colors of different components are important, such as the pie chart of portfolio composition, we employed a gray-scale color scheme to accommodate for users with all types of colorblindness. Although we did not directly implement any other part of our system to adhere to this principle, our design decision to use Discord as our input interface comes with the advantage of granting our system access to the wide variety of accessibility features of Discord, such as text to speech/speech to text, high contrast, and enlarged fonts that provides equitable usage of our system to users with potential visual and motor impairments.

-   Principle of Flexibility in Use

Our program features a voting power system, and each user has their own voting power based on the profitability of their historical decisions; users with higher voting power control a larger part of the capital and their decisions are more critical and effective. This follows the principle of flexibility in use, because good investors would have more capital to manage, while novices can make money even if they do not make any decisions. Furthermore, users may decide to create their own channel for private use if they feel that the general channel is too cluttered. This offers the flexibility for individuals or smaller groups to interact with the application with their own personal "terminal", while still being able to see the activities of other users in the system.

-   Principle of Simple and Intuitive Use

Unlike other portfolio managers, our application does not constantly overload the user with unnecessary information and bloat. This creates a clean and functional aesthetic that does not sacrifice functionality. All the information the user will need can be accessed through performant and responsive commands. Upon execution, a command will promptly return meaningful feedback on the progress of your action. Furthermore, we believe that pictures are worth more than a thousand words, and that is why we designed a sleek and compact Jframe-GUI to display important information in an easily digestible format. We also accommodate for users of all skill and literacy levels with our easy to understand and interactive user interface. Since we are using discord as our client platform, it serves as both the interface for our client as well as a place for social activities. This builds a community where everyone can help each other out and contribute.

-   Principle of Perceptible Information

To ensure that the design of our application communicates necessary information effectively to all users regardless of their conditions or abilities, we made sure that the user interface is highly customizable and that the relayed information is independent of any personal factors. For example, our application has the option to display the current state of the system via a GUI that has many graphs and charts. We specifically made sure to design the GUI so that information can be presented without reliance on colours. This way, users with colour blindness may use our program without any trouble. Furthermore, the display text can be optionally bolded or have its size increased, which accommodates users that have poor vision. Lastly, there is also an option for all outputs to be read out loud via the text-to-speech feature. Overall, we designed our program to be suitable for any kind of user interface, and if the user wishes, they may even develop their own client suitable to their needs.

-   Principle of Tolerance for Error

Our program does not follow the principle of tolerance for error, but we can add features to tolerate errors. Firstly, we can add some flexibility to the inputted command, so that the system can handle commands that are slightly different but mean the same thing. In addition, we can add detailed failure messages when the system cannot handle the given commands,and we can also add a confirmation step to avoid unintended mistakes.

-   Principle of Low Physical Effort

Using our program is almost physically effortless since the users only need to type in the commands to perform actions. Also, we have individual commands for almost all possible actions, so that users can do whatever they want in one line without having to go through different layers. Thus, our program follows the principle of low physical effort.

-   Principle of Size and Space for Approach and Use

Because our application is accessed via a computer, physical size and space considerations depend highly on the equipment and setup that the user is using. Nonetheless, we still ensured that visual aspects displayed to the user are as generous in sizing as possible. This includes the formatting of the information displayed as well as what information is displayed, which is designed to encapsulate as much functionality as possible into as little information as possible. For example, to upvote a transaction, one can simply go through a list of all pending transactions, copy the UUID string, and paste into the upvote command. The application will automatically know which user initiated the upvote and exactly which transaction it was for. In essence, all of the information of upvote, transaction, and the user are encapsulated into a single string.

## Target Audience

Our main target audience are post-secondary students who have a background related to financial markets, such as Business or Economics, but lack real-life experience. We designed our program with two kinds of people in mind: good investors but short of money, and bad investors who still want to make money through investments. The first kind of people can operate with more capital and get a bigger share of profit, while the second kind of people can make use of good investors' decisions and make profit with their money. Eventually, the program takes the advantages of both of them while both of their interests are complied.

## Demographics

We predict that the majority of our users will have some kind of background or interest in financial markets. But in general, our program is less likely to attract people who dislike taking risks or trading. Because investments are not guaranteed to be profitable, users are taking the risk of losing their money while using the program; if someone is not willing to take the risk, then our program is certainly not for them. In addition, some people suppose that the stock market is too bubbled and they prefer to invest in other ways (e.g. real estate). Since our program mainly focuses on stock investments, this group of people would also reject our program. We also feel that our application is sufficiently prepared to provide ease of use for any kind of user, regardless of their impairments or other special conditions. Our program focuses much more on the community rather than the individual, and so while some individuals may not find any success in the financial markets on their own, we believe that they will be able to find something meaningful here as a member of the community.
