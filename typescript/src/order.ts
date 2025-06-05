import { Status } from "./status";

export class Order {
    public readonly id: number;
    public status?: Status;

    constructor(id: number) {
        this.id = id;
    }

    setStatus(status: Status): void {
        this.status = status;
    }

    isUpdateAllowed(): boolean {
        return !this.isPaid();
    }

    isCancelAllowed(): boolean {
        return !this.isPaid();
    }

    // BUG! All statuses except PAYMENT_EXPECTED mean that it is paid.
    // Off by one error: PAID should also return true.
    isPaid(): boolean {
        if (!this.status) {
            return false;
        }
        const statusOrder = Object.values(Status);
        const currentIndex = statusOrder.indexOf(this.status);
        const paidIndex = statusOrder.indexOf(Status.PAID);
        return currentIndex > paidIndex;
    }
}
