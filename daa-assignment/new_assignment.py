def cost_of_assignment(assignments, cost_matrix):
    total_cost = 0
    for student, club in enumerate(assignments):
        total_cost += cost_matrix[student][club]
    return total_cost


def branch_and_bound(N, cost_matrix):
    def branch(assignments, remaining_students, cost_bound):
        if not remaining_students:
            return cost_of_assignment(assignments, cost_matrix), assignments[:]

        min_cost = float("inf")
        best_assignment = None

        for student in remaining_students:
            for club in range(N):
                if club not in assignments:
                    new_assignments = assignments.copy()
                    new_assignments[student] = club
                    remaining = [s for s in remaining_students if s != student]
                    cost = cost_of_assignment(new_assignments, cost_matrix)

                    if cost < cost_bound:
                        new_cost_bound = cost_bound - cost_matrix[student][club]
                        cost, assignment = branch(
                            new_assignments, remaining, new_cost_bound
                        )

                        if cost < min_cost:
                            min_cost = cost
                            best_assignment = assignment

        return min_cost, best_assignment

    initial_assignments = [-1] * N
    remaining_students = list(range(N))
    initial_cost_bound = float("inf")

    min_cost, best_assignment = branch(
        initial_assignments, remaining_students, initial_cost_bound
    )
    return min_cost, best_assignment


def main():
    N = int(input("Enter the number of students and clubs (N): "))

    cost_matrix = []

    print("\n# Enter the cost of assigning students to clubs #")
    for i in range(N):
        row = []
        for j in range(N):
            cost = int(input(f"Enter the cost of assigning student {i} to club {j}: "))
            row.append(cost)
        cost_matrix.append(row)

    print("\n")
    min_cost, optimal_assignment = branch_and_bound(N, cost_matrix)
    print("Minimum total cost of assignment:", min_cost)
    print("Optimal Assignment:")
    for student, club in enumerate(optimal_assignment):
        print(f"Assign student {student} to club {club}")


if __name__ == "__main__":
    main()
