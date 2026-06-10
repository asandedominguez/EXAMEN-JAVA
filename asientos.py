from Asentos import Asento
# --- OPCIÓN 1: Función para crear los asientos ---
def crear_asientos(asientos_totales):
    lista_nueva = []
    b = asientos_totales * 10 // 100
    p = asientos_totales * 20 // 100
    
    for i in range(1, asientos_totales + 1): 
        if i == 13:
            continue
        if i <= b:
            clase_actual = "business"
        elif i <= b + p:
            clase_actual = "preferente"
        else:
            clase_actual = "turista"
        
        nuevo_asiento = Asento(str(i), clase_actual)
        lista_nueva.append(nuevo_asiento)
        
    print("¡Asientos creados con éxito!")
    return lista_nueva  # Devolvemos la lista llena para guardarla fuera


# --- OPCIÓN 2: Función para buscar asiento libre ---
def buscar_asiento(lista_asientos, tipo_clase):
    encontrado = False
    for asiento in lista_asientos:
        if tipo_clase == asiento.clase and not asiento.ocupado:
            print(f"{asiento.clase} asiento Número: {asiento.numero}")
            encontrado = True
            break
    if not encontrado:
        print("No hay asientos disponibles de esa clase.")


# --- OPCIÓN 3: Función para ocupar un asiento ---
def ocupar_asiento(asientos_global, num_asi, nombre):
    for asentos in asientos_global:
        if asentos.numero == num_asi and asentos.ocupado == False:
            asentos.ocupado = True
            print(f"Numero:{asentos.numero} Pasejero: {nombre} Estado actuial: {asentos.ocupado}")
            break
        
    pass

# Este será nuestro almacén global en el script
asientos_global = []

while True:
    print("\n--- MENÚ AVION ---")
    print("1. Crear asientos libres")
    print("2. Buscar primer asiento libre")
    print("3. Ocupar un asiento")
    print("4. Salir")
    
    opcion = input("Elige una opción: ")
    
    if opcion == "1":
        total = int(input("¿Cuántos asientos tiene el avión?: "))
        # Llamamos a la función y guardamos el resultado en nuestra lista global
        asientos_global = crear_asientos(total)
        
    elif opcion == "2":
        if not asientos_global:
            print("Primero debes crear los asientos en la opción 1.")
        else:
            clase = input("¿Qué tipo de asiento quieres (business, preferente, turista)?: ")
            buscar_asiento(asientos_global, clase)
            
    elif opcion == "3":
        nombre = input("dime tu nombre ")
        asiento = input("dime tu asiento ")
        ocupar_asiento(asientos_global,asiento,nombre)
        pass
        
    elif opcion == "4":
        print("Saliendo del programa...")
        break
    else:
        print("Opción no válida.")