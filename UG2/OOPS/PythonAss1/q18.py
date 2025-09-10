import pytest

@pytest.mark.parametrize(
    "base, exponent, expected",
    [
        (2, 2, 4),
        (2, 3, 8),
        (1, 9, 1),
        (0, 9, 1),
    ]
)
def test_power(base, exponent, expected):
    assert pow(base, exponent) == expected

@pytest.mark.parametrize(
    "base, exponent, exception",
    [
        ("a", 2, TypeError),
        (2, "b", TypeError),  
        (None, 3, TypeError), 
    ]
)
def test_power_exceptions(base, exponent, exception):
    with pytest.raises(exception):
        pow(base, exponent)

