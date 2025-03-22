def vectors(v1, v2):

    return (v1[0] * v1[0] + v1[1] * v2[1] + v1[2] * v2[2])

for i in range (3):

    v1 = input("Enter the first vector coordinate: ")
    v2 = input("Enter the second vector coordinate: ")
    v3 = input("Enter the third vector coordinate: ")

    if i == 0:
        A = [v1, v2, v3]
    
    elif i == 1:

        B = [v1, v2, v3]

    else:

        C = [v1, v2, v3]

if (vectors(A, B) == 0):

    print("The vectors are orthogonal.")

else:

    print("The vectors are not orthogonal.")

if (vectors(A, C) == 0):

    print("The vectors are orthogonal.")

else:

    print("The vectors are not orthogonal.")

if (vectors(B, C) == 0):

    print("The vectors are orthogonal.")

else:

    print("The vectors are not orthogonal.")









































































