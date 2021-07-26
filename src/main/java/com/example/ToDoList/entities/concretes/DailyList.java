package com.example.ToDoList.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="DailyList")
public class DailyList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="is_add")
	private boolean isAdd = false;
	
	@Column(name="is_clear")
	private boolean isClear = false;
	
	@ManyToOne
	@JoinColumn(name="list_element_id" , referencedColumnName = "id")
	private ListElement listElement;
}
