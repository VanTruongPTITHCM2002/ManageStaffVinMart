package PTITHCM.BEAN;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAIKHOAN")
public class TaiKhoan {
	@Id
	@Column(name = "IDTK")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idTK;
	@OneToOne
	@JoinColumn(name = "TENTK")
	private NhanVien nhanvien;
	@Column(name = "MATKHAU")
	private String matkhau;
	@Column(name = "TRANGTHAI")
	private Boolean trangthai;
	@ManyToOne
	@JoinColumn(name = "MAQUYEN")
	private Quyen quyen = new Quyen();

	
	public String getIdTK() {
		return idTK;
	}


	public void setIdTK(String idTK) {
		this.idTK = idTK;
	}


	public String getMatkhau() {
		return matkhau;
	}


	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}


	public Boolean getTrangthai() {
		return trangthai;
	}


	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}


	
	public Quyen getQuyen() {
		return quyen;
	}


	public void setQuyen(Quyen quyen) {
		this.quyen = quyen;
	}


	public NhanVien getNhanvien() {
		return nhanvien;
	}
	public void setmacv(int cv) {
		this.quyen.setMaQuyen(cv);;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public String trangThaiHoatDong() {
		if (this.trangthai) {
			return "Vẫn còn hoạt động";
		}
		return "Vô hiệu hóa";
	}
}
