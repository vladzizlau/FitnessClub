package by.pvt.core.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


//Стратегия 1
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Table(schema = "guest", name = "user")
//Стратегия 2
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@MappedSuperclass
//Стратегия 3

@Getter
@Setter
//@Inheritance(strategy = InheritanceType.JOINED)
@Table(schema = "guest", name = "client")
@Entity
public class Client implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "sur_name")
    private String surName;
    private Integer age;
    @Column(name = "phone_number", length = 50)
    private String phoneNumber;
    private String login;
    private String password;

    private String status;
    @Column(name = "amount_sum")
    private BigDecimal amountSum;
    @Column(name = "first_visit_date", length = 30)
    private LocalDate firstVisitDate;
    @Column(name = "last_visit_date", length = 30)
    private LocalDate lastVisitDate;
    private String role;

    @OneToMany
    @JoinColumn(name = "visits_id")
    private List<Visits> visits;
    @Embedded
    private Adress adress;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return getPassword();
    }

    @Override
    public String getUsername() {
        return firstName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
