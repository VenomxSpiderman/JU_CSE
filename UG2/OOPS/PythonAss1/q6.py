class UserError(Exception):
    pass

class UsernameNotUniqueError(UserError):
    def __init__(self, username, message="Username is not unique"):
        self.username = username
        self.message = message
        super().__init__(self.message)

class InvalidAgeError(UserError):
    def __init__(self, age, message="Age is not a positive integer"):
        self.age = age
        self.message = message
        super().__init__(self.message)

class UserUnderAgeError(UserError):
    def __init__(self, age, message="User is under 16"):
        self.age = age
        self.message = message
        super().__init__(self.message)

class InvalidEmailError(UserError):
    def __init__(self, email, message="Invalid email address"):
        self.email = email
        self.message = message
        super().__init__(self.message)

def is_valid_email(email):
    if "@" not in email:
        return False
    parts = email.split("@")
    if len(parts) != 2:
        return False
    username_part, domain_part = parts
    if not username_part or not domain_part:
        return False
    if "." not in domain_part:
        return False
    return True

def add_user_to_directory(user_directory, username, email, age):
    if not isinstance(age, int) or age <= 0:
        raise InvalidAgeError(age)
    if age < 16:
        raise UserUnderAgeError(age)
    if not is_valid_email(email):
        raise InvalidEmailError(email)
    if username in user_directory:
        raise UsernameNotUniqueError(username)
    user_directory[username] = email

user_data_list = []
T=int(input("Enter the number of persons:"))
for i in range(T):
    name=input(f"Enter name of person number {i+1}: ")
    email=input(f"Enter mail id of person number {i+1}: ")
    age=input(f"Enter age of person number {i+1}: ")
    if (age.isdigit):
        user_data_list.append((name,email,int(age)))
    
user_directory = {}

for username, email, age in user_data_list:
    try:
        add_user_to_directory(user_directory, username, email, age)
        print(f"\nUser {username} added successfully.")
    except UsernameNotUniqueError as e:
        print(f"\nError adding user {username}: {e.message} (Username: {e.username})")
    except InvalidAgeError as e:
        print(f"\nError adding user {username}: {e.message} (Age: {e.age})")
    except UserUnderAgeError as e:
        print(f"\nError adding user {username}: {e.message} (Age: {e.age})")
    except InvalidEmailError as e:
        print(f"\nError adding user {username}: {e.message} (Email: {e.email})")
    except ValueError:
        print(f"\nError adding user {username}: Age must be an integer.")
    except UserError as e:
        print(f"\nAn unexpected user error occurred for {username}: {e}")

print("\nFinal User Directory:")
for username, email in user_directory.items():
    print(f"Username: {username}, Email: {email}")