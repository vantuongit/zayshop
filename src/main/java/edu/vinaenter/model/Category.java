package edu.vinaenter.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class Category {

	private int cid;
	
	@Size(min = 5, max = 20)
	@NotBlank
	private String cname;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Category(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public Category() {
		super();
	}

	@Override
	public String toString() {
		return "Cat [cid=" + cid + ", cname=" + cname + "]";
	}

	
	
}
