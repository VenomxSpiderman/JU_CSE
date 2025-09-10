import os

def findfiles(directory):
    
    for root, _, files in os.walk(directory):
        for filename in files:
            filepath = os.path.join(root, filename)
            yield filepath

if __name__ == '__main__':
    
    directory_to_explore = '.'  
    
    file_generator = findfiles(directory_to_explore)
    
    print("Files found in the directory tree:")
    for file_path in file_generator:
        print(file_path)