# DevMo-Corentin-L-o

A student project to learn mobile development.
This is an application supposed to help with organising evenments. It is not done, as the goal is to focus on some functionalities.

Here is a short description of the screens of the application :

## Login screen 
It displays two text inputs, and a button "login", under the title of the application (Crewmate)
  When the user clicks on the button, two things can happen :
  <ol>
  <li>The password input is "admin", the application then goes to the next screen</li>
  <li>The password isn't "admin". Both text fields are reset.</li>
</ol> 

## List of events
The Event List Screen is composed of a List of Event, with a picture for each event, a title, the event's organizer name and the date of the event. Each event have their own informations. There is also two button, to edit and delete the events, but currently, theses buttons have no functionnality implemented.

At the bottom of the screen, three toggle buttons allow to navigate between the list of events, the chat and the user's profile.

## Event

When the user click on an event, it open a specific page with the informations of the event, with the title, the picture, the date, the name of the organizer, and the description of the event.

## Chat
It's an empty screen.

## User 
A screen displaying the user name used when login. Of course, if developpment were to continue, it would also have a profile picture, a description, statistics...



# Known issues :

## Crash with the 3 navigation butttons :
  Pressing the different buttons too quickly, or pressing one of them while or just after scrolling the view might cause crashes.
  
## The gradle.xml version

We were two working on this project. Since we forgot to add the graddle xml files (and in fact some other xml files), some issues might arise if you try to build the application after cloning it. Consider manually changing the file, or changing your gradle if necessary.
