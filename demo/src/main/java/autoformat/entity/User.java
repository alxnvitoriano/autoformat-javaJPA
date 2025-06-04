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

    @Format(type = "phone")
    private String phone;
    

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}