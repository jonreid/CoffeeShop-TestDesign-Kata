package org.sammancoaching.parameterizedtests;

/**
 * Enumeration for all the statuses an {@link Order} can be in.
 */
public enum Status {

	/**
	 * Placed, but not payed yet. Still changeable.
	 */
	PAYMENT_EXPECTED,

	/**
	 * {@link Order} was payed. No changes allowed to it anymore.
	 */
	PAID,

	/**
	 * The {@link Order} is currently processed.
	 */
	PREPARING,

	/**
	 * The {@link Order} is ready to be picked up by the customer.
	 */
	READY,

	/**
	 * The {@link Order} was completed.
	 */
	TAKEN;
}
