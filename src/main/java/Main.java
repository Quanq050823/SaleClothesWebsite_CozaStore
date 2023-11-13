import entity.CustomerEntity;
import entity.CustomeraccountEntity;
import entity.ProductsEntity;
import entity.StyleEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {

////            ------INSERT------
            transaction.begin();

            List<ProductsEntity> list = new ArrayList<>();
            TypedQuery<ProductsEntity> ListAllProduct = entityManager.createNamedQuery("ListAllProduct", ProductsEntity.class);
            try {
                for (ProductsEntity productsEntity : ListAllProduct.getResultList()) {
//                    list.add(ProductsEntity(productsEntity.getProductId(), productsEntity.getProductName()));
                }
                System.out.println(list);
            }catch (Exception e) {

            }

//            CustomeraccountEntity quang = new CustomeraccountEntity();
//            BigDecimal bd = new BigDecimal(0.00);
//            quang.setMail("qauang@123");
//            quang.setPwd("123");
//            quang.setTotalPayment(bd);
//            entityManager.persist(quang);


//            -------ExecuteQueryWrittren-------
//            transaction.begin();
//
//            TypedQuery<CustomerEntity> CustomerByFirstName = entityManager.createNamedQuery("CustomerbyFirstname", CustomerEntity.class);
//            CustomerByFirstName.setParameter(1, "Quang");
//            for (CustomerEntity customerEntity : CustomerByFirstName.getResultList()) {
//                System.out.println(customerEntity);
//            }

            //--------ExecuteSQLQUery------
//              transaction.begin();
//
//              Query countQuang = entityManager.createNativeQuery("SELECT COUNT(*) AS QuangCount FROM customer WHERE firstName =:customername");
//              countQuang.setParameter("customername", "Quang");
//              System.out.println("Có tất cả " + countQuang.getSingleResult() + " Thằng khách tên Quang");



            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }
    }
}