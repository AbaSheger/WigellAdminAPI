-- Inserting initial data into the addresses table
INSERT INTO addresses (street, postal_code, city)
VALUES
    ('Storgatan 1', '12345', 'Stockholm'),
    ('Lillgatan 2', '23456', 'Göteborg'),
    ('Kungsgatan 3', '34567', 'Malmö'),
    ('Storgatan 4', '45678', 'Uppsala'),
    ('Lillgatan 5', '56789', 'Västerås');


-- Inserting initial data into the members table

INSERT INTO members (first_name, last_name, address_id, email, phone, date_of_birth)
VALUES
    ( 'Erik', 'Svensson', 1, 'erik.svensson@example.com', '012-3456789', '1980-01-01'),
    ( 'Anna', 'Johansson', 2, 'anna.johansson@example.com', '023-4567891', '1982-02-02'),
    ( 'Lars', 'Larsson', 3, 'lars.larsson@example.com', '034-5678902', '1984-03-03'),
    ('Sofia', 'Karlsson', 4, 'sofia.karlsson@example.com', '045-6789012', '1986-04-04'),
    ('Karl', 'Andersson', 5, 'karl.andersson@example.com', '056-7890123', '1988-05-05');