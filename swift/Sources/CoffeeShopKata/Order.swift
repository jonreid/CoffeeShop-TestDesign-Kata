import Foundation

public class Order {
    public let id: Int
    public var status: Status?
    
    public init(id: Int) {
        self.id = id
    }

    public func setStatus(_ status: Status) {
        self.status = status
    }
    
    public var isUpdateAllowed: Bool {
        return !isPaid
    }
    
    public var isCancelAllowed: Bool {
        return !isPaid
    }
    
    // BUG! All statuses except PAYMENT_EXPECTED mean that it is paid.
    // Off by one error: PAID should also return true.
    public var isPaid: Bool {
        guard let status = status else {
            return false
        }
        let statusOrder = Array(Status.allCases)
        let currentIndex = statusOrder.firstIndex(of: status)!
        let paidIndex = statusOrder.firstIndex(of: .paid)!
        return currentIndex > paidIndex
    }
} 