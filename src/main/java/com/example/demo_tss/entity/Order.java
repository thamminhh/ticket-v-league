package com.example.demo_tss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer accountId;
    @ManyToOne( targetEntity = Accounts.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="accountId", referencedColumnName = "id", insertable = false, updatable = false)
    private Accounts account;
    @OneToMany(targetEntity = OrderDetail.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name ="orderId", referencedColumnName = "id")
//   @JsonIgnore
   private List<OrderDetail> orderDetails;
    private String orderDate;
    private double total;
    private int status;
}
