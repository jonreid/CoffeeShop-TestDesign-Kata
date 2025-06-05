/**
 * Enumeration for all the statuses an Order can be in.
 */
export enum Status {
  /**
   * Placed, but not paid yet. Still changeable.
   */
  PAYMENT_EXPECTED = "PAYMENT_EXPECTED",

  /**
   * Order was paid. No changes allowed to it anymore.
   */
  PAID = "PAID",

  /**
   * The Order is currently processed.
   */
  PREPARING = "PREPARING",

  /**
   * The Order is ready to be picked up by the customer.
   */
  READY = "READY",

  /**
   * The Order was completed.
   */
  TAKEN = "TAKEN",
}