package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PhonebookVO {
	private int id; //전화번호 리스트 시퀀스 증가
	private String name; //이름
	private String hp; //전화번호
	private String memo; //메모기능
}
