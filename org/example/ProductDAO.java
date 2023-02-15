package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements Repository{
    private Connection conn;
    public ProductDAO(){}
    public void setConnection (String dbname, String user, String pass){
        try
        {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Object add(Object item) {
        String sql = "insert into product (id, nameProduct, price) values (?, ?, ?)";
        PreparedStatement ptm = null;
        try {
             ptm = (PreparedStatement) conn.prepareStatement(sql);
            if(item instanceof Product)
            {
                ptm.setString(1,((Product) item).getId());
                ptm.setString(2, ((Product) item).getName());
                ptm.setDouble(3, ((Product) item).getPrice());
                ptm.executeUpdate();
                System.out.println("Add into database successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ptm != null)
            {
                try {
                    ptm.close();
                }catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return item;
    }

    @Override
    public List readAll() {
        String sql = "SELECT * FROM product;";
        List<Product> productList = new ArrayList<>();
        Statement stm = null;
        ResultSet data = null;
        try {
            stm = (Statement) conn.createStatement();
            data = stm.executeQuery(sql);
            while(data.next())
            {
                String id = data.getString(1);
                String name =data.getString(2);
                double price = data.getDouble(3);
                Product product = new Product(id, name, price);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(data != null)
            {
                try {
                    data.close();
                }catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if(stm != null)
            {
                try {
                    stm.close();
                }catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return productList;
    }

    @Override
    public Object read(Object id) {
        Product product = new Product();
        PreparedStatement ptm = null;
        ResultSet data = null;
        if(id instanceof String)
        {
            String sql = "select * from product where id = ? ";
            try {
                ptm = (PreparedStatement) conn.prepareStatement(sql);
                ptm.setString(1, ((String) id));
                data = ptm.executeQuery();
                while(data.next())
                {
                    product.setId(data.getString("id"));
                    product.setName(data.getString("nameProduct"));
                    product.setPrice(data.getDouble("price"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(data != null)
                {
                    try {
                        data.close();
                    }catch(SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
                if(ptm != null)
                {
                    try {
                        ptm.close();
                    }catch(SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }

        return product;
    }

    @Override
    public boolean update(Object item) {
        PreparedStatement ptm = null;
        if(item instanceof Product)
        {
            String sql = "update product set" + " nameProduct = ?, price = ? where id = ? ";
            try {
                ptm = (PreparedStatement) conn.prepareStatement(sql);
                ptm.setString(3, ((Product) item).getId());
                ptm.setString(1, ((Product) item).getName());
                ptm.setDouble(2, ((Product) item).getPrice());
                ptm.executeUpdate();
                ptm.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(ptm != null)
                {
                    try {
                        ptm.close();
                    }catch(SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean delete(Object id) {
        PreparedStatement ptm = null;
        if(id instanceof String)
        {
            try {
                String sql = "delete from product where id = ? ";
                ptm = (PreparedStatement) conn.prepareStatement(sql);
                ptm.setString(1, ((String) id));
                ptm.executeUpdate();
                ptm.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(ptm != null)
                {
                    try {
                        ptm.close();
                    }catch(SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }
    public void closeConnection() {
        try {
            if (conn!=null) {
                conn.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
