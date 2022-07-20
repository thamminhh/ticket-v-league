package com.example.demo_tss.repository;

import com.example.demo_tss.entity.Match;
import com.example.demo_tss.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByAccountId(int accountId);

    @Query(value = "select MAX(id) from orders", nativeQuery = true)
    int getNewestOrderId();

    @Modifying
    @Query(value = "update orders set status = ? where id = ?", nativeQuery = true)
    void updateOrderStatus(int status, int orderId);


    @Query(value = "select  o.id, o.accountId, a.id, a.firstname, a.lastname, a.username, a.phone, o.orderDate, o.total, o.status \n" +
            "from orders o inner join accounts a on o.accountId = a.id where o.status = '0'",
            countQuery = "select count(*) from orders o inner join accounts a on o.accountId = a.id where o.status = '0'order by o.id;",
            nativeQuery = true)
    Page<Order> findOrderedInfo(Pageable pagingSort);

    @Query(value = "\n" +
            "select  o.id, o.accountId, a.id, a.firstname, a.lastname, a.username, a.phone, o.orderDate, o.total, o.status,\n" +
            "od.id, od.orderId, od.ticketId, od.quantity\n" +
            "from orders o inner join accounts a on o.accountId = a.id \n" +
            "inner join orderDetail od on o.id = od.orderId",
            countQuery = "select count(*) from orders o inner join accounts a on o.accountId = a.id +\n" +
                               "inner join orderDetail od on o.id = od.orderId order by o.id",
            nativeQuery = true)
    Page<Order> findOrderInfo(Pageable pagingSort);
}
