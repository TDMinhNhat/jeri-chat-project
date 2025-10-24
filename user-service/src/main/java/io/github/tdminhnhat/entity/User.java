package io.github.tdminhnhat.entity;

import io.github.tdminhnhat.enums.UserGender;
import io.github.tdminhnhat.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity @Table(name = "users")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class User extends BaseEntityJPA {

    @Column(name = "code", length = 30, unique = true, nullable = false)
    @NonNull
    private String code;

    @Column(name = "first_name", length = 50, nullable = false)
    @NonNull
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    @NonNull
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 50, nullable = false)
    @NonNull
    private UserGender gender;

    @Column(name = "birth_date", nullable = false)
    @NonNull
    private LocalDate birthDate;

    @Column(name = "phone_number", length = 30, unique = true, nullable = false)
    @NonNull
    private String phoneNumber;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_id", nullable = false)
    @NonNull
    private UserRole role;

    @Column(name = "display_name", length = 100, nullable = false)
    @NonNull
    private String displayName;

    @Column(name = "email", length = 200, unique = true, nullable = false)
    @NonNull
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    @NonNull
    private String password;

    public User(@NonNull String code, @NonNull String firstName, @NonNull String lastName, @NonNull UserGender gender, @NonNull LocalDate birthDate, @NonNull String phoneNumber, Address address, @NonNull UserRole role, @NonNull String displayName, @NonNull String email, @NonNull String password) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
        this.displayName = displayName;
        this.email = email;
        this.password = password;
    }
}
