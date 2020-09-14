drop table customer;
--고객테이블
create table customer(
  user_id varchar2(30) primary key, 
  user_pwd varchar2(30) not null,
  user_name varchar2(30),
  reg_date date
);


insert into  customer values('jang','1111','유재석',sysdate);
insert into  customer values('lee','1111','이효리',sysdate);
insert into  customer values('kim','1111','송중기',sysdate);
insert into  customer values('king','1111','송혜교',sysdate);

--상품테이블
create table goods(
  goods_id varchar2(20) primary key,
  goods_name varchar2(50) not null,
  goods_price number(12) ,
  stock number(3),
  regdate date default sysdate
);

insert into goods values('A01','새우깡',1500,10,SYSDATE);
insert into goods values('A02','허니버터칩',2500,10,SYSDATE);
insert into goods values('A03','콘칩',2000,10,SYSDATE);
insert into goods values('A04','빼빼로',1500,10,SYSDATE);
insert into goods values('A05','감자깡',1500,10,SYSDATE);

delete from goods;

--주문테이블
drop table orders;
create table orders(
  order_id number(5) primary key,
  order_date date not null,
  user_id varchar2(30) not null references customer(user_id) ,
  address varchar2(100) not null,
  total_amount number(20) not null
);

-- ORDER_ID 시퀀스 생성
drop sequence ORDER_ID_SEQ;
CREATE SEQUENCE ORDER_ID_SEQ NOCACHE;

--주문상세
drop table order_line;

create table order_line(
  order_line_id number(5) primary key,
  order_id number(5) not null references orders(order_id),
  goods_id varchar2(20) not null references goods(goods_id),
  unit_price number(12) not null,
  qty number(3) not null,
  amount number(10) not null
);

--ORDER_LINE_ID 시퀀스 생성
CREATE SEQUENCE ORDER_LINE_ID_SEQ  NOCACHE;

--주문하기
 1) jang 아이디가 A01 상품 2개, AO2 상품 1개 구입한다.
  INSERT INTO ORDERS(ORDER_ID, ORDER_DATE,USER_ID, ADDRESS, TOTAL_AMOUNT)
  VALUES(ORDER_ID_SEQ.NEXTVAL ,sysdate,'jang','경기도 판교', 5500);
  
  select ORDER_ID_SEQ.currval from dual;
  
  insert into order_line(order_line_id,order_id, goods_id,unit_price, qty, amount)
  values(ORDER_LINE_ID_SEQ.nextval ,ORDER_ID_SEQ.currval , 'A01', 1500,2 , 3000 );
  
   insert into order_line(order_line_id,order_id, goods_id,unit_price, qty, amount)
  values(ORDER_LINE_ID_SEQ.nextval , ORDER_ID_SEQ.currval , 'A02', 2500,1 , 2500 );
  
  --주문수량만큼 재고량 감소시킨다.
  update goods set stock=stock-2 where goods_id='A01';
  update goods set stock=stock-1 where goods_id='A02';
 
 commit;
 
 select * from orders;
 select * from order_line;
 
 2) KIM 아이디가 A01 상품 3개 구입한다.
   INSERT INTO ORDERS(ORDER_ID, ORDER_DATE,USER_ID, ADDRESS, TOTAL_AMOUNT)
  VALUES(ORDER_ID_SEQ.NEXTVAL ,sysdate,'kim','서울시 강남구', 4500);
  
  insert into order_line(order_line_id,order_id, goods_id,unit_price, qty, amount)
  values(ORDER_LINE_ID_SEQ.nextval ,ORDER_ID_SEQ.currval , 'A01', 1500,3 , 4500 );
  
  update goods set stock=stock-3 where goods_id='A01';
  
  commit
 
 3) JANG 아이디가 A03 상품 2개와 A04 상품 1개 구입한다.
  INSERT INTO ORDERS(ORDER_ID, ORDER_DATE,USER_ID, ADDRESS, TOTAL_AMOUNT)
  VALUES(ORDER_ID_SEQ.NEXTVAL ,sysdate,'jang','경기도 분당구', 5500);
  
  select ORDER_ID_SEQ.currval from dual;
  
  insert into order_line(order_line_id,order_id, goods_id,unit_price, qty, amount)
  values(ORDER_LINE_ID_SEQ.nextval ,ORDER_ID_SEQ.currval , 'A03', 2000,2 , 4000 );
  
   insert into order_line(order_line_id,order_id, goods_id,unit_price, qty, amount)
  values(ORDER_LINE_ID_SEQ.nextval , ORDER_ID_SEQ.currval , 'A04', 1500,1 , 1500 );
  
  update goods set stock=stock-2 where goods_id='A03';
  update goods set stock=stock-1 where goods_id='A04';
  
  -------------------------------------------------------
  select * from customer;
  select * from goods;
  select * from orders;
  select * from order_line;
  
  
   drop table order_line;
  drop table orders;
  drop table goods;
  drop table customer;
  
  drop sequence ORDER_ID_SEQ;
  drop sequence ORDER_LINE_ID_SEQ;
  
  commit
 
