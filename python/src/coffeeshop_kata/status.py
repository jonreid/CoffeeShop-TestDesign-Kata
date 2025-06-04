from enum import Enum


class Status(Enum):
    """Enumeration for all the statuses an Order can be in."""
    
    PAYMENT_EXPECTED = "payment_expected"
    """Placed, but not paid yet. Still changeable."""
    
    PAID = "paid"
    """Order was paid. No changes allowed to it anymore."""
    
    PREPARING = "preparing"
    """The Order is currently processed."""
    
    READY = "ready"
    """The Order is ready to be picked up by the customer."""
    
    TAKEN = "taken"
    """The Order was completed."""