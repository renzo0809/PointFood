package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="dish_extras")
public class DishExtra implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_detail_id", nullable = false)
    private OrderDetail orderDetail;

    @ManyToOne
    @JoinColumn(name = "extra_id", nullable = false)
    private Extra extra;

    @Min(1)
    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "subTotal", precision = 5, scale =  2, nullable = false)
    private double subTotal;
}
