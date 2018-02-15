# Android Final Project: Footy App!

**Developed by James McCarthy**

The Footy Application provides end-users a flexible interface to query the most up-to-date Football data.( soccer for the Americans). The leagues to choose from include : 

* **Barclays Premier League 2017/2018**
* **Italian Serie A 2017/2018**
* **Primera Division/La Liga 2017/2018**
* **Bundesliga 2017/2018**

In each league end-users are able to view the current league table including the common Football club statistics including: GD (Goal Difference), GF (Goals For), GA (Goals Against), Wins, Draws, and Losses. 

End-users are provided the ability to press the team row to display more information. The application displays a descriptive display of Football Club information such as home-goals, away-goals, etc.

Future plan is to add displays for fixtures and players, however due to time contraints will implement after the semester.

##minSDK-Version

**Version 15**

## Getting Started

To get start please make sure Wi-Fi is on and you are connected to the internet. Once the application is launched. The End-User may pick which league they would like to view. When user clicks the League's row (e.g. Premier League) , the current league table and team statistics are displayed, sorted in the club's position in the league. End-User may then choose which Team they'd like find information about. Upon entering the team screen the team's latest stats are displayed. A button is including in this window to allow the user to favorite the teams. When the button is clicked the teams API url code is saved into a SQLite database using the Room Persistence library provided in Android. When the user re-enters the screen containing rows for each league. The user will be able to see their favorite team displayed above the list of Football leagues. The fragment for containing their favorite team also contains a shortened description than the one provided in the Team window. End-User may also click on this fragment to take shortcut right to their favorite Team's window display.

## Screencaps

![Competition Capture](https://i.imgur.com/EOYvKst.png "Compeition Capture")
![League Capture](https://i.imgur.com/8OBH6b4.png "League Capture")
![Team Capture](https://i.imgur.com/B4ge53q.png "Team Capture")

### Prerequisites & Installing

Android Project was built at a Min-API level of 15 so any prior API versions may run into issues with this application. Wi-Fi or some type of internet connection is required in order for the API request to be sent and the data payloads be received. 


## Built With

* [Room Persistence Library](https://developer.android.com/topic/libraries/architecture/room.html) - SQLite ORM used for Database Manipulation.
* [FootBall-Data.org API](http://football-data.org/index) - API Used to query most up-to-date football data.
* [Recycler View](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html) - Used to load ListView more efficiently.
* [SVG-Android](https://github.com/japgolly/svg-android) - Library to load SVG's from URL's.



## Authors

* **James McCarthy** - *Initial work* - [jmccarthy92](https://github.com/jmccarthy92)


## Acknowledgments

* **Ashok Basawapatna** - For putting up with me the last 3 semesters!
