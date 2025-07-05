import Testing
@testable import CoffeeShopKata

struct OrderStateTests {    
    @Test("order can be updated and canceled if not paid yet")
    func testOrderCanBeUpdatedAndCanceledIfNotPaidYet() throws {
        let order = existingOrderWithStatus(.paymentExpected)
        #expect(order.isUpdateAllowed == true)
        #expect(order.isCancelAllowed == true)
        #expect(order.isPaid == false)
    }
    
    @Test("order cannot be updated or canceled if paid")
    func testOrderCannotBeUpdatedOrCanceledIfPaid() throws {
        let order = existingOrderWithStatus(.paid)
        #expect(order.isUpdateAllowed == false)
        #expect(order.isCancelAllowed == false)
        #expect(order.isPaid == true)
    }
    
    @Test("order cannot be updated or canceled if preparing")
    func testOrderCannotBeUpdatedOrCanceledIfPreparing() throws {
        let order = existingOrderWithStatus(.preparing)
        #expect(order.isUpdateAllowed == false)
        #expect(order.isCancelAllowed == false)
        #expect(order.isPaid == true)
    }
    
    @Test("order cannot be updated or canceled if ready")
    func testOrderCannotBeUpdatedOrCanceledIfReady() throws {
        let order = existingOrderWithStatus(.ready)
        #expect(order.isUpdateAllowed == false)
        #expect(order.isCancelAllowed == false)
        #expect(order.isPaid == true)
    }
    
    @Test("order cannot be updated or canceled if taken")
    func testOrderCannotBeUpdatedOrCanceledIfTaken() throws {
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