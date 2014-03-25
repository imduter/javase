
create database bbs;

use bbs;

create table article
(
	id int primary key auto_increment,
	pid int,
	rootid int,
	title varchar(255),
	cont text,
	pdate datetime,
	isleaf int
);

insert into article values (null, 0, 1, '���ϴ�ս����', '���ϴ�ս����', now(), 1);
insert into article values (null, 1, 1, '���󱻴�ſ����', '���󱻴�ſ����', now(), 1);
insert into article values (null, 2, 1, '����Ҳ���ù�', '����Ҳ���ù�', now(), 0);
insert into article values (null, 2, 1, 'Ϲ˵', 'Ϲ˵', now(), 1);
insert into article values (null, 4, 1, 'û��Ϲ˵', 'û��Ϲ˵', now(), 0);
insert into article values (null, 1, 1, '��ô����', '��ô����', now(), 1);
insert into article values (null, 6, 1, '��ôû�п���', '��ôû�п���', now(), 0);
insert into article values (null, 6, 1, '�����Ժܴ�', '�����Ժܴ�', now(), 0);
insert into article values (null, 2, 1, '�����ҽԺ��', '�����ҽԺ��', now(), 1);
insert into article values (null, 9, 1, '��ʿ������', '��ʿ������', now(), 0);

/*
���ϴ�ս����
	���󱻴�ſ��
		����Ҳ���ù�
			Ϲ˵
				û��Ϲ˵
			�����ҽԺ��
*/	