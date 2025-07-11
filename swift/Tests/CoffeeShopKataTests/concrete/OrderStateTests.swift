@testable import CoffeeShopKata
import Testing

struct OrderStateTests {
    @Test("order can be updated and canceled if not paid yet")
    func paymentExpected() throws {
        let order = existingOrderWithStatus(.paymentExpected)
        #expect(order.isUpdateAllowed == true)
        #expect(order.isCancelAllowed == true)
    }
    
    @Test("order cannot be updated or canceled if paid")
    func paid() throws {
        let order = existingOrderWithStatus(.paid)
        #expect(order.isUpdateAllowed == false)
        #expect(order.isCancelAllowed == false)
    }
    
    @Test("order cannot be updated or canceled if preparing")
    func preparing() throws {
        let order = existingOrderWithStatus(.preparing)
        #expect(order.isUpdateAllowed == false)
        #expect(order.isCancelAllowed == false)
    }
    
    @Test("order cannot be updated or canceled if ready")
    func ready() throws {
        let order = existingOrderWithStatus(.ready)
        #expect(order.isUpdateAllowed == false)
        #expect(order.isCancelAllowed == false)
    }
    
    @Test("order cannot be updated or canceled if taken")
    func taken() throws {
        let order = existingOrderWithStatus(.taken)
        #expect(order.isUpdateAllowed == false)
        #expect(order.isCancelAllowed == false)
    }

    private func existingOrderWithStatus(_ status: Status) -> Order {
        let order = Order(id: 1)
        order.setStatus(status)
        return order
    }
}
