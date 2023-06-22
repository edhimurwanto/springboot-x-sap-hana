package com.test.hanadbb.services;

import com.test.hanadbb.entities.Students;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentsService {

    @Autowired
    EntityManager em;

    public List<Students> getAll(){
        return em.createNamedQuery("Students.findAll", Students.class).getResultList();
    }

    @Transactional
    public void create(Students students) {
        em.persist(students);
    }

    public Students findById(int id) {
        return em.find(Students.class, id);
    }

    @Transactional
    public void update(Students students) {
        em.merge(students);
    }

    @Transactional
    public void delete(Students students) {

        if (!em.contains(students)) {
            students = em.merge(students);
        }

        em.remove(students);
    }

}
