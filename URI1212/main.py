while True:
    entrada = input()

    entradas = entrada.split()

    if int(entradas[0]) == 0 and int(entradas[1]) == 0: break

    list1 = list(entradas[0])
    list2 = list(entradas[1])

    list1.reverse()
    list2.reverse()

    numeroCarry = 0

    menor = min(len(list1), len(list2))
    maior = max(len(list1), len(list2))

    maior1 = False
    if(len(list1) == maior): maior1 = True

    list3 = []

    it = 0
    while it != menor:
        if maior1 == True: list1[it]=int(list1[it]) + int(list2[it])
        else: list2[it] = int(list1[it]) + int(list2[it])
        it = it + 1

    ant = 0
    it2 = 0
    if maior1 == True:
        for elem in list1:
            if(int(ant) > 9 and int(elem) == 9): list1[it2] = 10
            ant = list1[it2]
            it2 = it2+1
    else:
        for elem in list2:
            if (int(ant) > 9 and int(elem) == 9): list2[it2] = 10
            ant = list2[it2]
            it2 = it2+1

    while it != maior:
        if maior1 == True and int(list1[it]) > 9:
           if len(list1)<it+1: list1[it+1] = int(list1[it+1])+1
        else:
            if len(list2)>it+1 and int(list2[it]) > 9: list2[it+1] = int(list2[it+1]) + 1
        it = it + 1

    if maior1 == True:
        for elem in list1:
            if(int(elem) > 9): numeroCarry = numeroCarry + 1
    else:
        for elem in list2:
            if (int(elem) > 9): numeroCarry = numeroCarry + 1

    if numeroCarry == 0: print("No carry operation.")
    elif numeroCarry == 1: print("1 carry operation.")
    else: print(numeroCarry, "carry operations.")