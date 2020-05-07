package com.incloud.tgestiona.b2b.model;


import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.incloud.tgestiona.domain.BaseDomain;
import org.hibernate.validator.constraints.NotEmpty;
import com.google.common.base.MoreObjects;

/**
 * Adjunto Documento
 */
@Entity
@Table(name = "adjunto")
//@Audited
//@AuditTable("_audi_adjunto")
public class Adjunto extends BaseDomain implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Adjunto.class.getName());

    /***************************/
    /* Atributos de la Entidad */
    /***************************/

    // Raw attributes
    private Integer id;
    private String carpetaId;
    private String archivoId;
    private String archivoNombre;
    private String archivoTipo;
    private String rutaCatalogo;
    private String tipoAdjunto;
    private String adjuntoUsuario;

    @Override
    public String entityClassName() {
        return Adjunto.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "adjunto_id", precision = 10)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_adjunto")
    @Id
    @SequenceGenerator(name = "seq_adjunto", sequenceName = "seq_adjunto", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Adjunto id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [carpetaId] ------------------------

    @NotEmpty(message = "{message.adjunto.carpetaId.requerido}")
    @Size(max = 60, message = "{message.adjunto.carpetaId.sizeMax} {max} {message.caracter}")
    @Column(name = "carpeta_id", nullable = false, length = 60)
    public String getCarpetaId() {
        return carpetaId;
    }

    public void setCarpetaId(String carpetaId) {
        this.carpetaId = carpetaId;
    }

    public Adjunto carpetaId(String carpetaId) {
        setCarpetaId(carpetaId);
        return this;
    }
    // -- [archivoId] ------------------------

    @NotEmpty(message = "{message.adjunto.archivoId.requerido}")
    @Size(max = 60, message = "{message.adjunto.archivoId.sizeMax} {max} {message.caracter}")
    @Column(name = "archivo_id", nullable = false, length = 60)
    public String getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(String archivoId) {
        this.archivoId = archivoId;
    }

    public Adjunto archivoId(String archivoId) {
        setArchivoId(archivoId);
        return this;
    }
    // -- [archivoNombre] ------------------------

    @NotEmpty(message = "{message.adjunto.archivoNombre.requerido}")
    @Size(max = 250, message = "{message.adjunto.archivoNombre.sizeMax} {max} {message.caracter}")
    @Column(name = "archivo_nombre", nullable = false)
    public String getArchivoNombre() {
        return archivoNombre;
    }

    public void setArchivoNombre(String archivoNombre) {
        this.archivoNombre = archivoNombre;
    }

    public Adjunto archivoNombre(String archivoNombre) {
        setArchivoNombre(archivoNombre);
        return this;
    }
    // -- [archivoTipo] ------------------------

    @NotEmpty(message = "{message.adjunto.archivoTipo.requerido}")
    @Size(max = 100, message = "{message.adjunto.archivoTipo.sizeMax} {max} {message.caracter}")
    @Column(name = "archivo_tipo", nullable = false, length = 100)
    public String getArchivoTipo() {
        return archivoTipo;
    }

    public void setArchivoTipo(String archivoTipo) {
        this.archivoTipo = archivoTipo;
    }

    public Adjunto archivoTipo(String archivoTipo) {
        setArchivoTipo(archivoTipo);
        return this;
    }
    // -- [rutaCatalogo] ------------------------

    @NotEmpty(message = "{message.adjunto.rutaCatalogo.requerido}")
    @Size(max = 1000, message = "{message.adjunto.rutaCatalogo.sizeMax} {max} {message.caracter}")
    @Column(name = "ruta_catalogo", nullable = false, length = 1000)
    public String getRutaCatalogo() {
        return rutaCatalogo;
    }

    public void setRutaCatalogo(String rutaCatalogo) {
        this.rutaCatalogo = rutaCatalogo;
    }

    public Adjunto rutaCatalogo(String rutaCatalogo) {
        setRutaCatalogo(rutaCatalogo);
        return this;
    }
    // -- [tipoAdjunto] ------------------------

    @NotEmpty(message = "{message.adjunto.tipoAdjunto.requerido}")
    @Size(max = 10, message = "{message.adjunto.tipoAdjunto.sizeMax} {max} {message.caracter}")
    @Column(name = "tipo_adjunto", nullable = false, length = 10)
    public String getTipoAdjunto() {
        return tipoAdjunto;
    }

    public void setTipoAdjunto(String tipoAdjunto) {
        this.tipoAdjunto = tipoAdjunto;
    }

    public Adjunto tipoAdjunto(String tipoAdjunto) {
        setTipoAdjunto(tipoAdjunto);
        return this;
    }
    // -- [adjuntoUsuario] ------------------------

    @Size(max = 30, message = "{message.adjunto.adjuntoUsuario.sizeMax} {max} {message.caracter}")
    @Column(name = "adjunto_usuario", length = 1)
    public String getAdjuntoUsuario() {
        return adjuntoUsuario;
    }

    public void setAdjuntoUsuario(String adjuntoUsuario) {
        this.adjuntoUsuario = adjuntoUsuario;
    }

    public Adjunto adjuntoUsuario(String adjuntoUsuario) {
        setAdjuntoUsuario(adjuntoUsuario);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Adjunto withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Adjunto && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Adjunto instance.
     *
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("carpetaId", getCarpetaId()) //
                .add("archivoId", getArchivoId()) //
                .add("archivoNombre", getArchivoNombre()) //
                .add("archivoTipo", getArchivoTipo()) //
                .add("rutaCatalogo", getRutaCatalogo()) //
                .add("tipoAdjunto", getTipoAdjunto()) //
                .add("adjuntoUsuario", getAdjuntoUsuario()) //
                .toString();
    }
}
