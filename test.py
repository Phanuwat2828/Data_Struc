num1 = str(input("Enter first number: "));
num1 = num1.replace(" ", "")
num1_list = list(num1)
print(int(num1_list[0]) + int(num1_list[1]) + int(num1_list[2]))