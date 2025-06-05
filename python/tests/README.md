# Pytest Parametrization Examples

This directory contains examples of pytest's parametrization features.

## Files

- `test_order_state.py` - The main kata tests with duplication (ready to be refactored using parametrization)
- `test_parametrized_examples.py` - Comprehensive examples of pytest parametrization features
- `test_data.csv` - Sample data file for file-based parametrization

## Pytest Parametrization Features Demonstrated

1. **Basic `@pytest.mark.parametrize`**
   - Single parameter
   - Multiple parameters
   - Using lists of values

2. **Test IDs**
   - Custom test names using `ids` parameter
   - Better test output readability

3. **Cartesian Product**
   - Multiple decorators create all combinations
   - Useful for testing matrix of inputs

4. **`pytest.param`**
   - Adding IDs to individual test cases
   - Marking tests as xfail or skip
   - Adding custom marks

5. **Indirect Parametrization**
   - Parametrizing fixtures
   - More complex test setup

6. **Dynamic Test Generation**
   - Using functions to generate test data
   - Reading from files (CSV example)
   - `pytest_generate_tests` hook

7. **Class-level Parametrization**
   - Applying parameters to all methods in a class

8. **Advanced Features**
   - Dictionary parameters
   - Complex data structures
   - Python 3.10+ match statements

## Running the Examples

```bash
# Run all tests
uv run pytest -v

# Run only parametrization examples
uv run pytest tests/test_parametrized_examples.py -v

# See all generated test cases
uv run pytest tests/test_parametrized_examples.py -v --collect-only

# Run with different dynamic parameters
uv run pytest tests/test_parametrized_examples.py::TestDynamicParametrization -v
uv run pytest tests/test_parametrized_examples.py::TestDynamicParametrization -vv
```

## Key Differences from JUnit 5

- No need for separate test sources (ValueSource, EnumSource, etc.)
- More concise syntax with decorators
- Dynamic test generation is more flexible
- No special CSV file source - just use Python to read files
- Fixture parametrization adds extra power
- Can parametrize entire classes, not just methods