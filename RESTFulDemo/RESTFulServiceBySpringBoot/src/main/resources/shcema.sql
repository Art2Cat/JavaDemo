CREATE TABLE user_table (
  id        NUMBER        NOT NULL,
  username  VARCHAR2(255) NULL,
  password  VARCHAR2(255),
  firstname VARCHAR2(255),
  lastname  VARCHAR2(255)
);

CREATE TABLE company (
  id      NUMBER NOT NULL,
  name    VARCHAR2(255),
  address VARCHAR2(255),
  city    VARCHAR2(16),
  state   VARCHAR2(255),
  zipcode NUMBER,
  country VARCHAR2(255)
);

INSERT INTO company
VALUES (10001, 'Alphabet Inc.', '1600 Amphitheatre Parkway', 'Mountain View', 'CA', 94043, 'US');
INSERT INTO company
VALUES (10002, 'Samsung Electronics', '150 Maeyeong-ro, Maetan 4(sa)-dong, Yeongtong-gu', 'Suwon', 'Gyeonggi-do', 16674,
        'South Korea');
INSERT INTO company
VALUES (10003, 'Apple Inc.', '1 Infinite Loop', 'Cupertino', 'CA', 95014, 'US');
INSERT INTO company
VALUES (10004, 'Amazon Inc.', '410 Terry Ave', 'North Seattle', ' WA', 98109, 'US');
INSERT INTO company
VALUES (10005, 'Microsoft', 'One Microsoft Way', 'Redmond', 'WA', 98052, 'US');

CREATE TABLE technology_giant (
  rank_id      NUMBER NOT NULL,
  company      VARCHAR2(255),
  revenue      VARCHAR2(255),
  fiscal_year  NUMBER,
  employees    NUMBER,
  market_cap   VARCHAR2(255),
  headquarters VARCHAR2(255)
);


INSERT INTO technology_giant
VALUES (2016001, 'Samsung Electronics', '$215.6', 2016, 313000, '$311', 'Suwon, South Korea');
INSERT INTO technology_giant
VALUES (2016002, 'Apple Inc.', '$215.1', 2016, 116000, '$815.39', 'Cupertino, CA, US');
INSERT INTO technology_giant
VALUES (2016003, 'Amazon Inc.', '$135.9', 2016, 341400, '	$478.00', 'Seattle, WA, US');
INSERT INTO technology_giant
VALUES (2016004, 'Foxconn', '$135.1', 2016, 726772, '$66', 'New Taipei City, Taiwan');
INSERT INTO technology_giant
VALUES (2016005, 'Alphabet Inc.', '$90.2', 2016, 72053, '$676', 'Mountain View, CA, US');
INSERT INTO technology_giant
VALUES (2016006, 'Microsoft', '$85.3', 2016, 114000, '$561', 'Redmond, WA, US');
INSERT INTO technology_giant
VALUES (2016007, 'Hitachi', '$84.5', 2016, 303887, '$32', 'Tokyo, Japan');
INSERT INTO technology_giant
VALUES (2016008, 'IBM', '$79.9', 2016, 414400, '$145', 'Armonk, NY, US');
INSERT INTO technology_giant
VALUES (2016009, 'Huawei', '$78.5', 2016, 180000, 'N/A (Private)', 'Shenzhen, China');
INSERT INTO technology_giant
VALUES (2016010, 'Sony', '$70.1', 2016, 128400, '$51', 'Tokyo, Japan');