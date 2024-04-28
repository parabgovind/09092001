package nmfc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity 
@Table(name="students") 
@NamedQueries(@NamedQuery(name = "getAllStudents", query = "SELECT student FROM Students student"))
public class Students implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String student_barcode;
	private int student_roll_number;
	private String student_seat_number;
	private String student_name;
	private String student_stream;
	private String student_class;
	private char student_div;
	private String student_library_card_valid_upto="";
	@Override
	public String toString() {
		return "Students [student_barcode=" + student_barcode + ", student_roll_number=" + student_roll_number
				+ ", student_seat_number=" + student_seat_number + ", student_name=" + student_name
				+ ", student_stream=" + student_stream + ", student_class=" + student_class + ", student_div="
				+ student_div + ", student_library_card_valid_upto=" + student_library_card_valid_upto + "]";
	}
	public String getStudent_barcode() {
		return student_barcode;
	}
	public void setStudent_barcode(String student_barcode) {
		this.student_barcode = student_barcode;
	}
	public int getStudent_roll_number() {
		return student_roll_number;
	}
	public void setStudent_roll_number(int student_roll_number) {
		this.student_roll_number = student_roll_number;
	}
	public String getStudent_seat_number() {
		return student_seat_number;
	}
	public void setStudent_seat_number(String student_seat_number) {
		this.student_seat_number = student_seat_number;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_stream() {
		return student_stream;
	}
	public void setStudent_stream(String student_stream) {
		this.student_stream = student_stream;
	}
	public String getStudent_class() {
		return student_class;
	}
	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}
	public char getStudent_div() {
		return student_div;
	}
	public void setStudent_div(char student_div) {
		this.student_div = student_div;
	}
	public String getStudent_library_card_valid_upto() {
		return student_library_card_valid_upto;
	}
	public void setStudent_library_card_valid_upto(String student_library_card_valid_upto) {
		this.student_library_card_valid_upto = student_library_card_valid_upto;
	}
}