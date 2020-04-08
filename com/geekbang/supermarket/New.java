package com.geekbang.supermarket;

import com.geekbang.supermarket.impl.SimpleMerchandise;
import com.geekbang.supermarket.interfaces.Category;
import com.geekbang.supermarket.interfaces.Customer;
import com.geekbang.supermarket.interfaces.Merchandise;
import com.geekbang.supermarket.interfaces.SuperMarket;

import static com.geekbang.supermarket.util.ShoppingUtil.*;

public class New {
    public static void main(String[] args) {
        SuperMarket superMarket = createSuperMarket();

//        new ShoppingTask(shopman).executeTask();
        Customer customer = createCustomer(true);
        Category category = customer.chooseCategory();
//        System.out.println(category.name());
        Merchandise[] toChoose = superMarket.getRandomMerchandiseOfCategory(category);
        System.out.println("the lenght is" + toChoose.length);
        for(Merchandise merchandise: toChoose){
            System.out.println("name is" + merchandise.getName());
            System.out.println("category is " + merchandise.getCategory());
            System.out.println("1" + "\t"+ "1");
        }
    }
}
