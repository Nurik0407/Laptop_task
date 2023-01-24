package djolsoshov;

import djolsoshov.model.Laptop;
import djolsoshov.model.OperatingSystem;
import djolsoshov.services.LaptopService;
import djolsoshov.services.LaptopServiceImpl;

import java.time.LocalDate;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    static LaptopService laptopService = new LaptopServiceImpl();

    public static void main(String[] args) {

        List<Laptop> laptops = new ArrayList<>(Arrays.asList(
                new Laptop("Mac", OperatingSystem.MACOS, 256, 60000, LocalDate.of(2020, 4, 2)),
                new Laptop("Lenovo", OperatingSystem.WINDOWS, 500, 70000, LocalDate.of(2020, 8, 20))
        ));


        while (true){
            System.out.println("1 SAVE");
            System.out.println("2 SAVE ALL");
            System.out.println("3 DELETE");
            System.out.println("4 DELETE ALL");
            System.out.println("5 GET ALL");
            System.out.println("6 UPDATE");
            System.out.println("7 GROUPING");
            System.out.println("8 SORT");
            int i = new Scanner(System.in).nextInt();
            switch (i){
                case 1->System.out.println(laptopService.saveProgrammer(scan()));
                case 2->System.out.println(laptopService.saveAll(laptops));
                case 3->System.out.println(laptopService.deleteById(getId()));
                case 4 ->laptopService.deleteAll();
                case 5->System.out.println(laptopService.findAll());
                case 6->System.out.println(laptopService.update(getId(), scan()));
                case 7-> System.out.println(laptopService.groupBy());
                case 8->{
                    System.out.println("Enter column: (id/brand/operatingSystem/memory/price/dateOfIssue)");
                    String column = new Scanner(System.in).nextLine();
                    System.out.println("Ascending or descending (asc/desc): ");
                    String ascOrDesc = new Scanner(System.in).nextLine();
                    System.out.println(laptopService.sortByDifferentColumn(column.toLowerCase(),ascOrDesc));
                }

            }
        }
    }
    public static Long getId(){
        System.out.println("Enter ID: ");
        Long id = new Scanner(System.in).nextLong();
        return id;
    }
    public static Laptop scan(){
        try {
            System.out.println("Enter brand: ");
            String brand = new Scanner(System.in).nextLine();
            System.out.println("Enter operating system: ");
            String system = new Scanner(System.in).nextLine();
            System.out.println("Enter memory: ");
            double memory = new Scanner(System.in).nextDouble();
            System.out.println("Enter price: ");
            int price = new Scanner(System.in).nextInt();
            System.out.println("Enter date of issue: (DD/MM/YYYY)");
            String date = new Scanner(System.in).nextLine();
            String[] split = date.split("/");
            Laptop laptop = new Laptop(brand, OperatingSystem.valueOf(system.toUpperCase()), memory, price, LocalDate.of(Integer.parseInt(split[2]), Integer.parseInt(split[1]), Integer.parseInt(split[0])));
            return laptop;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
