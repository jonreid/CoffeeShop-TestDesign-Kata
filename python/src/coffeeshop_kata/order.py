from .status import Status


class Order:
    def __init__(self, order_id: int) -> None:
        self.id: int = order_id
        self.status: Status | None = None

    def set_status(self, status: Status) -> None:
        self.status = status

    def is_update_allowed(self) -> bool:
        return not self.is_paid()

    def is_cancel_allowed(self) -> bool:
        return not self.is_paid()

    def is_paid(self) -> bool:
        """
        BUG! All statuses except PAYMENT_EXPECTED mean that it is paid.
        Off by one error: Status.PAID should also return True.
        """
        if self.status is None:
            return False
        # This comparison preserves the exact same bug as Java version
        # Uses > instead of >= causing PAID status to incorrectly return False
        status_order = list(Status)
        return status_order.index(self.status) > status_order.index(Status.PAID)
