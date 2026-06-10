from Asentos import Asento
asientos= []
with open("ASIENTOS.txt","r",encoding="utf-8") as ca:
    for linea in ca:
       separado = linea.split()
       numero = separado[1]
       clase = separado[2]
       estado = separado[3]
       if estado=="libre":
           ocupado = False
           nombre = None
       else:
           nombre = estado
           ocupado = True
       n2 = Asento(numero,clase,)
       n2.ocupado = ocupado
       n2.pasaxeiro = nombre
       asientos.append(n2)

for a in asientos:
    print(f"Asiento: {a.numero} | Clase: {a.clase} | Ocupado: {a.ocupado} | Pasajero: {a.pasaxeiro}")