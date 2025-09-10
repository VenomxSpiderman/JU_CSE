class TextAnalyzer:
    def __init__(self, text):
        self.text = text
    
    def find_palindromes(self):
        words = [word.lower().strip('.,!?') for word in self.text.split()]

        palindromes = [word for word in words if word == word[::-1] and len(word) > 1]
        return list(set(palindromes))
    
    def find_unique_words(self):

        words = [word.lower().strip('.,!?') for word in self.text.split()]

        word_count = {}
        for word in words:
            word_count[word] = word_count.get(word, 0) + 1

        unique_words = [word for word, count in word_count.items() if count == 1]
        return unique_words

if __name__ == "__main__":
    sample_text = "Alice and Bob played a nim game"
    analyzer = TextAnalyzer(sample_text)
    
    print("Palindromes found:", analyzer.find_palindromes())
    print("Unique words found:", analyzer.find_unique_words())