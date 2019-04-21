/*
    Database initialization script that runs on every web-application redeployment.
*/
DROP TABLE IF EXISTS publications CASCADE;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    login_name TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
	CONSTRAINT login_name_not_empty CHECK (login_name <> ''),
	CONSTRAINT password_not_empty CHECK (password <> '')
);

CREATE TABLE publications (
    p_id SERIAL PRIMARY KEY,
    u_id INTEGER,
    title varchar(40),
    text_content text,
    published_year INTEGER,
    FOREIGN KEY (u_id) REFERENCES users(id)
);

INSERT INTO users (login_name, password) VALUES
	('rejtojeno', 'rejto'), -- 1
    ('adyendre', 'ady'), -- 2
    ('petofisandor', 'petofi'); -- 3

INSERT INTO publications (u_id, title, text_content, published_year) VALUES
    (1, 'Ha valaki jönne...', 'Ha valaki jönne, csuf téli hajnalon
Mikor minden felbug és szorit a torkomon
Ha iljenkor jönne... csendbe... szomoruan
Jönne akit várok, keresek, hasztalan
Leborulnák térdre és lüktető fejem
Ölébe hajtanám...
Lihegnék fáradtan... térdét szoritanám
Friss harmatos ölét, csókkal boritanám
Hullana a könnyem hófehér combjára...
Hörögne a mellem... a zokogás rázna...
Fáradtan, megtörten, vad keserves vággyal,
Bus férfi sirással...
Szólna hozzám lágyan... halkan... bánatosan,
Simogatná fejem... s arcomat szorosan...
Egyre szoritaná kis puha ölébe...
És én a hajnali... sápadt csöndességbe
Kezdenék vallani...
Felsirnám ott, tépett összetört életem
Beteg lázas agyam... sápadt, fáradt fejem
Piszkos éjji álmok, kéjbe fult titkait
Ezer rongy szerelem, kifestett csókjait
Bus bojongó vágyak, miket sohasem láttak
miket kinevettem
Régi éjszakáknak festett durva kéjét,
Tehetetlen dühöm undok irigységét...
Aljas pillanatok... éhes mocskos vágyak...
Ezer pillantásom, amit sohasem láttak
Százezer gondolat, mit félig gondoltam
s vágyódtam utánuk...
Lihegve... kifultam... elsuttognám "Ámen"...
Ölébe hajtanám, fáradt, zugó fejem
Ő, tudom kiköpne... felrugna... ott hagyna...
s vergödve a földön... utána zokogva...
Azt sugnám lihegve... hajnali pirkon...
Igaza volt néki!' , 1928),
    (2, 'Őrizem a szemed', 'Már vénülő kezemmel
Fogom meg a kezedet,
Már vénülő szememmel
Őrizem a szemedet.
Világok pusztulásán
Ősi vad, kit rettenet
Űz, érkeztem meg hozzád
S várok riadtan veled.

Már vénülő kezemmel
Fogom meg a kezedet,
Már vénülő szememmel
Őrizem a szemedet.

Nem tudom, miért, meddig
Maradok meg még neked,
De a kezedet fogom
S őrizem a szemedet.', 1916),
    (2, 'Elbocsátó, szép üzenet', 'Törjön százegyszer százszor-tört varázs:
Hát elbocsátlak még egyszer, utólszor,
Ha hitted, hogy még mindig tartalak
S hitted, hogy kell még elbocsáttatás.
Százszor-sujtottan dobom, ím, feléd
Feledésemnek gazdag úr-palástját.
Vedd magadra, mert lesz még hidegebb is,
Vedd magadra, mert sajnálom magunkat,
Egyenlőtlen harc nagy szégyeniért,
Alázásodért, nem tudom, miért,
Szóval már téged, csak téged sajnállak.
Milyen régen és titkosan így volt már:
Sorsod szépítni hányszor adatott
Ámító kegyből, szépek szépiért
Forrott és küldött, ékes Léda-zsoltár.
Sohase kaptam, el hát sohse vettem:
Átadtam néked szépen ál-hitét
Csókoknak, kik mással csattantanak
S szerelmeket, kiket mással szerettem:
És köszönök ma annyi ölelést,
Ám köszönök mégis annyi volt-Lédát,
Amennyit férfi megköszönni tud,
Mikor egy unott, régi csókon lép át.

És milyen régen nem kutattalak
Fövényes multban, zavaros jelenben
S már jövőd kicsiny s asszonyos rab-útján
Milyen régen elbúcsuztattalak.
Milyen régen csupán azt keresem,
Hogy szép énemből valamid maradjon,
Én csodás, verses rádfogásaimból
S biztasd magad árván, szerelmesen,
Hogy te is voltál, nemcsak az, aki
Nem bírt magának mindent vallani
S ráaggatott díszeiből egy nőre.

Büszke mellemről, ki nagy, telhetetlen,
Akartam látni szép hullásodat
S nem elhagyott némber kis bosszuját,
Ki áll dühödten bosszu-hímmel lesben,
Nem kevés, szegény magad csúfolását,
Hisz rajtad van krőzusságom nyoma
S hozzám tartozni lehetett hited,
Kinek mulását nem szabad, hogy lássák,
Kinek én úgy adtam az ölelést,
Hogy neki is öröme teljék benne,
Ki előttem kis kérdőjel vala
S csak a jöttömmel lett beteljesedve.

Lezörögsz-e, mint rég-hervadt virág
Rég-pihenő imakönyvből kihullva,
Vagy futkározva rongyig-cipeled
Vett nimbuszod, e zsarnok, bús igát
S, mely végre méltó nőjéért rebeg,
Magamimádó önmagam imáját?
Kérem a Sorsot, sorsod kérje meg,
Csillag-sorsomba ne véljen fonódni
S mindegy, mi nyel el, ár avagy salak:
Általam vagy, mert meg én láttalak
S régen nem vagy, mert már régen nem látlak.', 1912),
    (3, 'Szeptember végén', 'Még nyílnak a völgyben a kerti virágok,
Még zöldel a nyárfa az ablak előtt,
De látod amottan a téli világot?
Már hó takará el a bérci tetőt.
Még ifju szivemben a lángsugarú nyár
S még benne virít az egész kikelet,
De íme sötét hajam őszbe vegyűl már,
A tél dere már megüté fejemet.
Elhull a virág, eliramlik az élet...
Űlj, hitvesem, űlj az ölembe ide!
Ki most fejedet kebelemre tevéd le,
Holnap nem omolsz-e sirom fölibe?
Oh mondd: ha előbb halok el, tetemimre
Könnyezve borítasz-e szemfödelet?
S rábírhat-e majdan egy ifju szerelme,
Hogy elhagyod érte az én nevemet?

Ha eldobod egykor az özvegyi fátyolt,
Fejfámra sötét lobogóul akaszd,
Én feljövök érte a síri világból
Az éj közepén, s oda leviszem azt,
Letörleni véle könyűimet érted,
Ki könnyeden elfeledéd hivedet,
S e szív sebeit bekötözni, ki téged
Még akkor is, ott is, örökre szeret!', 1847);
