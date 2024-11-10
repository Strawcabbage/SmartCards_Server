DROP TABLE IF EXISTS FLASHCARD;
DROP TABLE IF EXISTS SETS;

-- Create Set table
CREATE TABLE SETS (
    ID int AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL
);

-- Create Flashcard table with a foreign key to Set
CREATE TABLE FLASHCARD (
    ID int AUTO_INCREMENT PRIMARY KEY,
    TERM VARCHAR(255) NOT NULL,
    DEFINITION VARCHAR(255) NOT NULL,
    SET_ID int,
    CONSTRAINT fk_set
        FOREIGN KEY (SET_ID)
        REFERENCES sets(ID)
        ON DELETE CASCADE
);

INSERT INTO sets (name) VALUES
    ('Economics'),
    ('Music'),
    ('Food'),
    ('Energy Drinks');

-- Insert sample data into flashcard table
INSERT INTO flashcard (term, definition, set_id) VALUES
    ('Living Wage', 'A wage that is good enough to live on', 1),
    ('Poverty Line', 'The amount of money required to barely survive', 1),
    ('Institutional Discrimination', 'Policies or practices that systematically discriminate against people', 1),
    ('The Box', 'His best song', 2),
    ('High Fashion', 'His chillest song', 2),
    ('Perfect Time', 'Most motivational', 2),
    ('Aston Martin Truck', 'Just hype', 2),
    ('Parmesan', 'parm', 3),
    ('Original', 'OG', 3),
    ('Celsius', 'Heart attack in a can', 4),
    ('Red Bull', 'The OG energy drink', 4);