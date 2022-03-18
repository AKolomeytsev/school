select * from student where age between 24 and 37;
select s.nane from student s;
select s.nane from student s where s.nane like '%d%';
select s.nane from student s where s.age<s.id;
select s.nane,s.age from student s order by s.age;