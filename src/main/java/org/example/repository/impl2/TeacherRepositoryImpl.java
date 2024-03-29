package org.example.repository.impl2;

import org.example.dto.response.GetStudentResponse;
import org.example.dto.response.GetTeacherResponse;
import org.example.entity.Teacher;
import org.example.mapper.StudentMapper;
import org.example.mapper.TeacherMapper;
import org.example.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TeacherRepositoryImpl implements TeacherRepository {

    private static final TeacherRepositoryImpl INSTANCE = new TeacherRepositoryImpl() {
        @Override
        public void AddTeacher(Teacher teacher) {

        }
    };

    private final TeacherRepository teacherRepository = TeacherRepositoryImpl.getInstance();

    private final TeacherMapper teacherMapper = TeacherMapper.getInstance();
    private static final Map<Long, Teacher> teachers = new HashMap<>();

    protected TeacherRepositoryImpl() {}

    public static TeacherRepositoryImpl getInstance() {
        return INSTANCE;
    }

    public void addTeacher(Teacher teacher) {
        teachers.put(teacher.getId(), teacher);

    }

    public abstract void AddTeacher(Teacher teacher);

    @Override
    public List<Teacher> getAllTeachers() {
       return new ArrayList<>(teachers.values());
    }


}
