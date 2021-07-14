package com.joshua.service;

import com.joshua.domain.ManyToMany.Customer;
import com.joshua.domain.ManyToMany.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class ManyToMany_Service {
    private final EntityManager em;

    @Transactional
    public void manyTomany () {
        Product product = new Product();
        product.setProductName("제품테스트");
        em.persist(product);

        Customer customer = new Customer();
        customer.setCustomerName("고객테스트");

        //양방향으로 서로 객체 추가
        customer.getProducts().add(product);
        product.getCustomers().add(customer);

        em.persist(customer);

    }

    public void manyTomany_find () {
        Product product = em.find(Product.class, 1L);
        Customer customer = em.find(Customer.class, 1L);

        System.out.println(customer.getProducts().get(0).getProductName());
    }
}
