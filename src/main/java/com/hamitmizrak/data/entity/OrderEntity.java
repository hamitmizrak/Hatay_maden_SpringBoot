package com.hamitmizrak.data.entity;

import com.hamitmizrak.audit.AuditingAwareBaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2

// ENTITY
@Entity(name = "Orders") // JPQL için kullanılacak varlıklar için özelleştirme için
@Table(name = "orders") // Database tablo adı

// Customer(1) - Address(1)
public class OrderEntity extends AuditingAwareBaseEntity {

    // FIELD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FIRST NAME
    private String name;

    // LASTNAME
    private String price;

    // DATE
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "system_created_date")
    private Date systemCreatedDate;

    // RELATION
    // Order(N) - Customer(1)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id", referencedColumnName = "id",unique=true)
    private CustomerEntity customerOrderEntity;

} //end  CustomerEntity

