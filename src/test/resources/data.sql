INSERT INTO game(game_id, game_name) VALUES (5, 'Golf');
INSERT INTO game(game_id, game_name) VALUES (6, 'Rocket League');
INSERT INTO game(game_id, game_name) VALUES (7, 'Chess');

INSERT INTO team (team_id, team_name, team_member_01, team_member_02, team_member_03)
VALUES (5, 'Uh Oh Boyz', 'Alex', 'Drew', 'Jeff');

INSERT INTO team (team_id, team_name, team_member_01, team_member_02, team_member_03, team_member_04, team_member_05, team_member_06, team_member_07, team_member_08, team_member_09, team_member_10)
VALUES (6, 'Team Alpha', 'Alice', 'Bob', 'Charlie', 'Diana', 'Evan', 'Fiona', 'George', 'Hannah', 'Ian', 'Julia');

INSERT INTO game_record (game_record_id, game_id, team_id, win, lose, draw, game_date_time)
VALUES (5, 5, 5, TRUE, FALSE, FALSE, '2023-12-07T10:56:04');