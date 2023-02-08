package org.rmc.coches.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "marcas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Marca implements Serializable {

    private static final long serialVersionUID = 8596963228385280L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "modify_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyAt;

    @JsonIgnoreProperties(value = {"marca"}, allowSetters = true)
    @OneToMany(mappedBy = "marca", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coche> coches = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
        this.modifyAt = new Date();
    }

    public void addCoche(Coche coche) {
        this.coches.add(coche);
        coche.setMarca(this);
    }

    public void removeCoche(Coche coche) {
        this.coches.remove(coche);
        coche.setMarca(null);
    }

    public void update(Marca other) {
        this.nombre = other.nombre;
        this.modifyAt = new Date();
    }

}
