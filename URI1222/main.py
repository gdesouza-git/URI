while True:
    try:
        numeros = input()

        lista = numeros.split()
        palavras = input()
        listaPalavras = palavras.split(" ")
        palav = int(lista[0]) - 1
        letras = 0
        linhas = 1
        paginas = 1

        while palav >= 0:
            if letras + (letras != 0) + len(listaPalavras[palav]) <= int(lista[2]):
                letras = letras + (letras != 0) + len(listaPalavras[palav])
            else:
                linhas = linhas + 1
                letras = len(listaPalavras[palav])
                if linhas > int(lista[1]):
                    paginas = paginas + 1
                    linhas = 1
            palav = palav - 1

        print(paginas)
    except EOFError:
        break
