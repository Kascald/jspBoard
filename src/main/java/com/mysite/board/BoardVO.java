package com.mysite.board;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class BoardVO {
	private int num; //index
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int cnt;
	
	
	@Override
	public String toString() {
		return "BoardVO || num = "+ num + "\ntitle = "+ title + "\nwriter = "+ writer + 
							"\ncontent = "+ content + "\nregDate = " + regdate + "\nviewCount = "+ cnt +"\n";	
	}
}
