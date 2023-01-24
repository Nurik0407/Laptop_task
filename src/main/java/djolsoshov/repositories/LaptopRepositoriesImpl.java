package djolsoshov.repositories;

import djolsoshov.config.HibernateConfig;
import djolsoshov.model.Laptop;
import djolsoshov.model.OperatingSystem;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LaptopRepositoriesImpl implements LaptopRepositories, AutoCloseable {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.GetEntityManagerFactory();

    @Override
    public Laptop saveProgrammer(Laptop laptop) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(laptop);
            entityManager.getTransaction().commit();
            entityManager.close();
            return laptop;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Laptop> saveAll(List<Laptop> laptops) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            for (Laptop l : laptops) {
                entityManager.persist(l);
            }
            entityManager.getTransaction().commit();
            entityManager.close();
            return laptops;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Laptop deleteById(Long id) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Laptop la = entityManager.createQuery("select l from Laptop l where l.id = :id", Laptop.class).
                    setParameter("id", id).getSingleResult();
            entityManager.remove(la);
            entityManager.getTransaction().commit();
            entityManager.close();
            return la;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteAll() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete Laptop ").executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Laptop> findAll() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Laptop> selectLaptop = entityManager.createQuery("from Laptop ").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return selectLaptop;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Laptop update(Long id, Laptop laptop) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Laptop result = entityManager.createQuery("select l from Laptop l where l.id=:id", Laptop.class).setParameter("id", id).getSingleResult();
            result.setBrand(laptop.getBrand());
            result.setPrice(laptop.getPrice());
            result.setMemory(laptop.getMemory());
            result.setOperatingSystem(laptop.getOperatingSystem());
            result.setDateOfIssue(laptop.getDateOfIssue());
            entityManager.getTransaction().commit();
            entityManager.close();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Map<OperatingSystem, List<Laptop>> groupBy() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Map<OperatingSystem, List<Laptop>> map = entityManager.createQuery("select l from Laptop l ", Laptop.class).getResultStream().collect(Collectors.groupingBy(Laptop::getOperatingSystem));
            entityManager.getTransaction().commit();
            entityManager.close();
            return map;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {
        switch (column) {
            case "id" -> System.out.println(id(ascOrDesc));
            case "brand" -> System.out.println(brand(ascOrDesc));
            case "operatingsystem" -> System.out.println(operatingSystem(ascOrDesc));
            case "memory" -> System.out.println(memory(ascOrDesc));
            case "price" -> System.out.println(price(ascOrDesc));
            case "dateofissue" -> System.out.println(dateOfIssue(ascOrDesc));
        }
        return null;
    }

    private List<Laptop> brand(String ascOrDesc) {
        String sql1 = "select l from Laptop l order by brand";
        String sql2 = "select l from Laptop l order by brand desc";
        String sql = "";
        if (ascOrDesc.toLowerCase().equals("asc")) sql = sql1;
        else if (ascOrDesc.toLowerCase().equals("desc")) sql = sql2;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Laptop> list = entityManager.createQuery(sql).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return list;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List<Laptop> id(String ascOrDesc) {
        String sql1 = "select l from Laptop l order by id";
        String sql2 = "select l from Laptop l order by id desc";
        String sql = "";
        if (ascOrDesc.toLowerCase().equals("asc")) sql = sql1;
        else if (ascOrDesc.toLowerCase().equals("desc")) sql = sql2;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Laptop> list = entityManager.createQuery(sql).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return list;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List<Laptop> operatingSystem(String ascOrDesc) {
        String sql1 = "select l from Laptop l order by operatingSystem";
        String sql2 = "select l from Laptop l order by operatingSystem desc";
        String sql = "";
        if (ascOrDesc.toLowerCase().equals("asc")) sql = sql1;
        else if (ascOrDesc.toLowerCase().equals("desc")) sql = sql2;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Laptop> list = entityManager.createQuery(sql).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return list;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List<Laptop> memory(String ascOrDesc) {
        String sql1 = "select l from Laptop l order by memory";
        String sql2 = "select l from Laptop l order by memory desc";
        String sql = "";
        if (ascOrDesc.toLowerCase().equals("asc")) sql = sql1;
        else if (ascOrDesc.toLowerCase().equals("desc")) sql = sql2;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Laptop> list = entityManager.createQuery(sql).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return list;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List<Laptop> price(String ascOrDesc) {
        String sql1 = "select l from Laptop l order by price";
        String sql2 = "select l from Laptop l order by price desc";
        String sql = "";
        if (ascOrDesc.toLowerCase().equals("asc")) sql = sql1;
        else if (ascOrDesc.toLowerCase().equals("desc")) sql = sql2;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Laptop> list = entityManager.createQuery(sql).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return list;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    private List<Laptop> dateOfIssue(String ascOrDesc) {
        String sql1 = "select l from Laptop l order by dateOfIssue";
        String sql2 = "select l from Laptop l order by dateOfIssue desc";
        String sql = "";
        if (ascOrDesc.toLowerCase().equals("asc")) sql = sql1;
        else if (ascOrDesc.toLowerCase().equals("desc")) sql = sql2;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Laptop> list = entityManager.createQuery(sql).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return list;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    //close
    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
