package com.mycompany.empleadosjpa.persistencia;

import com.mycompany.empleadosjpa.logica.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmpleadoJpaController {

    private EntityManagerFactory emf = null;

    public EmpleadoJpaController() {
        emf = Persistence.createEntityManagerFactory("empleadosPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(Empleado empleado) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(empleado);
        em.getTransaction().commit();
        em.close();
    }

    public void destroy(int id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Empleado empleado = em.find(Empleado.class, id);
        if (empleado != null) {
            em.remove(empleado);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Empleado> findEmpleadoEntities() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT e FROM Empleado e");
        List<Empleado> empleados = query.getResultList();
        em.close();
        return empleados;
    }

    public Empleado findEmpleado(int id) {
        EntityManager em = getEntityManager();
        Empleado empleado = em.find(Empleado.class, id);
        em.close();
        return empleado;
    }

    public List<Empleado> findEmpleadosByCargo(String cargo) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT e FROM Empleado e WHERE e.cargo = :cargo");
        query.setParameter("cargo", cargo);
        List<Empleado> empleados = query.getResultList();
        em.close();
        return empleados;
    }
}
