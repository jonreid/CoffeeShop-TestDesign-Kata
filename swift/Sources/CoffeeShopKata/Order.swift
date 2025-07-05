class Order {
    let id: Int
    private(set) var status: Status?
    
    init(id: Int) {
        self.id = id
    }
    
    func setStatus(_ status: Status) {
        self.status = status
    }
    
    var isUpdateAllowed: Bool {
        !isPaid
    }
    
    var isCancelAllowed: Bool {
        !isPaid
    }
    
    // BUG! All statuses except PAYMENT_EXPECTED mean that it is paid.
    // Off by one error: PAID should also return true.
    private var isPaid: Bool {
        guard let status else {
            return false
        }
        let statusOrder = Array(Status.allCases)
        let currentIndex = statusOrder.firstIndex(of: status)!
        let paidIndex = statusOrder.firstIndex(of: .paid)!
        return currentIndex > paidIndex
    }
}
