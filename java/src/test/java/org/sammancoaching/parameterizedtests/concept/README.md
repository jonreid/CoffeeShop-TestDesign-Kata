In `ParameterizedTests` liegen JUnit5 Beispiele, wie man auf Basis von JUnit5 parametrisierbare Tests erstellen kann. Dies ist für den "concept" Teil einer Samman-Coaching-Learning-Hour vorgesehen. 

Im "concrete" Teil ist die Aufgabe, den `OrderStateTest` zu einem parametrisierbaren Test umzubauen (genauere Beschreibung hierzu siehe LH-Beschreibung intern oder [extern](https://sammancoaching.org/learning_hours/test_design/parameterized_tests.html)). 

Eine **mögliche** Lösung kann wie folgt aussehen: 
```
@ParameterizedTest
@EnumSource(value = Status.class, mode = EXCLUDE, names = "PAYMENT_EXPECTED")
void whenStateIsNotPaymentExcpected_orderCannotBeUpdatedAndNotBeCanceled(Status status) {
	Order order = existingOrderWithStatus(status);
	assertThat(order.isUpdateAllowed()).isFalse();
	assertThat(order.isCancelAllowed()).isFalse();
}

@ParameterizedTest
@EnumSource(value = Status.class, mode = INCLUDE, names = "PAYMENT_EXPECTED")
void whenStateIsPaymentExcpected_orderCanBeUpdatedAndBeCanceled(Status status) {
	Order order = existingOrderWithStatus(status);
	assertThat(order.isUpdateAllowed()).isTrue();
	assertThat(order.isCancelAllowed()).isTrue();
}

private static Order existingOrderWithStatus(Status status) {
	Order order = new Order(1L);
	order.setStatus(status);
	return order;
}
```

Weitere Möglichkeiten sind: 
- EnumSource mit Assumptions statt EXCLUDE
- EnumSource mit guard statement statt EXCLUDE (nicht wirklich gut, da damit ein "grüner" Test erzeugt wir der eigentlich kein Test ist)
- CsvSource, ParameterType Status (JUnit macht das Status.valueOf(String) selbst
- ???

