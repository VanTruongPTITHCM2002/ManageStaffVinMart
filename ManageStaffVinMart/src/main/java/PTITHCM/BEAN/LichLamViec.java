package PTITHCM.BEAN;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "LICHLAMVIEC")
public class LichLamViec {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDLLV")
	private int idllv;
	@Column(name = "NGAYLAM")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayLam;
	@Column(name = "GIOBATDAU")
	private Time gioBatDau;
	
	@Column(name = "GIOKETTHUC")
	private Time gioKetThuc;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MANV")
	private NhanVien manhanvien;
	@OneToOne(mappedBy = "lichlamviec")
	private ChamCong chamcong;
	public LichLamViec() {
		super();
	}
	public LichLamViec(int idllv, Date ngayLam, Time gioBatDau, Time gioKetThuc, NhanVien manhanvien,
			ChamCong chamcong) {
		super();
		this.idllv = idllv;
		this.ngayLam = ngayLam;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
		this.manhanvien = manhanvien;
		this.chamcong = chamcong;
	}
	public int getIdllv() {
		return idllv;
	}
	public void setIdllv(int idllv) {
		this.idllv = idllv;
	}
	public Date getNgayLam() {
		return ngayLam;
	}
	public void setNgayLam(Date ngayLam) {
		this.ngayLam = ngayLam;
	}
	public Time getGioBatDau() {
		return gioBatDau;
	}
	public void setGioBatDau(Time gioBatDau) {
		this.gioBatDau = gioBatDau;
	}
	public Time getGioKetThuc() {
		return gioKetThuc;
	}
	public void setGioKetThuc(Time gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}
	public NhanVien getManhanvien() {
		return manhanvien;
	}
	public void setManhanvien(NhanVien manhanvien) {
		this.manhanvien = manhanvien;
	}
	public ChamCong getChamcong() {
		return chamcong;
	}
	public void setChamcong(ChamCong chamcong) {
		this.chamcong = chamcong;
	}
	
	
}
