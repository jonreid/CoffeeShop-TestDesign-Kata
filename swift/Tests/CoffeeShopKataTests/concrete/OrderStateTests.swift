@testable import CoffeeShopKata
import Testing

struct OrderStateTests {
    @Test("order can be updated and canceled if not paid yet")
    func orderCanBeUpdatedAndCanceledIfNotPaidYet() throws {
        let order = existingOrderWithStatus(.paymentExpected)
        #expect(order.isUpdateAllowed == true)
        #expect(order.isCancelAllowed == true)
        #expect(order.isPaid == false)
    }
    
    @Test("order cannot be updated or canceled if paid")
    func orderCannotBeUpdatedOrCanceledIfPaid() throws {
        let order = existingOrderWithStatus(.paid)
        #expect(order.isUpdateAllowed == false)
        #expect(order.isCancelAllowed == false)
        #expect(order.isPaid == true)
    }
    
    @Test("order cannot be updated or canceled if preparing")
    func orderCannotBeUpdatedOrCanceledIfPreparing() throws {
        let order = existingOrderWithStatus(.preparing)
        #expect(order.isUpdateAllowed == false)
        #expect(order.isCancelAllowed == false)
        #expect(order.isPaid == true)
    }
    
    @Test("order cannot be updated or canceled if ready")
    func orderCannotBeUpdatedOrCanceledIfReady() throws {
        let order = existingOrderWithStatus(.ready)
        #expect(order.isUpdateAllowed == false)
        #expect(order.isCancelAllowed == false)
        #expect(order.isPaid == true)
    }
    
    @Test("order cannot be updated or canceled if taken")
    func orderCannotBeUpdatedOrCanceledIfTaken() throws {
        let order = existingOrderWithStatus(.taken)
        #expect(order.isUpdateAllowed == false)
        #expect(order.isCancelAllowed == false)
        #expect(order.isPaid == true)
    }

    private func existingOrderWithStatus(_ status: Status) -> Order {
        let order = Order(id: 1)
        order.setStatus(status)
        return order
    }
}
