-- Insert sample data into the GameName table
INSERT INTO game (GameName, GameID) VALUES
    ('game 1', 1),
    ('game 2', 2),
    ('game 3', 3);

-- Insert sample data into the TeamNumber table
INSERT INTO team (TeamName, TeamID, TeamMember01, TeamMember02, TeamMember03) VALUES
    ('team A', 1, 'Player 1', 'Player 2', 'Player 3'),
    ('team B', 2, 'Player 3', 'Player 4', 'Player 7'),
    ('team C', 3, 'Player 5', 'Player 6', 'Player 8');

-- Insert sample data into the game_record table
INSERT INTO game_record (GameRecordID, GameID, TeamID, Win, Lose, Draw, GameDateTime) VALUES
    (1, 1, 1, TRUE, FALSE, FALSE, '2023-11-06 10:00:00'),
    (2, 2, 2, FALSE, TRUE, FALSE, '2023-11-06 11:00:00'),
    (3, 3, 3, FALSE, FALSE, TRUE, '2023-11-06 12:00:00');
