
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BalanceTests {
	
	Trip sampleTrip = new Trip ("Trial",2);
	

	@Test
	void equals1PersonAmtOwedEqualsZero() {
		sampleTrip.addPerson("Yocheved");
		assertEquals(sampleTrip.getAmtOwed(),0);
	}
	@Test
	void equals2PeopleAmtOwedEqualsZero() {
		sampleTrip.addPerson("Yocheved");
		sampleTrip.addPerson("Adeena");
		assertEquals(0,sampleTrip.getAmtOwed());
	}
	@Test
	void notEquals2PeopleAmtOwedEqualsZeroWithReciept() {
		Person yocheved = sampleTrip.addPerson("Yocheved");
		Person adeena = sampleTrip.addPerson("Adeena");
		Receipt sampleReceipt = new Receipt(yocheved.getID(),500.20,"Socks");
		sampleTrip.addReceipt(sampleReceipt);
		assertNotEquals(0,sampleTrip.getAmtOwed());
	}
	@Test
	void Equals2PeopleAmtOwedEqualsn500WithReciept() {
		Person yocheved = sampleTrip.addPerson("Yocheved");
		Person adeena = sampleTrip.addPerson("Adeena");
		Receipt sampleReceipt = new Receipt(yocheved.getID(),500,"Socks");
		sampleTrip.addReceipt(sampleReceipt);
		assertNotEquals(-500,sampleTrip.getAmtOwed());
	}
	@Test
	void Equals2PeopleAmtOwedEquals250WithReciept() {
		Person yocheved = sampleTrip.addPerson("Yocheved");
		Person adeena = sampleTrip.addPerson("Adeena");
		Receipt sampleReceipt = new Receipt(yocheved.getID(),500,"Socks");
		sampleTrip.addReceipt(sampleReceipt);
		assertNotEquals(250,sampleTrip.getAmtOwed());
	}
	@Test
	void Equals2PeopleAmtOwedEquals500WithReciept() {
		Person yocheved = sampleTrip.addPerson("Yocheved");
		Person adeena = sampleTrip.addPerson("Adeena");
		Receipt sampleReceipt = new Receipt(yocheved.getID(),500,"Socks");
		sampleTrip.addReceipt(sampleReceipt);
		assertEquals(500,sampleTrip.getAmtOwed());
	}
	@Test
	void Equals2PeopleAmtOwedEquals500WithAddtoAmtOwed() {
		Person yocheved = sampleTrip.addPerson("Yocheved");
		Person adeena = sampleTrip.addPerson("Adeena");
		
		sampleTrip.addToAmtOwed(500);
		assertEquals(500,sampleTrip.getAmtOwed());
	}
	@Test
	void Equals2PeopleAmtOwedEquals500WithAddtoAmtOwedTwoTimes() {
		Person yocheved = sampleTrip.addPerson("Yocheved");
		Person adeena = sampleTrip.addPerson("Adeena");
		
		sampleTrip.addToAmtOwed(500);
		sampleTrip.addToAmtOwed(500);
		assertEquals(1000,sampleTrip.getAmtOwed());
	}
	
	@Test
	void ReceiptGetAmountSpentWithOneUser() {
		Person yocheved = sampleTrip.addPerson("Yocheved");
		Receipt sampleReceipt = new Receipt(yocheved.getID(),500,"Socks");
		assertEquals(500,sampleReceipt.getAmountSpent());
	}
	@Test
	void ReceiptGetAmountSpentWithTwoUser() {
		Person yocheved = sampleTrip.addPerson("Yocheved");
		Person adeena = sampleTrip.addPerson("Adeena");
		Receipt sampleReceipt = new Receipt(yocheved.getID(),500,"Socks");
		assertEquals(500,sampleReceipt.getAmountSpent());
	}
	
	@Test
	void ReceiptWithTwoUserWithArrayList() {
		Person yocheved = sampleTrip.addPerson("Yocheved");
		Person adeena = sampleTrip.addPerson("Adeena");
	
		Receipt sampleReceipt = new Receipt(yocheved.getID(),500,"Socks");
		sampleTrip.addReceipt(sampleReceipt);
		assertEquals(sampleReceipt,sampleTrip.receipts.get(0));
	}
	@Test
	void RecieptCostEqualsAmountOwed() {
		Person yocheved = sampleTrip.addPerson("Yocheved");
		Person adeena = sampleTrip.addPerson("Adeena");
	
		Receipt sampleReceipt = new Receipt(yocheved.getID(),500,"Socks");
		sampleTrip.addReceipt(sampleReceipt);
		assertEquals(sampleTrip.getAmtOwed(),sampleTrip.receipts.get(0).getAmountSpent());
	}
	@Test
	void PersonalBalancePersonThatPutInReceiptEquals() {
		Person yocheved = sampleTrip.addPerson("Yocheved");
		Person adeena = sampleTrip.addPerson("Adeena");
	
		Receipt sampleReceipt = new Receipt(yocheved.getID(),500,"Socks");
		sampleTrip.addReceipt(sampleReceipt);
		assertEquals(-250,yocheved.getBalance());
	}
	@Test
	void PersonalBalancePersonThatPutInReceiptNotEquals() {
		Person yocheved = sampleTrip.addPerson("Yocheved");
		Person adeena = sampleTrip.addPerson("Adeena");
	
		Receipt sampleReceipt = new Receipt(yocheved.getID(),500,"Socks");
		sampleTrip.addReceipt(sampleReceipt);
		assertNotEquals(-500,yocheved.getBalance());
	}
	@Test
	void PersonalBalanceOtherUserNotEquals() {
		Person yocheved = sampleTrip.addPerson("Yocheved");
		Person adeena = sampleTrip.addPerson("Adeena");
	
		Receipt sampleReceipt = new Receipt(yocheved.getID(),500,"Socks");
		sampleTrip.addReceipt(sampleReceipt);
		assertNotEquals(500,adeena.getBalance());
	}
	@Test
	void PersonalBalanceOtherUser() {
		Person yocheved = sampleTrip.addPerson("Yocheved");
		Person adeena = sampleTrip.addPerson("Adeena");
	
		Receipt sampleReceipt = new Receipt(yocheved.getID(),500,"Socks");
		sampleTrip.addReceipt(sampleReceipt);
		assertEquals(250,adeena.getBalance());
	}
	@Test
	void PersonalBalanceOtherUserAddedLater() {
		Person yocheved = sampleTrip.addPerson("Yocheved");
		
	
		Receipt sampleReceipt = new Receipt(yocheved.getID(),500,"Socks");
		sampleTrip.addReceipt(sampleReceipt);
		Person adeena = sampleTrip.addPerson("Adeena");
		assertEquals(250,adeena.getBalance());
	}
	
	
	
	
	

}