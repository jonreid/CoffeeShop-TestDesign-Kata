import { describe, expect, test } from "bun:test";
import { Order } from "@/order";
import { Status } from "@/status";

function existingOrderWithStatus(status: Status): Order {
	const order = new Order(1);
	order.setStatus(status);
	return order;
}

describe("OrderStateTest", () => {
	test("order can be updated and canceled if not paid yet", () => {
		const order = existingOrderWithStatus(Status.PAYMENT_EXPECTED);
		expect(order.isUpdateAllowed()).toBe(true);
		expect(order.isCancelAllowed()).toBe(true);
	});

	test("order cannot be updated or canceled if paid", () => {
		const order = existingOrderWithStatus(Status.PAID);
		expect(order.isUpdateAllowed()).toBe(false);
		expect(order.isCancelAllowed()).toBe(false);
	});

	test("order cannot be updated or canceled if preparing", () => {
		const order = existingOrderWithStatus(Status.PREPARING);
		expect(order.isUpdateAllowed()).toBe(false);
		expect(order.isCancelAllowed()).toBe(false);
	});

	test("order cannot be updated or canceled if ready", () => {
		const order = existingOrderWithStatus(Status.READY);
		expect(order.isUpdateAllowed()).toBe(false);
		expect(order.isCancelAllowed()).toBe(false);
	});

	test("order cannot be updated or canceled if taken", () => {
		const order = existingOrderWithStatus(Status.TAKEN);
		expect(order.isUpdateAllowed()).toBe(false);
		expect(order.isCancelAllowed()).toBe(false);
	});
});
