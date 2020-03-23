package com.tenpo.demo.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;


@Entity
@Table(name="audit_math_operation", schema="public")
public class MathOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="input_1")
    private BigDecimal input1;

    @Column(name="input_2")
    private BigDecimal input2;

    @Column(name="sum")
    private BigDecimal sum;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date updatedDt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getInput1() {
        return input1;
    }

    public void setInput1(BigDecimal input1) {
        this.input1 = input1;
    }

    public BigDecimal getInput2() {
        return input2;
    }

    public void setInput2(BigDecimal input2) {
        this.input2 = input2;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Date getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(Date updatedDt) {
        this.updatedDt = updatedDt;
    }
}
