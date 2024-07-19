month = input("Enter the month: ")
month = month.lower()
month = month[:3]

match month :
    case "jan" | "mar" | "may" | "july" | "aug" | "oct" | "nov" : 
        print("31 days")
    case "apr" | "june"  | "sep" | "oct"  : 
        print("30 days") 
    case _:
        print("HAHA")




