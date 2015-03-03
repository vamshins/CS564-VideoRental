Insert into CUSTOMER values(1001, 'Keitha', 'Harrold', 'Active', 'F', '1990-03-02', 'kharrold@test.com', 'Add1', 8999703390, MD5('pass1'));
Insert into CUSTOMER values(1002, 'Kera', 'Mangels', 'Active', 'F', '1962-04-30', 'kmangels@test.com', 'Add1', 8447036076, MD5('pass2'));
Insert into CUSTOMER values(1003, 'Daine', 'Comacho', 'Active', 'F', '1989-05-13', 'kharrold@test.com', 'Add1', 8226102953, MD5('pass3'));
Insert into CUSTOMER values(1004, 'Daniel', 'Malan', 'Active', 'M', '1973-12-22', 'kharrold@test.com', 'Add1', 8558398089, MD5('pass4'));
Insert into CUSTOMER values(1005, 'Kazuko', 'Boulden', 'Active', 'F', '1987-09-21', 'kharrold@test.com', 'Add1', 8995938833, MD5('pass5'));

Insert into GENRE values (2001, 'Action');
Insert into GENRE values (2002, 'Adventure');
Insert into GENRE values (2003, 'Animation');
Insert into GENRE values (2004, 'Biography');
Insert into GENRE values (2005, 'Comedy');

Insert into FILM values(3001, 'American Sniper', 'Clint Eastwood', 'Village Roadshow Pictures', 2001, 18, 1);
Insert into FILM values(3002, 'Kingsman: The Secret Service', 'Matthew Vaughn', 'Marv Films', 2002, 21, 1);
Insert into FILM values(3003, 'How to Train Your Dragon 2', 'Dean DeBlois', 'DreamWorks Animation', 2003, 12, 2);
Insert into FILM values(3004, 'Schindler\'s List', 'Steven Spielberg', 'Amblin Entertainment', 2004, 18, 1);
Insert into FILM values(3005, 'The Artist', 'Michel Hazanavicius', 'La Petite Reine', 2005, 18, 1);

Insert into CUSTOMER_RATING values(1001, 3001, 4);
Insert into CUSTOMER_RATING values(1002, 3003, 3);
Insert into CUSTOMER_RATING values(1004, 3004, 2);
Insert into CUSTOMER_RATING values(1003, 3002, 4);
Insert into CUSTOMER_RATING values(1005, 3005, 5);

Insert into MEDIUM values(4001, 'DVD');
Insert into MEDIUM values(4002, 'ONLINE');

Insert into EXEMPLAR values(5001, 'NETFLIX', 'CA', '2025550182');
Insert into EXEMPLAR values(5002, 'A00001', 'MI', '2025550184');
Insert into EXEMPLAR values(5003, 'A00002', 'NM', '2025550129');
Insert into EXEMPLAR values(5004, 'A00003', 'TX', '2025550159');
Insert into EXEMPLAR values(5005, 'A00004', 'NY', '2025550165');

Insert into MOVIESOFFERED values(6001, 5001, 3001, 4001, 3.5, 'Y');
Insert into MOVIESOFFERED values(6002, 5002, 3002, 4002, 4.2, 'Y');
Insert into MOVIESOFFERED values(6003, 5003, 3003, 4002, 2.1, 'N');
Insert into MOVIESOFFERED values(6004, 5004, 3004, 4001, 3.1, 'Y');
Insert into MOVIESOFFERED values(6005, 5005, 3005, 4002, 4.5, 'Y');

Insert into BORROWING values(7001, 6001, 1001, '2014-03-02', '2014-03-04', 10, 1.6);
Insert into BORROWING values(7002, 6002, 1002, '2014-11-21', '2014-11-22', 5, 0.8);
Insert into BORROWING values(7003, 6003, 1003, '2014-02-13', '2014-02-15', 6, 0.6);
Insert into BORROWING values(7004, 6004, 1004, '2014-07-24', '2014-07-25', 4, 0.4);
Insert into BORROWING values(7005, 6005, 1005, '2014-06-18', '2014-06-20', 8, 0.7);