package mx.com.qtx.jpa.dominio;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name="CTE_CLIENTE")
@NamedQuery(name="Cliente.findAll", query="SELECT cte FROM Cliente cte ORDER BY cte.nombre")
public class Cliente  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CTE_NUM")
	private long numCte;
	@Column(name="CTE_NOMBRE", length=50, nullable=false)
	private String nombre;
	@Column(name="CTE_DIRECCION", length=60, nullable=false)
	private String direccion;
	@Column(name="CTE_SALDO")
	private double saldo;
	
	@OneToMany(mappedBy="cliente")
	private List<Venta> ventas;
	
	@Version
	@Column(name="CTE_VERSION_LOCK", nullable=false)
	private long version;
	
	public Cliente() {
	}

	public Cliente(String nombre, String direccion, double saldo) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.saldo = saldo;
	}

	public long getNumCte() {
		return numCte;
	}

	public void setNumCte(long numCte) {
		this.numCte = numCte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Cliente [numCte=" + numCte + ", nombre=" + nombre + ", direccion=" + direccion + ", saldo=" + saldo
				+ ", version=" + version + "]";
	}

	
}
