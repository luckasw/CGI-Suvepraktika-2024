CREATE TABLE Genres (
                        GenreID INT PRIMARY KEY,
                        GenreName VARCHAR(255) NOT NULL
);

CREATE TABLE Directors (
                           DirectorID INT PRIMARY KEY,
                           DirectorName VARCHAR(255) NOT NULL
);

CREATE TABLE Movies (
                        MovieID INT PRIMARY KEY,
                        Title VARCHAR(255) NOT NULL,
                        ReleaseDate DATE NOT NULL,
                        GenreID INT NOT NULL,
                        DirectorID INT NOT NULL,
                        AgeRestriction INT NOT NULL,
                        Language VARCHAR(255) NOT NULL,
                        Runtime TIME NOT NULL,
                        FOREIGN KEY (GenreID) REFERENCES Genres(GenreID),
                        FOREIGN KEY (DirectorID) REFERENCES Directors(DirectorID)
);

CREATE TABLE Users (
                       UserID INT PRIMARY KEY,
                       UserName VARCHAR(255) UNIQUE NOT NULL,
                       Email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE UserMovies (
                            UserMovieID INT PRIMARY KEY,
                            UserID INT,
                            MovieID INT,
                            Rating INT,
                            FOREIGN KEY (UserID) REFERENCES Users(UserID),
                            FOREIGN KEY (MovieID) REFERENCES Movies(MovieID),
                            CONSTRAINT ratingRangeCheck CHECK (Rating >= 1 and Rating <= 5)
);

CREATE TABLE Screenings (
                            screening_id INT PRIMARY KEY,
                            MovieID INT NOT NULL,
                            screening_time TIMESTAMP NOT NULL,
                            FOREIGN KEY (MovieID) REFERENCES Movies(MovieID)
);

