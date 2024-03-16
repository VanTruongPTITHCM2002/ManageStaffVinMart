package PTITHCM.BEAN;



import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "CT_LUONG")
public class CTBANGLUONG implements Serializable{
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MANV")
	private NhanVien nhanvienluong;
	
;
	
	@Id
	@Column(name = "THANG")
	private int thang;
	
	@Id
	@Column(name = "NAM")
	private int nam;

	@Column(name = "PHUCAP")
	private int phucap;
	@Column(name = "SOTIENTAMUNG")
	private int sotientamung;
	
	@Column(name = "TONGLUONG")
	private int tongluong;

	
	public CTBANGLUONG() {
		super();
	}
	public int getTongluong() {
		return tongluong;
	}
	public void setTongluong(int tongluong) {
		this.tongluong = tongluong;
	}
	public CTBANGLUONG(NhanVien nhanvienluong, int thang, int nam, int phucap, int sotientamung, int tongluong) {
		super();
		this.nhanvienluong = nhanvienluong;
		this.thang = thang;
		this.nam = nam;
		this.phucap = phucap;
		this.sotientamung = sotientamung;
		this.tongluong = tongluong;
	}
	public NhanVien getNhanvienluong() {
		return nhanvienluong;
	}
	public void setNhanvienluong(NhanVien nhanvienluong) {
		this.nhanvienluong = nhanvienluong;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public int getPhucap() {
		return phucap;
	}
	public void setPhucap(int phucap) {
		this.phucap = phucap;
	}
	public int getSotientamung() {
		return sotientamung;
	}
	public void setSotientamung(int sotientamung) {
		this.sotientamung = sotientamung;
	}
	

}
