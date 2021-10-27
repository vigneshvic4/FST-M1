a = input ("Enter User 1 name ")
b = input ("Enter User 2 name ")
a_ans = input("Rock/Paper/Scissor ")
b_ans = input("Rock/Paper/Scissor ")
if a_ans == "Rock" and b_ans == "Scissor":
 print("Rock beat Scissor")
elif a_ans == "Scissor" and b_ans == "paper":
 print("Scissor beats paper")
elif a_ans == "Paper" and b_ans == "Rock":
 print("Paper beats rock")
elif a_ans == b_ans:
 print("Tie")
else:
 print("Not valid")