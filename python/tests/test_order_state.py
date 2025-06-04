from src.coffeeshop_kata.order import Order
from src.coffeeshop_kata.status import Status


def existing_order_with_status(status: Status) -> Order:
    order = Order(1)
    order.set_status(status)
    return order


def test_order_can_be_updated_and_canceled_if_not_paid_yet():
    order = existing_order_with_status(Status.PAYMENT_EXPECTED)
    assert order.is_update_allowed() is True
    assert order.is_cancel_allowed() is True


def test_order_cannot_be_updated_or_canceled_if_paid():
    order = existing_order_with_status(Status.PAID)
    assert order.is_update_allowed() is False
    assert order.is_cancel_allowed() is False


def test_order_cannot_be_updated_or_canceled_if_preparing():
    order = existing_order_with_status(Status.PREPARING)
    assert order.is_update_allowed() is False
    assert order.is_cancel_allowed() is False


def test_order_cannot_be_updated_or_canceled_if_ready():
    order = existing_order_with_status(Status.READY)
    assert order.is_update_allowed() is False
    assert order.is_cancel_allowed() is False


def test_order_cannot_be_updated_or_canceled_if_taken():
    order = existing_order_with_status(Status.TAKEN)
    assert order.is_update_allowed() is False
    assert order.is_cancel_allowed() is False