/********************************************************************************************************
 * File:  Patient.java Course Materials CST 8277
 *
 * @author Teddy Yap
 * 
 */
package acmemedical.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@SuppressWarnings("unused")

/**
 * The persistent class for the patient database table.
 */
@Entity(name = "Patient")
@Table(name = "patient")
@AttributeOverride(name = "id", column = @Column(name = "patient_id"))
public class Patient extends PojoBase implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "first_name")	
	@Basic(optional = false)
	private String firstName;

	@Column(name = "last_name")	
	@Basic(optional = false)
	private String lastName;

	@Column(name = "year_of_birth")	
	@Basic(optional = false)
	private int year;

	@Column(name = "home_address")	
	@Basic(optional = false)
	private String address;

	@Column(name = "height_cm")	
	@Basic(optional = false)
	private int height;

	@Column(name = "weight_kg")	
	@Basic(optional = false)
	private int weight;

	@Column(name = "smoker")	
	@Basic(optional = false)
	private byte smoker;

    @OneToMany(mappedBy = "medicine", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Prescription> prescriptions = new HashSet<>();

	public Patient() {
		super();
	}

	public Patient(String firstName, String lastName, int year, String address, int height, int weight, byte smoker) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.year = year;
		this.address = address;
		this.height = height;
		this.weight = weight;
		this.smoker = smoker;
	}

	public Patient setPatient(String firstName, String lastName, int year, String address, int height, int weight, byte smoker) {
		setFirstName(firstName);
		setLastName(lastName);
		setYear(year);
		setAddress(address);
		setHeight(height);
		setWeight(weight);
		setSmoker(smoker);
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public byte getSmoker() {
		return smoker;
	}

	public void setSmoker(byte smoker) {
		this.smoker = smoker;
	}
	
	public Set<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescription(Set<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	//Inherited hashCode/equals is sufficient for this Entity class

}
