package djolsoshov.services;

import djolsoshov.model.Laptop;
import djolsoshov.model.OperatingSystem;
import djolsoshov.repositories.LaptopRepositories;
import djolsoshov.repositories.LaptopRepositoriesImpl;

import java.util.List;
import java.util.Map;

public class LaptopServiceImpl implements LaptopService{
    LaptopRepositories laptopRepositories = new LaptopRepositoriesImpl();

    @Override
    public Laptop saveProgrammer(Laptop laptop) {
        return laptopRepositories.saveProgrammer(laptop);
    }

    @Override
    public List<Laptop> saveAll(List<Laptop> laptops) {
        return laptopRepositories.saveAll(laptops);
    }

    @Override
    public Laptop deleteById(Long id) {
        return laptopRepositories.deleteById(id);
    }

    @Override
    public void deleteAll() {
laptopRepositories.deleteAll();
    }

    @Override
    public List<Laptop> findAll() {
        return laptopRepositories.findAll();
    }

    @Override
    public Laptop update(Long id, Laptop laptop) {
        return laptopRepositories.update(id, laptop);
    }

    @Override
    public Map<OperatingSystem, List<Laptop>> groupBy() {
        return laptopRepositories.groupBy();
    }

    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {
        return laptopRepositories.sortByDifferentColumn(column, ascOrDesc);
    }
}
