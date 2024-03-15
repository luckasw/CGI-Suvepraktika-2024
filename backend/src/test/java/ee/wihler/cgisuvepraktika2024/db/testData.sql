INSERT INTO Users (UserID, UserName, Email) VALUES
(1, 'john_doe', 'john.doe@example.com');
INSERT INTO Genres (GenreID, GenreName) VALUES
(1, 'Action'),
(2, 'Drama'),
(3, 'Comedy'),
(4, 'Horror'),
(5, 'Sci-Fi'),
(6, 'Documentary'),
(7, 'Romance'),
(8, 'Thriller'),
(9, 'Fantasy'),
(10, 'Animation');

INSERT INTO Directors (DirectorID, DirectorName) VALUES
(1, 'Steven Spielberg'),
(2, 'Martin Scorsese'),
(3, 'Christopher Nolan'),
(4, 'Quentin Tarantino'),
(5, 'James Cameron'),
(6, 'Tim Burton'),
(7, 'Ridley Scott'),
(8, 'Peter Jackson'),
(9, 'Clint Eastwood'),
(10, 'David Fincher');
INSERT INTO Movies (MovieID, Title, ReleaseDate, GenreID, DirectorID, AgeRestriction, Language, Runtime) VALUES
(1, 'Epic Adventure', '2023-01-01', 1, 1, 13, 'English', '02:30:00'),
(2, 'Dramatic Times', '2023-02-02', 2, 2, 16, 'English', '01:45:00'),
(3, 'Laugh Out Loud', '2023-03-03', 3, 3, 0, 'English', '01:30:00'),
(4, 'Scary Night', '2023-04-04', 4, 4, 18, 'English', '01:50:00'),
(5, 'Space Odyssey', '2023-05-05', 5, 5, 12, 'English', '02:20:00'),
(6, 'Real Stories', '2023-06-06', 6, 6, 0, 'English', '01:40:00'),
(7, 'Love Always', '2023-07-07', 7, 7, 13, 'English', '01:55:00'),
(8, 'Edge of the Seat', '2023-08-08', 8, 8, 15, 'English', '02:05:00'),
(9, 'Fantasy Land', '2023-09-09', 9, 9, 0, 'English', '02:00:00'),
(10, 'Animated Joy', '2023-10-10', 10, 10, 0, 'English', '01:35:00');
INSERT INTO SeatingPlan (SeatingPlanId) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10);
INSERT INTO Screenings (ScreeningId, MovieID, ScreeningTime, SeatingPlanId) VALUES
(1, 1, '2024-03-15 13:00:00', 1),
(2, 2, '2024-03-15 15:30:00', 2),
(3, 3, '2024-03-16 10:00:00', 3),
(4, 4, '2024-03-16 12:30:00', 4),
(5, 5, '2024-03-17 14:00:00', 5),
(6, 6, '2024-03-17 16:30:00', 6),
(7, 7, '2024-03-18 19:00:00', 7),
(8, 8, '2024-03-18 21:30:00', 8),
(9, 9, '2024-03-19 18:00:00', 9),
(10, 10, '2024-03-19 20:30:00', 10);
INSERT INTO UserMovies (UserMovieID, UserID, MovieID, Rating, VisitDate) VALUES
(1, 1, 1, 5, '2024-03-15 13:00:00'),
(2, 1, 2, 4, '2024-03-15 15:30:00'),
(3, 1, 3, NULL, '2024-03-16 10:00:00'),
(4, 1, 4, NULL, '2024-03-16 12:30:00'),
(5, 1, 5, 3, '2024-03-17 14:00:00'),
(6, 1, 6, 2, '2024-03-17 16:30:00'),
(7, 1, 7, 4, '2024-03-18 19:00:00'),
(8, 1, 8, NULL, '2024-03-18 21:30:00'),
(9, 1, 9, 5, '2024-03-19 18:00:00'),
(10, 1, 10, NULL, '2024-03-19 20:30:00');
