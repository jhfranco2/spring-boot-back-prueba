package net.javaguides.springboot.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
   
    private String apellido;
    
    private long dni;

    private boolean empleado;
    
    
    public Employee(){

    }


	public Employee(String nombre, String apellido, long dni, boolean empleado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.empleado = empleado;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public long getDNI() {
		return dni;
	}


	public void setDNI(long dni) {
		this.dni = dni;
	}


	public boolean isEmpleado() {
		return empleado;
	}


	public void setEmpleado(boolean empleado) {
		this.empleado = empleado;
	}
 
}
