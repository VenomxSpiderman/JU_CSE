import re

def validate_phone_number(phone_number):
    
    
    pattern = re.compile(
        r'^'                    
        r'(\+\d{1,3}\s?)?'      
        r'(\(\d{1,4}\)|\d{1,4})'
        r'[\s.-]?'              
        r'\d{3}'                
        r'[\s.-]?'              
        r'\d{4}$'               
    )
    
    return bool(pattern.fullmatch(phone_number))

test_numbers = [
    "+1 (555) 123-4567",  
    "555-123-4567",       
    "+44 20 1234 5678",   
    "02012345678",        
    "123.456.7890",       
    "(123) 456-7890",     
    "+91-98765-43210",    
    "invalid",              
    "1234",                 
    "+123-456-789",
    "+919903834838"       
]

for number in test_numbers:
    print(f"{number}: {'Valid' if validate_phone_number(number) else 'Invalid'}")
