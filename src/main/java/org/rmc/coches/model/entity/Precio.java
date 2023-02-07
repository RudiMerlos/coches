package org.rmc.coches.model.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "precios")
public class Precio implements Serializable {

    private static final long serialVersionUID = 3246152291975168L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private Double cantidad;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "modify_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyAt;

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
        this.modifyAt = new Date();
    }
    
    public void update(Precio other) {
        this.cantidad = other.cantidad;
        this.fechaInicio = other.fechaInicio;
        this.fechaFin = other.fechaFin;
        this.modifyAt = new Date();
    }

}
