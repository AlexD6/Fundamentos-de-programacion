# -*- coding: utf-8 -*-
'''
Created on 13 ene. 2021

@author: alget
'''

import csv
from collections import namedtuple, Counter
import matplotlib.pyplot as plt

Bien = namedtuple('Bien', 'code, name, year, category, country')

def lee_bienes(fichero):
    with open(fichero, encoding = 'utf-8') as f:
        lector = csv.reader(f)
        next(lector)
        bienes = [Bien(int(code), name, int(year), category, country) for code, name, year, category, country in lector]
    return bienes

def calcula_paises(bienes):
    return set(b.country for b in bienes)

def bienes_por_tipo(bienes):
    dicc = {}
    for b in bienes:
        k = b.category
        if k in dicc:
            dicc[k].append(b)
        else:
            dicc[k] = [b]
    return dicc

def dibuja_bienes_por_tipo(bienes):
    bienes_tipo = bienes_por_tipo(bienes)
    tipos = list(bienes_tipo.keys()) # [Cultural, Natural, etc.]
    numero_bienes = [len(bienes_tipo[k]) for k in tipos] # [800,500,200]
    plt.barh(range(len(numero_bienes)), numero_bienes, tick_label=tipos)
    plt.show()
    
def pais_mas_bienes(bienes, tipo = 'Cultural'):
    '''
    ENTRADA: 
    - lista de tuplas de tipo Bien(int, str, int, str, str) 
    - categoría -> Cultural, Natural o Mixed -> str
   
    SALIDA: 
    - tupla (int,str) -> (nº bienes, nombre_pais) con más bienes de la categoría recibida
    '''
    dicc = Counter(b.country for b in bienes if b.category == tipo)
    maximo = max(dicc.items(), key = lambda x: x[1])
    return (maximo[1], maximo[0])

#     res = dict()
#     for registro in bienes:
#         clave = registro.country
#         if registro.category == tipo:
#             if clave in res.keys():
#                 res[clave] = res[clave] + 1
#             else:
#                 res[clave] = 1
#     maximo = max(res.items(), key = lambda x: x[1])
#     tupla = (maximo[1], maximo[0])
#     return tupla
# 
#     res = Counter(f.country for f in lista_bienes if f.category==categoria)
#     res1 = max(res.items(), key=lambda it:it[1])
#     return (res1[1], res1[0])

def bienes_mas_recientes_por_pais(bienes, n=3):
    '''
    ENTRADA: 
    - lista de tuplas de tipo Bien(int, str, int, str, str) 
    - n: Limite en el numero de bienes recientes a devolver -> int
   
    SALIDA: 
    - Diccionario de bienes por pais -> {Pais: [(Año, Nombre)]} = {str: [(int, str)]}
    '''
    dicc = {}
    for b in bienes:        
        clave = b.country
        if clave in dicc.keys():
            dicc[clave].append((b.year, b.name))    
        else:
            dicc[clave] = [(b.year, b.name)]
    for k, l in dicc.items():
        dicc[k] = sorted(l,reverse=True)[:n]
                       
#     dicc = dict()
#         for registro in registros:
#         clave = registro.country
#         if clave in dicc.keys():
#             list_temp = dicc[clave]
#             tupla_datos = (registro.year, registro.name)
#             list_temp.append(tupla_datos)
#             list_temp = sorted(list_temp, key=lambda x:x[0], reverse=True)
#             dicc[clave] = list_temp[:n]
#         else:
#             tupla_datos = (registro.year, registro.name)
#             dicc[clave] = [tupla_datos]

    return dicc