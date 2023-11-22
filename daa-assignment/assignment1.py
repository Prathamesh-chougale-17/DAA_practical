def square_large_number(n):
    if n == 0:
        return 0
    elif n < 0:
        return square_large_number(-n)
    elif n % 2 == 0:
        return 4 * square_large_number(n // 2)
    else:
        return (
            (4 * square_large_number(n // 2)) + (4 * (n // 2)) + 1
        )  # // is integer division and / is float division


# Define the large number
large_number = int(input("Enter a large number: "))

# Square the large number using recursion
result = square_large_number(large_number)

# Print the result
print(result)
