def flatten_dict(d, parent_key='', sep='.'):
    flattened = {}

    for key, value in d.items():
        new_key = f"{parent_key}{sep}{key}" if parent_key else key  

        if isinstance(value, dict):
            flattened.update(flatten_dict(value, new_key, sep))
        elif isinstance(value, list):
            for i, item in enumerate(value):
                if isinstance(item, dict):
                    flattened.update(flatten_dict(item, f"{new_key}[{i}]", sep))
                else:
                    flattened[f"{new_key}[{i}]"] = item
        else:
            flattened[new_key] = value

    return flattened

nested_dict = {
'fullname': 'Alessandra',
'age': 41,
'phone-numbers': ['+447421234567', '+447423456789'],
'residence': {
'address': {
'first-line': 'Alexandra Rd',
'second-line': ''
},
'zip': 'N8 0PP',
'city': 'London',
'country': 'UK',
},
}


flattened_dict = flatten_dict(nested_dict)
print(flattened_dict)
