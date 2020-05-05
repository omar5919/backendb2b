package com.incloud.tgestiona.b2b.model.isis;

import com.incloud.tgestiona.b2b.model.Cliente;
import com.incloud.tgestiona.b2b.model.Identifiable;
import com.incloud.tgestiona.b2b.model.IdentifiableHashBuilder;
import com.incloud.tgestiona.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.logging.Logger;

import static javax.persistence.GenerationType.SEQUENCE;
@Entity
@Table(name = "i_cliente", schema = "isis")
public class IsisCliente extends BaseDomain implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(IsisCliente.class.getName());

    // Raw attributes
    private Integer id;

    @Override
    public String entityClassName() {
        return IsisCliente.class.getSimpleName();
    }

    @Column(name = "cliente_id", precision = 10)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_isis_cliente")
    @Id
    @SequenceGenerator(name = "seq_isis_cliente", sequenceName = "seq_isis_cliente", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public IsisCliente id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }

    // COMMENT ON COLUMN isis.cliente.clcodapli IS 'Código gran cliente'
    @Column(name = "clcodapli", nullable = true, length = 6, columnDefinition = "char")
    private String clcodapli;

    // COMMENT ON COLUMN isis.cliente.clnomcli IS 'Dato nombre cliente'
    @Column(name = "clnomcli", nullable = true, length = 45, columnDefinition = "char")
    private String clnomcli;

    // COMMENT ON COLUMN isis.cliente.clapecli IS 'Dato apellido cliente'
    @Column(name = "clapecli", nullable = false, length = 45, columnDefinition = "char")
    private String clapecli;

    // COMMENT ON COLUMN isis.cliente.clcodcli IS 'Código fact. cliente'
    @Column(name = "clcodcli", nullable = false, length = 8, columnDefinition = "char")
    private String clcodcli;

    // COMMENT ON COLUMN isis.cliente.gctipdoc IS 'Tipo documento'
    @Column(name = "gctipdoc", nullable = false, length = 2, columnDefinition = "char")
    private String gctipdoc;

    // COMMENT ON COLUMN isis.cliente.gcrucgc IS 'Ruc gran cliente'
    @Column(name = "gcrucgc", nullable = true, length = 15, columnDefinition = "char")
    private String gcrucgc;

    // COMMENT ON COLUMN isis.cliente.gctipgc IS 'Segmento '
    @Column(name = "gctipgc", nullable = false, length = 2, columnDefinition = "char")
    private String gctipgc;

    // COMMENT ON COLUMN isis.accion.gccladat IS 'Sub segmento'
    @Column(name = "gccladat", nullable = false, length = 3, columnDefinition = "char")
    private String gccladat;

    public IsisCliente() {
    }

    public IsisCliente(String clcodapli, String clnomcli, String clapecli, String clcodcli, String gctipdoc, String gcrucgc,
                   String gctipgc, String gccladat) {

        this.clcodapli = clcodapli;
        this.clnomcli = clnomcli;
        this.clapecli = clapecli;
        this.clcodcli = clcodcli;
        this.gctipdoc = gctipdoc;
        this.gcrucgc = gcrucgc;
        this.gctipgc = gctipgc;
        this.gccladat = gccladat;
    }

    public String getClcodapli() {
        return clcodapli;
    }

    public void setClcodapli(String clcodapli) {
        this.clcodapli = clcodapli;
    }

    public String getClnomcli() {
        return clnomcli;
    }

    public void setClnomcli(String clnomcli) {
        this.clnomcli = clnomcli;
    }

    public String getClapecli() {
        return clapecli;
    }

    public void setClapecli(String clapecli) {
        this.clapecli = clapecli;
    }

    public String getClcodcli() {
        return clcodcli;
    }

    public void setClcodcli(String clcodcli) {
        this.clcodcli = clcodcli;
    }

    public String getGctipdoc() {
        return gctipdoc;
    }

    public void setGctipdoc(String gctipdoc) {
        this.gctipdoc = gctipdoc;
    }

    public String getGcrucgc() {
        return gcrucgc;
    }

    public void setGcrucgc(String gcrucgc) {
        this.gcrucgc = gcrucgc;
    }

    public String getGctipgc() {
        return gctipgc;
    }

    public void setGctipgc(String gctipgc) {
        this.gctipgc = gctipgc;
    }

    public String getGccladat() {
        return gccladat;
    }

    public void setGccladat(String gccladat) {
        this.gccladat = gccladat;
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }
}
