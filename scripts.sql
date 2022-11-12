select * from student;

select * from student where age >= 10 and age <= 20;

select name from student;

select * from student where name like '%o%' or name like 'O%';

select * from student where name like '%n%' or name like 'N%';

select * from student where age < student.id;

select * from student order by age;

select * from student order by age desc;

select s.* from faculty as f, student as s
where s.faculty_id = f.id
  and f.name = 'Gryffindor';

select f.* from faculty as f, student as s
where s.faculty_id = f.id
  and s.name = 'Harry Potter';

SELECT faculty.id, faculty.color, faculty.name FROM student, faculty where student.faculty_id = faculty.id and student.name='Harry Potter' ;

SELECT student.id, student.age, student.name FROM student, faculty where student.faculty_id = faculty.id and faculty.name='string' ;
