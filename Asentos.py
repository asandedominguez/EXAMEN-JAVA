class Asento:
    def __init__(self, numero: str, clase: str):
        self.numero = numero
        self.clase = clase  # "turista", "preferente", "business"
        self.ocupado = False
        self.pasaxeiro = None
asientos = []
with open("avion.csv","r",encoding="utf-8") as file:
    file.readline()
    for linea in file:
        sinsaltos = linea.strip()
        sinnada = sinsaltos.split(',')
        asiento = Asento(sinnada[0],sinnada[1])
        asientos.append(asiento)
for a in asientos:
    print(f"Asiento {a.numero} - Clase: {a.clase} - Ocupado: {a.ocupado}")