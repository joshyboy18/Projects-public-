
def catalan(catNum,n):

    return int(((4*n+2)/(n+2)) * catNum)

catNum = 1
n = 0

while catNum < 1000000000:

    print(catNum)
    catNum = catalan(catNum, n)
    n += 1


