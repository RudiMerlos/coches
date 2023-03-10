package org.rmc.coches.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "coches")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Coche implements Serializable {

    private static final long serialVersionUID = 5068591135195136L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String modelo;

    private String color;

    private Integer cilindrada;

    private Integer potencia;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "modify_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyAt;

    @JsonIgnoreProperties(value = {"coches"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Precio> precios = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Extra> extras = new ArrayList<>();

    public String getExtras() {
        StringBuilder result = new StringBuilder();
        this.extras.forEach(e -> {
            result.append(e.getNombre() + ", ");
        });
        if (!result.isEmpty())
            result.replace(result.lastIndexOf(","), result.length(), "");
        return result.toString();
    }

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
        this.modifyAt = new Date();
    }

    public void addPrecio(Precio precio) {
        this.precios.add(precio);
    }

    public void removePrecio(Precio precio) {
        this.precios.remove(precio);
    }

    public void addExtra(Extra extra) {
        this.extras.add(extra);
    }

    public void removeExtra(Extra extra) {
        this.extras.remove(extra);
    }

    public void update(Coche other) {
        this.modelo = other.modelo;
        this.color = other.color;
        this.cilindrada = other.cilindrada;
        this.potencia = other.potencia;
        this.modifyAt = new Date();
    }

}
