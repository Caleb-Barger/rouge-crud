DELETE
FROM suppliers;

DELETE
FROM flowers;


INSERT INTO suppliers (supplierid, name, address, phonenumber)
    VALUES (1, 'Green Acres', '106 SE St.', '111-111-1111'),
           (2, 'Your Personal Zen', '10 W Ave.', '222-222-2222'),
           (3, 'Outlet Backyard', '50th N Blv.', '333-333-3333');

INSERT INTO flowers (flowerid, type, price, supplierid)
    VALUES (1, 'Lilies', 10.00, 1),
            (2, 'Roses', 7.00, 1),
            (3, 'Carnations', 7.00, 1),
            (4, 'Gardenias', 8.00, 2),
            (5, 'Orchids', 5.00, 2),
            (6, 'Sunflowers', 11.00, 2),
            (7, 'Tulips', 8.00, 3),
            (8, 'Peonies', 7.00, 3),
            (9, 'Dahlias', 9.00, 3),
            (10, 'marigold', 6.00, 3);

/*
Must tell hibernate of the id numbers already used.
The number after with must be greater that the highest number id assigned.
 */
alter sequence hibernate_sequence restart with 15;