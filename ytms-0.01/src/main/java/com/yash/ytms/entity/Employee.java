package com.yash.ytms.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yash.ytms.entity.Competency;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;
    
    @NotNull
    private String designation;
    
    @NotNull
    private String email;
    
    @NotNull
    private String irm;

    
     @ManyToOne()
     @JsonBackReference
    private Competency competency;
    
    

}
