from collections import Counter

class TextAnalyzer:
    def __init__(self, text):
        self.text = text

    def __len__(self):
        # Spliting the text into words and count their occurrences
        words = self.text.split()
        word_counts = Counter(words)
        # Finding words that appear more than once
        repeated = {word: count for word, count in word_counts.items() if count > 1}
        
        # If there are repeated words, return the total length of repeated words
        if repeated:
            return sum(len(word) for word in repeated)
        # Otherwise, return the total string length.
        return len(self.text)

    def most_common(self, n=1):
        # Counting frequencies and return the n most common words.
        words = self.text.split()
        word_counts = Counter(words)
        return word_counts.most_common(n)


# Example usage:
if __name__ == '__main__':
    sample_text = "hello world hello python python python"
    analyzer = TextAnalyzer(sample_text)
    
    # Using the overloaded len operator:
    result = len(analyzer)
    print("Result of len(analyzer):", result)
    
    # Display two most common words:
    common = analyzer.most_common(2)
    print("Most common words:", common)
