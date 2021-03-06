package com.incloud.tgestiona.b2b.model.isis;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.b2b.model.Identifiable;
import com.incloud.tgestiona.b2b.model.IdentifiableHashBuilder;
import com.incloud.tgestiona.domain.BaseDomain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.logging.Logger;

import static javax.persistence.GenerationType.SEQUENCE;
@Entity
@Table(name = "i_equipo", schema = "isis")
public class IsisEquipo extends BaseDomain implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(IsisEquipo.class.getName());

    /***************************/
    /* Atributos de la Entidad */
    /***************************/

    // Raw attributes
    private Integer id;
    private Integer codigoIsis;
    private String b2bDedescripcion;
    private Integer codMarcEqui;
    private String indEqui;
    private String madesmar;

    @Override
    public String entityClassName() {
        return IsisEquipo.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "equipo_id", precision = 10)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_equipo")
    @Id
    @SequenceGenerator(name = "seq_equipo", sequenceName = "seq_equipo", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public IsisEquipo id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [codigoIsis] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "codigo_isis", precision = 10)
    public Integer getCodigoIsis() {
        return codigoIsis;
    }

    public void setCodigoIsis(Integer codigoIsis) {
        this.codigoIsis = codigoIsis;
    }

    public IsisEquipo codigoIsis(Integer codigoIsis) {
        setCodigoIsis(codigoIsis);
        return this;
    }
    // -- [b2bDedescripcion] ------------------------

    @Size(max = 200, message = "{message.equipo.b2bDedescripcion.sizeMax} {max} {message.caracter}")
    @Column(name = "b2b_dedescripcion", length = 200)
    public String getB2bDedescripcion() {
        return b2bDedescripcion;
    }

    public void setB2bDedescripcion(String b2bDedescripcion) {
        this.b2bDedescripcion = b2bDedescripcion;
    }

    public IsisEquipo b2bDedescripcion(String b2bDedescripcion) {
        setB2bDedescripcion(b2bDedescripcion);
        return this;
    }
    // -- [codMarcEqui] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "cod_marc_equi", precision = 10)
    public Integer getCodMarcEqui() {
        return codMarcEqui;
    }

    public void setCodMarcEqui(Integer codMarcEqui) {
        this.codMarcEqui = codMarcEqui;
    }

    public IsisEquipo codMarcEqui(Integer codMarcEqui) {
        setCodMarcEqui(codMarcEqui);
        return this;
    }
    // -- [indEqui] ------------------------

    @Size(max = 2, message = "{message.equipo.indEqui.sizeMax} {max} {message.caracter}")
    @Column(name = "ind_equi", length = 2)
    public String getIndEqui() {
        return indEqui;
    }

    public void setIndEqui(String indEqui) {
        this.indEqui = indEqui;
    }

    public IsisEquipo indEqui(String indEqui) {
        setIndEqui(indEqui);
        return this;
    }
    // -- [madesmar] ------------------------

    @Size(max = 20, message = "{message.equipo.madesmar.sizeMax} {max} {message.caracter}")
    @Column(name = "madesmar", length = 20)
    public String getMadesmar() {
        return madesmar;
    }

    public void setMadesmar(String madesmar) {
        this.madesmar = madesmar;
    }

    public IsisEquipo madesmar(String madesmar) {
        setMadesmar(madesmar);
        return this;
    }

    /**
     * Apply the default values.
     */
    public IsisEquipo withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof IsisEquipo && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Equipo instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("codigoIsis", getCodigoIsis()) //
                .add("b2bDedescripcion", getB2bDedescripcion()) //
                .add("codMarcEqui", getCodMarcEqui()) //
                .add("indEqui", getIndEqui()) //
                .add("madesmar", getMadesmar()) //
                .toString();
    }
}
