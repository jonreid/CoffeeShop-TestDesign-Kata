import Foundation

/**
 * Enumeration for all the statuses an Order can be in.
 */
public enum Status: String, CaseIterable {
    /**
     * Placed, but not paid yet. Still changeable.
     */
    case paymentExpected = "PAYMENT_EXPECTED"
    
    /**
     * Order was paid. No changes allowed to it anymore.
     */
    case paid = "PAID"
    
    /**
     * The Order is currently processed.
     */
    case preparing = "PREPARING"
    
    /**
     * The Order is ready to be picked up by the customer.
     */
    case ready = "READY"
    
    /**
     * The Order was completed.
     */
    case taken = "TAKEN"
} 