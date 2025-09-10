import itertools

def read_file(file_path):
    with open(file_path, 'r', encoding='utf-8') as file:
        return [line.strip().split() for line in file]

def tokenize_and_number(lines):
    unique_tokens = {token: idx for idx, token in enumerate(set(itertools.chain(*lines)), start=1)}
    return [[unique_tokens[token] for token in line] for line in lines], unique_tokens

def pad_lines(numeric_lines, pad_value=0):
    max_length = max(map(len, numeric_lines))
    return [line + [pad_value] * (max_length - len(line)) for line in numeric_lines]

if __name__ == "__main__":
    file_path = "input_text.txt"

    lines = read_file(file_path)
    numeric_lines, token_dict = tokenize_and_number(lines)
    padded_lines = pad_lines(numeric_lines)

    print("Token Dictionary:", token_dict)
    print("Padded Numeric Lines:", padded_lines)
