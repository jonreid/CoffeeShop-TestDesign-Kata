package org.sammancoaching.parameterizedtests.concrete;

import static org.sammancoaching.parameterizedtests.Status.PAID;
import static org.sammancoaching.parameterizedtests.Status.PAYMENT_EXPECTED;
import static org.sammancoaching.parameterizedtests.Status.PREPARING;
import static org.sammancoaching.parameterizedtests.Status.READY;
import static org.sammancoaching.parameterizedtests.Status.TAKEN;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.sammancoaching.parameterizedtests.Order;
import org.sammancoaching.parameterizedtests.Status;

class OrderStateTest {

	@Test
	void orderCanBeUpdatedAndCanceledIfNotPaidYet() {
		Order order = existingOrderWithStatus(PAYMENT_EXPECTED);
		assertThat(order.isUpdateAllowed()).isTrue();
		assertThat(order.isCancelAllowed()).isTrue();
	}

	@Test
	void orderCannotBeUpdatedOrCanceledIfPaid() {
		Order order = existingOrderWithStatus(PAID);
		assertThat(order.isUpdateAllowed()).isFalse();
		assertThat(order.isCancelAllowed()).isFalse();
	}

	@Test
	void orderCannotBeUpdatedOrCanceledIfPreparing() {
		Order order = existingOrderWithStatus(PREPARING);
		assertThat(order.isUpdateAllowed()).isFalse();
		assertThat(order.isCancelAllowed()).isFalse();
	}

	@Test
	void orderCannotBeUpdatedOrCanceledIfReady() {
		Order order = existingOrderWithStatus(READY);
		assertThat(order.isUpdateAllowed()).isFalse();
		assertThat(order.isCancelAllowed()).isFalse();
	}

	@Test
	void orderCannotBeUpdatedOrCanceledIfTaken() {
		Order order = existingOrderWithStatus(TAKEN);
		assertThat(order.isUpdateAllowed()).isFalse();
		assertThat(order.isCancelAllowed()).isFalse();
	}

	private static Order existingOrderWithStatus(Status status) {
		Order order = new Order(1L);
		order.setStatus(status);
		return order;
	}
}
