class BankAccount:
    def __init__(self, initial_balance=0, pin="0000"):
        self._balance = initial_balance
        self._pin = pin

    def deposit(self, amount, pin):
        if pin != self._pin:
            print("Invalid PIN!")
            return
        if amount > 0:
            self._balance += amount
            print("Deposit successful!")
        else:
            print("Invalid amount!")

    def withdraw(self, amount, pin):
        if pin != self._pin:
            return False, "Invalid PIN"
        if amount > 0 and amount <= self._balance:
            self._balance -= amount
            return True, "Withdrawal successful"
        return False, "Insufficient funds"

    def get_balance(self, pin):
        if pin == self._pin:
            return self._balance
        return None

    def change_pin(self, old_pin, new_pin):
        if old_pin == self._pin:
            self._pin = new_pin
            return True
        return False

class SavingsAccount(BankAccount):
    def __init__(self, initial_balance=0, pin="0000", interest_rate=0.02):
        super().__init__(initial_balance, pin)
        self._interest_rate = interest_rate

    def apply_interest(self):
        interest = self._balance * self._interest_rate
        self._balance += interest
        return interest

class FeeSavingsAccount(SavingsAccount):
    def __init__(self, initial_balance=0, pin="0000", interest_rate=0.02, withdrawal_fee=5):
        super().__init__(initial_balance, pin, interest_rate)
        self._withdrawal_fee = withdrawal_fee

    def withdraw(self, amount, pin):
        if pin != self._pin:
            return False, "Invalid PIN"
        total_amount = amount + self._withdrawal_fee
        if total_amount <= self._balance:
            self._balance -= total_amount
            return True, f"Withdrawal successful (fee: ${self._withdrawal_fee})"
        return False, "Insufficient funds"

def main():
    account = None
    while True:
        print("\nBank Account Menu:")
        print("1. Create new account")
        print("2. Deposit")
        print("3. Withdraw")
        print("4. Check balance")
        print("5. Change PIN")
        print("6. Apply interest (Savings accounts only)")
        print("7. Exit")

        choice = input("Enter your choice (1-7): ")

        if choice == '1':
            print("\nSelect account type:")
            print("1. Basic Bank Account")
            print("2. Savings Account")
            print("3. Fee Savings Account")
            acc_type = input("Enter account type (1-3): ")
            initial_balance = float(input("Enter initial balance: "))
            pin = input("Enter PIN: ")
            
            if acc_type == '1':
                account = BankAccount(initial_balance, pin)
            elif acc_type == '2':
                interest_rate = float(input("Enter interest rate (e.g., 0.02 for 2%): "))
                account = SavingsAccount(initial_balance, pin, interest_rate)
            elif acc_type == '3':
                interest_rate = float(input("Enter interest rate (e.g., 0.02 for 2%): "))
                fee = float(input("Enter withdrawal fee: "))
                account = FeeSavingsAccount(initial_balance, pin, interest_rate, fee)
            print("Account created successfully!")

        elif not account:
            print("Please create an account first!")
            continue

        elif choice == '2':
            pin = input("Enter PIN: ")
            amount = float(input("Enter amount to deposit: "))
            if account.deposit(amount,pin):
                print("Deposit successful!")
            else:
                print("Invalid amount!")

        elif choice == '3':
            amount = float(input("Enter amount to withdraw: "))
            pin = input("Enter PIN: ")
            success, message = account.withdraw(amount, pin)
            print(message)

        elif choice == '4':
            pin = input("Enter PIN: ")
            balance = account.get_balance(pin)
            if balance is not None:
                print(f"Current balance: ${balance:.2f}")
            else:
                print("Invalid PIN!")

        elif choice == '5':
            old_pin = input("Enter old PIN: ")
            new_pin = input("Enter new PIN: ")
            if account.change_pin(old_pin, new_pin):
                print("PIN changed successfully!")
            else:
                print("Invalid PIN!")

        elif choice == '6':
            if isinstance(account, SavingsAccount):
                interest = account.apply_interest()
                print(f"Interest applied: ${interest:.2f}")
            else:
                print("This feature is only available for savings accounts!")

        elif choice == '7':
            print("Thank you for using our banking system!")
            break

        else:
            print("Invalid choice! Please try again.")

if __name__ == "__main__":
    main()