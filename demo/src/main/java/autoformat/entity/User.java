package autoformat.entity;

import jakarta.persistence.*;
import autoformat.annotation.Format;
import autoformat.listeners.FormattingListenerEntity;

@Entity
@Table(name = "users")
@EntityListeners(FormattingListenerEntity.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Format(type = "cpf")
    private String cpf;

    //@Format(type = "phone")
    //private String phone;

    //@Format(type = "currency")
    //private String price;
    

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //public String getPhone() {
    //    return phone;
    //}

    //public void setPhone(String phone) {
    //    this.phone = phone;
    //}

    //public String getPrice() {
    //    return price;
    //}

    //public void setPrice(String price) {
    //    this.price = price;
    //}
}