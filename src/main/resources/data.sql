-- Inserting initial data into the addresses table
INSERT INTO addresses (street, postal_code, city) VALUES
                                                          ('Granvägen 1', '12345', 'Stockholm'),
                                                          ('Björkallén 2', '67890', 'Göteborg'),
                                                          ('Ekbacken 3', '10112', 'Malmö');

-- Inserting initial data into the members table

INSERT INTO members (first_name, last_name, address_id, email, phone, date_of_birth) VALUES
                                                                                             ( 'Erik', 'Svensson', 1, 'erik.svensson@example.com', '012-3456789', '1980-01-01'),
                                                                                             ( 'Anna', 'Johansson', 1, 'anna.johansson@example.com', '023-4567891', '1982-02-02'),
                                                                                             ( 'Lars', 'Larsson', 2, 'lars.larsson@example.com', '034-5678902', '1984-03-03'),
                                                                                             ('Sofia', 'Karlsson', 3, 'sofia.karlsson@example.com', '045-6789012', '1986-04-04'),
                                                                                             ('Karl', 'Andersson', 2, 'karl.andersson@example.com', '056-7890123', '1988-05-05');