CREATE TABLE Game (
    GameID SERIAL PRIMARY KEY,
    GameName VARCHAR(50) NOT NULL
);

CREATE TABLE Team (
    TeamID SERIAL PRIMARY KEY,
    TeamName VARCHAR(50),
    TeamMember01 VARCHAR(50),
    TeamMember02 VARCHAR(50),
    TeamMember03 VARCHAR(50),
    TeamMember04 VARCHAR(50),
    TeamMember05 VARCHAR(50),
    TeamMember06 VARCHAR(50),
    TeamMember07 VARCHAR(50),
    TeamMember08 VARCHAR(50),
    TeamMember09 VARCHAR(50),
    TeamMember10 VARCHAR(50)
);

CREATE TABLE GameRecord (
    GameRecordID SERIAL PRIMARY KEY,
    GameID INT NOT NULL, -- FK
    TeamID INT NOT NULL, -- FK
    Win BOOLEAN NOT NULL,
    Lose BOOLEAN NOT NULL,
    Draw BOOLEAN NOT NULL,
    GameDateTime TIMESTAMP NOT NULL, -- Add the DateTime column
    -- Define the first foreign key constraint
    CONSTRAINT FK_Game_Name
        FOREIGN KEY (GameID)
        REFERENCES Game(GameID),
    -- Define the second foreign key constraint
    CONSTRAINT FK_Team_Number
        FOREIGN KEY (TeamID)
        REFERENCES Team(TeamID)
);