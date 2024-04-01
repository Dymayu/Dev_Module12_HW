INSERT INTO spacetravel.client (NAME) VALUES
	('Alex Johnson'),
	('Emily Smith'),
	('Michael Brown'),
	('Sarah Davis'),
	('David Wilson'),
	('Jennifer Taylor'),
	('Christopher Martinez'),
	('Jessica Anderson'),
	('Matthew Thomas'),
	('Amanda Jackson');
INSERT INTO spacetravel.planet (ID, NAME) VALUES
	('MRS', 'Mars'),
	('VNS', 'Venus'),
	('JPR', 'Jupiter'),
	('STN', 'Saturn'),
	('NPT', 'Neptune');
INSERT INTO spacetravel.ticket (CREATED_AT, CLIENT_ID, FROM_PLANET_ID, TO_PLANET_ID) VALUES
	('2030-11-05 10:30:15', 3, 'MRS', 'STN'),
	('2030-05-14 08:44:08', 5, 'NPT', 'MRS'),
	('2030-04-21 16:55:12', 1, 'NPT', 'MRS'),
	('2030-02-03 22:23:41', 2, 'JPR', 'VNS'),
	('2030-04-18 07:40:12', 7, 'VNS', 'NPT'),
	('2030-12-03 15:20:32', 9, 'STN', 'NPT'),
	('2030-02-13 18:21:30', 4, 'JPR', 'VNS'),
	('2030-04-16 10:11:55', 8, 'MRS', 'NPT'),
	('2030-01-06 09:12:23', 10, 'VNS', 'STN'),
	('2030-08-16 10:49:12', 6, 'JPR', 'MRS');