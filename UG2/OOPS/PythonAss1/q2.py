import random

# Generating discount coupon codes for each day of the week
days_of_week = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']
discount_coupons = {}

for day in days_of_week:
    discount_rate = random.randint(5, 50)  
    
    coupon_code = f"{day[:3].upper()}-{random.randint(1000, 9999)}"  
    
    discount_coupons[day] = {'rate': discount_rate, 'code': coupon_code}

print(discount_coupons)
