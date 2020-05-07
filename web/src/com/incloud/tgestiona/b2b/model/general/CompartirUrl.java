package com.incloud.tgestiona.b2b.model.general;

import com.incloud.tgestiona.b2b.model.Identifiable;
import com.incloud.tgestiona.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compartirurl")
public class CompartirUrl extends BaseDomain implements Identifiable<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compartirurl_id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "codigo",length = 255)
    private String codigo;

    @Column(name = "url",length = 255)
    private String url;

    @Column(name = "data",length = 255)
    private String data;

    @Override
    public String entityClassName() {
        return CompartirUrl.class.getSimpleName();
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean isIdSet() {
        return id != null;
    }
}
