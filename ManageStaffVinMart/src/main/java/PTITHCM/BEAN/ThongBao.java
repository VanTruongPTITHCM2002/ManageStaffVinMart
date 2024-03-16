package PTITHCM.BEAN;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "THONGBAO")
public class ThongBao {
	@Id
	@Column(name = "MATB")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maTB;
	@Column(name = "NGAYTB")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayTB;
	@Column(name = "NOIDUNG")
	private String noiDung;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MANVQL")
	private NhanVien manvql;
	@OneToMany(mappedBy = "bangthongbao",fetch = FetchType.EAGER)
	private Collection<CTThongbao> chitietthongbao;
	
	public ThongBao(int maTB, Date ngayTB, String noiDung, NhanVien manvql, Collection<CTThongbao> chitietthongbao) {
		super();
		this.maTB = maTB;
		this.ngayTB = ngayTB;
		this.noiDung = noiDung;
		this.manvql = manvql;
		this.chitietthongbao = chitietthongbao;
	}
	public ThongBao() {
		
	}
	
	public Collection<CTThongbao> getChitietthongbao() {
		return chitietthongbao;
	}
	public void setChitietthongbao(Collection<CTThongbao> chitietthongbao) {
		this.chitietthongbao = chitietthongbao;
	}
	public int getMaTB() {
		return maTB;
	}
	public void setMaTB(int maTB) {
		this.maTB = maTB;
	}
	public Date getNgayTB() {
		return ngayTB;
	}
	public void setNgayTB(Date ngayTB) {
		this.ngayTB = ngayTB;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public NhanVien getManvql() {
		return manvql;
	}
	public void setManvql(NhanVien manvql) {
		this.manvql = manvql;
	}
	
}
