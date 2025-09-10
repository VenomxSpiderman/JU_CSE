import re
from num2words import num2words

# Function to convert numbers into words
def convert_numbers_to_words(text):
    # Define a regex to match all numbers (integers and decimals)
    number_pattern = r'\b\d+(\.\d+)?\b'

    # Function to process each match (number) and convert to words
    def convert(match):
        num = match.group(0)  
        
        number_in_words = num2words(num)
        
        return number_in_words
    

    updated_text = re.sub(number_pattern, convert, text)
    return updated_text

def process_file(file_path):
    # Read the content of the file
    with open(file_path, 'r') as file:
        text = file.read()

    # Convert the numbers in the text to words
    converted_text = convert_numbers_to_words(text)

    with open("converted_text.txt", "w") as output_file:
        output_file.writelines([f"{converted_text}"])

    print("Text with numbers converted to words:")
    print(converted_text)

file_path = '/home/pc-23/Desktop/Tathagata_BCSE2_030/Python Ass1/input.txt' 

process_file(file_path)
