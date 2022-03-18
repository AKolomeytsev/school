SELECT a.name
     ,a.age
     ,f.name
     ,f.color
FROM student a
         LEFT JOIN faculty f on f.id = a.faculty_id;

SELECT a.name
     ,a.age
     ,av.file_path
     ,av.file_size
     ,av.media_type
     ,av.data
FROM student a
         INNER JOIN avatar av on  av.student_id = a.id

