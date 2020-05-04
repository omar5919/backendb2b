package com.incloud.tgestiona.b2b.model.isis;

import com.google.common.base.MoreObjects;
import com.incloud.tgestiona.b2b.model.Identifiable;
import com.incloud.tgestiona.b2b.model.IdentifiableHashBuilder;
import com.incloud.tgestiona.domain.BaseDomain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.logging.Logger;

import static javax.persistence.GenerationType.SEQUENCE;
@Entity
@Table(name = "i_tarifa", schema = "isis")
public class IsisTarifa extends BaseDomain implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(IsisTarifa.class.getName());

    /***************************/
    /* Atributos de la Entidad */
    /***************************/

    // Raw attributes
    private Integer id;
    private String codTari;
    private String desTari;
    private String monto;
    private String montoSolariza;
    private String tipPagoTari;
    private String fecInicTariVige;
    private String fecFinaTariVige;
    private String codCon;
    private String desConc;
    private String codMone;
    private String codGrupDsct;
    private String sec;

    @Override
    public String entityClassName() {
        return IsisTarifa.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "tarifa_id", precision = 10)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_tarifa")
    @Id
    @SequenceGenerator(name = "seq_tarifa", sequenceName = "seq_tarifa", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public IsisTarifa id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [codTari] ------------------------

    @Size(max = 10, message = "{message.tarifa.codTari.sizeMax} {max} {message.caracter}")
    @Column(name = "cod_tari", length = 10)
    public String getCodTari() {
        return codTari;
    }

    public void setCodTari(String codTari) {
        this.codTari = codTari;
    }

    public IsisTarifa codTari(String codTari) {
        setCodTari(codTari);
        return this;
    }
    // -- [desTari] ------------------------

    @Size(max = 200, message = "{message.tarifa.desTari.sizeMax} {max} {message.caracter}")
    @Column(name = "des_tari", length = 200)
    public String getDesTari() {
        return desTari;
    }

    public void setDesTari(String desTari) {
        this.desTari = desTari;
    }

    public IsisTarifa desTari(String desTari) {
        setDesTari(desTari);
        return this;
    }
    // -- [monto] ------------------------

    @Size(max = 15, message = "{message.tarifa.monto.sizeMax} {max} {message.caracter}")
    @Column(name = "monto", length = 15)
    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public IsisTarifa monto(String monto) {
        setMonto(monto);
        return this;
    }
    // -- [montoSolariza] ------------------------

    @Size(max = 15, message = "{message.tarifa.montoSolariza.sizeMax} {max} {message.caracter}")
    @Column(name = "monto_solariza", length = 15)
    public String getMontoSolariza() {
        return montoSolariza;
    }

    public void setMontoSolariza(String montoSolariza) {
        this.montoSolariza = montoSolariza;
    }

    public IsisTarifa montoSolariza(String montoSolariza) {
        setMontoSolariza(montoSolariza);
        return this;
    }
    // -- [tipPagoTari] ------------------------

    @Size(max = 10, message = "{message.tarifa.tipPagoTari.sizeMax} {max} {message.caracter}")
    @Column(name = "tip_pago_tari", length = 10)
    public String getTipPagoTari() {
        return tipPagoTari;
    }

    public void setTipPagoTari(String tipPagoTari) {
        this.tipPagoTari = tipPagoTari;
    }

    public IsisTarifa tipPagoTari(String tipPagoTari) {
        setTipPagoTari(tipPagoTari);
        return this;
    }
    // -- [fecInicTariVige] ------------------------

    @Size(max = 20, message = "{message.tarifa.fecInicTariVige.sizeMax} {max} {message.caracter}")
    @Column(name = "fec_inic_tari_vige", length = 20)
    public String getFecInicTariVige() {
        return fecInicTariVige;
    }

    public void setFecInicTariVige(String fecInicTariVige) {
        this.fecInicTariVige = fecInicTariVige;
    }

    public IsisTarifa fecInicTariVige(String fecInicTariVige) {
        setFecInicTariVige(fecInicTariVige);
        return this;
    }
    // -- [fecFinaTariVige] ------------------------

    @Size(max = 20, message = "{message.tarifa.fecFinaTariVige.sizeMax} {max} {message.caracter}")
    @Column(name = "fec_fina_tari_vige", length = 20)
    public String getFecFinaTariVige() {
        return fecFinaTariVige;
    }

    public void setFecFinaTariVige(String fecFinaTariVige) {
        this.fecFinaTariVige = fecFinaTariVige;
    }

    public IsisTarifa fecFinaTariVige(String fecFinaTariVige) {
        setFecFinaTariVige(fecFinaTariVige);
        return this;
    }
    // -- [codCon] ------------------------

    @Size(max = 10, message = "{message.tarifa.codCon.sizeMax} {max} {message.caracter}")
    @Column(name = "cod_con", length = 10)
    public String getCodCon() {
        return codCon;
    }

    public void setCodCon(String codCon) {
        this.codCon = codCon;
    }

    public IsisTarifa codCon(String codCon) {
        setCodCon(codCon);
        return this;
    }
    // -- [desConc] ------------------------

    @Size(max = 100, message = "{message.tarifa.desConc.sizeMax} {max} {message.caracter}")
    @Column(name = "des_conc", length = 100)
    public String getDesConc() {
        return desConc;
    }

    public void setDesConc(String desConc) {
        this.desConc = desConc;
    }

    public IsisTarifa desConc(String desConc) {
        setDesConc(desConc);
        return this;
    }
    // -- [codMone] ------------------------

    @Size(max = 10, message = "{message.tarifa.codMone.sizeMax} {max} {message.caracter}")
    @Column(name = "cod_mone", length = 10)
    public String getCodMone() {
        return codMone;
    }

    public void setCodMone(String codMone) {
        this.codMone = codMone;
    }

    public IsisTarifa codMone(String codMone) {
        setCodMone(codMone);
        return this;
    }
    // -- [codGrupDsct] ------------------------

    @Size(max = 10, message = "{message.tarifa.codGrupDsct.sizeMax} {max} {message.caracter}")
    @Column(name = "cod_grup_dsct", length = 10)
    public String getCodGrupDsct() {
        return codGrupDsct;
    }

    public void setCodGrupDsct(String codGrupDsct) {
        this.codGrupDsct = codGrupDsct;
    }

    public IsisTarifa codGrupDsct(String codGrupDsct) {
        setCodGrupDsct(codGrupDsct);
        return this;
    }
    // -- [sec] ------------------------

    @Size(max = 10, message = "{message.tarifa.sec.sizeMax} {max} {message.caracter}")
    @Column(name = "sec", length = 10)
    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public IsisTarifa sec(String sec) {
        setSec(sec);
        return this;
    }

    /**
     * Apply the default values.
     */
    public IsisTarifa withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof IsisTarifa && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Tarifa instance.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("codTari", getCodTari()) //
                .add("desTari", getDesTari()) //
                .add("monto", getMonto()) //
                .add("montoSolariza", getMontoSolariza()) //
                .add("tipPagoTari", getTipPagoTari()) //
                .add("fecInicTariVige", getFecInicTariVige()) //
                .add("fecFinaTariVige", getFecFinaTariVige()) //
                .add("codCon", getCodCon()) //
                .add("desConc", getDesConc()) //
                .add("codMone", getCodMone()) //
                .add("codGrupDsct", getCodGrupDsct()) //
                .add("sec", getSec()) //
                .toString();
    }
}
