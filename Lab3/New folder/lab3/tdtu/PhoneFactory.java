package lab3.tdtu;

import dao.ManufactureDAO;
import dao.PhoneDAO;

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
        Phone phone1 = new Phone("1", "Iphone", 1000.00, "White", "US", 100);
        Phone phone2 = new Phone("2", "Galaxy", 1000.00, "Black", "Korea", 500);
        Phone phone3 = new Phone("3", "Xiaomi", 500.00, "Black", "China", 1000);
        phoneDao.add(phone1);
        phoneDao.add(phone2);
        phoneDao.add(phone3);
    }
    private void addManufacture()
    {
        Manufacture manufacture1 = new Manufacture("1", "Apple", "LA", 100000);
        Manufacture manufacture2 = new Manufacture("2", "Samsung", "Suwon-si", 200000);
        Manufacture manufacture3 = new Manufacture("3", "Xiaomi", "Beijing", 500000);
        manufactureDao.add(manufacture1);
        manufactureDao.add(manufacture2);
        manufactureDao.add(manufacture3);
    }
    private void initData()
    {
        addManufacture();
        addPhone();
    }
    public static void main(String[] args)
    {
        PhoneFactory phoneFactory = new PhoneFactory();
        phoneFactory.initData();
    }
}
