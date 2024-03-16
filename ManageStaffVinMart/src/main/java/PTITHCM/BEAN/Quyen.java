package PTITHCM.BEAN;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "QUYEN")
public class Quyen {
	@Id
	@Column(name = "MAQUYEN")
	private int maQuyen;
	@Column(name = "TENQUYEN")
	private String tenQuyen;
	@OneToMany(mappedBy = "quyen",fetch = FetchType.EAGER)
	private Collection<TaiKhoan> taikhoan;
	public Quyen() {
		super();
	}
	
	public Quyen(int maQuyen, String tenQuyen, Collection<TaiKhoan> taikhoan) {
		super();
		this.maQuyen = maQuyen;
		this.tenQuyen = tenQuyen;
		this.taikhoan = taikhoan;
	}

	public int getMaQuyen() {
		return maQuyen;
	}
	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}
	public String getTenQuyen() {
		return tenQuyen;
	}
	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}
	public Collection<TaiKhoan> getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(Collection<TaiKhoan> taikhoan) {
		this.taikhoan = taikhoan;
	}
}
