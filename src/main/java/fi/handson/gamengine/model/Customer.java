package fi.handson.gamengine.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Entity(name = "customers")
@Table(name = "customers")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Double accountBalanace;



}
