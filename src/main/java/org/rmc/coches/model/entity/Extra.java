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
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "extras")
public class Extra implements Serializable {

    private static final long serialVersionUID = 297957821775872L;

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

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
        this.modifyAt = new Date();
    }
    
    public void update(Extra other) {
        this.nombre = other.nombre;
        this.modifyAt = new Date();
    }

}
