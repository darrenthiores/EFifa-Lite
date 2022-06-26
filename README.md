# eFifa-Lite

eFifa Lite --
A football manager app, you can play as a manager and build your own team with players which you can aquire by draw.
This is not a real football game app thought, it is only a for fun app where you can choose players by position and
team's formation. You can aquire player by draw, you can choose which league to draw and it cost 100 in game coin.
You will get 1100 coin in the first login and 100 coin every 7am WIB from claiming login gift.

Technology:
- Kotlin
- Jetpack Compose
- Ktor Client
- Room Db
- Data Store
- Dependency Injection (Koin)
- Pager -> To make carousel
- Paging3 -> This app implement RemoteMediator to support offline-online
- MVVM Pattern
- Clean Architecture

Note:
- The Project use API-FOOTBALL api and you need api key to run this app, you can get the api key for free
in this link: https://dashboard.api-football.com/

Place the api key in the build.gradle (core)

<img width="652" alt="Screen Shot 2022-06-26 at 19 14 59" src="https://user-images.githubusercontent.com/69592810/175814397-7c7bfb95-e374-4227-a818-d245e0d4c1ab.png">

- This project may run into error when the request/minute is reached (it is 10r/m for free plan), i found out
the error will occure when you try to draw when the limit reached

App Screenshoots:

<img src="https://user-images.githubusercontent.com/69592810/175814339-d942f9cd-8771-40ce-8033-ed7caf415b81.png" width="35%" height="35%">
<img src="https://user-images.githubusercontent.com/69592810/175814362-a4f64364-4ea6-4065-8500-2403ae8409a4.png" width="35%" height="35%">
<img src="https://user-images.githubusercontent.com/69592810/175814383-daba704d-4dd3-4770-af0d-1fbae41cd5c0.png" width="35%" height="35%">
<img src="https://user-images.githubusercontent.com/69592810/175814422-6745d666-b79d-4c4c-81c2-cc940892e133.png" width="35%" height="35%">
<img src="https://user-images.githubusercontent.com/69592810/175814423-804ed733-7be6-427f-9959-2b9dba7e2de7.png" width="35%" height="35%">
<img src="https://user-images.githubusercontent.com/69592810/175814425-c891c7ff-7cd1-4d11-b3e6-a08029abc35f.png" width="35%" height="35%">
<img src="https://user-images.githubusercontent.com/69592810/175814427-3f35850a-0226-4aa3-875b-b3592805f60d.png" width="35%" height="35%">




