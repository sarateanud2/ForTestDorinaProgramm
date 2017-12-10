package org.ascop.programs.entitys;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.SelectBeforeUpdate;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the copiii_sapp database table.
 * 
 */
@Entity
@Table(name="copiii_sapp")
@NamedQuery(name="CopiiiSapp.findAll", query="SELECT c FROM CopiiiSapp c")
public class CopiiiSapp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String app;

	@Column(name="categoria_art_8")
	private Integer categoriaArt8;

	@Temporal(TemporalType.DATE)
	@Column(name="data_evidenta")
	private Date dataEvidenta;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nasterii")
	private Date dataNasterii;

	@Temporal(TemporalType.DATE)
	@Column(name="data_scoaterii_evident")
	private Date dataScoateriiEvident;

	@Column(name="forma_protectie_fk")
	private Integer formaProtectieFk;

	private Integer localitate;

	private String note;

	@Column(name="nr_casa")
	private String nrCasa;

	private String nume;

	private String prenume;

	private Integer statutul;

	private Integer strada;

	//bi-directional many-to-many association to Parintii
	@ManyToMany(mappedBy="copiiiSapps", fetch = FetchType.LAZY)
	private List<Parintii> parintiis;

	public CopiiiSapp() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApp() {
		return this.app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public Integer getCategoriaArt8() {
		return this.categoriaArt8;
	}

	public void setCategoriaArt8(Integer categoriaArt8) {
		this.categoriaArt8 = categoriaArt8;
	}

	public Date getDataEvidenta() {
		return this.dataEvidenta;
	}

	public void setDataEvidenta(Date dataEvidenta) {
		this.dataEvidenta = dataEvidenta;
	}

	public Date getDataNasterii() {
		return this.dataNasterii;
	}

	public void setDataNasterii(Date dataNasterii) {
		this.dataNasterii = dataNasterii;
	}

	public Date getDataScoateriiEvident() {
		return this.dataScoateriiEvident;
	}

	public void setDataScoateriiEvident(Date dataScoateriiEvident) {
		this.dataScoateriiEvident = dataScoateriiEvident;
	}

	public Integer getFormaProtectieFk() {
		return this.formaProtectieFk;
	}

	public void setFormaProtectieFk(Integer formaProtectieFk) {
		this.formaProtectieFk = formaProtectieFk;
	}

	public Integer getLocalitate() {
		return this.localitate;
	}

	public void setLocalitate(Integer localitate) {
		this.localitate = localitate;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNrCasa() {
		return this.nrCasa;
	}

	public void setNrCasa(String nrCasa) {
		this.nrCasa = nrCasa;
	}

	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return this.prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public Integer getStatutul() {
		return this.statutul;
	}

	public void setStatutul(Integer statutul) {
		this.statutul = statutul;
	}

	public Integer getStrada() {
		return this.strada;
	}

	public void setStrada(Integer strada) {
		this.strada = strada;
	}

	public List<Parintii> getParintiis() {
		return this.parintiis;
	}

	public void setParintiis(List<Parintii> parintiis) {
		this.parintiis = parintiis;
	}

}