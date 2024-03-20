package nmfc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="visitors") 
@NamedQueries({
//	@NamedQuery(name = "getCountByStreamSingleFilter", query = "SELECT COUNT(visitors) FROM Visitors visitors WHERE visitors.visitor_stream LIKE :ptitle"),
	@NamedQuery(name = "getAllVisitorsRollNumber", query = "SELECT visitors.visitor_roll_no FROM Visitors visitors"),
	@NamedQuery(name = "getAllVisitorsSeatNumber", query = "SELECT visitors.visitor_seat_number FROM Visitors visitors"),
	@NamedQuery(name = "getAllVisitorsName", query = "SELECT visitors.visitor_name FROM Visitors visitors"),
	@NamedQuery(name = "getAllVisitorsStream", query = "SELECT visitors.visitor_stream FROM Visitors visitors"),
	@NamedQuery(name = "getAllVisitorsClass", query = "SELECT visitors.visitor_class FROM Visitors visitors"),
	@NamedQuery(name = "getAllVisitorsDivision", query = "SELECT visitors.visitor_div FROM Visitors visitors"),
	@NamedQuery(name = "getAllVisitorsLibraryCardValidUpto", query = "SELECT visitors.visitor_library_card_valid_upto FROM Visitors visitors"),
	@NamedQuery(name = "getAllVisitorsDate", query = "SELECT visitors.visit_date FROM Visitors visitors"),
	@NamedQuery(name = "getAllVisitorsTime", query = "SELECT visitors.visit_time FROM Visitors visitors"),
	@NamedQuery(name = "getAllVisitorsStatus", query = "SELECT visitors.visit_status FROM Visitors visitors"),
	@NamedQuery(name = "getAllVisitorsTimeSpent", query = "SELECT visitors.time_spent FROM Visitors visitors"),
	})
public class Visitors implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private int visitor_roll_no;
	private String visitor_seat_number;
	private String visitor_name;
	private String visitor_stream;
	private String visitor_class;
	private char visitor_div;
	private String visitor_library_card_valid_upto;
	private String visit_date;
	private String visit_time;
	private String visit_status;
	private String time_spent;
	
	public Visitors() {
		
	}
	
	public int getVisitor_roll_no() {
		return visitor_roll_no;
	}



	public void setVisitor_roll_no(int visitor_roll_no) {
		this.visitor_roll_no = visitor_roll_no;
	}



	public String getVisitor_seat_number() {
		return visitor_seat_number;
	}



	public void setVisitor_seat_number(String visitor_seat_number) {
		this.visitor_seat_number = visitor_seat_number;
	}



	public String getVisitor_name() {
		return visitor_name;
	}



	public void setVisitor_name(String visitor_name) {
		this.visitor_name = visitor_name;
	}



	public String getVisitor_stream() {
		return visitor_stream;
	}



	public void setVisitor_stream(String visitor_stream) {
		this.visitor_stream = visitor_stream;
	}



	public String getVisitor_class() {
		return visitor_class;
	}



	public void setVisitor_class(String visitor_class) {
		this.visitor_class = visitor_class;
	}



	public char getVisitor_div() {
		return visitor_div;
	}



	public void setVisitor_div(char visitor_div) {
		this.visitor_div = visitor_div;
	}



	public String getVisitor_library_card_valid_upto() {
		return visitor_library_card_valid_upto;
	}



	public void setVisitor_library_card_valid_upto(String visitor_library_card_valid_upto) {
		this.visitor_library_card_valid_upto = visitor_library_card_valid_upto;
	}



	public String getVisit_date() {
		return visit_date;
	}



	public void setVisit_date(String visit_date) {
		this.visit_date = visit_date;
	}



	public String getVisit_time() {
		return visit_time;
	}



	public void setVisit_time(String visit_time) {
		this.visit_time = visit_time;
	}



	public String getVisit_status() {
		return visit_status;
	}



	public void setVisit_status(String visit_status) {
		this.visit_status = visit_status;
	}



	public String getTime_spent() {
		return time_spent;
	}



	public void setTime_spent(String time_spent) {
		this.time_spent = time_spent;
	}



	public Visitors(int visitor_roll_no, String visitor_seat_number, String visitor_name, String visitor_stream,
			String visitor_class, char visitor_div, String visitor_library_card_valid_upto, String visit_date,
			String visit_time, String visit_status, String time_spent) {
		super();
		this.visitor_roll_no = visitor_roll_no;
		this.visitor_seat_number = visitor_seat_number;
		this.visitor_name = visitor_name;
		this.visitor_stream = visitor_stream;
		this.visitor_class = visitor_class;
		this.visitor_div = visitor_div;
		this.visitor_library_card_valid_upto = visitor_library_card_valid_upto;
		this.visit_date = visit_date;
		this.visit_time = visit_time;
		this.visit_status = visit_status;
		this.time_spent = time_spent;
	}

	@Override
	public String toString() {
		return "Visitors [visitor_roll_no=" + visitor_roll_no + ", visitor_seat_number=" + visitor_seat_number
				+ ", visitor_name=" + visitor_name + ", visitor_stream=" + visitor_stream + ", visitor_class="
				+ visitor_class + ", visitor_div=" + visitor_div + ", visitor_library_card_valid_upto="
				+ visitor_library_card_valid_upto + ", visit_date=" + visit_date + ", visit_time=" + visit_time
				+ ", visit_status=" + visit_status + ", time_spent=" + time_spent + "]";
	}
	
	
}
