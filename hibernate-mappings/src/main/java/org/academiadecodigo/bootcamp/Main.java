package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.component.Address;
import org.academiadecodigo.bootcamp.component.Customer;
import org.academiadecodigo.bootcamp.inheritance.Boat;
import org.academiadecodigo.bootcamp.inheritance.Car;
import org.academiadecodigo.bootcamp.many_to_many.SecurityGroup;
import org.academiadecodigo.bootcamp.many_to_many.Users;
import org.academiadecodigo.bootcamp.many_to_one.Owner;
import org.academiadecodigo.bootcamp.many_to_one.OwnerCar;
import org.academiadecodigo.bootcamp.one_to_many.Category;
import org.academiadecodigo.bootcamp.one_to_many.Product;
import org.academiadecodigo.bootcamp.one_to_one.OneOwner;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by codecadet on 04/07/16.
 */
public class Main {

    public static void main(String[] args) {

        HibernateSessionManager hibernateSessionManager = HibernateSessionManager.getInstance();

        try {

            Session session = hibernateSessionManager.beginTransaction();

            //Component-------------
            Address address = new Address();
            address.setStreet("Rua da Prata");
            address.setNumber("81");
            address.setCity("Lisbon");
            Customer customer = new Customer();
            customer.setName("Academia de Codigo");
            customer.setAddress(address);
            session.save(customer);
            //----------------------


            //Inheritance------------
            Boat b = new Boat();
            b.setName("My shiny new boat");
            b.setSpeed(50);
            b.setEngines(2);
            Car c = new Car();
            c.setName("Range Rover");
            c.setSpeed(200);
            c.setGears(6);
            session.save(b);
            session.save(c);
            //-----------------------


            //Many-to-One------------
            Owner o  = new Owner();
            o.setName("Rui");

            OwnerCar c1 = new OwnerCar();
            c1.setName("Fiat");
            c1.setOwner(o);

            OwnerCar c2 = new OwnerCar();
            c2.setName("Renault");
            c2.setOwner(o);

            session.save(c1);
            session.save(c2);
            //-----------------------


            //One-to-One-------------
            OneOwner one  = new OneOwner();
            one.setName("Ze");

            OwnerCar c3 = new OwnerCar();
            c3.setName("Carro do Ze");
            c3.setOwner(o);

            session.save(c3);
            //-----------------------


            //One-to-Many------------
            Product p1 = new Product();
            p1.setProductName("iMac");
            Product p2 = new Product();
            p2.setProductName("MacBook");

            Set<Product> products = new HashSet<Product>();
            products.add(p1);
            products.add(p2);

            Category cat = new Category();
            cat.setCategoryName("Apple Computers");
            cat.setProducts(products);
            session.save(cat);
            //-----------------------


            //Many-to-Many-----------
            Users u1 = new Users();
            u1.setUsername("rui");
            u1.setPassword("123");
            Users u2 = new Users();
            u2.setUsername("catarina");
            u2.setPassword("321");

            Set<Users> userses = new HashSet<Users>();
            userses.add(u1);
            userses.add(u2);

            SecurityGroup g1 = new SecurityGroup();
            g1.setName("master-coders");
            g1.setUserses(userses);
            SecurityGroup g2 = new SecurityGroup();
            g2.setName("staff");
            g2.setUserses(userses);

            session.save(g1);
            session.save(g2);
            //-----------------------


            //Bidirectional----------

            //-----------------------


            hibernateSessionManager.commitTransaction();

        } catch (HibernateException ex) {

            System.out.println(ex.getMessage());
            hibernateSessionManager.rollbackTransaction();

        }

        hibernateSessionManager.close();
    }
}
