package org.rmc.coches.model.entity;

import java.io.Serializable;
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
import jakarta.persistence.JoinColumn;
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

    private String nombre;

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
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @JsonIgnoreProperties(value = {"coche"}, allowSetters = true)
    @OneToMany(mappedBy = "precio", fetch = FetchType.LAZY, cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Precio> precios;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Extra> extras;

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
        this.modifyAt = new Date();
    }
    
    public void update(Coche other) {
        this.nombre = other.nombre;
        this.color = other.color;
        this.cilindrada = other.cilindrada;
        this.potencia = other.potencia;
        this.modifyAt = new Date();
    }

}
