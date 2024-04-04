package org.example.storage.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "supplies")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name",nullable = false)
    @Setter
    private String name;
    @Column(name = "username")
    @Setter
    private String username;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supply supply = (Supply) o;
        return Objects.equals(id, supply.id) && Objects.equals(name, supply.name) && Objects.equals(username, supply.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username);
    }
}
