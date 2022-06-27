# CS-320 Software Test Automation &amp; QA

How can I ensure that my code, program, or software is functional and secure?  
To ensure that my code, program, or software is functional and secure, I take a layered approach. First, the code must be covered by unit tests. Ideally, the code would be written using test-driven development so that the author knows when to stop writing code (once the tests pass). The next layer of testing should be integration tests. In complex systems there could be changes in one area of the system that adversely effect another part of the system that was not anticipated. As a result, the integration test must span those boundaries. In addition to unit and integration testing, there is another class of testing that is relevant in development of software for rockets and other flight hardware, and that is hardware-in-the-loop (HITL) testing. I first found out about HITL testing from the [SpaceX Software Engineer's ask me anything (AMA)](https://www.reddit.com/r/spacex/comments/ncj4vz/we_are_the_spacex_software_team_ask_us_anything/) from a few years ago. This amazing repository of knowledge not only includes an overview of HITL testing, but it also has many other points of encouragement for me to believe that I will be able to join their team.

How do I interpret user needs and incorporate them into a program?  
Interpreting user needs can be as easy as writing user stories based on a conversation with stakeholders, but it is not always so. More than likely, the stakeholders don't actually know what they want, or they are thinking in incremental improvements from what they already have. If you want to develop something truly revolutionary that will help your stakeholders out in a profound way, it would be best to take the inputs and outputs that the stakeholders are requesting, and think about them from a first principles standpoint. Not only that, but before you get to work on fulfilling the requirements just remember according to Elon Musk, "Your requirements are definitely dumb". It should be our goal to iterate on the requirements as well making them less dumb with each iteration.

How do I approach designing software?  
The design of a software system should be domain driven. By it's very nature domain driven design indicates in an obvious manner why it was written, not just the frameworks that were used to develop it. Frameworks can all be replaced, but the core of the application is the business logic that is developed from stakeholder requirements.  
<br />
<br />
__References__

Dodd, T., &amp; Musk, E. (2021, August 3). _Starbase tour with Elon Musk [part 1]_. YouTube. https://www.youtube.com/watch?v=t705r8ICkRw&amp;t=813s 