-- Insert sample data into the GameName table
INSERT INTO GameName (GameName, GameNameID) VALUES
    ('Game 1', 1),
    ('Game 2', 2),
    ('Game 3', 3);

-- Insert sample data into the TeamNumber table
INSERT INTO TeamNumber (TeamName, TeamNumberID, TeamMember01, TeamMember02, TeamMember03) VALUES
    ('Team A', 1, 'Player 1', 'Player 2', 'Player 3'),
    ('Team B', 2, 'Player 3', 'Player 4', 'Player 7'),
    ('Team C', 3, 'Player 5', 'Player 6', 'Player 8');

-- Insert sample data into the GameRecord table
INSERT INTO GameRecord (GameNameID, TeamNumberID, Win, Lose, Draw, GameDateTime) VALUES
    (1, 1, TRUE, FALSE, FALSE, '2023-11-06 10:00:00'),
    (2, 2, FALSE, TRUE, FALSE, '2023-11-06 11:00:00'),
    (3, 3, FALSE, FALSE, TRUE, '2023-11-06 12:00:00');
