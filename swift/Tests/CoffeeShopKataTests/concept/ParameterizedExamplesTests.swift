import Testing

struct ParameterizedExamplesTests {
    
    // MARK: - Basic parameterization

    @Test("string values", arguments: ["foo", "bar", "###", "___", "   "])
    func stringValues(value: String) throws {
        #expect(value.count > 0)
    }
    
    // MARK: - Multiple parameters

    @Test(arguments: [
        ("test", "TEST"),
        ("tEst", "TEST"),
        ("Java", "JAVA"),
        ("Python", "PYTHON")
    ])
    func stringUppercase(input: String, expected: String) throws {
        #expect(input.uppercased() == expected)
    }
    
    @Test(arguments: [
        (2, 3, 5),
        (0, 0, 0),
        (-1, 1, 0),
        (100, 200, 300)
    ])
    func addition(a: Int, b: Int, expected: Int) throws {
        #expect(a + b == expected)
    }
    
    // MARK: - All combinations of two arguments

    // This creates 6 test cases: (1,10), (1,20), (2,10), (2,20), (3,10), (3,20)
    @Test(arguments: [1, 2, 3], [10, 20])
    func cartesianProduct(x: Int, y: Int) throws {
        #expect(x < y)
    }
} 
