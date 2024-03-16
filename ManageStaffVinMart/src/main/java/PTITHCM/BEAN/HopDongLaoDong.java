package PTITHCM.BEAN;


import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "HOPDONGLAODONG")
public class HopDongLaoDong {
	@Id
	@Column(name = "MAHDLD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maHDLD;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Column(name = "NGAYBATDAU")
	private Date ngayBatDau;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Column(name = "NGAYKETTHUC")
	private Date ngayKetThuc;
	@ManyToOne
	@JoinColumn(name = "MANV")
	private NhanVien manv;
	@ManyToOne
	@JoinColumn(name = "BACLUONG")
	private BangLuong bl;
	
	
	public BangLuong getBl() {
		return bl;
	}
	public void setBl(BangLuong bl) {
		this.bl = bl;
	}
	public int getMaHDLD() {
		return maHDLD;
	}
	public void setMaHDLD(int maHDLD) {
		this.maHDLD = maHDLD;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public NhanVien getManv() {
		return manv;
	}
	public void setManv(NhanVien manv) {
		this.manv = manv;
	}


	
	
}
