def print_array(arr: list[int]):
    for i in range(len(arr) - 1):
        print(arr[i], end=" ")
    print(arr[len(arr) - 1])

def swap(arr: list[int], i: int, j: int):
    arr[i], arr[j] = arr[j], arr[i]


def quick_sort(arr: list[int], start: int, end: int):
    f = start
    r = end

    if end > start:
        pivot = arr[end]

        while r > f:
            while f < end and arr[f] < pivot and r > f:
                f += 1

            while r > start and arr[r] >= pivot and r >= f:
                r -= 1

            if r > f:
                swap(arr, f, r)

        swap(arr, f, end)

        print_array(arr)
        quick_sort(arr, start, f - 1)
        quick_sort(arr, f + 1, end)

arr = []
size = int(input())

my_input = input().split(" ")

for i in range(size):
    arr.append(int(my_input[i]))

quick_sort(arr, 0, len(arr) - 1)