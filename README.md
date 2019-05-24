# Cinema-Project
## Overview
Application helps users to view the information about the movie are theatrical release, the film has a high rating, see trailer of the movie.
Requirements of the project is Build a read-only movie listing app using the Movie Database API.

## Design Pattern
- The design of the MVP pattern.

## User Stories 
- User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.
- Lists should be fully optimized for performance with Recyclerview.
- Views should be responsive for both landscape/portrait mode : In portrait mode, the poster image, title, and movie overview is shown. In landscape mode, the rotated layout should use the backdrop image instead and show the title and movie overview to the right of it.
- Have pull-to-refresh for popular stream with SwipeRefreshLayout.
- Display a nice default placeholder graphic for each image during loading (Using Glide).
- Expose details of movie (ratings using RatingBar, popularity, and synopsis) in a separate activity.
- Allow video posts to be played in full-screen using the YouTubePlayerView.

## Capture
![Home Screen](https://user-images.githubusercontent.com/38346869/58333636-0cebf680-7e68-11e9-9b51-2079feac85b1.PNG)
![Detail_Screen](https://user-images.githubusercontent.com/38346869/58333638-0cebf680-7e68-11e9-8201-5727a4f33c61.PNG)
![Full Screen Youtube Play](https://user-images.githubusercontent.com/38346869/58333634-0cebf680-7e68-11e9-873d-22c681170e71.PNG)

## Technology
- Language: Kotlin
- Libraries: Glide libraries. Retrofit2

Copyright [2019] [Tran Quang Nhat]
