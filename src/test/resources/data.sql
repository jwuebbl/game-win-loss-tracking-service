INSERT INTO game(game_id, game_name) VALUES (1, 'Golf');
INSERT INTO game(game_id, game_name) VALUES (2, 'Rocket League');
INSERT INTO game(game_id, game_name) VALUES (3, 'Chess');

INSERT INTO team (team_id, team_name, team_member_01, team_member_02, team_member_03)
VALUES (1, 'Uh Oh Boyz', 'Alex', 'Drew', 'Jeff');

INSERT INTO team (team_id, team_name, team_member_01, team_member_02, team_member_03, team_member_04, team_member_05, team_member_06, team_member_07, team_member_08, team_member_09, team_member_10)
VALUES (2, 'Team Alpha', 'Alice', 'Bob', 'Charlie', 'Diana', 'Evan', 'Fiona', 'George', 'Hannah', 'Ian', 'Julia');

INSERT INTO game_record (game_record_id, game_id, team_id, win, lose, draw, game_date_time)
VALUES (1, 1, 1, TRUE, FALSE, FALSE, '2023-12-07T10:56:04');