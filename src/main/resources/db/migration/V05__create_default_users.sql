INSERT INTO profile (id, name) VALUES (1, "ADMIN");
INSERT INTO profile (id, name) VALUES (2, "USER");

INSERT INTO user (email, password, profile_id) VALUES ("godl@gft.com", "$2a$10$d14Bq9Y8wWomgx577qdj3.rFxc8oEq.63Oe5fMio9GUNLSXmnJMzm", 1);
INSERT INTO user (email, password, profile_id) VALUES ("test@gft.com", "$2a$10$4s07G9.t49QzG45lsIj.eeoEQi/AEpBECeOBCgIzdEGhslhhRTRCy", 2);
