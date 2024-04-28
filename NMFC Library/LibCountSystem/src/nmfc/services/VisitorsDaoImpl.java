package nmfc.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import nmfc.entities.Visitors;

public class VisitorsDaoImpl {

	private EntityManager entityManager; 
	public VisitorsDaoImpl() { 
		entityManager = JPAUtil.getEntityManager(); 
	}	
	public Long getAllVisitorsCount() {
		String qStr = "SELECT COUNT(visitors.visitor_seat_number) FROM Visitors visitors";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		Long count = query.getSingleResult();
		return count;
	} 
	public Long getAllVisitorsClassCount() {
		String qStr = "SELECT COUNT(distinct visitors.visitor_class) FROM Visitors visitors";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		Long count = query.getSingleResult();
		return count;
	}	
	public Long getStreamCountByTDAte(String fdate) {
		String qStr = "SELECT COUNT(visitors) FROM Visitors visitors WHERE visitors.visit_date = :pstream AND visit_status ='come'";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pstream", fdate);
		Long countStream = query.getSingleResult();
		return countStream;
	}
	public String getStreamCountByTCurrent(String fdate) {
		String qStr = "SELECT COUNT(visitors) FROM Visitors visitors WHERE visitors.visit_date = :pstream AND visit_status ='come'";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pstream", fdate);
		Long countStream = query.getSingleResult();
		
		String qStr1 = "SELECT COUNT(visitors) FROM Visitors visitors WHERE visitors.visit_date = :pstream AND visit_status ='gone'";
		TypedQuery<Long> query1 = entityManager.createQuery(qStr1,Long.class);
		query1.setParameter("pstream", fdate);
		Long countStream1 = query1.getSingleResult();
		return countStream-countStream1+"";
	}
	public Long getAllVisitorsCountBYCome() {
		String qStr = "SELECT COUNT(visitors.visitor_seat_number) FROM Visitors visitors WHERE visit_status = 'come'";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		Long count = query.getSingleResult();
		return count;
	}
	public List getAllVisitorsTimeBYCome() {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query4 = entityManager1.createQuery("SELECT visitors.time_spent FROM Visitors visitors WHERE time_spent IS NOT NULL");
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query4.getResultList();
		return timeList;
	}
	public Long getParticularVisitorCountBYCome(String seatNumber) {
		String qStr = "SELECT COUNT(visitors.visitor_seat_number) FROM Visitors visitors WHERE visitor_seat_number = :pid AND visit_status = 'come'";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pid", seatNumber);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getParticularVisitorCountBYCome(String seatNumber,String date1 ,String date2) {	
		String qStr = "SELECT COUNT(visitors.visitor_seat_number) FROM Visitors visitors WHERE visitor_seat_number = :pid AND visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pid", seatNumber).setParameter("pdate1", date1).setParameter("pdate2", date2);
		Long count = query.getSingleResult();
		return count;
	}
	public void addVisitors(Visitors visitors) {	
		entityManager.getTransaction().begin();
		entityManager.persist(visitors); 
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManager = JPAUtil.getEntityManager(); 
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
	}
	public Visitors findVisitorBySeatNumber(String seatNumber) {	
		Visitors visitor = entityManager.find(Visitors.class, seatNumber); 
		return visitor;
	}
	public List getAllVisitorsRollNumber() {	
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsRollNumber");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	public List getAllVisitorsName() {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsName");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	public List getAllVisitorsClass() {	
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsClass");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	public List getAllVisitorsTimeSpent() {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsTimeSpent");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	public List getAllVisitorsStream() {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsStream");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	public List getAllVisitorsTime() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsTime");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	public List getAllVisitorsDate() {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsDate");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	public List getAllVisitorsStatus() {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsStatus");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	public List getAllVisitorsSeatNumber() {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsSeatNumber");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	public List getAllVisitorsDivision() {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsDivision");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	public List getAllVisitorsLibraryCardValidUpto() {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createNamedQuery("getAllVisitorsLibraryCardValidUpto");
		@SuppressWarnings("unchecked")
		List<Visitors> countList = query.getResultList();
		return countList;
	}
	public List getVisitorNameRecordBySeatNumber(String seatNumber) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitors.visitor_name FROM Visitors visitors WHERE visitor_seat_number = :pid");
		query.setParameter("pid", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> dateList = query.getResultList();
		return dateList;
	}
	public List getVisitorStreamRecordBySeatNumber(String seatNumber) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitors.visitor_stream FROM Visitors visitors WHERE visitor_seat_number = :pid");
		query.setParameter("pid", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> dateList = query.getResultList();
		return dateList;
	}
	public List getVisitorClassRecordBySeatNumber(String seatNumber) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitors.visitor_class FROM Visitors visitors WHERE visitor_seat_number = :pid");
		query.setParameter("pid", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> dateList = query.getResultList();
		return dateList;
	}
	public List getVisitorDateRecordBySeatNumber(String seatNumber) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitors.visit_date FROM Visitors visitors WHERE visitor_seat_number = :pid");
		query.setParameter("pid",seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> dateList = query.getResultList();
		return dateList;
	}
	public List getVisitorTimeRecordBySeatNumber(String seatNumber) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query2 = entityManager1.createQuery("SELECT visitors.visit_time FROM Visitors visitors WHERE visitor_seat_number = :pid");
		query2.setParameter("pid", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query2.getResultList();
		return timeList;
	}
	public List getVisitorTimeRecordByDateSeatNumber(String seatNumber,String sdate) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query2 = entityManager1.createQuery("SELECT visitors.visit_time FROM Visitors visitors WHERE visitor_seat_number = :pid AND visit_date = :pdate");
		query2.setParameter("pid", seatNumber).setParameter("pdate", sdate);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query2.getResultList();
		return timeList;
	}
	public List getVisitorStatusRecordBySeatNumber(String seatNumber) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query3 = entityManager1.createQuery("SELECT visitors.visit_status FROM Visitors visitors WHERE visitor_seat_number = :pid");
		query3.setParameter("pid", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query3.getResultList();
		return timeList;
	}


	public List getVisitorTimeSpentRecordBySeatNumber(String seatNumber) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query4 = entityManager1.createQuery("SELECT visitors.time_spent FROM Visitors visitors WHERE visitor_seat_number = :pid AND time_spent IS NOT NULL");
		query4.setParameter("pid", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query4.getResultList();
		return timeList;
	}
	public List getVisitorTimeSpentRecordBySeatNumber(String seatNumber, String date1, String date2) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query4 = entityManager1.createQuery("SELECT visitors.time_spent FROM Visitors visitors WHERE visitor_seat_number = :pid AND time_spent IS NOT NULL AND visit_date BETWEEN :pdate1 AND :pdate2");
		query4.setParameter("pid", seatNumber).setParameter("pdate1", date1).setParameter("pdate2", date2);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query4.getResultList();
		return timeList;
	}
	public List getVisitorTimeSpentRecordBySeatNumberYear(String seatNumber,int year) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query4 = entityManager1.createQuery("SELECT visitors.time_spent FROM Visitors visitors WHERE visitor_seat_number = :pid AND YEAR(visit_date) = :pyear AND time_spent IS NOT NULL");
		query4.setParameter("pid", seatNumber).setParameter("pyear", year);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query4.getResultList();
		return timeList;
	}
	public List getVisitorTimeSpentRecordBySeatNumberYearMonth(String seatNumber,int year,String month) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query4 = entityManager1.createQuery("SELECT visitors.time_spent FROM Visitors visitors WHERE visitor_seat_number = :pid AND YEAR(visit_date) = :pyear AND DATE_FORMAT(visit_date,'%b') = :pmonth AND time_spent IS NOT NULL");
		query4.setParameter("pid", seatNumber).setParameter("pyear", year).setParameter("pmonth", month);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query4.getResultList();
		return timeList;
	}

	public List getStreams() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DISTINCT visitor_stream FROM Visitors visitors WHERE visit_status ='come'");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}

	public List getClassy() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DISTINCT visitor_class FROM Visitors visitors WHERE visit_status ='come'");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getGroupBYClass() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitor_class, COUNT(visitor_class) FROM Visitors visitors WHERE visit_status ='come' GROUP BY visitor_class");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getGroupBY() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitor_stream, COUNT(visitor_stream) FROM Visitors visitors WHERE visit_status ='come' GROUP BY visitor_stream");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getGroupBYDatesClass(String fdate,String sdate) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitor_class, COUNT(visitor_class) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :fdate AND :sdate GROUP BY visitor_class");
		query.setParameter("fdate", fdate).setParameter("sdate", sdate);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getGroupBYDates(String fdate,String sdate) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitor_stream, COUNT(visitor_stream) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :fdate AND :sdate GROUP BY visitor_stream");
		query.setParameter("fdate", fdate).setParameter("sdate", sdate);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getRecordsGroupBYDates(String fdate,String sdate) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitor_stream, visitor_class, COUNT(visitor_class),visitor_div FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :fdate AND :sdate GROUP BY visitor_stream, visitor_class, visitor_div");
		query.setParameter("fdate", fdate).setParameter("sdate", sdate);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public Long getStreamCountBystreams(String stream) {
		String qStr = "SELECT COUNT(visitors) FROM Visitors visitors WHERE visitors.visitor_stream = :pstream AND visit_status ='come'";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pstream", stream);
		Long countStream = query.getSingleResult();
		return countStream;
	}

	public List getStudentMonthlyGrouply(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),DATE_FORMAT(visit_date,'%b'),COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY YEAR(visit_date),DATE_FORMAT(visit_date,'%b'),visitor_stream");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getYearsStreamsGroupBY() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitor_stream,YEAR(visit_date), COUNT(visitor_stream) FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date),visitor_stream");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getYearsMonthsStreamsGroupBY() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'),YEAR(visit_date), COUNT(visitor_stream) FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date), DATE_FORMAT(visit_date,'%b') ORDER BY MONTH(visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllRecordGroupBY() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date ORDER BY visit_date");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthsRecordGroupBY() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),DATE_FORMAT(visit_date,'%b'), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date), DATE_FORMAT(visit_date,'%b') ORDER BY visit_date");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorRecord(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY visit_date ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date ORDER BY visit_date");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
//	public List getAllOrganicDayWiseVisitorRecord() {
//		Visitors visitors = new Visitors();
//		EntityManager entityManager1 = JPAUtil.getEntityManager1();
//		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), SUBSTRING(EXTRACT(YEAR FROM (visit_date)),3), DATE_FORMAT(visit_date,'%b') FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
//		@SuppressWarnings("unchecked")
//		List<Visitors> streamList = query.getResultList();
//		return streamList;
//	}
	public List getAllOrganicDayWiseVisitorRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), YEAR(visit_date), DATE_FORMAT(visit_date,'%b') FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllOrganicClassDayWiseVisitorRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), SUBSTRING(EXTRACT(YEAR FROM (visit_date)),3), DATE_FORMAT(visit_date,'%b'), visit_class FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date,visit_class ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorRecord(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date ORDER BY visit_date");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllOrganicDayWiseVisitorRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), SUBSTRING(EXTRACT(YEAR FROM (visit_date)),3), DATE_FORMAT(visit_date,'%b') FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}

	public List getAllMonthlyVisitorRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),DATE_FORMAT(visit_date,'%b'), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date), DATE_FORMAT(visit_date,'%b') ORDER BY visit_date");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthlyVisitorRecord(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),DATE_FORMAT(visit_date,'%b'), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY YEAR(visit_date), DATE_FORMAT(visit_date,'%b') ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthlyVisitorRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),DATE_FORMAT(visit_date,'%b'), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY YEAR(visit_date), DATE_FORMAT(visit_date,'%b') ORDER BY visit_date");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthlyVisitorRecord(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),DATE_FORMAT(visit_date,'%b'), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY YEAR(visit_date), DATE_FORMAT(visit_date,'%b') ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getCombinedC_MonthlyVisitorRecord(String stream) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'),YEAR(visit_date), COUNT(visitor_seat_number), visitor_class FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pstream GROUP BY YEAR(visit_date), DATE_FORMAT(visit_date,'%b') ORDER BY YEAR(visit_date), Date_FORMAT(visit_date,'%m')");
		query.setParameter("pstream", stream);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getCombinedAllClassC_MonthlyVisitorRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'),YEAR(visit_date), COUNT(visitor_seat_number), visitor_class FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date), DATE_FORMAT(visit_date,'%b'), visitor_class ORDER BY YEAR(visit_date), Date_FORMAT(visit_date,'%m')");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getCombinedAllStreamC_MonthlyVisitorRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'),YEAR(visit_date), COUNT(visitor_seat_number), visitor_stream FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date), DATE_FORMAT(visit_date,'%b'), visitor_stream ORDER BY YEAR(visit_date), Date_FORMAT(visit_date,'%m')");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getCombinedSingleStreamC_MonthlyVisitorRecord(String stream) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'),YEAR(visit_date), COUNT(visitor_seat_number), visitor_stream FROM Visitors visitors WHERE visit_status ='come' AND visitor_stream = :pstream GROUP BY YEAR(visit_date), DATE_FORMAT(visit_date,'%b') ORDER BY YEAR(visit_date), Date_FORMAT(visit_date,'%m')");
		query.setParameter("pstream", stream);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getCombinedMonthlyVisitorRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY DATE_FORMAT(visit_date,'%b') ORDER BY Date_FORMAT(visit_date,'%m')");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getCombinedMonthlyVisitorRecord(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY DATE_FORMAT(visit_date,'%b') ORDER BY Date_FORMAT(visit_date,'%m')");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getCombinedMonthlyVisitorRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY DATE_FORMAT(visit_date,'%b') ORDER BY Date_FORMAT(visit_date,'%m')");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getCombinedMonthlyVisitorRecord(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY DATE_FORMAT(visit_date,'%b') ORDER BY Date_FORMAT(visit_date,'%m')");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getStudentGrouply(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),COUNT(visitor_stream) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY YEAR(visit_date) ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentGrouply(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),COUNT(visitor_stream) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY YEAR(visit_date) ORDER BY visit_date");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentGrouply(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),COUNT(visitor_stream) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY YEAR(visit_date) ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentGrouply() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date),COUNT(visitor_stream) FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date) ORDER BY visit_date");
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentWeekly(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DAYNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY DAYNAME(visit_date) ORDER BY Date_FORMAT(visit_date,'%w')");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentWeekly(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DAYNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY DAYNAME(visit_date) ORDER BY Date_FORMAT(visit_date,'%w')");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentWeekly() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DAYNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY DAYNAME(visit_date) ORDER BY Date_FORMAT(visit_date,'%w')");
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentWeekly(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DAYNAME(visit_date), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY DAYNAME(visit_date) ORDER BY Date_FORMAT(visit_date,'%w')");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentMonthly(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY DATE_FORMAT(visit_date,'%b') ORDER BY visit_date");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentHourly(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT HOUR(visit_time), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY HOUR(visit_time) ORDER BY visit_time");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentHourly(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT HOUR(visit_time), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY HOUR(visit_time) ORDER BY visit_time");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentHourly() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT HOUR(visit_time), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY HOUR(visit_time) ORDER BY visit_time");
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getStudentHourly(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT HOUR(visit_time), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY HOUR(visit_time) ORDER BY visit_time");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> grouplylist = query.getResultList();
		return grouplylist;
	}
	public List getAllTimelyVisitorRecord(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visit_time, HOUR(visit_time) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date, visit_time ORDER BY visit_date, visit_time");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllTimelyVisitorRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visit_time, HOUR(visit_time) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date, visit_time ORDER BY visit_date, visit_time");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllTimelyVisitorRecord(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visit_time, HOUR(visit_time) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY visit_date, visit_time ORDER BY visit_date, visit_time");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllTimelyVisitorRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visit_time, HOUR(visit_time) FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date, visit_time ORDER BY visit_date, visit_time");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public Long getAllVisitorsCountBYComeDate(String datePicker, String datePicker1) {
		
		String qStr = "SELECT COUNT(visitors.visitor_seat_number) FROM Visitors visitors WHERE visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		Long count = query.getSingleResult();
		return count;
	}
	public List getAllVisitorsTimeBYComeDate(String datePicker, String datePicker1) {
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query4 = entityManager1.createQuery("SELECT visitors.time_spent FROM Visitors visitors WHERE time_spent IS NOT NULL AND visit_date BETWEEN :pdate1 AND :pdate2");
		query4.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> timeList = query4.getResultList();
		return timeList;
	}
	public List getAllDayTimelyVisitorRecord(String seatNumber, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, HOUR(visit_time), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_time ORDER BY visit_date, visit_time");
		query.setParameter("pseatNumber", seatNumber).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayTimelyVisitorRecord(String seatNumber) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, HOUR(visit_time), COUNT(visitor_seat_number) FROM Visitors visitors WHERE visitors.visitor_seat_number = :pseatNumber AND visit_status ='come' GROUP BY visit_time ORDER BY visit_date, visit_time");
		query.setParameter("pseatNumber", seatNumber);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getInOut1() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date FROM Visitors visitors WHERE visit_status ='come'");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public Long getAllVisitorsVisitDateCount() {
		String qStr = "SELECT COUNT(distinct visitors.visit_date) FROM Visitors visitors";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitDateCount(String datePicker, String datePicker1) {
		String qStr = "SELECT COUNT(distinct visitors.visit_date) FROM Visitors visitors where visit_date BETWEEN :pdate1 AND :pdate2";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		Long count = query.getSingleResult();
		return count;
	}
	public List getAllVisitorsVisitDateCountWeek() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT COUNT(*) FROM Visitors visitors GROUP BY WEEK(visitors.visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllVisitorsVisitDateCountWeek(String datePicker, String datePicker1) {
		
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT COUNT(*) FROM Visitors visitors where visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY WEEK(visitors.visit_date)");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllVisitorsVisitDateCountMonth() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT COUNT(*) FROM Visitors visitors GROUP BY MONTH(visitors.visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllVisitorsVisitDateCountMonth(String datePicker, String datePicker1) {
		
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT COUNT(*) FROM Visitors visitors where visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY MONTH(visitors.visit_date)");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllVisitorsVisitDateCountYear() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT COUNT(*) FROM Visitors visitors GROUP BY YEAR(visitors.visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllVisitorsVisitDateCountYear(String datePicker, String datePicker1) {
		
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT COUNT(*) FROM Visitors visitors where visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY YEAR(visitors.visit_date)");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorClassRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date,visitor_class ORDER BY visit_date");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllOrganicDayWiseVisitorClassRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), DATE_FORMAT(visit_date,'%b'), YEAR(visit_date), visitor_class FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date, visitor_class ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllOrganicDayWiseVisitorStreamRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), DATE_FORMAT(visit_date,'%b'), YEAR(visit_date), visitor_stream FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date, visitor_stream ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllOrganicDayWiseVisitorClassRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), DATE_FORMAT(visit_date,'%b'), YEAR(visit_date), visitor_class FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date, visitor_class ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllOrganicDayWiseVisitorStreamRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), DATE_FORMAT(visit_date,'%b'), YEAR(visit_date), visitor_stream FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date, visitor_stream ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorClassRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date,visitor_class ORDER BY visit_date");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllWeekWiseVisitorClassRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT WEEK(visit_date), visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY WEEK(visit_date),visitor_class ORDER BY WEEK(visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllWeekWiseVisitorClassRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT WEEK(visit_date), visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY WEEK(visit_date),visitor_class ORDER BY WEEK(visit_date)");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthWiseVisitorClassRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'), visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY DATE_FORMAT(visit_date,'%b'),visitor_class ORDER BY CASE MONTH(visit_date) WHEN 1 THEN 1 WHEN 2 THEN 2 WHEN 3 THEN 3 WHEN 4 THEN 4 WHEN 5 THEN 5 WHEN 6 THEN 6 WHEN 7 THEN 7 WHEN 8 THEN 8 WHEN 9 THEN 9 WHEN 10 THEN 10 WHEN 11 THEN 11 WHEN 12 THEN 12 END");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthWiseVisitorClassRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'), visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY DATE_FORMAT(visit_date,'%b'),visitor_class ORDER BY CASE MONTH(visit_date) WHEN 1 THEN 1 WHEN 2 THEN 2 WHEN 3 THEN 3 WHEN 4 THEN 4 WHEN 5 THEN 5 WHEN 6 THEN 6 WHEN 7 THEN 7 WHEN 8 THEN 8 WHEN 9 THEN 9 WHEN 10 THEN 10 WHEN 11 THEN 11 WHEN 12 THEN 12 END");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllYearWiseVisitorClassRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date), visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date),visitor_class ORDER BY YEAR(visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllYearWiseVisitorClassRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date), visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY YEAR(visit_date),visitor_class ORDER BY YEAR(visit_date)");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorStreamRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date,visitor_stream ORDER BY visit_date");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorStreamRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date,visitor_stream ORDER BY visit_date");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllWeekWiseVisitorStreamRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT WEEK(visit_date), visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY WEEK(visit_date),visitor_stream ORDER BY WEEK(visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllWeekWiseVisitorStreamRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT WEEK(visit_date), visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY WEEK(visit_date),visitor_stream ORDER BY WEEK(visit_date)");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthWiseVisitorStreamRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'), visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY DATE_FORMAT(visit_date,'%b'),visitor_stream ORDER BY CASE MONTH(visit_date) WHEN 1 THEN 1 WHEN 2 THEN 2 WHEN 3 THEN 3 WHEN 4 THEN 4 WHEN 5 THEN 5 WHEN 6 THEN 6 WHEN 7 THEN 7 WHEN 8 THEN 8 WHEN 9 THEN 9 WHEN 10 THEN 10 WHEN 11 THEN 11 WHEN 12 THEN 12 END");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthWiseVisitorStreamRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'), visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY DATE_FORMAT(visit_date,'%b'),visitor_stream ORDER BY CASE MONTH(visit_date) WHEN 1 THEN 1 WHEN 2 THEN 2 WHEN 3 THEN 3 WHEN 4 THEN 4 WHEN 5 THEN 5 WHEN 6 THEN 6 WHEN 7 THEN 7 WHEN 8 THEN 8 WHEN 9 THEN 9 WHEN 10 THEN 10 WHEN 11 THEN 11 WHEN 12 THEN 12 END");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllYearWiseVisitorStreamRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date), visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date),visitor_stream ORDER BY YEAR(visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllYearWiseVisitorStreamRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date), visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY YEAR(visit_date),visitor_stream ORDER BY YEAR(visit_date)");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorSingleClassRecord(String pclass,String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pclass AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date,visitor_class ORDER BY visit_date");
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllOrganicDayWiseVisitorSingleClassRecord(String pclass,String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), DATE_FORMAT(visit_date,'%b'), YEAR(visit_date), visitor_class FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pclass AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date, visitor_class ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorSingleClassRecord(String pclass) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pclass GROUP BY visit_date ORDER BY visit_date");
		query.setParameter("pclass", pclass);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllOrganicDayWiseVisitorSingleClassRecord(String pclass) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), DATE_FORMAT(visit_date,'%b'), YEAR(visit_date), visitor_class FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pclass GROUP BY visit_date, visitor_class ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
		query.setParameter("pclass", pclass);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllWeekWiseVisitorSingleClassRecord(String pclass,String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT WEEK(visit_date), visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pclass AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY WEEK(visit_date),visitor_class ORDER BY WEEK(visit_date)");
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllWeekWiseVisitorSingleClassRecord(String pclass) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT WEEK(visit_date), visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pclass GROUP BY WEEK(visit_date) ORDER BY WEEK(visit_date)");
		query.setParameter("pclass", pclass);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthWiseVisitorSingleClassRecord(String pclass,String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'), visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pclass AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY DATE_FORMAT(visit_date,'%b'),visitor_class ORDER BY CASE MONTH(visit_date) WHEN 1 THEN 1 WHEN 2 THEN 2 WHEN 3 THEN 3 WHEN 4 THEN 4 WHEN 5 THEN 5 WHEN 6 THEN 6 WHEN 7 THEN 7 WHEN 8 THEN 8 WHEN 9 THEN 9 WHEN 10 THEN 10 WHEN 11 THEN 11 WHEN 12 THEN 12 END");
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthWiseVisitorSingleClassRecord(String pclass) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'), visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pclass GROUP BY DATE_FORMAT(visit_date,'%b') ORDER BY CASE MONTH(visit_date) WHEN 1 THEN 1 WHEN 2 THEN 2 WHEN 3 THEN 3 WHEN 4 THEN 4 WHEN 5 THEN 5 WHEN 6 THEN 6 WHEN 7 THEN 7 WHEN 8 THEN 8 WHEN 9 THEN 9 WHEN 10 THEN 10 WHEN 11 THEN 11 WHEN 12 THEN 12 END");
		query.setParameter("pclass", pclass);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllYearWiseVisitorSingleClassRecord(String pclass,String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date), visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pclass AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY YEAR(visit_date),visitor_class ORDER BY YEAR(visit_date)");
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllYearWiseVisitorSingleClassRecord(String pclass) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date), visitor_class, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pclass GROUP BY YEAR(visit_date) ORDER BY YEAR(visit_date)");
		query.setParameter("pclass", pclass);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorSingleStreamRecord(String pclass,String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_stream = :pclass AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date,visitor_stream ORDER BY visit_date");
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllOrganicDayWiseVisitorSingleStreamRecord(String pclass,String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), DATE_FORMAT(visit_date,'%b'), YEAR(visit_date), visitor_stream FROM Visitors visitors WHERE visit_status ='come' AND visitor_stream = :pclass AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date, visitor_stream ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorSingleStreamRecord(String pclass) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_stream = :pclass GROUP BY visit_date ORDER BY visit_date");
		query.setParameter("pclass", pclass);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllOrganicDayWiseVisitorSingleStreamRecord(String pclass) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), DATE_FORMAT(visit_date,'%b'), YEAR(visit_date), visitor_stream FROM Visitors visitors WHERE visit_status ='come' AND visitor_stream = :pclass GROUP BY visit_date, visitor_stream ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
		query.setParameter("pclass", pclass);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllWeekWiseVisitorSingleStreamRecord(String pclass,String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT WEEK(visit_date), visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_stream = :pclass AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY WEEK(visit_date),visitor_stream ORDER BY WEEK(visit_date)");
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllWeekWiseVisitorSingleStreamRecord(String pclass) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT WEEK(visit_date), visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_stream = :pclass GROUP BY WEEK(visit_date) ORDER BY WEEK(visit_date)");
		query.setParameter("pclass", pclass);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthWiseVisitorSingleStreamRecord(String pclass,String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'), visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_stream = :pclass AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY DATE_FORMAT(visit_date,'%b'),visitor_stream ORDER BY CASE MONTH(visit_date) WHEN 1 THEN 1 WHEN 2 THEN 2 WHEN 3 THEN 3 WHEN 4 THEN 4 WHEN 5 THEN 5 WHEN 6 THEN 6 WHEN 7 THEN 7 WHEN 8 THEN 8 WHEN 9 THEN 9 WHEN 10 THEN 10 WHEN 11 THEN 11 WHEN 12 THEN 12 END");
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthWiseVisitorSingleStreamRecord(String pclass) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'), visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_stream = :pclass GROUP BY DATE_FORMAT(visit_date,'%b') ORDER BY CASE MONTH(visit_date) WHEN 1 THEN 1 WHEN 2 THEN 2 WHEN 3 THEN 3 WHEN 4 THEN 4 WHEN 5 THEN 5 WHEN 6 THEN 6 WHEN 7 THEN 7 WHEN 8 THEN 8 WHEN 9 THEN 9 WHEN 10 THEN 10 WHEN 11 THEN 11 WHEN 12 THEN 12 END");
		query.setParameter("pclass", pclass);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllYearWiseVisitorSingleStreamRecord(String pclass,String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date), visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_stream = :pclass AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY YEAR(visit_date),visitor_stream ORDER BY YEAR(visit_date)");
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllYearWiseVisitorSingleStreamRecord(String pclass) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date), visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_stream = :pclass GROUP BY YEAR(visit_date) ORDER BY YEAR(visit_date)");
		query.setParameter("pclass", pclass);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorClassStreamRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date,visitor_class,visitor_stream ORDER BY visit_date");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllOrganicDayWiseVisitorClassStreamRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), DATE_FORMAT(visit_date,'%b'), YEAR(visit_date), visitor_class, visitor_stream FROM Visitors visitors WHERE visit_status ='come' GROUP BY visit_date,visitor_class,visitor_stream ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllOrganicDayWiseVisitorClassStreamRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), DATE_FORMAT(visit_date,'%b'), YEAR(visit_date), visitor_class, visitor_stream FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date,visitor_class,visitor_stream ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorClassStreamRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY visit_date,visitor_class,visitor_stream ORDER BY visit_date");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllWeekWiseVisitorClassStreamRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT WEEK(visit_date), visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY WEEK(visit_date),visitor_class,visitor_stream ORDER BY WEEK(visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllWeekWiseVisitorClassStreamRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT WEEK(visit_date), visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY WEEK(visit_date),visitor_class,visitor_stream ORDER BY WEEK(visit_date)");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthWiseVisitorClassStreamRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date), DATE_FORMAT(visit_date,'%b'), visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date), DATE_FORMAT(visit_date,'%b'),visitor_class,visitor_stream ORDER BY DATE_FORMAT(DATE_FORMAT(visit_date,'%b'),'%m')");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthWiseVisitorClassStreamRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date), DATE_FORMAT(visit_date,'%b'), visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY YEAR(visit_date), DATE_FORMAT(visit_date,'%b'),visitor_class,visitor_stream ORDER BY DATE_FORMAT(DATE_FORMAT(visit_date,'%b'),'%m')");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllYearWiseVisitorClassStreamRecord() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date), visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' GROUP BY YEAR(visit_date),visitor_class,visitor_stream ORDER BY YEAR(visit_date)");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllYearWiseVisitorClassStreamRecord(String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date), visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 GROUP BY YEAR(visit_date),visitor_class,visitor_stream ORDER BY YEAR(visit_date)");
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorSingleClassStreamRecord(String pclass, String pstream) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pclass AND visitor_stream = :pstream GROUP BY visit_date,visitor_class,visitor_stream ORDER BY visit_date");
		query.setParameter("pclass", pclass).setParameter("pstream", pstream);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllOrganicDayWiseVisitorSingleClassStreamRecord(String pclass, String pstream) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), DATE_FORMAT(visit_date,'%b'), YEAR(visit_date), visitor_class, visitor_stream FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pclass AND visitor_stream = :pstream GROUP BY visit_date,visitor_class,visitor_stream ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
		query.setParameter("pclass", pclass).setParameter("pstream", pstream);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllOrganicDayWiseVisitorSingleClassStreamRecord(String pclass, String pstream, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT extract(day from visit_date), COUNT(visitor_seat_number), DATE_FORMAT(visit_date,'%b'), YEAR(visit_date), visitor_class, visitor_stream FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 AND visitor_class = :pclass AND visitor_stream = :pstream GROUP BY visit_date,visitor_class,visitor_stream ORDER BY extract(day from visit_date),DATE_FORMAT(visit_date,'%b'), YEAR(visit_date)");
		query.setParameter("pclass", pclass).setParameter("pstream", pstream).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllDayWiseVisitorSingleClassStreamRecord(String pclass, String pstream, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visit_date, visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 AND visitor_class = :pclass AND visitor_stream = :pstream GROUP BY visit_date,visitor_class,visitor_stream ORDER BY visit_date");
		query.setParameter("pclass", pclass).setParameter("pstream", pstream).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllWeekWiseVisitorSingleClassStreamRecord(String pclass, String pstream) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT WEEK(visit_date), visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pclass AND visitor_stream = :pstream GROUP BY WEEK(visit_date),visitor_class,visitor_stream ORDER BY WEEK(visit_date)");
		query.setParameter("pclass", pclass).setParameter("pstream", pstream);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllWeekWiseVisitorSingleClassStreamRecord(String pclass, String pstream, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT WEEK(visit_date), visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 AND visitor_class = :pclass AND visitor_stream = :pstream GROUP BY WEEK(visit_date),visitor_class,visitor_stream ORDER BY WEEK(visit_date)");
		query.setParameter("pclass", pclass).setParameter("pstream", pstream).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthWiseVisitorSingleClassStreamRecord(String pclass, String pstream) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'), visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pclass AND visitor_stream = :pstream GROUP BY DATE_FORMAT(visit_date,'%b'),visitor_class,visitor_stream ORDER BY DATE_FORMAT(DATE_FORMAT(visit_date,'%b'),'%m')");
		query.setParameter("pclass", pclass).setParameter("pstream", pstream);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllMonthWiseVisitorSingleClassStreamRecord(String pclass, String pstream, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT DATE_FORMAT(visit_date,'%b'), visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 AND visitor_class = :pclass AND visitor_stream = :pstream GROUP BY DATE_FORMAT(visit_date,'%b'),visitor_class,visitor_stream ORDER BY DATE_FORMAT(DATE_FORMAT(visit_date,'%b'),'%m')");
		query.setParameter("pclass", pclass).setParameter("pstream", pstream).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllYearWiseVisitorSingleClassStreamRecord(String pclass, String pstream) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date), visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pclass AND visitor_stream = :pstream GROUP BY YEAR(visit_date),visitor_class,visitor_stream ORDER BY YEAR(visit_date)");
		query.setParameter("pclass", pclass).setParameter("pstream", pstream);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getAllYearWiseVisitorSingleClassStreamRecord(String pclass, String pstream, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT YEAR(visit_date), visitor_class,visitor_stream, COUNT(visitor_seat_number) FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 AND visitor_class = :pclass AND visitor_stream = :pstream GROUP BY YEAR(visit_date),visitor_class,visitor_stream ORDER BY YEAR(visit_date)");
		query.setParameter("pclass", pclass).setParameter("pstream", pstream).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public Long getAllVisitorsVisitClassCountDaywise(String pclass) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' and visitor_class =:pclass group by visit_date,visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassCountDaywise(String pclass,String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 and visitor_class =:pclass group by visit_date,visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitStreamCountDaywise(String pclass) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' and visitor_stream =:pclass group by visit_date,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitStreamCountDaywise(String pclass,String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 and visitor_stream =:pclass group by visit_date,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsClassCountDaywise() {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' group by visit_date,visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsClassCountDaywise(String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 group by visit_date,visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassCountWeekwise(String pclass) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' and visitor_class =:pclass group by week(visit_date),visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassCountWeekwise(String pclass,String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 and visitor_class =:pclass group by week(visit_date),visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitStreamCountWeekwise(String pclass) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' and visitor_stream =:pclass group by week(visit_date),visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitStreamCountWeekwise(String pclass,String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 and visitor_stream =:pclass group by week(visit_date),visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsClassCountWeekwise() {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' group by week(visit_date),visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsClassCountWeekwise(String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 group by week(visit_date),visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassCountMonthwise(String pclass) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' and visitor_class =:pclass group by DATE_FORMAT(visit_date,'%b'),visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassCountMonthwise(String pclass,String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 and visitor_class =:pclass group by DATE_FORMAT(visit_date,'%b'),visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitStreamCountMonthwise(String pclass) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' and visitor_stream =:pclass group by DATE_FORMAT(visit_date,'%b'),visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitStreamCountMonthwise(String pclass,String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 and visitor_stream =:pclass group by DATE_FORMAT(visit_date,'%b'),visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsClassCountMonthwise() {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' group by DATE_FORMAT(visit_date,'%b'),visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsClassCountMonthwise(String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 group by DATE_FORMAT(visit_date,'%b'),visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassCountYearwise(String pclass) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' and visitor_class =:pclass group by year(visit_date),visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassCountYearwise(String pclass,String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 and visitor_class =:pclass group by year(visit_date),visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitStreamCountYearwise(String pclass) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' and visitor_stream =:pclass group by year(visit_date),visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitStreamCountYearwise(String pclass,String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 and visitor_stream =:pclass group by year(visit_date),visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsClassCountYearwise() {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' group by year(visit_date),visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsClassCountYearwise(String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 group by year(visit_date),visitor_class order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsStreamCountDaywise() {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' group by visit_date,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsStreamCountDaywise(String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 group by visit_date,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsStreamCountWeekwise() {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' group by week(visit_date),visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsStreamCountWeekwise(String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 group by week(visit_date),visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsStreamCountMonthwise() {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' group by DATE_FORMAT(visit_date,'%b'),visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsStreamCountMonthwise(String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 group by DATE_FORMAT(visit_date,'%b'),visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsStreamCountYearwise() {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' group by year(visit_date),visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsStreamCountYearwise(String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 group by year(visit_date),visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountDaywise() {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' group by visit_date,visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountDaywise2(String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 group by visit_date,visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountWeekwise() {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' group by week(visit_date),visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountWeekwise2(String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 group by week(visit_date),visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountMonthwise() {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' group by DATE_FORMAT(visit_date,'%b'),visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountMonthwise2(String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 group by DATE_FORMAT(visit_date,'%b'),visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountYearwise() {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' group by year(visit_date),visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountYearwise2(String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 group by year(visit_date),visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountDaywise(String pclass,String pstream) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' and visitor_class =:pclass and visitor_stream = :pstream group by visit_date,visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pstream", pstream);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountDaywise(String pclass,String pstream,String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 and visitor_class =:pclass and visitor_stream = :pstream group by visit_date,visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pstream", pstream).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountWeekwise(String pclass,String pstream) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' and visitor_class =:pclass and visitor_stream = :pstream group by week(visit_date),visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pstream", pstream);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountWeekwise(String pclass,String pstream,String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 and visitor_class =:pclass and visitor_stream = :pstream group by week(visit_date),visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pstream", pstream).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountMonthwise(String pclass,String pstream) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' and visitor_class =:pclass and visitor_stream = :pstream group by DATE_FORMAT(visit_date,'%b'),visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pstream", pstream);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountMonthwise(String pclass,String pstream,String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 and visitor_class =:pclass and visitor_stream = :pstream group by DATE_FORMAT(visit_date,'%b'),visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pstream", pstream).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);;
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountYearwise(String pclass,String pstream) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' and visitor_class =:pclass and visitor_stream = :pstream group by year(visit_date),visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pstream", pstream);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public Long getAllVisitorsVisitClassStreamCountYearwise(String pclass,String pstream,String datePicker, String datePicker1) {
		String qStr = "select count(*) from Visitors visitors where visit_status = 'come' AND visit_date BETWEEN :pdate1 AND :pdate2 and visitor_class =:pclass and visitor_stream = :pstream group by year(visit_date),visitor_class,visitor_stream order by count(*) desc";
		TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
		query.setParameter("pclass", pclass).setParameter("pstream", pstream).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		query.setMaxResults(1);
		Long count = query.getSingleResult();
		return count;
	}
	public List getAllDefaulters() {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT visitor_name,visit_date,visit_status FROM Visitors visitors WHERE visit_status ='come'");
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	/***/
	public List getParticularStreamAllclass(String pstream) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT COUNT(*), visitor_stream, visitor_class FROM Visitors visitors WHERE visit_status ='come' AND visitor_stream = :pstream GROUP BY visitor_stream, visitor_class ORDER BY visitor_class");
		query.setParameter("pstream", pstream);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getParticularAllclass(String pstream) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT COUNT(*), visitor_class FROM Visitors visitors WHERE visit_status ='come' AND visitor_class = :pstream GROUP BY visitor_class ORDER BY visitor_class");
		query.setParameter("pstream", pstream);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
	public List getParticularStreamAllclass(String pstream, String datePicker, String datePicker1) {
		Visitors visitors = new Visitors();
		EntityManager entityManager1 = JPAUtil.getEntityManager1();
		Query query = entityManager1.createQuery("SELECT COUNT(*), visitor_stream, visitor_class FROM Visitors visitors WHERE visit_status ='come' AND visit_date BETWEEN :pdate1 AND :pdate2 AND visitor_stream = :pstream GROUP BY visitor_stream, visitor_class ORDER BY visitor_class");
		query.setParameter("pstream", pstream).setParameter("pdate1", datePicker).setParameter("pdate2", datePicker1);
		@SuppressWarnings("unchecked")
		List<Visitors> streamList = query.getResultList();
		return streamList;
	}
}