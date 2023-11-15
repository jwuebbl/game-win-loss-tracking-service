CREATE TABLE game (
    game_id     BIGINT PRIMARY KEY AUTO_INCREMENT,
    game_name   VARCHAR(256) NOT NULL
);

CREATE TABLE team (
    team_id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    team_name       VARCHAR(50),
    team_member_01  VARCHAR(50),
    team_member_02  VARCHAR(50),
    team_member_03  VARCHAR(50),
    team_member_04  VARCHAR(50),
    team_member_05  VARCHAR(50),
    team_member_06  VARCHAR(50),
    team_member_07  VARCHAR(50),
    team_member_08  VARCHAR(50),
    team_member_09  VARCHAR(50),
    team_member_10  VARCHAR(50)
);

CREATE TABLE game_record (
    game_record_id    BIGINT PRIMARY KEY AUTO_INCREMENT,
    game_id           BIGINT,
    team_id           BIGINT,
    win               BOOLEAN,
    lose              BOOLEAN,
    draw              BOOLEAN,
    game_date_time    DATETIME,
    FOREIGN KEY (game_id) REFERENCES game(game_id),
    FOREIGN KEY (team_id) REFERENCES team(team_id)
);
