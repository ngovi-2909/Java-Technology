package lab3.tdtu;

import dao.ManufactureDAO;
import dao.PhoneDAO;

import java.util.List;

public class PhoneFactory {
    private PhoneDAO phoneDao;
    private ManufactureDAO manufactureDao;
    public PhoneFactory()
    {
        this.phoneDao = new PhoneDAO();
        this.manufactureDao = new ManufactureDAO();
    }
    private void addPhone()
    {
        Phone phone1 = new Phone(1L, "Iphone", 200000000.00, "Pink", "US", 100);
        Phone phone2 = new Phone(2L, "Galaxy", 150000000.00, "Pink", "Korea", 500);
        Phone phone3 = new Phone(3L, "Xiaomi", 50000000.00, "Black", "China", 1000);
        Phone phone4 = new Phone(4L, "IPhone7", 5200000.00, "Black", "US", 100);
        phoneDao.add(phone1);
        phoneDao.add(phone2);
        phoneDao.add(phone3);
        phoneDao.add(phone4);
    }
    private void addManufacture()
    {
        Manufacture manufacture1 = new Manufacture(1L, "Apple", "LA", 100000);
        Manufacture manufacture2 = new Manufacture(2L, "Samsung", "Suwon-si", 200000);
        Manufacture manufacture3 = new Manufacture(3L, "Xiaomi", "Beijing", 500000);
        manufactureDao.add(manufacture1);
        manufactureDao.add(manufacture2);
        manufactureDao.add(manufacture3);
    }
    private void getAllPhone()
    {
        System.out.println("----------------List of Phones----------------");
        phoneDao.getAll().forEach(c->System.out.println(c.toString()));
    }
    private Phone getPhoneByID(Long id)
    {
        Phone item = phoneDao.get(id);
        if(item !=null)
        {
            System.out.println( "----------------Get Phone By ID----------------\n"+ item.toString());
            return item;
        }
        return null;
    }
    private void updatePhone(Phone item)
    {
        boolean check = phoneDao.update(item);
        System.out.println("Update Phone ---> " + check);
    }
    private void removePhone(Phone item)
    {
        if(item !=null)
        {
            boolean check = phoneDao.remove(item);
            System.out.println("Remove Phone with ID " + item.getID() + "---> " + check);
        }else
        {
            System.out.println("Cannot remove phone");
        }
    }
    private void removePhoneById(Long id)
    {
        boolean check = phoneDao.removeById(id);
        System.out.println("Remove Phone By Id " + id + "---> " + check);
    }
    private void getAllManuFacture()
    {
        System.out.println("----------------List of Manufactures----------------");
        manufactureDao.getAll().forEach(c->System.out.println(c.toString()));
    }
    private Manufacture getManufactureById(Long id)
    {
        Manufacture item = manufactureDao.get(id);
        if(item !=null)
        {
            System.out.println("----------------Get Manufacture By ID----------------\n" + item.toString());
            return item;
        }
        return null;
    }
    private void removeManufacture(Manufacture item)
    {
        if(item !=null) {
            boolean check = manufactureDao.remove(item);
            System.out.println("Remove Manufacture ---> " + check);
        }else
        {
            System.out.println("Cannot remove manufacture");
        }
    }
    private void removeManufactureById(Long id)
    {
        boolean check = manufactureDao.removeById(id);
        System.out.println("Remove Manufacture By ID ---> " + check);
    }
    private void updateManufacture (Manufacture item)
    {
        boolean check = manufactureDao.update(item);
        System.out.println("Update Manufacture ---> " + check);
    }
    private void getHighestPriceOfPhone()
    {
        List<Phone> items = phoneDao.getHighestPrice();
        items.forEach(c->System.out.println(c.toString()));
    }
    private void getPriceGreaterThan50MilOfPhone()
    {
        List<Phone> items = phoneDao.priceHighestThan50Mil();
        items.forEach(c->System.out.println(c.toString()));
    }
    private void sortByNameOfPhone()
    {
        List<Phone> items = phoneDao.sortByName();
        items.forEach(c->System.out.println(c.toString()));
    }
    private void colorPink_GreaterThan15Mil()
    {
        List<Phone> items = phoneDao.phoneWithPink_andGreater15Mil();
        items.forEach(c->System.out.println(c.toString()));
    }
    private void checkEmployeesGreaterThan100()
    {
        List<Manufacture> items = manufactureDao.checkEmployees();
        items.forEach(c->System.out.println(c.toString()));
    }
    private void totalOfEmployees() throws Exception {
        List<Integer> items = manufactureDao.sumaryEmployees();
        items.forEach(c->System.out.println(c.toString()));
    }
    private void manufacturersInUs() throws Exception
    {
        List<Manufacture> items = manufactureDao.getLastManufactuterInUS();
        if(!items.isEmpty())
        {
            items.forEach(c->System.out.println(c.toString()));
        }else
        {
            throw new Exception("InvalidOperationException");
        }
    }
    private void initData() throws Exception {
        addManufacture();
        addPhone();
        //getAllPhone();
        //getPhoneByID(2L);
        //removePhone(getPhoneByID(1L));
        //removePhoneById(3L);
        //updatePhone(new Phone(1L, "IphoneX", 20050.0, "Black", "US", 100));
        //getHighestPriceOfPhone();
        //sortByNameOfPhone();
        //getPriceGreaterThan50MilOfPhone();
        //colorPink_GreaterThan15Mil();

        //getAllManuFacture();
        //getManufactureById(1L);
        //removeManufacture(getManufactureById(1L));
        //removeManufactureById(2L);
        //updateManufacture(new Manufacture(1L, "Apple", "New Zealand", 200000));
        //checkEmployeesGreaterThan100();
        totalOfEmployees();
        manufacturersInUs();
    }
    public static void main(String[] args) throws Exception {
        PhoneFactory phoneFactory = new PhoneFactory();
        phoneFactory.initData();
    }
}
