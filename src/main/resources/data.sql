
INSERT INTO role(name) values ('USER');
INSERT INTO role(name) values ('ADMIN');
INSERT INTO role(name) values ('MODERATOR');


INSERT INTO client(client_id,ban,ip) values (1,false,null);
INSERT INTO client(client_id,ban,ip) values (2,false,null);
INSERT INTO client(client_id,ban,ip) values (3,false,null);
INSERT INTO client(client_id,ban,ip) values (4,false,null);
INSERT INTO client(client_id,ban,ip) values (5,false,null);
INSERT INTO client(client_id,ban,ip) values (6,false,null);
INSERT INTO client(client_id,ban,ip) values (7,false,null);


INSERT INTO section(id, teg)  VALUES(1,'ANIME');
INSERT INTO section(id, teg)  VALUES(2,'MUSIC');
INSERT INTO section(id, teg)  VALUES(3,'FILMS');
INSERT INTO section(id, teg)  VALUES(4,'MANGA');
INSERT INTO section(id, teg)  VALUES(5,'FILMS');
INSERT INTO section(id, teg)  VALUES(6,'RANDOM');



INSERT INTO tred(tred_id,section_id,name,info ) VALUES (1,5,'Lorem ipsum dolor sit amet consectetur adipiscing elit, eleifend nullam taciti maecenas ex nulla magna mauris, tempor vestibulum risus nunc elementum ridiculus. Gravida urna nisi proin tempor dolor fermentum ante ex dignissim nulla, morbi id laoreet purus facilisis accumsan nascetur dapibus aliquam, nunc interdum nec posuere dictumst in ad fusce curabitur. Condimentum vehicula sapien inceptos gravida, ex hac ipsum maecenas, mauris velit neque. Dictum venenatis blandit bibendum ultrices suscipit tempus quisque ante augue, per aliquam fames est vestibulum neque dapibus consequat eleifend phasellus, risus semper at quis duis porttitor volutpat efficitur. Suspendisse tellus ultrices justo nisi nec imperdiet semper mollis facilisi enim id, lobortis nisl curae euismod dapibus duis consectetur in luctus. Etiam ultrices vulputate sociosqu et lorem justo commodo nostra, dictum leo elit torquent mus tortor habitant ac, metus montes venenatis pharetra suscipit platea mollis. Id in ac maximus natoque lacinia praesent aliquam dolor, felis aptent erat rutrum penatibus volutpat elementum, varius quam nisl dis dictum hendrerit nulla.

Nisl penatibus vehicula tortor ex consequat lorem arcu in, felis mus imperdiet semper nunc malesuada massa, est suspendisse faucibus facilisi laoreet tempus sociosqu. Varius luctus feugiat sapien habitant diam dictumst massa, nam bibendum sollicitudin commodo praesent at, nostra hac mi augue vitae malesuada. Suspendisse orci ipsum tortor dapibus volutpat ac nostra, molestie gravida phasellus himenaeos lectus quis ligula nam, aenean malesuada ultricies vitae nascetur sagittis. Quisque volutpat dictumst cubilia risus nec nisi eleifend maximus, fermentum nisl ridiculus diam nascetur tellus sit adipiscing id, duis aenean elementum fames semper parturient dictum. Pulvinar sem ipsum ullamcorper nisl praesent lacus bibendum nunc morbi maximus, fermentum lobortis diam eleifend id sit quisque cras hac facilisi, potenti amet varius phasellus ante mus a at urna.

Dictumst commodo velit nisl duis sollicitudin lobortis risus maximus parturient, massa nulla lacinia proin porta sit adipiscing mus nibh, vehicula ex blandit euismod ultricies hendrerit purus porttitor. Mollis aptent id leo hac hendrerit egestas rutrum habitasse mauris vivamus, nam tincidunt mus parturient justo auctor placerat sagittis urna est taciti, nulla nibh suspendisse congue pulvinar erat curabitur litora bibendum. Commodo lectus condimentum nunc pulvinar maximus malesuada vulputate sociosqu proin parturient natoque scelerisque dapibus montes interdum ligula suscipit, vel sem rhoncus per egestas phasellus sodales pellentesque litora gravida velit nostra dui luctus nibh cursus. Dictum cursus justo hendrerit commodo nullam nascetur aptent cubilia elit, donec ligula faucibus nibh sed sollicitudin ullamcorper proin euismod, luctus lacus nisi senectus quam molestie malesuada ante. Maximus aenean vitae himenaeos feugiat netus efficitur, sollicitudin duis at fermentum facilisi leo, nostra scelerisque congue magnis tempor. Neque hendrerit felis platea pulvinar tempor nam porta etiam dictumst inceptos, lobortis pellentesque velit orci luctus varius convallis est suspendisse curabitur, placerat habitant risus morbi faucibus in phasellus amet massa.','я б хотів  поговорити про паркур');
INSERT INTO tred(tred_id, section_id,name,info) VALUES (2,5,'Сап фчан я б  зотів послухати твою пораду','Я хочу замовити мишку, але не знаю яку. Прошу вашої поради.w');
INSERT INTO tred(tred_id, section_id,name,info) VALUES (3,5,'Сьогодні я відрубав руки','зараз пишу з лікарні кров вже зупинилася');
INSERT INTO tred(tred_id, section_id,name,info) VALUES (4,5,'Механічної клавіатури тред',' Сьогодні я вирішив, що я куплю собі механічну клавіатуру');
INSERT INTO tred(tred_id, section_id,name,info) VALUES (5,1,'Holy panda switches top ','Якщо існують світчі кращі за ці прошу  написати');



INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (1,'Пост і його текст','2021-03-12',1,1);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (2,'Пост і його текст','2021-04-12',1,1);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (3,'Пост і його текст','2021-05-12',1,1);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (4,'Пост і його текст','2021-06-12',1,1);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (5,'Пост і його текст','2021-09-12',1,5);



INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (6,'Пост і його текст','2021-09-12',2,1);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (7,'Пост і його текст','2021-09-12',3,1);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (8,'Пост і його текст','2021-09-12',2,1);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (9,'Пост і його текст','2021-09-12',2,1);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (10,'Пост і його текст','2021-09-12',2,1);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (11,'Пост і його текст','2021-09-12',2,1);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (12,'Пост і його текст','2021-09-12',2,1);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (13,'Пост і його текст','2021-09-12',2,1);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (14,'Пост і його текст','2021-09-12',3,1);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (15,'Пост і його текст','2021-09-12',4,1);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (16,'Пост і його текст','2021-09-12',5,1);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (17,'Пост і його текст','2021-09-12',5,1);


INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (18,'Пост і його текст','2021-09-12',2,2);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (19,'Пост і його текст','2021-09-12',3,2);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (20,'Пост і його текст','2021-09-12',2,2);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (21,'Пост і його текст','2021-09-12',2,2);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (22,'Пост і його текст','2021-09-12',2,2);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (23,'Пост і його текст','2021-09-12',2,2);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (24,'Пост і його текст','2021-09-12',2,2);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (25,'Пост і його текст','2021-09-12',2,2);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (26,'Пост і його текст','2021-09-12',3,2);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (27,'Пост і його текст','2021-09-12',4,2);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (28,'Пост і його текст','2021-09-12',5,2);
INSERT INTO post(post_id,message,date,id_owner,tred_id) VALUES (29,'Пост і його текст','2021-09-12',5,2);







INSERT INTO answer(answer_id,answer_to) VALUES(2,1);
INSERT INTO answer(answer_id,answer_to) VALUES(3,1);
INSERT INTO answer(answer_id,answer_to) VALUES(4,1);




