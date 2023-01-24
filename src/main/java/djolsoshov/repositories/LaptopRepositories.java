package djolsoshov.repositories;

import djolsoshov.model.Laptop;
import djolsoshov.model.OperatingSystem;

import java.util.List;
import java.util.Map;

public interface LaptopRepositories {

    Laptop saveProgrammer(Laptop laptop);

    public List<Laptop> saveAll(List<Laptop> laptops);

    public Laptop deleteById(Long id);

    public void deleteAll();

    public List<Laptop> findAll();

    public Laptop update(Long id, Laptop laptop);

    Map<OperatingSystem, List<Laptop>> groupBy();

    List<Laptop> sortByDifferentColumn(String column, String ascOrDesc);
}
