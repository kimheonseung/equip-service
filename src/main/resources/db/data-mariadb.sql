INSERT IGNORE INTO EQUIP_TYPE
VALUES (1, 'SERVER', '서버', '서버타입', NULL),
       (2, 'CLIENT', '클라이언트', '클라이언트타입', NULL);
INSERT IGNORE INTO EQUIP_GROUP (`ID`, `NAME`, `DESCRIPTION`, `PARENT_ID`, `DISPLAY_ORDER`)
VALUES (1, '개발연구소', '개발연구소', NULL, 0),
       (101, '연구소A', '연구소A', 1, 1),
       (102, '연구소B', '연구소B', 1, 2),
       (103, 'C연구소', '연구소C', 1, 3),
       (201, '팀A-1', '팀A-1', 101, 1),
       (202, '팀A-2', '팀A-2', 101, 2),
       (301, '팀B-1', '팀B-1', 102, 1),
       (302, '팀B-2', '팀B-2', 102, 2),
       (401, '팀C-1', '팀C-1', 103, 1),
       (402, '팀C-2', '팀C-2', 103, 2);
INSERT IGNORE INTO EQUIP (`ID`, `IP`, `NAME`, `EQUIP_TYPE_CODE`, `OS`, `ENABLE`, `PARENT_ID`, `EQUIP_GROUP_ID`, `DESCRIPTION`)
VALUES (1, '192.168.103.1', '서버장비', 'SERVER', 'WINDOWS', TRUE, NULL, 1, '서버'),
       (2, '192.168.103.10', '클라이언트1', 'CLIENT', 'MAC', TRUE, NULL, 1, '클라이언트'),
       (3, '192.168.103.11', '클라이언트2', 'CLIENT', 'MAC', TRUE, NULL, 1, '클라이언트'),
       (4, '192.168.103.12', '클라이언트3', 'CLIENT', 'MAC', TRUE, NULL, 1, '클라이언트'),
       (5, '192.168.103.13', '클라이언트4', 'CLIENT', 'MAC', TRUE, NULL, 1, '클라이언트'),
       (6, '192.168.103.15', '클라이언트5', 'CLIENT', 'MAC', TRUE, NULL, 1, '클라이언트'),
       (7, '192.168.103.16', '클라이언트6', 'CLIENT', 'MAC', TRUE, NULL, 1, '클라이언트'),
       (8, '192.168.103.17', '클라이언트7', 'CLIENT', 'MAC', TRUE, NULL, 1, '클라이언트');