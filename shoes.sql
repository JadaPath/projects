START TRANSACTION;

DROP TABLE IF EXISTS shoes;

CREATE TABLE shoes (

shoe_id SERIAL primary key,
shoe_name VARCHAR(50) NOT NULL,
brand VARCHAR(50) NOT NULL,
style VARCHAR(20) NOT NULL,
heel_height numeric(3,2) NULL,	
color VARCHAR(25) NOT NULL,
size VARCHAR(5) NOT NULL,
price int NOT NULL,
decription VARCHAR(100) NOT NULL,
comfort_rating numeric(3,1) NOT NULL	
);

INSERT INTO shoes (shoe_name, brand, style, heel_height, color, size, price, decription, comfort_rating)
VALUES ('Yeezy Slide','Adidas', 'sandal', NULL, 'onyx', '7.0M', 204, 'Thick midsole athletic sandal with exaggerated tread on bottom', 9),
       ('Yeezy Slide','Adidas', 'sandal', NULL, 'glow Green', '7.0M', 150, 'Thick midsole athletic sandal with exaggerated tread on bottom', 9),
	   ('Crocs','Crocs', 'sandal',NULL, 'taffy Pink', '7W', 49, 'Lightweght, waterproof and breathable slipper', 8),
	   ('Provoke XT Mids', 'Puma', 'sneaker', NULL,'black-rose gold', '7.5W', 100, 'Futurist, mid height training sneaker', 8.5),
	   ('React Presto','Nike', 'sneaker', NULL, 'black-white', '7W', 0,'Walking shoes', 8.5),
	   ('Sk8-Hi', 'Vans', 'sneaker', NULL, 'camo-black-military Olive', '6M', 60, 'Stylish High-Top Canvas Sneaker', 7),
	   ('Port Duck boot','Sperry','boot',NULL,'tan-brown', '5M', 60, 'Waterproof Duck boot idea for rainy weather',7.5),
	   ('NMD','Adidas','sneaker', NULL,'black','6M', 140, 'Everyday wear versatile sneaker', 9.5),
	   ('Lola bootie','Kelly & Katie','bootie', 3.25,'burgundy','7.5W', 59,'slouchy suede bootie',8.5),
	   ('Aleska Sandal','Not Rated','sandal', NULL,'pale peach','7W', 29, 'crochet covered sandal',8),
	   ('Marnee Sandal','Sole Society','sandal', NULL,'Coral','7.5W', 39, 'glidiator open heal strappy sandals', 6),
	   ('Quesia over-the-knee boot','Unisa','boot', 3.25,'black','8W', 59 , 'over-the-knee suede boot with block heel', 8.5),
	   ('Yeezy Boost 350 V2','Adidas','sneaker', NULL,'light/light','6.5M', 322, 'tailight yeezy cavas sneakers', 9),
	   ('Ugg classic boots','Ugg','boot', NULL, 'grey', '8W', 150, 'Sheepskin, fleece-lined winter boots', 10),
	   ('Bevvyn','Vince Camuto','sandal', 3.5,'Henna Rust','8.5W', 79, 'round open toe sandal with strap for ankle support', 6.5),
	   ('Air Jordan retro 11 low','Nike/Jordan','sneaker',NULL,'white-metallic gold','6.5M',200,'Michael Jordans own classic sneaker',8),
	   ('Moccasin','Minnetonka','slipper',NULL,'cognac','7W', 39,'cozy slipper with faux fur lining and padded footbed',8.5),
	   ('Chassidy Boots','Mia','boot',1.75,'black','7.5W', 59,'combat boot with chunky block heel',9),
	   ('Ozelia','Adidas','sneaker', NULL, 'magic mauve', '7.5W', 49,'retro-inspired sneakers with sleek design', 8.5),
	   ('Yeezy 450','Adidas','sneaker', NULL, 'cinder/grey', '6.5M', 279, 'primeknit upper with thick laces and teeth-like design', 8),
	   ('Gabbie Sandal','JLO','sandal', 4,'black', '8W', 89,'rhinestone trimmed wavy straps with ankle wrap that ties up the leg', 7),
	   ('Air Jordan retro 11 low','Nike/Jordan','sneaker',NULL,'red-black','5.5M',200,'Michael Jordans own classic sneaker',8),
	   ('Tulah','Impo','bootie','3.75','leopard print', '8W',29,'ankle boot with ruched fablic and coned-shape heel', 8.5),
	   ('Thermoball pull-on','Northface','boot',Null,'vintage white', '8W',100,'lightweight weatherproof snow boots', 9),
	   ('Inner2-t','Indigo road','boot', NULL,'medium brown', '7.5W',40,'faux leather fur lined boots', 9.5),
	   ('Yeezy 700','Adidas','sneaker', NULL,'Hi Res blue','7M',279,'Hi res blue base with hues of purple, orange,and black,extra cushion', 10),
	   ('6 inch boots','Timberland','boot', NULL,'wheat', '5.5M', 125, 'classic 6in waterproof booots', 7.5),
	   ('Tulum','Crocs','sandal', NULL,'yellow', '7W',45, 'Strappy sandal with supportive footbed featuring massaging nubs', 9),
	   ('Tagazee','Kelly & Katie','bootie', 3.5,'off-white','7.5W', 59,'slouchy suede bootie with padded footbed',8.5),
	   ('Ozweego','Adidas','sneaker', NULL,'olive','7W',99,'90s inspired athletic shoe',8.5),
	   ('Chuck Taylor Shoreline','Converse','sneaker', NULL,'white','7.5W',39, 'low top slip on design with elastic heel',7),
	   ('Sk8-Hi', 'Vans', 'sneaker', NULL, 'black-white', '6M', 60, 'Stylish High-Top Canvas Sneaker', 7),
	   ('Conradd','Kelly & Katie','sandal', 3, 'nude','7.5W',59,'Platform sandal with t-strap',6.5),
	   ('Cloudfoam','Adidas','sneaker', NULL,'white','7W',45,'Made of recycled material lightweight shoe',10),
	   ('Larix','Kelly & Katie','bootie', 3.5, 'black-white', '8W', 49, 'Ankle boot with buckle and neoprene fabric panel',8.5),
	   ('Litton','Kelly & Katie','sandal', 3.75, 'pink-multi', '8W', 15, 'Round open toe sandal', 5),
	   ('Foamposite','Nike','sneaker', NULL, 'black-silver-crimson', '6.5M', 200, 'Lightening design with rubber outsole', 9),
	   ('Steralla','Crown Vintage','sandal', NULL, 'taupe', '7W', 29,'Gladiator laced-up sandals', 8.5),
	   ('Lola','Kelly & Katie','bootie', 3, 'black', '8W', 59, 'Slouchy Leather booties', 8.5),
	   ('Blazer Mid 77','Nike','sneaker', NULL, 'denim', '7.5W', 65, 'Timeless old-school basketball design', 8.5);
 

COMMIT;
--rollback;

select*from shoes;