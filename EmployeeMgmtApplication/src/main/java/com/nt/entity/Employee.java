package com.nt.entity;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="Emp_mgmt")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@SQLDelete(sql="update emp_mgmt set status='INACTIVE' where emp_Id=?")
@SQLRestriction(value ="status <> 'INACTIVE' ")
public class Employee {

	@Id
	@SequenceGenerator(name="empgen1",sequenceName="empsq1",initialValue=1022,allocationSize=1)
	@GeneratedValue(generator="empgen1",strategy=GenerationType.AUTO)
	private Integer empId;
	
	//@NonNull
	@Column(length=30)
	private String empName;
	
	//@NonNull
	@Column(length=30)
	private String empDesg;
	
	//@NonNull
	@Column(length=30)
	private String empAddrs="Hyd";
	
	//@NonNull
	private Integer empAge;
	
	//@NonNull
	private Double empSal;
	
	private String status="ACTIVE";
}
