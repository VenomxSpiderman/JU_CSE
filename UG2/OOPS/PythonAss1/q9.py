import string

lowercase_letters = string.ascii_lowercase

for index, letter in enumerate(lowercase_letters):
    print(f"{index+1}: {letter}")