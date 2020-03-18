package com.hadwinling.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="id")
public class Book {
	private int id;
	private String bno;
	private String bname;
	private String author;
	private double price;
	private String mark;
	
}