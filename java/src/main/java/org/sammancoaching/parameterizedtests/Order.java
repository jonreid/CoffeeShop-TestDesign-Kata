package org.sammancoaching.parameterizedtests;

public class Order {

	public final long id;
	public Status status;

	public Order(long id) {
		this.id = id;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isUpdateAllowed() {
		return !isPaid();
	}

	public boolean isCancelAllowed() {
		return !isPaid();
	}

	// BUG! All statuses except PAYMENT_EXPECTED mean that it is paid.
	// Off by one error: 0 should also return true.
	public boolean isPaid() {
		return status.compareTo(Status.PAID) > 0;
	}

}
